/*
package employee;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZDMMetroMainFrame extends JFrame {

    private JLabel nameLabel;
    private JLabel positionLabel;

    public ZDMMetroMainFrame(String employeeName, String employeePosition) {
        // Set the title of the JFrame
        setTitle("ZDM Metro Management System");

        // Set the size of the JFrame
        setSize(600, 400);

        // Set the default close operation to exit the application when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create labels for employee details
        nameLabel = new JLabel("Name: " + employeeName);
        positionLabel = new JLabel("Position: " + employeePosition);

        // Create buttons for various functionalities
        JButton payrollButton = new JButton("View Payroll");
        JButton routesButton = new JButton("View Today's Routes");
        JButton registerButton = new JButton("Register New Employee");
        JButton complaintButton = new JButton("Lodge Complaint");
        JButton attendanceButton = new JButton("Mark Attendance");
        JButton vacationButton = new JButton("Request Vacation");

        // Set layout manager to arrange components
        setLayout(new GridLayout(8, 1));

        // Add components to the content pane
        add(nameLabel);
        add(positionLabel);
        add(payrollButton);
        add(routesButton);
        add(registerButton);
        add(complaintButton);
        add(attendanceButton);
        add(vacationButton);

        // Attach action listeners to buttons
        payrollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement functionality to view payroll
                JOptionPane.showMessageDialog(ZDMMetroMainFrame.this, "View Payroll Functionality");
            }
        });

        routesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement functionality to view today's routes
                JOptionPane.showMessageDialog(ZDMMetroMainFrame.this, "View Today's Routes Functionality");
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement functionality to register a new employee
                JOptionPane.showMessageDialog(ZDMMetroMainFrame.this, "Register New Employee Functionality");
            }
        });

        complaintButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement functionality to lodge a complaint
                JOptionPane.showMessageDialog(ZDMMetroMainFrame.this, "Lodge Complaint Functionality");
            }
        });

        attendanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement functionality to mark attendance
                JOptionPane.showMessageDialog(ZDMMetroMainFrame.this, "Mark Attendance Functionality");
            }
        });

        vacationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement functionality to request vacation
                JOptionPane.showMessageDialog(ZDMMetroMainFrame.this, "Request Vacation Functionality");
            }
        });

        // Center the JFrame on the screen
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        // Example usage:
        // Create an instance of ZDMMetroMainFrame with employee details
        ZDMMetroMainFrame mainFrame = new ZDMMetroMainFrame("John Doe", "Driver");

        // Set the visibility of the JFrame to true
        mainFrame.setVisible(true);
    }
}
*/
