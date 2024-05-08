package employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PerformanceFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    public PerformanceFrame() {
        // Set the title of the JFrame
        setTitle("ZDM Metro - Performance");

        // Set the size of the JFrame
        setSize(1080, 720);

        // Set the default close operation to exit the application when the JFrame is closed
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create components for the Performance frame
        JLabel statusLabel = new JLabel("Performance Status:");
        JLabel reviewLabel = new JLabel("Performance Review:");
        JLabel pointsLabel = new JLabel("Performance Points Deducted:");

        JTextField statusField = new JTextField(15);
        JTextField reviewField = new JTextField(15);
        JTextField pointsField = new JTextField(15);

        JButton reviewButton = createStyledButton("Request Performance Review");
        JButton backToDashboardButton = createStyledButton("Back to Dashboard");

        // Load and set image
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Mashhood\\Desktop\\loginback.jpg");
        JLabel imageLabel = new JLabel(imageIcon);

        // Set the layout manager for the content pane
        setLayout(new GridLayout(4, 2, 10, 10));
        getContentPane().setBackground(Color.BLACK);
        setForeground(Color.WHITE);

        // Customize font and color for labels and text fields
        Font labelFont = new Font("Arial", Font.PLAIN, 16);
        statusLabel.setFont(labelFont);
        statusLabel.setForeground(Color.WHITE);
        reviewLabel.setFont(labelFont);
        reviewLabel.setForeground(Color.WHITE);
        pointsLabel.setFont(labelFont);
        pointsLabel.setForeground(Color.WHITE);

        Font fieldFont = new Font("Arial", Font.PLAIN, 14);
        statusField.setFont(fieldFont);
        statusField.setForeground(Color.WHITE);
        statusField.setBackground(Color.BLACK);
        reviewField.setFont(fieldFont);
        reviewField.setForeground(Color.WHITE);
        reviewField.setBackground(Color.BLACK);
        pointsField.setFont(fieldFont);
        pointsField.setForeground(Color.WHITE);
        pointsField.setBackground(Color.BLACK);

        // Customize font and color for the buttons
        Font buttonFont = new Font("Arial", Font.BOLD, 14);
        reviewButton.setFont(buttonFont);
        reviewButton.setForeground(Color.WHITE);
        reviewButton.setBackground(Color.BLACK);

        // Add components to the content pane
        add(statusLabel);
        add(statusField);
        add(reviewLabel);
        add(reviewField);
        add(pointsLabel);
        add(pointsField);
        add(reviewButton);
        add(backToDashboardButton);

        // Set the background color to black and text color to white
        getContentPane().setBackground(Color.BLACK);
        setForeground(Color.WHITE);

        // Center the JFrame on the screen
        setLocationRelativeTo(null);

        // Attach action listener to the reviewButton
        reviewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement logic for requesting performance review
                JOptionPane.showMessageDialog(PerformanceFrame.this, "Performance review requested");
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
        // Create an instance of PerformanceFrame
        PerformanceFrame performanceFrame = new PerformanceFrame();

        // Set the visibility of the JFrame to true
        performanceFrame.setVisible(true);
    }
}
