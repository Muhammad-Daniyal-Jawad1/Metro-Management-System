package metro.management.system.customer.register;

import dbconnect.dbconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationFrame extends JFrame {
       
   Connection sos = null;
    PreparedStatement sss = null;
    ResultSet rs = null;
    
    private static final long serialVersionUID = 1L;

    public RegistrationFrame() {
        // Set the title of the JFrame
        setTitle("ZDM Metro - Registration");

        // Set the size of the JFrame
        setSize(1080, 720);

        // Set the default close operation to exit the application when the JFrame is closed
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a header label
        JLabel headerLabel = new JLabel("ZDM METRO");
        Font headerFont = new Font("Arial", Font.BOLD, 24);
        headerLabel.setFont(headerFont);
        headerLabel.setForeground(Color.WHITE);

        // Create components for registration form
        JLabel nameLabel = new JLabel("Full Name:");
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel employeeIdLabel = new JLabel("Employee ID:");
        JLabel emailLabel = new JLabel("Email:");

        JTextField nameField = new JTextField(20);
        JTextField usernameField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        JTextField employeeIdField = new JTextField(20);
        JTextField emailField = new JTextField(20);

        JButton registerButton = new JButton("Register");
        JButton backToLoginButton = new JButton("Back to Login");

        // Set the layout manager for the content pane
        setLayout(new GridBagLayout());
        getContentPane().setBackground(Color.BLACK);
        setForeground(Color.WHITE);

        // Customize font and color for labels
        Font labelFont = new Font("Arial", Font.PLAIN, 16);
        nameLabel.setFont(labelFont);
        nameLabel.setForeground(Color.WHITE);
        usernameLabel.setFont(labelFont);
        usernameLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(labelFont);
        passwordLabel.setForeground(Color.WHITE);
        employeeIdLabel.setFont(labelFont);
        employeeIdLabel.setForeground(Color.WHITE);
        emailLabel.setFont(labelFont);
        emailLabel.setForeground(Color.WHITE);

        // Customize font and color for text fields
        Font fieldFont = new Font("Arial", Font.PLAIN, 14);
        nameField.setFont(fieldFont);
        nameField.setForeground(Color.WHITE);
        nameField.setBackground(Color.BLACK);
        usernameField.setFont(fieldFont);
        usernameField.setForeground(Color.WHITE);
        usernameField.setBackground(Color.BLACK);
        passwordField.setFont(fieldFont);
        passwordField.setForeground(Color.WHITE);
        passwordField.setBackground(Color.BLACK);
        employeeIdField.setFont(fieldFont);
        employeeIdField.setForeground(Color.WHITE);
        employeeIdField.setBackground(Color.BLACK);
        emailField.setFont(fieldFont);
        emailField.setForeground(Color.WHITE);
        emailField.setBackground(Color.BLACK);

        // Customize font and color for the buttons
        Font buttonFont = new Font("Arial", Font.BOLD, 14);
        registerButton.setFont(buttonFont);
        registerButton.setForeground(Color.WHITE);
        registerButton.setBackground(Color.BLACK);
        backToLoginButton.setFont(buttonFont);
        backToLoginButton.setForeground(Color.WHITE);
        backToLoginButton.setBackground(Color.BLACK);

        // Add components to the content pane with GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Add header label
        gbc.gridx = 1;
        gbc.gridy = 0;
        getContentPane().add(headerLabel, gbc);

        // Add labels and text fields
        gbc.gridx = 0;
        gbc.gridy = 1;
        getContentPane().add(nameLabel, gbc);

        gbc.gridy = 2;
        getContentPane().add(usernameLabel, gbc);

        gbc.gridy = 3;
        getContentPane().add(passwordLabel, gbc);

        gbc.gridy = 4;
        getContentPane().add(employeeIdLabel, gbc);

        gbc.gridy = 5;
        getContentPane().add(emailLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        getContentPane().add(nameField, gbc);

        gbc.gridy = 2;
        getContentPane().add(usernameField, gbc);

        gbc.gridy = 3;
        getContentPane().add(passwordField, gbc);

        gbc.gridy = 4;
        getContentPane().add(employeeIdField, gbc);

        gbc.gridy = 5;
        getContentPane().add(emailField, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        getContentPane().add(new JLabel(), gbc); // Placeholder for spacing

        // Add buttons
        gbc.gridy = 6;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.SOUTHWEST;
        getContentPane().add(registerButton, gbc);

        gbc.gridx = 3;
        gbc.anchor = GridBagConstraints.SOUTHEAST;
        getContentPane().add(backToLoginButton, gbc);

        // Set the background color to black and text color to white
        getContentPane().setBackground(Color.BLACK);
        setForeground(Color.WHITE);

        // Attach action listener to the register button
         registerButton.addActionListener((ActionEvent e) -> {
            String name = nameField.getText();
            String username = usernameField.getText();
            char[] passwordChars = passwordField.getPassword();
            String password = new String(passwordChars);
            String employeeId = employeeIdField.getText();
            String email = emailField.getText();

            if (name.isEmpty() || username.isEmpty() || password.isEmpty() || employeeId.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(RegistrationFrame.this, "Please fill in all fields");
                return;
            }

            try {
                sos = dbconnect.Connect();
              String query = "INSERT INTO register (`Full Name`, `Username`, `Password`, `Employee ID`, `Email`) VALUES (?, ?, ?, ?, ?)";
sss = sos.prepareStatement(query);
sss.setString(1, name);
sss.setString(2, username);
sss.setString(3, password);
sss.setString(4, employeeId);
sss.setString(5, email);

                int result = sss.executeUpdate();

                if (result > 0) {
                    JOptionPane.showMessageDialog(RegistrationFrame.this, "Registration successful");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(RegistrationFrame.this, "Registration failed");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (sss != null) {
                        sss.close();
                    }
                    if (sos != null) {
                        sos.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        backToLoginButton.addActionListener((ActionEvent e) -> {
            // Go back to the login frame
            dispose();
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
        });

        // Center the JFrame on the screen
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        // Example usage:
        // Create an instance of RegistrationFrame
        RegistrationFrame registrationFrame = new RegistrationFrame();
        
        // Set the visibility of the JFrame to true
        registrationFrame.setVisible(true);
    }
}