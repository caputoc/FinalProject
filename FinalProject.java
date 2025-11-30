import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;

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
        
        public static void printAllAudiobooks(List<Media<?>> media) {
            media.stream()
                .filter(a -> a instanceof Audiobook)
                .forEach(System.out::println);
        }
        
        public static void printAllTvEpisodes(List<Media<?>> media) {
            media.stream()
                .filter(a -> a instanceof TvEpisode)
                .forEach(System.out::println);
        }
        
        public static void printByCreator(List<Media<?>> media, String creator){
            media.stream()
                .filter(a -> a.getCreator().equals(creator))
                .forEach(System.out::println);
        }
        
        //public static void sortByRating(List<Media<?>> media) {
        //    media.sort((a,b) -> Double.compare(a.getRating(),b.getRating()));
        //}
        
        public static void sortByYear(List<Media<?>> media) {
            media.sort((a,b) -> Integer.compare(a.getYear(),b.getYear()));
        }
        
        public static void sortByTitle(List<Media<?>> media) {
            media.sort((a,b) -> a.getTitle().compareTo(b.getTitle()));
        }
        
        public static void printByYear(List<Media<?>> media, int year) {
            media.stream()
                .filter(a -> a.getYear() >= year)
                .forEach(System.out::println);
        }
        
        
    
        public static void main(String[] args) {
            
            /*
            List<Media<?>> media = createMedia(); 
            printAllMedia(media);
            System.out.println("\nTracks: ");
            printAllTracks(media);
            
            System.out.println("\nAudioBooks: ");
            printAllAudiobook(media);
            
            System.out.println("\nTvEpisode: ");
            printAllTvEpisode(media);
            
            System.out.println("\nCreator - Queen: ");
            printByCreator(media, "Queen");
            
            System.out.println("\nSorted by Year: ");
            sortByYear(media);
            printAllMedia(media);
            
            System.out.println("\nSorted by Title: ");
            sortByTitle(media);
            printAllMedia(media);
            
            System.out.println("\nPrint by Year: ");
            printByYear(media, 2002);
            */
           
           List<Media<?>> media = createMedia();
           Scanner input = new Scanner(System.in);
           int selection;
           
           boolean active = true;
           
           while(active) {
               System.out.println("Print all Media: Enter 1 ");
               System.out.println("Print all Tracks: Enter 2");
               System.out.println("Print all Audio Books: Enter 3");
               System.out.println("Print all TV Episodes: Enter 4");
               System.out.println("Print all Media Created By: Enter 5");
               System.out.println("Sort by Rating: Enter 6");
               System.out.println("Sort by Year: Enter 7");
               System.out.println("Sort by Title: Enter 8");
               System.out.println("Print all Media by Year: Enter 9");
               System.out.println("Exit Program: Enter 10");
               
                 try {
                   selection = input.nextInt();
                   input.nextLine();
                   
                   switch(selection) {
                       case 1:
                           printAllMedia(media);
                           System.out.println();
                           break;
                       case 2:
                           printAllTracks(media);
                           System.out.println();
                           break;
                       case 3:
                           printAllAudiobooks(media);
                           System.out.println();
                           break;
                       case 4:
                           printAllTvEpisodes(media);
                           System.out.println();
                           break;
                       case 5:
                           {
                               System.out.println("Please enter a creator: ");
                               String creatorName = input.nextLine();
                               
                               if(creatorName.isEmpty()) {
                                   System.out.println("Error: You must enter a valid name.");
                                   break;
                               }
                               
                               printByCreator(media, creatorName);
                               break;
                           }
                       case 6:
                           //sortByRating(media);
                           break;
                       case 7:
                           sortByYear(media);
                           break;
                       case 8:
                           sortByTitle(media);
                           break;
                       case 9:
                           System.out.println("Please enter a year: ");
                           int year = input.nextInt();
                           printByYear(media,year);
                           break;
                       case 10:
                           System.out.println("Goodbye!");
                           active = false;
                           input.close();
                           break;
                       default:
                           System.out.println("Invalid Input! Please enter a number 1-10.");
                           break;
                   }
               } catch (InputMismatchException e) {
                   System.out.println("Invalid Input! Please enter a number 1-10.");
                   input.nextLine();
               }
           }
        }
        
    
}
