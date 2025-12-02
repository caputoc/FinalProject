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
import java.io.PrintWriter;

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
                        Double trackRating = Double.parseDouble(columns[6]);
                        Track track = new Track(title, creator, album, year, duration, trackRating);
                        mediaList.add(track);
                        break;
                    
                    case "AudioBook":
                        ThumbRating thumbRating = ThumbRating.valueOf(stringRating.toUpperCase());
                        Audiobook audiobook = new Audiobook(title, creator, year, duration, thumbRating);
                        mediaList.add(audiobook);
                        break;
                    
                    case "TVEpisode":
                        String showTitle = columns[7];
                        int seasonNum = Integer.parseInt(columns[8]);
                        int episodeNum = Integer.parseInt(columns[9]);
                        Integer tvRating = Integer.parseInt(columns[6]);
                        TvEpisode tvEpisode = new TvEpisode(title, creator, year, duration, tvRating, showTitle, seasonNum, episodeNum);
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
        
        public static void addMedia(List<Media<?>> media, String path) {
            Scanner input = new Scanner(System.in);
            System.out.println("What type of media are you adding: (1) Track, (2) AudioBook, (3) TVEpisode");
            int selection = input.nextInt();
            input.nextLine();
            
            try (PrintWriter writer = new PrintWriter(new FileWriter(path, true))) {
                if (selection == 1) {
                    System.out.println("Title: ");
                    String title = input.nextLine();
                    System.out.println("Creator: ");
                    String creator = input.nextLine();
                    System.out.println("Album: ");
                    String album = input.nextLine();
                    System.out.println("Year: ");
                    int year = input.nextInt();
                    System.out.println("Duration: ");
                    int duration = input.nextInt();
                    System.out.println("Rating: ");
                    Double rating = input.nextDouble();
                    input.nextLine();
    
                    Track track = new Track(title, creator, album, year, duration, rating);
                    media.add(track);
                    
                    writer.println("Track," + title + "," + creator + "," + album + "," + year + "," + duration + "," + rating);
                } else if (selection == 2) {
                    System.out.println("Title: ");
                    String title = input.nextLine();
                    System.out.println("Creator: ");
                    String creator = input.nextLine();
                    System.out.println("Year: ");
                    int year = input.nextInt();
                    System.out.println("Duration: ");
                    int duration = input.nextInt();
                    input.nextLine();
                    System.out.println("Rating: ");
                    ThumbRating rating = ThumbRating.valueOf(input.nextLine().toUpperCase());
    
                    Audiobook audiobook = new Audiobook(title, creator, year, duration, rating);
                    media.add(audiobook);
                    
                    writer.println("Audiobook" + "," + title + "," + creator + "," + "," + year + "," + duration + "," + rating);
                } else if (selection == 3) {
                    System.out.println("Title: ");
                    String title = input.nextLine();
                    System.out.println("Creator: ");
                    String creator = input.nextLine();
                    System.out.println("Year: ");
                    int year = input.nextInt();
                    System.out.println("Duration: ");
                    int duration = input.nextInt();
                    System.out.println("Rating: ");
                    Integer rating = input.nextInt();
                    input.nextLine();
                    System.out.println("Show Title: ");
                    String showTitle = input.nextLine();
                    System.out.println("Season Number: ");
                    int seasonNum = input.nextInt();
                    System.out.println("Episode Number: ");
                    int episodeNum = input.nextInt();
                    
                    TvEpisode tvEpisode = new TvEpisode(title, creator, year, duration, rating, showTitle, seasonNum, episodeNum);
                    media.add(tvEpisode);
                    
                    writer.println("TVEpisode" + "," + title + "," + creator + "," + "," + year + "," + duration + "," + rating + "," + showTitle + "," + seasonNum + "," + episodeNum);
    
                }
                
                System.out.println("Media has been added.");
            } catch (IOException e) {
                System.out.println("Error writing to file.");
            }
            
            
        }
        
        public static void removeMedia(List<Media<?>> media, String path, String title) {
            
            boolean removed = media.removeIf(a -> a.getTitle().equalsIgnoreCase(title));
            
            if(!removed) {
                System.out.println("Media not found.");
                return;
            }
            
            try (PrintWriter writer = new PrintWriter(new FileWriter(path))){
                for(Media<?> m : media) {
                    if(m instanceof Audiobook a) {
                        writer.println("Audiobook," + a.getTitle() + "," + a.getCreator() + "," + "," + a.getYear() + "," + a.getDuration() + "," + a.getRating());
                    } else if (m instanceof Track t) {
                        writer.println("Track," + t.getTitle() + "," + t.getCreator() + "," + t.getAlbum() + "," + t.getYear() + "," + t.getDuration() + "," + t.getRating());
                    } else if (m instanceof TvEpisode e) {
                        writer.println("TvEpisode," + e.getTitle() + "," + e.getCreator() + "," + "," + e.getYear() + "," + e.getDuration() + "," + e.getRating() + "," + e.getShowTitle() + "," + e.getSeasonNum() + "," + e.getEpisodeNum());
                    }
                }
            } catch (IOException e) {
                System.out.println("File not rewriten.");
            }
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
           String path = "media_database.csv";
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
               System.out.println("Add Media Object: Enter 10");
               System.out.println("Remove Media Object: Enter 11");
               System.out.println("Exit Program: Enter 0");
               
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
                               addMedia(media, path); 
                               break;
                       case 11:
                            {
                               System.out.println("Please enter a title: ");
                               String titleName = input.nextLine();
                               
                               if(titleName.isEmpty()) {
                                   System.out.println("Error: You must enter a valid name.");
                                   break;
                               }
                               
                               removeMedia(media, path, titleName);
                               break;
                            }
                       case 0:
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
