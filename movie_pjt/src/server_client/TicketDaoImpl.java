package server_client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketDaoImpl implements TicketDao  {

	private static TicketDaoImpl instacne = new TicketDaoImpl();
	
	private TicketDaoImpl() {}
	
	public static TicketDaoImpl getInstance() {
		return instacne;
	}
	public TicketDto ticketFindById(int ticket_id) throws ClassNotFoundException,SQLException {
		String sql = "select * from ticket where ticket_id = ?";
		try(Connection conn = DbConn.getConn();
				PreparedStatement pst = conn.prepareStatement(sql)){
			
			pst.setInt(1, ticket_id);
			try(ResultSet rs = pst.executeQuery()){
				TicketDto ticket = null;
				if(rs.next()) {
					ticket = new TicketDto(ticket_id, 
							rs.getInt("seat_id"),
							rs.getInt("payment_id"),
							rs.getInt("movie_id"),
							rs.getInt("ticket_tot"));
				}
				return ticket;
			}
		}
	}

	@Override
	public int insert(TicketDto ticket) throws ClassNotFoundException,SQLException {
	     String sql = "insert into ticket value(?,?,?,?,?)";
	     try(Connection conn = DbConn.getConn();
	    		 PreparedStatement pst = conn.prepareStatement(sql)){
	    	 pst.setInt(1, ticket.getTicket_id());
	    	 pst.setInt(2, ticket.getSeat_id());
	    	 pst.setInt(3, ticket.getPayment_id());
	    	 pst.setInt(4, ticket.getMovie_id());
	    	 pst.setInt(5, ticket.getTicket_tot());
	    	 return pst.executeUpdate();
	     }
	}

