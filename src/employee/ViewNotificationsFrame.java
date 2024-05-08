package employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewNotificationsFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    public ViewNotificationsFrame() {
        // Set the title of the JFrame
        setTitle("ZDM Metro - View Notifications");

        // Set the size of the JFrame
        setSize(1080, 720);

        // Set the default close operation to exit the application when the JFrame is closed
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create components for the View Notifications frame
        JTextArea notificationsTextArea = new JTextArea();
        notificationsTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(notificationsTextArea);

        JButton backToDashboardButton = createStyledButton("Back to Dashboard");

        // Load and set image from the dashboard
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Mashhood\\Desktop\\loginback.jpg");
        JLabel imageLabel = new JLabel(imageIcon);

        // Set the layout manager for the content pane
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLACK);
        setForeground(Color.WHITE);

        // Customize font and color for text area
        Font textAreaFont = new Font("Arial", Font.PLAIN, 14);
        notificationsTextArea.setFont(textAreaFont);
        notificationsTextArea.setForeground(Color.WHITE);
        notificationsTextArea.setBackground(Color.BLACK);

        // Add components to the content pane
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(backToDashboardButton, BorderLayout.SOUTH);
        getContentPane().add(imageLabel, BorderLayout.EAST);

        // Set the background color to black and text color to white
        getContentPane().setBackground(Color.BLACK);
        setForeground(Color.WHITE);

        // Center the JFrame on the screen
        setLocationRelativeTo(null);

        // Simulate loading notifications data
        notificationsTextArea.setText("1. Notification: Payroll update\n2. Notification: Shift change");

        // Attach action listener to the back button
        backToDashboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the current frame
                dispose();

                // Open the Employee Dashboard frame
                EmployeeDashboardFrame dashboardFrame = new EmployeeDashboardFrame("John Doe");
                dashboardFrame.setVisible(true);
            }
        });
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        button.setFont(new Font("Arial", Font.BOLD, 16));

        return button;	
    }

    public static void main(String[] args) {
        // Example usage:
        // Create an instance of ViewNotificationsFrame
        ViewNotificationsFrame viewNotificationsFrame = new ViewNotificationsFrame();

        // Set the visibility of the JFrame to true
        viewNotificationsFrame.setVisible(true);
    }
}
