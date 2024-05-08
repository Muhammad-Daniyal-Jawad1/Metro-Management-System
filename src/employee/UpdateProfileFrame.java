package employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateProfileFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    public UpdateProfileFrame() {
        // Set the title of the JFrame
        setTitle("ZDM Metro - Update Profile");

        // Set the size of the JFrame
        setSize(1080, 720);

        // Set the default close operation to exit the application when the JFrame is closed
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create components for the Update Profile frame
        JLabel nameLabel = new JLabel("Full Name:");
        JLabel positionLabel = new JLabel("Position:");

        JTextField nameField = new JTextField(15);
        JTextField positionField = new JTextField(15);

        JButton updateButton = createStyledButton("Update Profile");
        JButton backToDashboardButton = createStyledButton("Back to Dashboard");

        // Load and set image
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Mashhood\\Desktop\\loginback.jpg");
        JLabel imageLabel = new JLabel(imageIcon);

        
        // Set the layout manager for the content pane
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        // Add image label to the right
        add(imageLabel, BorderLayout.EAST);
        // Customize font and color for labels and text fields
        Font labelFont = new Font("Arial", Font.PLAIN, 16);
        nameLabel.setFont(labelFont);
        nameLabel.setForeground(Color.WHITE);
        positionLabel.setFont(labelFont);
        positionLabel.setForeground(Color.WHITE);

        Font fieldFont = new Font("Arial", Font.PLAIN, 14);
        nameField.setFont(fieldFont);
        nameField.setForeground(Color.WHITE);
        nameField.setBackground(Color.BLACK);
        positionField.setFont(fieldFont);
        positionField.setForeground(Color.WHITE);
        positionField.setBackground(Color.BLACK);

        // Add components to the content pane
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2, 10, 10));
        inputPanel.setBackground(Color.BLACK);
        inputPanel.setForeground(Color.WHITE);

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(positionLabel);
        inputPanel.add(positionField);

        add(inputPanel, BorderLayout.NORTH);

        // Add buttons to the bottom
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        buttonPanel.setBackground(Color.BLACK);

        buttonPanel.add(updateButton);
        buttonPanel.add(backToDashboardButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Center the JFrame on the screen
        setLocationRelativeTo(null);

        // Attach action listener to the updateButton
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement logic for updating profile
                JOptionPane.showMessageDialog(UpdateProfileFrame.this, "Profile updated");
            }
        });

        // Attach action listener to the backToDashboardButton
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
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBorderPainted(false); // Remove button border
        button.setFocusPainted(false); // Remove focus border
        return button;
    }

    public static void main(String[] args) {
        // Example usage:
        // Create an instance of UpdateProfileFrame
        UpdateProfileFrame updateProfileFrame = new UpdateProfileFrame();

        // Set the visibility of the JFrame to true
        updateProfileFrame.setVisible(true);
    }
}
