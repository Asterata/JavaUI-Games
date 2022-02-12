package LoginScreen;

import GamesMenu.MainGameMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainLoginScreen implements ActionListener {

    public static JFrame mainFrame;
    public static JPanel mainPanel;


    // User credentials
    private static String user_Username = "";
    private static String user_Password = "";


    public static void ShowLoginScreen() {
        // Create frame, panel
        mainPanel = new JPanel();
        mainFrame = new JFrame("StockGame");
        mainFrame.setSize(300, 180);
        mainPanel.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add labels
        Labels.addLabels();

        // Add fields
        Fields.addFields();

        // Create a button
        JButton button2 = new JButton("Login");


        button2.setBounds(100, 70, 80, 25);
        button2.addActionListener(new MainLoginScreen());

        // Adding everything to the panel
        Fields.addToPanel();
        Labels.addToPanel();

        mainPanel.add(button2);

        mainFrame.add(mainPanel);

        // Show the frame
        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        user_Username = Fields.username_Field.getText();
        user_Password = Fields.password_Field.getText();
        System.out.printf(" %s , %s \n", user_Username, user_Password);

        // check if the username and password are correct
        if (user_Username.equals("") && user_Password.equals("")) {
            JOptionPane.showMessageDialog(null, "Welcome to the games!", "Login", JOptionPane.INFORMATION_MESSAGE);

            mainFrame.setVisible(false);
            mainFrame.dispose();

            // Show the StockGame main menu
            MainGameMenu.ShowGameMenu();

        } else {
            JOptionPane.showMessageDialog(null, "Wrong username or password!", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}
