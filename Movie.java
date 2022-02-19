
public class Movie {
	private String name;
	private String actor;
	private String director;
	private int year_of_release;

	public enum MovieAttribute {
		name, actor, director, year
	}

	public Movie(String name, String actor, String director, int yearOfRelease) {
		this.name = name;
		this.actor = actor;
		this.director = director;
		year_of_release = yearOfRelease;
	}

	// getter
	public String getMovieName() {
		return name;
	}

	public String getActorName() {
		return actor;
	}

	public String getDirectorName() {
		return director;
	}

	public int getYearOfRelease() {
		return year_of_release;
	}

	public void DisplayMovie() {

		System.out.print(name + " | \t");
		System.out.print(actor + " | \t");
		System.out.print(director + " | \t");
		System.out.println(director + " | \t");
	}

}