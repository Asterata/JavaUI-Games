package GamesMenu;

import GamesMenu.Games.Blackjack;
import GamesMenu.Games.StockGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GamesMenu.Buttons.stockGameButton;
import static GamesMenu.Buttons.blackjackButton;


public class MainGameMenu implements ActionListener {

    public static JFrame GM_mainFrame;
    public static JPanel GM_mainPanel;

    public static void ShowGameMenu() {
        GM_mainPanel = new JPanel();
        GM_mainPanel.setLayout(null);
        GM_mainFrame = new JFrame("StockGame");
        GM_mainFrame.setSize(500, 500);

        // Add Labels, Buttons, Fields
        Labels.gameMenu_AddLabels();
        Buttons.gameMenu_AddButtons();

        // Add Action Listeners idk how to do it
        stockGameButton.addActionListener(new MainGameMenu());
        blackjackButton.addActionListener(new MainGameMenu());

        // Add everything to the panel
        Labels.gameMenu_AddToPanel();
        Buttons.gameMenu_AddToPanel();



        GM_mainFrame.add(GM_mainPanel);

        GM_mainFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == stockGameButton) {
            GM_mainFrame.setVisible(false);
            StockGame.stockGame();
        } else if (e.getSource() == blackjackButton) {
            GM_mainFrame.setVisible(false);
            Blackjack.startBlackjack();
        }
    }
}
