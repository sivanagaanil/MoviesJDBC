import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqliteHandler{
	
	public static ResultSet getAllMoviResult(Statement statement, String table_name) {
		try {
			return statement.executeQuery("select * from " + table_name);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public static void InsertNewMovie(Statement statement, String table_name, Movie movie) {

		String insert = "INSERT INTO " + table_name + " values ('" + movie.getMovieName() + "','" + movie.getActorName()
				+ "','" + movie.getDirectorName() + "'," + movie.getYearOfRelease() + ")";

		try {
			statement.executeUpdate(insert);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public static Movie FatchMovieFromDataBase(ResultSet result){
		Movie movie;
		try {
			String MovieName = result.getString("name");
			String ActorName = result.getString("actor");
			String DirectorName = result.getString("director");
			int year = result.getInt("year");
			movie = new Movie(MovieName,ActorName,DirectorName,year);
			return movie;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

}