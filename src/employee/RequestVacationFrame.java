package employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RequestVacationFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    public RequestVacationFrame() {
        // Set the title of the JFrame
        setTitle("ZDM Metro - Request Vacation");

        // Set the size of the JFrame
        setSize(1080, 720);

        // Set the default close operation to exit the application when the JFrame is closed
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create components for the Request Vacation frame
        JLabel startDateLabel = createStyledLabel("Start Date:");
        JLabel endDateLabel = createStyledLabel("End Date:");
        JLabel reasonLabel = createStyledLabel("Reason:");

        JTextField startDateField = createStyledTextField(15);
        JTextField endDateField = createStyledTextField(15);
        JTextField reasonField = createStyledTextField(30);

        JButton requestButton = createStyledButton("Request Vacation");
        JButton backToDashboardButton = createStyledButton("Back to Dashboard");

        // Load and set image
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Mashhood\\Desktop\\loginback.jpg");
        JLabel imageLabel = new JLabel(imageIcon);

        // Set the layout manager for the content pane
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLACK);
        setForeground(Color.WHITE);

        // Add components to the content pane
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel1.setBackground(Color.BLACK);
        panel1.add(startDateLabel);
        panel1.add(startDateField);
        getContentPane().add(panel1, BorderLayout.NORTH);

        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel2.setBackground(Color.BLACK);
        panel2.add(endDateLabel);
        panel2.add(endDateField);
        getContentPane().add(panel2, BorderLayout.CENTER);

        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel3.setBackground(Color.BLACK);
        panel3.add(reasonLabel);
        panel3.add(reasonField);
        getContentPane().add(panel3, BorderLayout.SOUTH);

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(requestButton, BorderLayout.WEST);
        buttonPanel.add(backToDashboardButton, BorderLayout.EAST);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Add image label to the right
        add(imageLabel, BorderLayout.EAST);

        // Set the background color to black and text color to white
        getContentPane().setBackground(Color.BLACK);
        setForeground(Color.WHITE);

        // Center the JFrame on the screen
        setLocationRelativeTo(null);

        // Attach action listener to the requestButton
        requestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement logic for requesting vacation
                String reason = reasonField.getText();
                if (reason.isEmpty()) {
                    JOptionPane.showMessageDialog(RequestVacationFrame.this, "Please enter a reason for vacation.");
                } else {
                    JOptionPane.showMessageDialog(RequestVacationFrame.this, "Vacation requested with reason: " + reason);
                }
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

    private JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        label.setForeground(Color.WHITE);
        return label;
    }

    private JTextField createStyledTextField(int columns) {
        JTextField textField = new JTextField(columns);
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField.setForeground(Color.WHITE);
        textField.setBackground(Color.BLACK);
        return textField;
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        return button;
    }

    public static void main(String[] args) {
        // Example usage:
        // Create an instance of RequestVacationFrame
        RequestVacationFrame requestVacationFrame = new RequestVacationFrame();

        // Set the visibility of the JFrame to true
        requestVacationFrame.setVisible(true);
    }
}
