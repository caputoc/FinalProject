
public class TvEpisode extends Media<Integer> {

    private String showTitle;
    private int seasonNum;
    private int episodeNum;
    
    
    public TvEpisode(String title, String creator, int year, int duration, Integer rating, String showTitle, int seasonNum, int episodeNum) {
        super(title, creator, year, duration, rating);
        setShowTitle(showTitle);
        setSeasonNum(seasonNum);
        setEpisodeNum(episodeNum);
    }
    
    public String getShowTitle() {
        return showTitle;
    }

    public void setShowTitle(String showTitle) {
        if (showTitle == null || showTitle.isBlank()) {
            throw new IllegalArgumentException("Show Title cannot be null or blank");
        }
        this.showTitle = showTitle;
    }
    
    
    public int getSeasonNum() {
        return seasonNum;
    }

    public void setSeasonNum(int seasonNum) {
        if (seasonNum < 0) {
            throw new IllegalArgumentException("Season Number must be greater that 0");
        }
        this.seasonNum = seasonNum;
    }
    
    public int getEpisodeNum() {
        return episodeNum;
    }

    public void setEpisodeNum(int episodeNum) {
        if (episodeNum < 0) {
            throw new IllegalArgumentException("Episode Num must be greater that 0");
        }
        this.episodeNum = episodeNum;
    }
    
    @Override
    public String toString() {
        return String.format("Title: %s ShowTitle: %s Creator: %s  Year: %d Season Number: %d Episode Number: %d Duration: %d Rating: %d", getTitle(), showTitle, getCreator(), getYear(), seasonNum, episodeNum, getDuration(), getRating());
    }
}
