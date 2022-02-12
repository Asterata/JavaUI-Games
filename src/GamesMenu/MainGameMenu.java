package GamesMenu;

import GamesMenu.Games.StockGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GamesMenu.Buttons.stockGameButton;
import static GamesMenu.Buttons.blackjackButton;


public class MainGameMenu implements ActionListener {

    public static JFrame mainFrame;
    public static JPanel mainPanel;

    public static void ShowGameMenu() {
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainFrame = new JFrame("StockGame");
        mainFrame.setSize(500, 500);

        // Add Labels, Buttons, Fields
        Labels.gameMenu_AddLabels();
        Buttons.gameMenu_AddButtons();

        // Add Action Listeners idk how to do it
        stockGameButton.addActionListener(new MainGameMenu());
        blackjackButton.addActionListener(new MainGameMenu());

        // Add everything to the panel
        Labels.gameMenu_AddToPanel();
        Buttons.gameMenu_AddToPanel();



        mainFrame.add(mainPanel);

        mainFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == stockGameButton) {
            mainFrame.setVisible(false);
            StockGame.stockGame();
        } else if (e.getSource() == blackjackButton) {
            mainFrame.dispose();
            //new HighScoresMenu();
        }
    }
}
