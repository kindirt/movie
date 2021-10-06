package server_client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SeatDaoImpl implements SeatDao{
private static SeatDaoImpl instance = new SeatDaoImpl();
	
	private SeatDaoImpl() {}
	
	public static SeatDaoImpl getInstance() {
		return instance;
	}

	@Override
	public int insertSeat(SeatDto seat) throws ClassNotFoundException, SQLException {
		String sql = "insert into seat value (?,?,?)";
		try(Connection conn = DbConn.getConn();
				PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, seat.getSeat_id());
			pst.setString(2, seat.getSeat_detail());
			return pst.executeUpdate();
		}
	}
	

	

}
