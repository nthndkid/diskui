package mp3PlayerSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessagePrompt extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JProgressBar progressBar;

    public MessagePrompt() {
        setTitle("Warning Prompt Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 200);
        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(3, 1, 10, 10));

        JLabel lblPrompt = new JLabel("Enter your name:");
        contentPane.add(lblPrompt);

        textField = new JTextField();
        contentPane.add(textField);
        textField.setColumns(10);

        JButton submitButton = new JButton("Submit");
        //check if button does have action
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkTextField(); // call out function 
            }
        });
        contentPane.add(submitButton);
        
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        contentPane.add(progressBar);

        setVisible(true);
    }
    
    
    //function to check if textfield is empty
    private void checkTextField() {
        String inputText = textField.getText();
        if (inputText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill out the text field.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            //JOptionPane.showMessageDialog(this, "Submission successful!", "Info", JOptionPane.INFORMATION_MESSAGE);
            ProgressBarWorker worker = new ProgressBarWorker();
            worker.execute();
        }
    }
    
    private class ProgressBarWorker extends SwingWorker<Void, Void> {
        @Override
        protected Void doInBackground() throws Exception {
            progressBar.setIndeterminate(true);
            Thread.sleep(3000); // Simulate a long-running task
            return null;
        }

        @Override
        protected void done() {
            progressBar.setIndeterminate(false);
            JOptionPane.showMessageDialog(contentPane, "Submission successful!", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MessagePrompt();
            }
        });
    }
}
