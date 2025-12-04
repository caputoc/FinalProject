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
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.util.InputMismatchException;


public class FinalProject {

	private static void addTvEpisodeGUI(List<Media<?>> media) {
		JFrame addFrame = new JFrame("Add TV Episode");
		addFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addFrame.setSize(1600, 650);
		addFrame.setTitle("Add TV Episode");
		addFrame.setLayout(null);
		addFrame.getContentPane().setBackground(Color.DARK_GRAY);
		addFrame.setVisible(true);
		
		
		
		JTextField titleTxt = new JTextField();
		titleTxt.setBounds(36, 300, 175, 50);
		JTextField creatorTxt = new JTextField();
		creatorTxt.setBounds(213, 300, 175, 50);
		JTextField yearTxt = new JTextField();
		yearTxt.setBounds(390, 300, 175, 50);
		JTextField durationTxt = new JTextField();
		durationTxt.setBounds(567, 300, 175, 50);
		JTextField TvratingTxt = new JTextField();
		TvratingTxt.setBounds(744, 300, 175, 50);
		JTextField showTitleTxt = new JTextField();
		showTitleTxt.setBounds(921, 300, 175, 50);
		JTextField seasonNumTxt = new JTextField();
		seasonNumTxt.setBounds(1098, 300, 175, 50);
		JTextField episodeNumTxt = new JTextField();
		episodeNumTxt.setBounds(1275, 300, 175, 50);
		
		JLabel titleLabel = new JLabel();
		titleLabel.setBounds(90, 250, 175, 50);
		titleLabel.setText("Title");
		titleLabel.setForeground(Color.white);
		
		
		JLabel creatorLbl = new JLabel();
		creatorLbl.setBounds(253, 250, 175, 50);
		creatorLbl.setText("Creator");
		creatorLbl.setForeground(Color.white);
		
		JLabel yearLbl = new JLabel();
		yearLbl.setBounds(420, 250, 175, 50);
		yearLbl.setText("Year");
		yearLbl.setForeground(Color.white);
		
		JLabel durationLbl = new JLabel();
		durationLbl.setBounds(595, 250, 175, 50);
		durationLbl.setText("Duration");
		durationLbl.setForeground(Color.white);
		
		JLabel ratingLbl = new JLabel();
		ratingLbl.setBounds(744, 250, 235, 50);
		ratingLbl.setText("Rating (out of 10)");
		ratingLbl.setForeground(Color.white);
		
		JLabel showTitleLbl = new JLabel();
		showTitleLbl.setBounds(941, 250, 175, 50);
		showTitleLbl.setText("Show Title");
		showTitleLbl.setForeground(Color.white);
		
		JLabel seasonNumLbl = new JLabel();
		seasonNumLbl.setBounds(1118, 250, 175, 50);
		seasonNumLbl.setText("Season Number");
		seasonNumLbl.setForeground(Color.white);
		
		JLabel episodeNumLbl = new JLabel();
		episodeNumLbl.setBounds(1295, 250, 175, 50);
		episodeNumLbl.setText("Episode Number");
		episodeNumLbl.setForeground(Color.white);
		
		
		JButton addMediaBtn = new JButton("Add New TV Episode");
		addMediaBtn.addActionListener(a -> {
			try {
		        String title = titleTxt.getText();
		        String creator = creatorTxt.getText();
		        int year = Integer.parseInt(yearTxt.getText());
		        int duration = Integer.parseInt(durationTxt.getText());
		        int rating =  Integer.parseInt(TvratingTxt.getText());
		        String showTitle = showTitleTxt.getText();
		        int seasonNum = Integer.parseInt(seasonNumTxt.getText());
		        int episodeNum = Integer.parseInt(episodeNumTxt.getText());
		        String path = "media_database.csv";
		        addTvEpisode(media, title, creator, year, duration, rating, showTitle, seasonNum, episodeNum, path);

		        JOptionPane.showMessageDialog(addFrame, "TV Episode added!");
		        
		        
		        titleTxt.setText("");
		        creatorTxt.setText("");
		        yearTxt.setText("");
		        durationTxt.setText("");
		        TvratingTxt.setText("");
		        showTitleTxt.setText("");
		        seasonNumTxt.setText("");
		        episodeNumTxt.setText("");

		    } catch (NumberFormatException ex) {
		        JOptionPane.showMessageDialog(addFrame, 
		            "Please enter valid entries.",
		            "Invalid Input",
		            JOptionPane.ERROR_MESSAGE
		        );
		    }
			
			
		});
		addMediaBtn.setBounds(650, 352, 200, 50);
		addMediaBtn.setBorder(BorderFactory.createEmptyBorder());
		addMediaBtn.setBackground(Color.blue);
		addMediaBtn.setForeground(Color.WHITE);
		
		JButton ExitBtn = new JButton("Exit");
		ExitBtn.addActionListener(a -> GUI(media));
		ExitBtn.setBounds(1400, 460, 100, 30);
		ExitBtn.setBorder(BorderFactory.createEmptyBorder());
		ExitBtn.setBackground(Color.red);
		ExitBtn.setForeground(Color.black);
		
		addFrame.add(addMediaBtn);
		addFrame.add(TvratingTxt);
		addFrame.add(durationTxt);
		addFrame.add(yearTxt);
		addFrame.add(creatorTxt);
		addFrame.add(titleTxt);
		addFrame.add(ExitBtn);
		addFrame.add(showTitleTxt);
		addFrame.add(seasonNumTxt);
		addFrame.add(episodeNumTxt);
		addFrame.add(episodeNumLbl);
		addFrame.add(seasonNumLbl);
		addFrame.add(showTitleLbl);
		addFrame.add(ratingLbl);
		addFrame.add(durationLbl);
		addFrame.add(yearLbl);
		addFrame.add(creatorLbl);
		addFrame.add(titleLabel);
	}
	
	private static void addAudiobookGUI(List<Media<?>> media) {
		JFrame addFrame = new JFrame("Add Audiobook");
		addFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addFrame.setSize(1600, 550);
		addFrame.setTitle("Add Audiobook");
		addFrame.setLayout(null);
		addFrame.getContentPane().setBackground(Color.DARK_GRAY);
		addFrame.setVisible(true);
		
		JPanel addPanel = new JPanel();
		addPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		addPanel.setLayout(new GridLayout(5, 2, 5, 5));
		
		
		JTextField titleTxt = new JTextField();
		titleTxt.setBounds(203, 300, 200, 50);
		JTextField creatorTxt = new JTextField();
		creatorTxt.setBounds(405, 300, 200, 50);
		JTextField yearTxt = new JTextField();
		yearTxt.setBounds(607, 300, 200, 50);
		JTextField durationTxt = new JTextField();
		durationTxt.setBounds(809, 300, 200, 50);
		JTextField AudioratingTxt = new JTextField();
		AudioratingTxt.setBounds(1011, 300, 200, 50);
		
		JLabel titleLabel = new JLabel();
		titleLabel.setBounds(240, 250, 175, 50);
		titleLabel.setText("Title");
		titleLabel.setForeground(Color.white);
		
		
		JLabel creatorLbl = new JLabel();
		creatorLbl.setBounds(430, 250, 175, 50);
		creatorLbl.setText("Creator");
		creatorLbl.setForeground(Color.white);
		
		JLabel yearLbl = new JLabel();
		yearLbl.setBounds(640, 250, 175, 50);
		yearLbl.setText("Year");
		yearLbl.setForeground(Color.white);
		
		JLabel durationLbl = new JLabel();
		durationLbl.setBounds(840, 250, 175, 50);
		durationLbl.setText("Duration");
		durationLbl.setForeground(Color.white);
		
		JLabel ratingLbl = new JLabel();
		ratingLbl.setBounds(1012, 250, 215, 50);
		ratingLbl.setText("Thumb Rating (Up or Down)");
		ratingLbl.setForeground(Color.white);
		
		JButton addMediaBtn = new JButton("Add New Audiobook");
		addMediaBtn.addActionListener(a -> {try {
	        String title = titleTxt.getText();
	        String creator = creatorTxt.getText();
	        int year = Integer.parseInt(yearTxt.getText());
	        int duration = Integer.parseInt(durationTxt.getText());
	        ThumbRating rating =  ThumbRating.valueOf(AudioratingTxt.getText().toUpperCase());

	        String path = "media_database.csv";
	        addAudiobook(media, title, creator, year, duration, rating, path);

	        JOptionPane.showMessageDialog(addFrame, "Audiobook added!");
	        
	        
	        titleTxt.setText("");
	        creatorTxt.setText("");
	        yearTxt.setText("");
	        durationTxt.setText("");
	        AudioratingTxt.setText("");

	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(addFrame, 
	            "Please enter valid entries.",
	            "Invalid Input",
	            JOptionPane.ERROR_MESSAGE
	        );
	    }
	});
			
			
		addMediaBtn.setBounds(650, 352, 200, 50);
		addMediaBtn.setBorder(BorderFactory.createEmptyBorder());
		addMediaBtn.setBackground(Color.blue);
		addMediaBtn.setForeground(Color.WHITE);
		
		JButton ExitBtn = new JButton("Exit");
		ExitBtn.addActionListener(a -> GUI(media));
		ExitBtn.setBounds(1400, 460, 100, 30);
		ExitBtn.setBorder(BorderFactory.createEmptyBorder());
		ExitBtn.setBackground(Color.red);
		ExitBtn.setForeground(Color.black);
		
		addFrame.add(addMediaBtn);
		addFrame.add(AudioratingTxt);
		addFrame.add(durationTxt);
		addFrame.add(yearTxt);
		addFrame.add(creatorTxt);
		addFrame.add(titleTxt);
		addFrame.add(ExitBtn);
		addFrame.add(ratingLbl);
		addFrame.add(durationLbl);
		addFrame.add(yearLbl);
		addFrame.add(creatorLbl);
		addFrame.add(titleLabel);
	
	}
	
	private static void addTrackGUI(List<Media<?>> media) {
		JFrame addFrame = new JFrame("Add Track");
		addFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addFrame.setSize(1600, 550);
		addFrame.setTitle("Add Track");
		addFrame.setLayout(null);
		addFrame.getContentPane().setBackground(Color.DARK_GRAY);
		addFrame.setVisible(true);
		
		JPanel addPanel = new JPanel();
		addPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		addPanel.setLayout(new GridLayout(5, 2, 5, 5));
		
		JTextField titleTxt = new JTextField();
		titleTxt.setBounds(1, 300, 200, 50);
		JTextField creatorTxt = new JTextField();
		creatorTxt.setBounds(203, 300, 200, 50);
		JTextField albumTxt = new JTextField();
		albumTxt.setBounds(405, 300, 200, 50);
		JTextField yearTxt = new JTextField();
		yearTxt.setBounds(607, 300, 200, 50);
		JTextField durationTxt = new JTextField();
		durationTxt.setBounds(809, 300, 200, 50);
		JTextField ratingTxt = new JTextField();
		ratingTxt.setBounds(1011, 300, 200, 50);
		
		JLabel titleLabel = new JLabel();
		titleLabel.setBounds(10, 250, 175, 50);
		titleLabel.setText("Title");
		titleLabel.setForeground(Color.white);
		
		
		JLabel creatorLbl = new JLabel();
		creatorLbl.setBounds(273, 250, 175, 50);
		creatorLbl.setText("Creator");
		creatorLbl.setForeground(Color.white);
		
		JLabel albumLbl = new JLabel();
		albumLbl.setBounds(450, 250, 175, 50);
		albumLbl.setText("Album");
		albumLbl.setForeground(Color.white);
		
		JLabel yearLbl = new JLabel();
		yearLbl.setBounds(620, 250, 175, 50);
		yearLbl.setText("Year");
		yearLbl.setForeground(Color.white);
		
		JLabel durationLbl = new JLabel();
		durationLbl.setBounds(830, 250, 175, 50);
		durationLbl.setText("Duration");
		durationLbl.setForeground(Color.white);
		
		JLabel ratingLbl = new JLabel();
		ratingLbl.setBounds(1020, 250, 175, 50);
		ratingLbl.setText("Rating (up to 5, with decimals)");
		ratingLbl.setForeground(Color.white);
		
		JButton addMediaBtn = new JButton("Add New Track");
		addMediaBtn.addActionListener(a ->  {try {
	        String title = titleTxt.getText();
	        String creator = creatorTxt.getText();
	        String album = albumTxt.getText();

	        int year = Integer.parseInt(yearTxt.getText());
	        int duration = Integer.parseInt(durationTxt.getText());
	        double rating = Double.parseDouble(ratingTxt.getText());

	        String path = "media_database.csv";
	        addTrack(media, title, creator, album, year, duration, rating, path);

	        JOptionPane.showMessageDialog(addFrame, "Track added!");
	        
	        
	        titleTxt.setText("");
	        creatorTxt.setText("");
	        albumTxt.setText("");
	        yearTxt.setText("");
	        durationTxt.setText("");
	        ratingTxt.setText("");

	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(addFrame, 
	            "Please enter valid entries.",
	            "Invalid Input",
	            JOptionPane.ERROR_MESSAGE
	        );
	    }
	});
		
		addMediaBtn.setBounds(650, 352, 200, 50);
		addMediaBtn.setBorder(BorderFactory.createEmptyBorder());
		addMediaBtn.setBackground(Color.blue);
		addMediaBtn.setForeground(Color.WHITE);
		
		JButton ExitBtn = new JButton("Exit");
		ExitBtn.addActionListener(a -> GUI(media));
		ExitBtn.setBounds(1400, 460, 100, 30);
		ExitBtn.setBorder(BorderFactory.createEmptyBorder());
		ExitBtn.setBackground(Color.red);
		ExitBtn.setForeground(Color.black);
		
		addFrame.add(addMediaBtn);
		addFrame.add(ratingTxt);
		addFrame.add(durationTxt);
		addFrame.add(yearTxt);
		addFrame.add(albumTxt);
		addFrame.add(creatorTxt);
		addFrame.add(titleTxt);
		addFrame.add(ExitBtn);
		addFrame.add(ratingLbl);
		addFrame.add(durationLbl);
		addFrame.add(yearLbl);
		addFrame.add(creatorLbl);
		addFrame.add(titleLabel);
		addFrame.add(albumLbl);
		
		
	}
	
	private static void GUI(List<Media<?>> media) {
		
		JFrame frame = new JFrame("Media");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1600, 550);
		frame.setTitle("Media Menu");
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setVisible(true);
		
		
		
		JButton addTrackBtn = new JButton("Go To Add New Track");
		addTrackBtn.addActionListener(a -> addTrackGUI(media));
		addTrackBtn.setBounds(250, 52, 200, 50);
		addTrackBtn.setBorder(BorderFactory.createEmptyBorder());
		addTrackBtn.setBackground(Color.blue);
		addTrackBtn.setForeground(Color.WHITE);
		
		frame.add(addTrackBtn);
		
		JButton addAudiobookBtn = new JButton("Go To Add New AudioBook");
		addAudiobookBtn.addActionListener(a -> addAudiobookGUI(media));
		addAudiobookBtn.setBounds(250, 104, 200, 50);
		addAudiobookBtn.setBorder(BorderFactory.createEmptyBorder());
		addAudiobookBtn.setBackground(Color.blue);
		addAudiobookBtn.setForeground(Color.WHITE);
		
		frame.add(addAudiobookBtn);
		
		JButton addTVBtn = new JButton("Go To Add New TV Episode");
		addTVBtn.addActionListener(a -> addTvEpisodeGUI(media));
		addTVBtn.setBounds(250, 156, 200, 50);
		addTVBtn.setBorder(BorderFactory.createEmptyBorder());
		addTVBtn.setBackground(Color.blue);
		addTVBtn.setForeground(Color.WHITE);
		
		frame.add(addTVBtn);
		
		JButton printAllBtn = new JButton("Print All Media");
		printAllBtn.addActionListener(a -> printAllMedia(media));
		printAllBtn.setBounds(650, 0, 200, 50);
		printAllBtn.setBorder(BorderFactory.createEmptyBorder());
		printAllBtn.setBackground(Color.blue);
		printAllBtn.setForeground(Color.WHITE);
		
		JButton printTracksBtn = new JButton("Print All Tracks");
		printTracksBtn.addActionListener(a -> printAllTracks(media));
		printTracksBtn.setBounds(650, 52, 200, 50);
		printTracksBtn.setBorder(BorderFactory.createEmptyBorder());
		printTracksBtn.setBackground(Color.blue);
		printTracksBtn.setForeground(Color.WHITE);
		
		JButton printAudiobooksBtn = new JButton("Print All AudioBooks Media");
		printAudiobooksBtn.addActionListener(a -> printAllAudiobooks(media));
		printAudiobooksBtn.setBounds(650, 104, 200, 50);
		printAudiobooksBtn.setBorder(BorderFactory.createEmptyBorder());
		printAudiobooksBtn.setBackground(Color.blue);
		printAudiobooksBtn.setForeground(Color.WHITE);
		
		JButton printTvBtn = new JButton("Print All TV Episodes Media");
		printTvBtn.addActionListener(a -> printAllTvEpisodes(media));
		printTvBtn.setBounds(650, 156, 200, 50);
		printTvBtn.setBorder(BorderFactory.createEmptyBorder());
		printTvBtn.setBackground(Color.blue);
		printTvBtn.setForeground(Color.WHITE);
		
		JTextField creatorTxt = new JTextField();
		creatorTxt.setBounds(870, 208, 200, 50);
		
		
		JButton printByCreatorBtn = new JButton("Print All By Creator");
		printByCreatorBtn.addActionListener(a -> {
		String creator = creatorTxt.getText();	
		printByCreator(media, creator);}
		);
		
		printByCreatorBtn.setBounds(650, 208, 200, 50);
		printByCreatorBtn.setBorder(BorderFactory.createEmptyBorder());
		printByCreatorBtn.setBackground(Color.blue);
		printByCreatorBtn.setForeground(Color.WHITE);
		
		JButton sortByRatingBtn = new JButton("Sort By Rating");
		sortByRatingBtn.addActionListener(a -> sortByRating(media));
		sortByRatingBtn.setBounds(650, 260, 200, 50);
		sortByRatingBtn.setBorder(BorderFactory.createEmptyBorder());
		sortByRatingBtn.setBackground(Color.blue);
		sortByRatingBtn.setForeground(Color.WHITE);
		
		JButton sortByYearBtn = new JButton("Sort By Year");
		sortByYearBtn.addActionListener(a -> sortByYear(media));
		sortByYearBtn.setBounds(650, 312, 200, 50);
		sortByYearBtn.setBorder(BorderFactory.createEmptyBorder());
		sortByYearBtn.setBackground(Color.blue);
		sortByYearBtn.setForeground(Color.WHITE);
		
		JButton sortByTitleBtn = new JButton("Sort By Title");
		sortByTitleBtn.addActionListener(a -> sortByTitle(media));
		sortByTitleBtn.setBounds(650, 364, 200, 50);
		sortByTitleBtn.setBorder(BorderFactory.createEmptyBorder());
		sortByTitleBtn.setBackground(Color.blue);
		sortByTitleBtn.setForeground(Color.WHITE);
		
		JTextField yearTxt = new JTextField();
		yearTxt.setBounds(870, 416, 200, 50);
		JButton printByYearBtn = new JButton("Print All By Year");
		printByYearBtn.addActionListener(a -> {
		try {	
		int year = Integer.parseInt(yearTxt.getText());	
		printByYear(media, year);
		
		
		}
		 catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(frame, 
	            "Please enter valid entry.",
	            "Invalid Input",
	            JOptionPane.ERROR_MESSAGE);
		 }    
		});
		printByYearBtn.setBounds(650, 416, 200, 50);
		printByYearBtn.setBorder(BorderFactory.createEmptyBorder());
		printByYearBtn.setBackground(Color.blue);
		printByYearBtn.setForeground(Color.WHITE);
		
		JTextField titleTxt = new JTextField();
		titleTxt.setBounds(870, 468, 200, 50);
		
		JButton removeBtn = new JButton("Remove by Title");
		removeBtn.addActionListener(a -> { 
		String path = "media_database.csv";
		String title = titleTxt.getText();	
		removeMedia(media, path, title);
		JOptionPane.showMessageDialog(frame, "Media removed!");
		
		
		}
		);
		
		removeBtn.setBounds(650, 468, 200, 50);
		removeBtn.setBorder(BorderFactory.createEmptyBorder());
		removeBtn.setBackground(Color.blue);
		removeBtn.setForeground(Color.WHITE);
		
		JButton clearBtn = new JButton("Clear Console");
		clearBtn.addActionListener(a -> clearConsole());
		clearBtn.setBounds(1400, 420, 100, 30);
		clearBtn.setBorder(BorderFactory.createEmptyBorder());
		clearBtn.setBackground(Color.MAGENTA);
		clearBtn.setForeground(Color.black);
		
		JButton ExitBtn = new JButton("Exit");
		ExitBtn.addActionListener(a -> System.exit(0));
		ExitBtn.setBounds(1400, 460, 100, 30);
		ExitBtn.setBorder(BorderFactory.createEmptyBorder());
		ExitBtn.setBackground(Color.red);
		ExitBtn.setForeground(Color.black);
		
		frame.add(printAllBtn);
		frame.add(printTracksBtn);
		frame.add(printByCreatorBtn);
		frame.add(printAudiobooksBtn);
		frame.add(printTvBtn);
		frame.add(creatorTxt);
		frame.add(sortByYearBtn);
		frame.add(sortByTitleBtn);
		frame.add(printByYearBtn);
		frame.add(yearTxt);
		frame.add(clearBtn);
		frame.add(ExitBtn);
		frame.add(sortByRatingBtn);
		frame.add(removeBtn);
		frame.add(titleTxt);
	}
	
	public static void clearConsole() {
		for (int i = 0; i < 50; ++i) {
	        System.out.println();
	    }
	}

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
                     int trackYear = Integer.parseInt(columns[4]);
                     int trackDuration = Integer.parseInt(columns[5]);
                     double trackRating = Double.parseDouble(columns[6]);
                     mediaList.add(new Track(title, creator, album, trackYear, trackDuration, trackRating));
                     break;

                 case "AudioBook":
                     int abYear = Integer.parseInt(columns[4]);
                     int abDuration = Integer.parseInt(columns[5]);
                     ThumbRating abRating = ThumbRating.valueOf(columns[6].toUpperCase());
                     mediaList.add(new Audiobook(title, creator, abYear, abDuration, abRating));
                     break;

                 case "TVEpisode":
                     int tvYear = Integer.parseInt(columns[4]);
                     int tvDuration = Integer.parseInt(columns[5]);
                     int tvRating = Integer.parseInt(columns[6]);
                     String showTitle = columns[7];
                     int seasonNum = Integer.parseInt(columns[8]);
                     int episodeNum = Integer.parseInt(columns[9]);
                     mediaList.add(new TvEpisode(title, creator, tvYear, tvDuration, tvRating, showTitle, seasonNum, episodeNum));
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
        
        public static void addTrack(List<Media<?>> media, String title, String creator, String album, int year, int duration, double rating, String path) {
        	 try (PrintWriter writer = new PrintWriter(new FileWriter(path, true))) {
        		 
        		 Track track = new Track(title, creator, album, year, duration, rating);
                 media.add(track);
                 
                 writer.println("Track," + title + "," + creator + "," + album + "," + year + "," + duration + "," + rating);
                 
                
        	 }
        	 catch (IOException e) {
                 System.out.println("Error writing to file.");
             }
        }
        
        public static void addAudiobook(List<Media<?>> media, String title, String creator, int year, int duration, ThumbRating rating, String path) {
       	 try (PrintWriter writer = new PrintWriter(new FileWriter(path, true))) {
       		 
       		 Audiobook audiobook = new Audiobook(title, creator, year, duration, rating);
                media.add(audiobook);
                
                writer.println("AudioBook," + title + "," + creator + ",,"  + year + "," + duration + "," + rating);
                
               
       	 }
       	 catch (IOException e) {
                System.out.println("Error writing to file.");
            }
       }
        
        public static void addTvEpisode(List<Media<?>> media, String title, String creator, int year, int duration, int rating, String showTitle, int seasonNum, int episodeNum, String path) {
       	 try (PrintWriter writer = new PrintWriter(new FileWriter(path, true))) {
       		 
       		TvEpisode tvEpisode = new TvEpisode(title, creator, year, duration, rating, showTitle, seasonNum, episodeNum);
            media.add(tvEpisode);
            
            writer.println("TVEpisode," + title + "," + creator + ",," + year + "," + duration + "," + rating + "," + showTitle + "," + seasonNum + "," + episodeNum);

               
       	 }
       	 catch (IOException e) {
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
                        writer.println("AudioBook," + a.getTitle() + "," + a.getCreator() + ",," + a.getYear() + "," + a.getDuration() + "," + a.getRating());
                      
                    } else if (m instanceof Track t) {
                        writer.println("Track," + t.getTitle() + "," + t.getCreator() + "," + t.getAlbum() + "," + t.getYear() + "," + t.getDuration() + "," + t.getRating());
                      
                    } else if (m instanceof TvEpisode e) {
                        writer.println("TVEpisode," + e.getTitle() + "," + e.getCreator() + ",," + e.getYear() + "," + e.getDuration() + "," + e.getRating() + "," + e.getShowTitle() + "," + e.getSeasonNum() + "," + e.getEpisodeNum());
                   
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
        
        public static void sortByRating(List<Media<?>> media) {
        	media.stream()
            .sorted((a, b) -> Double.compare(normalizeRating(b.getRating()), normalizeRating(a.getRating())))
            .forEach(System.out::println);
        }
        
        public static double normalizeRating(Object rating) {
            if(rating instanceof Double d) {
                return d;
            } else if (rating instanceof Integer i) {
                return i/2.0;
            } else if (rating instanceof ThumbRating) {
                ThumbRating e = (ThumbRating) rating;
                if(e == ThumbRating.UP){
                    return 4.6;
                } else if(e == ThumbRating.DOWN) {
                    return 2.0;
                }
            }
            return 0.0;
        }
        
        public static void sortByYear(List<Media<?>> media) {
            media.sort((a,b) -> Integer.compare(a.getYear(),b.getYear()));
            media.forEach(System.out::println);
        }
        
        public static void sortByTitle(List<Media<?>> media) {
            media.sort((a,b) -> a.getTitle().compareTo(b.getTitle()));
            media.forEach(System.out::println);
        }
        
        public static void printByYear(List<Media<?>> media, int year) {
            media.stream()
                .filter(a -> a.getYear() >= year)
                .forEach(System.out::println);
        }
        
        
    
        public static void main(String[] args) {
            
        
           List<Media<?>> media = createMedia();
           GUI(media);
 
        }
        
    
}
