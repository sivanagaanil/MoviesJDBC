
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	String tableName;

	public static void main(String[] args) {

		Movie FreeGuy = new Movie("Free Guy", "Ryan Reynolds", "Shawn Levy", 2021);
		Movie Cruella = new Movie("Cruella", "Emma Stone", "Craig Gillespie", 2021);
		Movie Tenet = new Movie("Tenet", "John David Washington", "Christopher Nolan", 2020);
		Movie HarleyQuinn = new Movie("Harley Quinn: Birds of Prey", "Margot Robbie", "Cathy Yan", 2020);
		Connection connection = null;

		try {
			// create a database connection
			connection = DriverManager.getConnection("jdbc:sqlite:MovieDatabase.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.

			statement.executeUpdate("drop table if exists Movie");

			statement.executeUpdate("create table Movie (name string, actor string, director string,year integer)");
			SqliteHandler.InsertNewMovie(statement, "Movie", FreeGuy);
			SqliteHandler.InsertNewMovie(statement, "Movie", Cruella);
			SqliteHandler.InsertNewMovie(statement, "Movie", Tenet);
			SqliteHandler.InsertNewMovie(statement, "Movie", HarleyQuinn);

			ResultSet rs = SqliteHandler.getAllMoviResult(statement, "Movie");

			while (rs.next()) {
				// read the result set
				Movie selectedMovie = SqliteHandler.FatchMovieFromDataBase(rs);
				selectedMovie.DisplayMovie();
			}
		} catch (SQLException e) {
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// connection close failed.
				System.err.println(e.getMessage());
			}
		}
	}
}