package employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CertificationsFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    public CertificationsFrame() {
        // Set the title of the JFrame
        setTitle("ZDM Metro - Certifications");

        // Set the size of the JFrame
        setSize(1080, 720);

        // Set the default close operation to exit the application when the JFrame is closed
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create components for the Certifications frame
        JLabel acquiredLabel = new JLabel("Acquired Certifications:");
        JTextArea acquiredTextArea = new JTextArea(5, 20);
        JScrollPane acquiredScrollPane = new JScrollPane(acquiredTextArea);

        JLabel pendingLabel = new JLabel("Pending Certifications:");
        JTextArea pendingTextArea = new JTextArea(5, 20);
        JScrollPane pendingScrollPane = new JScrollPane(pendingTextArea);

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
        acquiredLabel.setFont(labelFont);
        acquiredLabel.setForeground(Color.WHITE);
        pendingLabel.setFont(labelFont);
        pendingLabel.setForeground(Color.WHITE);

        Font textAreaFont = new Font("Arial", Font.PLAIN, 14);
        acquiredTextArea.setFont(textAreaFont);
        acquiredTextArea.setForeground(Color.WHITE);
        acquiredTextArea.setBackground(Color.BLACK);

        pendingTextArea.setFont(textAreaFont);
        pendingTextArea.setForeground(Color.WHITE);
        pendingTextArea.setBackground(Color.BLACK);

        // Add components to the content pane
        JPanel acquiredPanel = new JPanel(new BorderLayout());
        acquiredPanel.setBackground(Color.BLACK);
        acquiredPanel.setForeground(Color.WHITE);

        acquiredPanel.add(acquiredLabel, BorderLayout.NORTH);
        acquiredPanel.add(acquiredScrollPane, BorderLayout.CENTER);

        add(acquiredPanel, BorderLayout.WEST);

        JPanel pendingPanel = new JPanel(new BorderLayout());
        pendingPanel.setBackground(Color.BLACK);
        pendingPanel.setForeground(Color.WHITE);

        pendingPanel.add(pendingLabel, BorderLayout.NORTH);
        pendingPanel.add(pendingScrollPane, BorderLayout.CENTER);

        add(pendingPanel, BorderLayout.EAST);

        // Add image label to the right
        add(imageLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        buttonPanel.setBackground(Color.BLACK);

        buttonPanel.add(backToDashboardButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Center the JFrame on the screen
        setLocationRelativeTo(null);

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
        // Create an instance of CertificationsFrame
        CertificationsFrame certificationsFrame = new CertificationsFrame();

        // Set the visibility of the JFrame to true
        certificationsFrame.setVisible(true);
    }
}
