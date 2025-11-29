
public class Audiobook extends Media{

	public Audiobook(String title, String creator, int year, int duration) {
		super(title, creator, year, duration);
		
	}
	
	@Override
	public String toString() {
		return String.format("Title: %s Creator: %s Year: %d Duration: %d Rating: %s", getTitle(), getCreator(), getYear(), getDuration(), getRating());
	}
}
