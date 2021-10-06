package server_client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Movie2DaoImpl implements Movie2Dao {
	private static Movie2DaoImpl instance = new Movie2DaoImpl();
	
	private Movie2DaoImpl() {}
	
	public static Movie2DaoImpl getInstance() {
		return instance;
	}
	public List<Movie2Dto> movieFindAll() throws ClassNotFoundException,SQLException{
		String sql = "select * from movie";
		try(Connection conn = DbConn.getConn();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()){
			List<Movie2Dto> movieList = new ArrayList<Movie2Dto>();
			while(rs.next()) {
				movieList.add(new Movie2Dto(rs.getInt("movie_id"),
						rs.getString("title"),
						rs.getString("category"),
						rs.getString("actor"),
						rs.getString("director")));	
			}
			return movieList;
		}
	}

	

}
