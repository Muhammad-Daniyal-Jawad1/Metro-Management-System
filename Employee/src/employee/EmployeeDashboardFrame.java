package employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class EmployeeDashboardFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private static final String IMAGE_PATH = "C:\\Users\\Mashhood\\Desktop\\loginback.jpg";

    private String employeeName;

    public EmployeeDashboardFrame(String employeeName) {
        this.employeeName = employeeName;
        setupFrame();
        setupHeader();
        setupButtonPanel();
        setupImageLabel();
    }

    private void setupFrame() {
        setTitle("ZDM Metro - Employee Dashboard");
        setSize(1080, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLACK);
        setForeground(Color.WHITE);
    }

    private void setupHeader() {
        JLabel headerLabel = new JLabel("ZDM METRO");
        JLabel welcomeLabel = new JLabel("Welcome, " + employeeName + "!");
        Font headerFont = new Font("Arial", Font.BOLD, 32);

        // Customize font and color for labels
        headerLabel.setFont(headerFont);
        headerLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setForeground(Color.WHITE);

        // Add components to the content pane
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.BLACK);
        headerPanel.add(headerLabel, BorderLayout.WEST);
        headerPanel.add(welcomeLabel, BorderLayout.EAST);

        add(headerPanel, BorderLayout.NORTH);
    }

    private void setupButtonPanel() {
        JButton viewRoutesButton = createStyledButton("View Routes");
        JButton viewNotificationsButton = createStyledButton("View Notifications");
        JButton markAttendanceButton = createStyledButton("Mark Attendance");
        JButton requestVacationButton = createStyledButton("Request Vacation");
        JButton updateProfileButton = createStyledButton("Update Profile");
        JButton complaintsButton = createStyledButton("Complaints");
        JButton certificationsButton = createStyledButton("Certifications");
        JButton performanceButton = createStyledButton("Performance");

        JButton logoutButton = createStyledButton("Logout");

        // Set the layout manager for the button panel
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBackground(Color.BLACK);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);

        buttonPanel.add(createButtonPanel(viewRoutesButton), gbc);
        gbc.gridy++;
        buttonPanel.add(createButtonPanel(viewNotificationsButton), gbc);
        gbc.gridy++;
        buttonPanel.add(createButtonPanel(markAttendanceButton), gbc);
        gbc.gridy++;
        buttonPanel.add(createButtonPanel(requestVacationButton), gbc);
        gbc.gridy++;
        buttonPanel.add(createButtonPanel(updateProfileButton), gbc);
        gbc.gridy++;
        buttonPanel.add(createButtonPanel(complaintsButton), gbc);
        gbc.gridy++;
        buttonPanel.add(createButtonPanel(certificationsButton), gbc);
        gbc.gridy++;
        buttonPanel.add(createButtonPanel(performanceButton), gbc);
        gbc.gridy++;
        buttonPanel.add(createButtonPanel(logoutButton), gbc);

        add(buttonPanel, BorderLayout.WEST);

        // Attach action listener to the logout button
        logoutButton.addActionListener(this::logout);
    }

    private void logout(ActionEvent event) {
        // Close the current frame
        dispose();

        // Open the login frame
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
    }

    private void setupImageLabel() {
        ImageIcon imageIcon = new ImageIcon(IMAGE_PATH);
        JLabel imageLabel = new JLabel(imageIcon);

        // Add image label to the right
        add(imageLabel, BorderLayout.EAST);
    }

    private JPanel createButtonPanel(JButton button) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.add(button);
        return panel;
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBorderPainted(false); // Remove button border
        button.setFocusPainted(false); // Remove focus border
        button.setPreferredSize(new Dimension(200, 40)); // Adjust button size
        return button;
    }

    private void openNewFrame(JFrame frame) {
        // Close the current frame
        dispose();

        // Open the new frame
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Example usage:
        // Create an instance of EmployeeDashboardFrame
        EmployeeDashboardFrame dashboardFrame = new EmployeeDashboardFrame("John Doe");

        // Set the visibility of the JFrame to true
        dashboardFrame.setVisible(true);
    }
}
