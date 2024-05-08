package employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MarkAttendanceFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private JLabel statusField;  // Moved statusField to class level for access in ActionListener

    public MarkAttendanceFrame() {
        // Set the title of the JFrame
        setTitle("ZDM Metro - Mark Attendance");

        // Set the size of the JFrame
        setSize(1080, 720);

        // Set the default close operation to exit the application when the JFrame is closed
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create components for the Mark Attendance frame
        JLabel statusLabel = new JLabel("Attendance Status:");
        statusField = new JLabel("");  // Initialize as blank

        JButton markButton = createStyledButton("Mark Attendance");
        JButton backToDashboardButton = createStyledButton("Back to Dashboard");

        // Load and set image
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Mashhood\\Desktop\\loginback.jpg");
        JLabel imageLabel = new JLabel(imageIcon);

        // Set the layout manager for the content pane
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLACK);
        setForeground(Color.WHITE);

        // Customize font and color for labels and text field
        Font labelFont = new Font("Arial", Font.PLAIN, 14);
        statusLabel.setFont(labelFont);
        statusLabel.setForeground(Color.WHITE);
        statusField.setFont(labelFont);
        statusField.setForeground(Color.WHITE);

        // Add components to the content pane
        JPanel leftPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        leftPanel.setBackground(Color.BLACK);
        leftPanel.setForeground(Color.WHITE);
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        leftPanel.add(markButton);

        // Panel for status label and field, arranged horizontally
        JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statusPanel.setBackground(Color.BLACK);
        statusPanel.add(statusLabel);
        statusPanel.add(statusField);
        leftPanel.add(statusPanel);

        getContentPane().add(leftPanel, BorderLayout.WEST);

        // Add back button to the bottom
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.BLACK);
        bottomPanel.add(backToDashboardButton);

        getContentPane().add(bottomPanel, BorderLayout.SOUTH);

        // Add image label to the right
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.BLACK);
        rightPanel.add(imageLabel);

        getContentPane().add(rightPanel, BorderLayout.EAST);

        // Set the background color to black and text color to white
        getContentPane().setBackground(Color.BLACK);
        setForeground(Color.WHITE);

        // Center the JFrame on the screen
        setLocationRelativeTo(null);

        // Attach action listener to the markButton
        markButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simulate marking attendance
                statusField.setText("Present");
            }
        });

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
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBorderPainted(false); // Remove button border
        button.setFocusPainted(false); // Remove focus border
        button.setPreferredSize(new Dimension(150, 40)); // Default button size
        if (text.equals("Back to Dashboard")) {
            button.setPreferredSize(new Dimension(1080, 40)); // Make "Back to Dashboard" full length
        } else if (text.equals("Mark Attendance")) {
            // Dynamically adjust the size based on the text
            int width = button.getFontMetrics(button.getFont()).stringWidth(text) + 30;
            button.setPreferredSize(new Dimension(width, 40));
        }
        return button;
    }

    public static void main(String[] args) {
        // Example usage:
        // Create an instance of MarkAttendanceFrame
        MarkAttendanceFrame markAttendanceFrame = new MarkAttendanceFrame();

        // Set the visibility of the JFrame to true
        markAttendanceFrame.setVisible(true);
    }
}
