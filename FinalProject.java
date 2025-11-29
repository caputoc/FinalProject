import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class FinalProject {

	 private static int getLineCount(String path) throws IOException {
	        File file = new File(path);
	        int lineCount = 0;

	        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
	            while(reader.readLine() != null) {
	                lineCount++;
	            }
	        }
	        catch(IOException e) {
	            throw e;
	        }
	        return lineCount;
	    }

	    private static List<Media<?>> readMediaFromFile(String path) throws IOException{
	        List<Media<?>> mediaList = new ArrayList<>();
	    	
	    	int numMedia = getLineCount(path) - 1;
	       

	        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
	            String line = reader.readLine();

	            for(int i = 0; i < numMedia; i++) {
	                line = reader.readLine();
	                String[] columns = line.split(",");
	                
	                String type = columns[0];
	                String title = columns[1];
	                String creator = columns[2];
	                int year = Integer.parseInt(columns[4]);
	                int duration = Integer.parseInt(columns[5]);
	                String stringRating = columns[6];
	                
	                switch(type) {
	                
	                case "Track":
	                	
	                	String album = columns[3];
	                	Track track = new Track(title, creator, album, year, duration);
	                	track.setRating(Double.parseDouble(stringRating));
	                	mediaList.add(track);
	                	break;
	                
	                case "AudioBook":
	                	Audiobook audiobook = new Audiobook(title, creator, year, duration);
	                	ThumbRating thumbRating = ThumbRating.valueOf(stringRating.toUpperCase());
	                	audiobook.setRating(thumbRating);
	                	mediaList.add(audiobook);
	                	break;
	                
	                case "TVEpisode":
	                	String showTitle = columns[7];
	                	int seasonNum = Integer.parseInt(columns[8]);
	                	int episodeNum = Integer.parseInt(columns[9]);
	                	TvEpisode tvEpisode = new TvEpisode(title, showTitle, creator, year, seasonNum, episodeNum, duration);
	                	tvEpisode.setRating(Integer.parseInt(stringRating));
	                	mediaList.add(tvEpisode);
	                	break;
	                
	                }
	            }
	        }
	        catch(IOException e) {
	            throw e;
	        }
	        return mediaList;
	    }
	    
	    public static List<Media<?>> createMedia() {
	    	String path = "media_database.csv";
	    	
	    	List<Media<?>> media = new ArrayList<>();
	    	
	    	try {
	            media = readMediaFromFile(path);
	        }
	        catch(IOException e) {
	            System.out.println("Error reading file: " + e.getMessage());
	        }
	        catch(NumberFormatException e) {
	            System.out.println("Error parsing number: " + e.getMessage());
	        }
	        catch(Exception e) {
	            System.out.println("An unexpected error occcured: " + e.getMessage());
	        }

	    	return media;
	    }
	    
	    public static void printAllMedia(List<Media<?>> media) {
	    	media.forEach(System.out::println);
	    }
	    
	    public static void printAllTracks(List<Media<?>> media) {
	    	media.stream()
	    		.filter(a -> a instanceof Track)
	    		.forEach(System.out::println);
	    }
	
	    public static void main(String[] args) {
	    	
	    	List<Media<?>> media = createMedia(); 
	    	printAllMedia(media);
	    	System.out.println("\nTracks: ");
	    	printAllTracks(media);
	    	
	    }
	    
	
}
