//Task - 3

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//In this code user cant perform mathematical operation
public class ATMInterface {
    private JFrame frame;
    private JTextField textField;
    private JButton depositButton, withdrawButton, checkBalanceButton, exitButton;
    private JLabel label;

    private int balance = 0;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ATMInterface window = new ATMInterface();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ATMInterface() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("ATM Management");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        label = new JLabel("Enter Amount:");
        label.setBounds(26, 48, 81, 25);
        frame.getContentPane().add(label);

        textField = new JTextField();
        textField.setBounds(123, 49, 156, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        depositButton = new JButton("Deposit");
        depositButton.setBounds(26, 112, 117, 25);
        frame.getContentPane().add(depositButton);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(177, 112, 117, 25);
        frame.getContentPane().add(withdrawButton);

        checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.setBounds(26, 162, 156, 25);
        frame.getContentPane().add(checkBalanceButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(236, 162, 117, 25);
        frame.getContentPane().add(exitButton);

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int amount = Integer.parseInt(textField.getText());
                balance += amount;
                JOptionPane.showMessageDialog(frame, "Deposit Successful! Your New Balance: " + balance);
                textField.setText("");
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int amount = Integer.parseInt(textField.getText());
                if (amount <= balance) {
                    balance -= amount;
                    JOptionPane.showMessageDialog(frame, "Withdrawal Successful! Your New Balance: " + balance);
                } else {
                    JOptionPane.showMessageDialog(frame, "Insufficient Funds!");
                }
                textField.setText("");
            }
        });

        checkBalanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Your Balance: " + balance);
                textField.setText("");
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(frame, "Do you want to exit?");
                if (confirm == JOptionPane.YES_OPTION) {
                    frame.dispose();
                }
            }
        });
    }
}