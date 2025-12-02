
public class Track extends Media<Double>{

    private String album;
    
    public Track(String title, String creator, String album, int year, int duration, Double rating) {
        super(title, creator, year, duration, rating);
        setAlbum(album);
    }
    
    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        if (album == null || album.isBlank()) {
            throw new IllegalArgumentException("Album cannot be null or blank");
        }
        this.album = album;
    }
    
    @Override
    public String toString() {
        return String.format("Title: %s Creator: %s Album: %s Year: %d Duration: %d Rating: %.1f", getTitle(), getCreator(), album, getYear(), getDuration(), getRating());
    }
    
}
