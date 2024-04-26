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

public class LoginFrame extends JFrame {

    private static final long serialVersionUID = 1L;
private Connection sos = null;
    private PreparedStatement sss = null;
    public LoginFrame() {
        // Set the title of the JFrame
        setTitle("ZDM Metro - Login");

        // Set the size of the JFrame
        setSize(1080, 720);

        // Set the default close operation to exit the application when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a header label
        JLabel headerLabel = new JLabel("ZDM METRO");
        Font headerFont = new Font("Arial", Font.BOLD, 24);
        headerLabel.setFont(headerFont);
        headerLabel.setForeground(Color.WHITE);

        // Create components for login page
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        JTextField usernameField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);

        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");

        // Set the layout manager for the content pane
        setLayout(new GridBagLayout());
        getContentPane().setBackground(Color.BLACK);
        setForeground(Color.WHITE);

        // Customize font and color for labels
        Font labelFont = new Font("Arial", Font.PLAIN, 16);
        usernameLabel.setFont(labelFont);
        usernameLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(labelFont);
        passwordLabel.setForeground(Color.WHITE);

        // Customize font and color for text fields
        Font fieldFont = new Font("Arial", Font.PLAIN, 14);
        usernameField.setFont(fieldFont);
        usernameField.setForeground(Color.WHITE);
        usernameField.setBackground(Color.BLACK);
        passwordField.setFont(fieldFont);
        passwordField.setForeground(Color.WHITE);
        passwordField.setBackground(Color.BLACK);

        // Customize font and color for buttons
        Font buttonFont = new Font("Arial", Font.BOLD, 14);
        loginButton.setFont(buttonFont);
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(Color.BLACK);
        registerButton.setFont(buttonFont);
        registerButton.setForeground(Color.WHITE);
        registerButton.setBackground(Color.BLACK);

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
        getContentPane().add(usernameLabel, gbc);

        gbc.gridy = 2;
        getContentPane().add(passwordLabel, gbc);

        gbc.gridy = 3;
        getContentPane().add(new JLabel(), gbc); // Placeholder for spacing

        gbc.gridx = 1;
        gbc.gridy = 1;
        getContentPane().add(usernameField, gbc);

        gbc.gridy = 2;
        getContentPane().add(passwordField, gbc);

        gbc.gridy = 3;
        getContentPane().add(new JLabel(), gbc); // Placeholder for spacing

        // Add buttons
        gbc.gridy = 4;
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.SOUTHWEST;
        getContentPane().add(loginButton, gbc);

        gbc.gridx = 2;
        getContentPane().add(registerButton, gbc);

        // Set the background color to black and text color to white
        getContentPane().setBackground(Color.BLACK);
        setForeground(Color.WHITE);

        // Attach action listener to the login button
         loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredUsername = usernameField.getText();
                char[] enteredPasswordChars = passwordField.getPassword();
                String enteredPassword = new String(enteredPasswordChars);

                // Authenticate user against the database
                boolean isAuthenticated = authenticateUser(enteredUsername, enteredPassword);

                if (isAuthenticated) {
                    openEmployeeDashboard();
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Invalid username or password");
                }
            }
        });
    


        // Attach action listener to the register button
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the registration form
                openRegistrationForm();
            }
        });

        // Center the JFrame on the screen
        setLocationRelativeTo(null);
    }

    private void openEmployeeDashboard() {
        // Close the login frame
        dispose();

        // Open the Employee Dashboard frame
        //EmployeeDashboardFrame dashboardFrame = new EmployeeDashboardFrame("John Doe");
       // dashboardFrame.setVisible(true);
    }

    private void openRegistrationForm() {
        // Open the registration form
       // RegistrationFrame registrationFrame = new RegistrationFrame();
       // registrationFrame.setVisible(true);
    }
 private boolean authenticateUser(String enteredUsername, String enteredPassword) {
        try {
            sos = dbconnect.Connect();  // Replace with your database connection logic
            String query = "SELECT * FROM register WHERE username=? AND password=?";
            sss = sos.prepareStatement(query);
            sss.setString(1, enteredUsername);
            sss.setString(2, enteredPassword);

            ResultSet resultSet = sss.executeQuery();

            // Check if the result set has any rows
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (sss != null) {
                    sss.close();
                }
                if (sos != null) {
                    sos.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Example usage:
        // Create an instance of LoginFrame
        LoginFrame loginFrame = new LoginFrame();

        // Set the visibility of the JFrame to true
        loginFrame.setVisible(true);
    }
}
