package server_client;

import java.sql.SQLException;
import java.util.List;

public interface Movie2Dao {
	public List<Movie2Dto> movieFindAll () throws ClassNotFoundException, SQLException;
	
	

}
