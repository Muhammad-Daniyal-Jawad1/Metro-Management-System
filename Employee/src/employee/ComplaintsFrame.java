package employee;

import dbconnect.dbconnect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ComplaintsFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private Connection connection = null;
    private String employeeName;

    public ComplaintsFrame(String employeeName) {
        this.employeeName = employeeName;

        // Set the title of the JFrame
        setTitle("ZDM Metro - Complaints");

        // Set the size of the JFrame
        setSize(1080, 720);

        // Set the default close operation to exit the application when the JFrame is closed
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Establish a database connection
        connection = dbconnect.Connect();

        // Create components for the Complaints frame
        JLabel viewComplaintsLabel = new JLabel("Complaints Filed Against You:");
        JTextArea viewComplaintsTextArea = new JTextArea(5, 20);
        JScrollPane viewComplaintsScrollPane = new JScrollPane(viewComplaintsTextArea);

        JButton backToDashboardButton = createStyledButton("Back to Dashboard");

        // Load and set image
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Mashhood\\Desktop\\loginback.jpg");
        JLabel imageLabel = new JLabel(imageIcon);

        // Set the layout manager for the content pane
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLACK);
        setForeground(Color.WHITE);

        // Customize font and color for labels and text areas
        Font labelFont = new Font("Arial", Font.PLAIN, 16);
        viewComplaintsLabel.setFont(labelFont);
        viewComplaintsLabel.setForeground(Color.WHITE);

        Font textAreaFont = new Font("Arial", Font.PLAIN, 14);

        // Add components to the content pane
        JPanel viewComplaintsPanel = new JPanel(new BorderLayout());
        viewComplaintsPanel.setBackground(Color.BLACK);
        viewComplaintsPanel.setForeground(Color.WHITE);

        viewComplaintsPanel.add(viewComplaintsLabel, BorderLayout.NORTH);
        viewComplaintsPanel.add(viewComplaintsScrollPane, BorderLayout.CENTER);

        add(viewComplaintsPanel, BorderLayout.CENTER);

        // Add image label to the right
        add(imageLabel, BorderLayout.EAST);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 1, 10, 10));
        buttonPanel.setBackground(Color.BLACK);

        buttonPanel.add(backToDashboardButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Center the JFrame on the screen
        setLocationRelativeTo(null);

        // Attach action listener to the viewComplaintsButton
        backToDashboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the current frame
                dispose();

                // Open the Employee Dashboard frame
                EmployeeDashboardFrame dashboardFrame = new EmployeeDashboardFrame(employeeName);
                dashboardFrame.setVisible(true);
            }
        });

        // Load and display complaints
        String complaints = viewComplaints(employeeName);

        // Set the retrieved complaints text to the text area
        viewComplaintsTextArea.setText(complaints);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBorderPainted(false); // Remove button border
        button.setFocusPainted(false); // Remove focus border
        return button;
    }

private String viewComplaints(String filedAgainst) {
    StringBuilder complaints = new StringBuilder();

    try {
        String query = "SELECT Complaint, Description, `Filed From`, `Filed Against` FROM complaints WHERE `Filed Against` = ?";
        try (Connection connection = dbconnect.Connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, filedAgainst);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String complaint = resultSet.getString("Complaint");
                    String description = resultSet.getString("Description");
                    String filedFrom = resultSet.getString("Filed From");
                    String filedAgainstColumn = resultSet.getString("Filed Against");

                    // Append all fields to the StringBuilder
                    complaints.append("Complaint: ").append(complaint).append("\n");
                    complaints.append("Description: ").append(description).append("\n");
                    complaints.append("Filed From: ").append(filedFrom).append("\n");
                    complaints.append("Filed Against: ").append(filedAgainstColumn).append("\n");
                    complaints.append("\n");
                }
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return complaints.toString();
}


    public static void main(String[] args) {
        // Example usage:
        // Create an instance of ComplaintsFrame
        ComplaintsFrame complaintsFrame = new ComplaintsFrame("John Doe");

        // Set the visibility of the JFrame to true
        complaintsFrame.setVisible(true);
    }
}
