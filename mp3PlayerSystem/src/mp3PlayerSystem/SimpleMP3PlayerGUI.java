package mp3PlayerSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SimpleMP3PlayerGUI extends JFrame {

    private JPanel contentPane;
    private JProgressBar progressBar;
    private Timer timer;
    private int songLength = 300; // Example song length in seconds
    private int currentSecond = 0;

    public SimpleMP3PlayerGUI() {
        setTitle("Simple MP3 Player");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 300);
        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(10, 10));

        // Top panel for controls
        JPanel controlPanel = new JPanel();
        contentPane.add(controlPanel, BorderLayout.NORTH);

        JButton playButton = new JButton("Play");
        addHoverEffect(playButton);
        playButton.addActionListener(e -> startPlaying());
        controlPanel.add(playButton);

        JButton stopButton = new JButton("Stop");
        addHoverEffect(stopButton);
        stopButton.addActionListener(e -> stopPlaying());
        controlPanel.add(stopButton);

        // Center panel for progress bar
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        contentPane.add(progressBar, BorderLayout.CENTER);

        // Slider for volume control
        JSlider volumeSlider = new JSlider(0, 100, 50);
        volumeSlider.setMajorTickSpacing(10);
        volumeSlider.setPaintTicks(true);
        volumeSlider.setPaintLabels(true);
        volumeSlider.addChangeListener(e -> {
            // Placeholder for volume control logic
            System.out.println("Volume: " + volumeSlider.getValue());
        });
        contentPane.add(volumeSlider, BorderLayout.SOUTH);

        // Timer to update progress bar
        timer = new Timer(1000, e -> updateProgressBar());

        setVisible(true);
    }

    private void addHoverEffect(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            Color originalColor = button.getBackground();

            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(originalColor);
            }
        });
    }

    private void startPlaying() {
        currentSecond = 0;
        progressBar.setMaximum(songLength);
        progressBar.setValue(currentSecond);
        timer.start();
    }

    private void stopPlaying() {
        timer.stop();
        progressBar.setValue(0);
    }

    private void updateProgressBar() {
        if (currentSecond < songLength) {
            currentSecond++;
            progressBar.setValue(currentSecond);
            progressBar.setString(formatTime(currentSecond) + " / " + formatTime(songLength));
        } else {
            timer.stop();
            JOptionPane.showMessageDialog(this, "Song finished", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private String formatTime(int seconds) {
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        return String.format("%02d:%02d", minutes, remainingSeconds);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimpleMP3PlayerGUI());
    }
}


