package server_client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentDaoImpl implements PaymentDao {
	
		private static PaymentDaoImpl instance = new PaymentDaoImpl();
			
			private PaymentDaoImpl() {}
			
			public static PaymentDaoImpl getInstance() {
				return instance;
			}

			@Override
			public int insert(PaymentDto payment) throws ClassNotFoundException,SQLException {
				String sql = "insert into payment value(?,?,?,?)";
				try(Connection conn = DbConn.getConn();
						PreparedStatement pst = conn.prepareStatement(sql)){
					pst.setInt(1, payment.getPayment_id());
					pst.setInt(2, payment.getCustomer_id());				
					pst.setInt(3, payment.getPrice());
					pst.setString(4, payment.getPayment_date().toString());
					return pst.executeUpdate();
				}		
			}
			

  }
