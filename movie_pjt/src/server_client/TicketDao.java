package server_client;

import java.sql.SQLException;
import java.util.List;

public interface TicketDao {
	
	public TicketDto ticketFindById(int ticket_id) throws ClassNotFoundException, SQLException;
	
	public int insert(TicketDto ticket) throws ClassNotFoundException, SQLException;

	

}
