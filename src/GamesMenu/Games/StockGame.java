package GamesMenu.Games;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GamesMenu.Buttons.games_GameButtons;
import static GamesMenu.Buttons.SG_PlayButton;
import static GamesMenu.Buttons.games_AddBackButton;

public class StockGame implements ActionListener {

    public static JFrame mainFrame;
    public static JPanel mainPanel;

    public static String totalDays = "1";
    public static String minPrice = "1";
    public static String maxPrice = "2";


    public static void stockGame() {
        mainFrame = new JFrame("Stock Game");
        mainPanel = new JPanel();

        mainPanel.setLayout(null);
        mainFrame.setSize(500, 500);

        // adding the buttons, labels andfields
        games_AddBackButton();
        games_GameButtons(1);

        // Adding Event Listeners
        SG_PlayButton.addActionListener(new StockGame());

        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);

        mainFrame.setSize(500, 500);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SG_PlayButton) {
            totalDays = JOptionPane.showInputDialog("Please enter how many rounds you want to play.",5);
            minPrice = JOptionPane.showInputDialog("Please enter the minimum stock price that you want.",0);
            maxPrice = JOptionPane.showInputDialog("Please enter the maximum stock price that you want.",20);

            // Controling the player input settings
            boolean allowedToPlay = false;

            if (Integer.parseInt(totalDays) <= 0) {
                System.out.println("[ERROR] The total rounds can't be 0 or lower than zero ");
                return;
            } else if (Integer.parseInt(minPrice) < 0 || Integer.parseInt(maxPrice) < 0) {
                System.out.println("[ERROR] The minimum or maximum stock price can't be lower than zero ");
                return;
            } else {
                allowedToPlay = true;
            }


            // continue here
        }
    }
}
