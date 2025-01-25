import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankingApplicationGUI extends JFrame {

    private JLabel balanceLabel, messageLabel;
    private JTextField amountField;
    private JButton depositButton, withdrawButton, checkBalanceButton, exitButton;
    private double balance = 1000.00;

    public BankingApplicationGUI() {
        super("Simple Banking Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(5, 2));

        // Create components
        balanceLabel = new JLabel("Current Balance: $" + balance);
        messageLabel = new JLabel("");
        amountField = new JTextField(10);
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        checkBalanceButton = new JButton("Check Balance");
        exitButton = new JButton("Exit");

        // Add components to the frame
        add(new JLabel(" ")); // Empty label for spacing
        add(balanceLabel);
        add(new JLabel("Amount:"));
        add(amountField);
        add(depositButton);
        add(withdrawButton);
        add(checkBalanceButton);
        add(exitButton);
        add(messageLabel);

        // Add action listeners
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    balance += amount;
                    balanceLabel.setText("Current Balance: $" + balance);
                    messageLabel.setText("Deposit successful.");
                    amountField.setText("");
                } catch (NumberFormatException ex) {
                    messageLabel.setText("Invalid amount.");
                }
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    if (amount > balance) {
                        messageLabel.setText("Insufficient funds.");
                    } else {
                        balance -= amount;
                        balanceLabel.setText("Current Balance: $" + balance);
                        messageLabel.setText("Withdrawal successful.");
                    }
                    amountField.setText("");
                } catch (NumberFormatException ex) {
                    messageLabel.setText("Invalid amount.");
                }
            }
        });

        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageLabel.setText("Your current balance is: $" + balance);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new BankingApplicationGUI();
    }
}