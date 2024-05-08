package employee;

import dbconnect.dbconnect;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class ViewRoutesFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private Connection sos = null;
    private PreparedStatement sss = null;

    public ViewRoutesFrame() {
        // Set the title of the JFrame
        setTitle("ZDM Metro - View Routes");

        // Set the size of the JFrame
        setSize(1080, 720);

        // Set the default close operation to exit the application when the JFrame is closed
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Load and set image
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Mashhood\\Desktop\\loginback.jpg");
        JLabel imageLabel = new JLabel(imageIcon);

        // Add image label to the right
        add(imageLabel, BorderLayout.EAST);

        // Create components for the View Routes frame
        JTextArea routesTextArea = new JTextArea();
        routesTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(routesTextArea);

        JButton backToDashboardButton = createStyledButton("Back to Dashboard");

        // Set the layout manager for the content pane
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLACK);
        setForeground(Color.WHITE);

        // Customize font and color for text area
        Font textAreaFont = new Font("Arial", Font.PLAIN, 14);
        routesTextArea.setFont(textAreaFont);
        routesTextArea.setForeground(Color.WHITE);
        routesTextArea.setBackground(Color.BLACK);

        // Add components to the content pane
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(backToDashboardButton, BorderLayout.SOUTH);
        getContentPane().add(imageLabel, BorderLayout.EAST);

        // Set the background color to black and text color to white
        getContentPane().setBackground(Color.BLACK);
        setForeground(Color.WHITE);

        // Center the JFrame on the screen
        setLocationRelativeTo(null);

        // Load routes data from the database
        loadRoutesDataFromDatabase(routesTextArea);

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

    private void loadRoutesDataFromDatabase(JTextArea routesTextArea) {
        try (Connection connection = dbconnect.Connect();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT `Set From`, Destination, Departure, Arrival FROM routes");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            // Process the result set
            StringBuilder routesData = new StringBuilder();
            routesData.append("Routes from Database:\n");

            while (resultSet.next()) {
                String setFrom = resultSet.getString("Set From");
                String destination = resultSet.getString("Destination");
                String departure = resultSet.getString("Departure");
                String arrival = resultSet.getString("Arrival");

                routesData.append("Set From: ").append(setFrom).append(", ");
                routesData.append("Destination: ").append(destination).append(", ");
                routesData.append("Departure: ").append(departure).append(", ");
                routesData.append("Arrival: ").append(arrival).append("\n");
            }

            // Set the text in the JTextArea
            routesTextArea.setText(routesData.toString());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Example usage:
        // Create an instance of ViewRoutesFrame
        ViewRoutesFrame viewRoutesFrame = new ViewRoutesFrame();

        // Set the visibility of the JFrame to true
        viewRoutesFrame.setVisible(true);
    }
}
