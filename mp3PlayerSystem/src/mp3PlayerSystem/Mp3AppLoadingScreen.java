package mp3PlayerSystem;

import javax.swing.*;
import java.awt.*;

public class Mp3AppLoadingScreen extends JFrame {

    public Mp3AppLoadingScreen() {
        super("MP3 App Loading");

        // Create components
        JLabel titleLabel = new JLabel("Welcome to Your MP3 App");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel loadingLabel = new JLabel("Loading...");
        loadingLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        loadingLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JProgressBar progressBar = new JProgressBar();
        progressBar.setIndeterminate(true); // Indeterminate progress bar for loading animation

        // Set layout (Null layout for absolute positioning)
        setLayout(null);

        // Set bounds and add components
        titleLabel.setBounds(50, 50, 300, 30); // (x, y, width, height)
        loadingLabel.setBounds(50, 100, 300, 30);
        progressBar.setBounds(50, 150, 300, 20);

        add(titleLabel);
        add(loadingLabel);
        add(progressBar);

        // Set frame properties
        setSize(400, 250); // Set initial size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close operation
        setLocationRelativeTo(null); // Center window on screen
        setResizable(false); // Disable resizing
        setVisible(true); // Display the frame
    }

    public static void main(String[] args) {
        // Create and display the loading screen
        SwingUtilities.invokeLater(() -> new Mp3AppLoadingScreen());
        
        // Simulate loading process (remove this in actual implementation)
        try {
            Thread.sleep(3000); // Simulate loading for 3 seconds
            System.exit(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        
        
        // Replace with code to load main application window or transition to next screen
        // Example: new MP3AppMainScreen(); // Create and display main application window
    }
}
