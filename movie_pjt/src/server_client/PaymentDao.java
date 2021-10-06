package server_client;

import java.sql.SQLException;

public interface PaymentDao {
	public int insert(PaymentDto payment) throws ClassNotFoundException, SQLException;

}
