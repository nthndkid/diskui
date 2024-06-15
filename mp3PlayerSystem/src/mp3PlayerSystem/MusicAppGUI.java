package mp3PlayerSystem;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridLayout;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.SystemColor;
import javax.swing.border.CompoundBorder;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Font;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import java.awt.Window.Type;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class MusicAppGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel root;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MusicAppGUI frame = new MusicAppGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MusicAppGUI() {
		setResizable(false);
		setBackground(new Color(10, 10, 10));
		setFont(new Font("SansSerif", Font.BOLD, 18));
		setIconImage(Toolkit.getDefaultToolkit().getImage(MusicAppGUI.class.getResource("/mp3Images/gorilla logo.png")));
		setForeground(new Color(10, 10, 10));
		setTitle("Apetune MP3 Player  | Develped by Raphael Johnathan F. Flores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		root = new JPanel();
		root.setBackground(new Color(10, 10, 10));
		root.setForeground(new Color(30, 31, 32));
		root.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(root);
		root.setLayout(null);
		
		JPanel playerPanel = new JPanel();
		playerPanel.setBorder(null);
		playerPanel.setBackground(new Color(10, 10, 10));
		playerPanel.setForeground(new Color(255, 255, 255));
		playerPanel.setBounds(0, 428, 884, 83);
		root.add(playerPanel);
		
		JButton prevButton = new JButton("\r\n");
		prevButton.setBounds(380, 17, 33, 29);
		prevButton.setSelectedIcon(new ImageIcon(MusicAppGUI.class.getResource("/mp3Images/Prev.png")));
		prevButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		playerPanel.setLayout(null);
		prevButton.setIcon(new ImageIcon(MusicAppGUI.class.getResource("/mp3Images/Prev.png")));
		prevButton.setForeground(Color.BLACK);
		prevButton.setBackground(new Color(10, 10, 10));
		prevButton.setBorder(null);
		playerPanel.add(prevButton);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(284, 60, 350, 6);
		progressBar.setMinimum(20);
		progressBar.setForeground(new Color(10, 96, 201));
		progressBar.setBackground(Color.WHITE);
		playerPanel.add(progressBar);
		
		JButton nextButton = new JButton("\r\n");
		nextButton.setBounds(490, 17, 33, 29);
		nextButton.setSelectedIcon(new ImageIcon(MusicAppGUI.class.getResource("/mp3Images/Next.png")));
		nextButton.setBackground(new Color(10, 10, 10));
		nextButton.setForeground(Color.BLACK);
		nextButton.setIcon(new ImageIcon(MusicAppGUI.class.getResource("/mp3Images/Next.png")));
		nextButton.setBorder(null);
		playerPanel.add(nextButton);
		
		JSlider slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setFont(new Font("SansSerif", Font.PLAIN, 9));
		slider.setBounds(738, 28, 129, 39);
		slider.setToolTipText("Volume");
		slider.setSnapToTicks(true);
		playerPanel.add(slider);
		slider.setValue(100);
		slider.setMinimum(0);
		slider.setMaximum(100);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing (10);
		slider.setForeground(new Color(255, 255, 255));
		slider.setBackground(new Color(10, 10, 10));
		
		JButton shufflePlay = new JButton("\r\n");
		shufflePlay.setBounds(330, 17, 33, 29);
		shufflePlay.setSelectedIcon(new ImageIcon(MusicAppGUI.class.getResource("/mp3Images/Shuffle.png")));
		shufflePlay.setIcon(new ImageIcon(MusicAppGUI.class.getResource("/mp3Images/Shuffle.png")));
		shufflePlay.setForeground(Color.BLACK);
		shufflePlay.setBorder(null);
		shufflePlay.setBackground(new Color(10, 10, 10));
		playerPanel.add(shufflePlay);
		
		JButton loopPlay = new JButton("\r\n");
		loopPlay.setBounds(540, 19, 33, 29);
		loopPlay.setSelectedIcon(new ImageIcon(MusicAppGUI.class.getResource("/mp3Images/Loopback.png")));
		loopPlay.setIcon(new ImageIcon(MusicAppGUI.class.getResource("/mp3Images/Loopback.png")));
		loopPlay.setForeground(Color.BLACK);
		loopPlay.setBorder(null);
		loopPlay.setBackground(new Color(10, 10, 10));
		playerPanel.add(loopPlay);
		
		JButton playButton = new JButton("\r\n");
		playButton.setBounds(430, 15, 44, 32);
		playerPanel.add(playButton);
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		playButton.setSelectedIcon(new ImageIcon(MusicAppGUI.class.getResource("/mp3Images/Play.png")));
		playButton.setBackground(new Color(10, 10, 10));
		playButton.setForeground(Color.BLACK);
		playButton.setIcon(new ImageIcon(MusicAppGUI.class.getResource("/mp3Images/Play.png")));
		playButton.setBorderPainted(false);
		playButton.setBorder(null);
		
		JButton loopPlay_1 = new JButton("\r\n");
		loopPlay_1.setSelectedIcon(new ImageIcon(MusicAppGUI.class.getResource("/mp3Images/MaxVolume.png")));
		loopPlay_1.setIcon(new ImageIcon(MusicAppGUI.class.getResource("/mp3Images/MaxVolume.png")));
		loopPlay_1.setForeground(new Color(0, 0, 0));
		loopPlay_1.setBorder(null);
		loopPlay_1.setBackground(new Color(10, 10, 10));
		loopPlay_1.setBounds(700, 30, 33, 29);
		playerPanel.add(loopPlay_1);
		
		JLabel musicLabel = new JLabel("Music Title");
		musicLabel.setBackground(new Color(10, 10, 10));
		musicLabel.setForeground(new Color(255, 255, 255));
		musicLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		musicLabel.setBounds(90, 24, 180, 22);
		playerPanel.add(musicLabel);
		
		JLabel lblArtistName = new JLabel("Artist Name");
		lblArtistName.setBackground(new Color(10, 10, 10));
		lblArtistName.setForeground(new Color(116, 116, 116));
		lblArtistName.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblArtistName.setBounds(90, 44, 180, 22);
		playerPanel.add(lblArtistName);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MusicAppGUI.class.getResource("/mp3Images/appIcon.png")));
		lblNewLabel.setBounds(12, 10, 64, 64);
		playerPanel.add(lblNewLabel);
		
		JPanel playlistPanel = new JPanel();
		playlistPanel.setBackground(new Color(20, 20, 20));
		playlistPanel.setBounds(220, 11, 654, 500);
		root.add(playlistPanel);
		playlistPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(679, 131, 10, 100);
		playlistPanel.add(scrollPane);
		
		JPanel manuPanel = new JPanel();
		manuPanel.setBackground(new Color(20, 20, 20));
		manuPanel.setBounds(10, 11, 200, 500);
		root.add(manuPanel);
		manuPanel.setLayout(null);
		
		JLabel appLabelHead = new JLabel("");
		appLabelHead.setIcon(new ImageIcon(MusicAppGUI.class.getResource("/mp3Images/titilehead-apetune.png")));
		appLabelHead.setForeground(Color.RED);
		appLabelHead.setFont(new Font("Tahoma", Font.PLAIN, 32));
		appLabelHead.setBounds(71, 11, 108, 45);
		manuPanel.add(appLabelHead);
		
		JLabel appLabelHead_1 = new JLabel("");
		appLabelHead_1.setIcon(new ImageIcon(MusicAppGUI.class.getResource("/mp3Images/header-apetune-logo.png")));
		appLabelHead_1.setForeground(Color.RED);
		appLabelHead_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		appLabelHead_1.setBounds(20, 11, 51, 45);
		manuPanel.add(appLabelHead_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(872, 0, 15, 500);
		root.add(scrollPane_1);
		
	}
}
