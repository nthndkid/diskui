package ProposedSystem;

import java.util.Scanner;
import java.io.IOException;

public class mp3App {
    private static final int MAX_MUSIC = 10; 
    private static final int MAX_DURATION = 300; 
    private String[] musicLibrary; // Array to store music tracks
    private int[] musicDurations; // Array to store music durations
    private int currentTrackIndex; // Index of currently playing track
    private int currentTime; // Current time
    private boolean isPlaying; // indicate if music is playing
    
    
    public mp3App() {
        musicLibrary = new String[MAX_MUSIC];
        musicDurations = new int[MAX_MUSIC];
        currentTrackIndex = -1;
        currentTime = 0;
        isPlaying = false;
    }

    public void addMusic(String title, String artist, int duration) {
        if (currentTrackIndex < MAX_MUSIC - 1) {
            currentTrackIndex++;
            musicLibrary[currentTrackIndex] = title + " - " + artist;
            musicDurations[currentTrackIndex] = Math.min(duration * 60, MAX_DURATION);
            System.out.println("Music added: \n" + title + " - " + artist);
        } 
        else {
            System.out.println("Music library full. Cannot add more music.");
        }
    }

    public void play() {
        if (currentTrackIndex >= 0 && currentTrackIndex < MAX_MUSIC) {
            isPlaying = true;
            System.out.println("Playing: " + musicLibrary[currentTrackIndex]);
            System.out.println("Press | 1 - pause | 2 - previous | 3 - next | 4 - stop \n");

            try {
                while (isPlaying) {
                    int input = System.in.read();
                    switch (input) {
                        case '1':
                            if (isPlaying) {
                                pause();
                            } else {
                                resume();
                            }
                            break;
                        case '2':
                            prev();
                            break;
                        case '3':
                            next();
                            break;
                        case '4':
                            System.out.println("Stopping playback.");
                            isPlaying = false;
                            return; 
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No music selected to play.");
        }
    }

    public void pause() {
        if (isPlaying) {
            System.out.println("Paused: " + musicLibrary[currentTrackIndex] + " - " + currentTime + "s");
            isPlaying = false;
        } 
        else {
            System.out.println("No music is currently playing.");
        }
    }

    public void resume() {
        if (!isPlaying) {
            System.out.println("Resuming playback: " + musicLibrary[currentTrackIndex]);
            isPlaying = true;
        } 
        else {
            System.out.println("Music is already playing.");
        }
    }

    public void next() {
        if (currentTrackIndex < MAX_MUSIC - 1) {
            currentTrackIndex++;
            System.out.println("Next music: " + musicLibrary[currentTrackIndex]);
            currentTime = 0;
            
            if (isPlaying) {
                play();
            }
        } 
        else {
            System.out.println("End of music library reached.");
        }
    }

    public void prev() {
        if (currentTrackIndex > 0) {
            currentTrackIndex--;
            System.out.println("Previous music: " + musicLibrary[currentTrackIndex]);
            currentTime = 0;
            
            if (isPlaying) {
                play();
            }
        } 
        else {
            System.out.println("Beginning of music library reached.");
        }
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        mp3App mp3 = new mp3App();

        while (true) {
            System.out.println("\nMP3 APP MENU");
            System.out.println("1. Add Music");
            System.out.println("2. Play Music");
            System.out.println("3. Next");
            System.out.println("4. Previous");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = userInput.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter music title: ");
                    userInput.nextLine();
                    String title = userInput.nextLine();
                    
                    System.out.print("Enter Artist Name: ");
                    String artist = userInput.nextLine();
                    
                    System.out.print("Enter music minutes duration: ");
                    int duration = userInput.nextInt();
                    
                    mp3.addMusic(title, artist, duration);
                    break;
                case 2:
                    mp3.play();
                    break;
                case 3:
                    mp3.next();
                    break;
                case 4:
                    mp3.prev();
                    break;
                case 5:
                    System.out.println("Exiting MP3 App.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1-5.");
            }
        }
    }
}
