package server_client;

import java.sql.SQLException;

public interface SeatDao {

	public int insertSeat(SeatDto seat) throws ClassNotFoundException,SQLException;
}
