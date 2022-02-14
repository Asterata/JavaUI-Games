package GamesMenu;

import LoginScreen.MainLoginScreen;

import javax.swing.*;

import static GamesMenu.MainGameMenu.mainPanel;

public class Labels {

    public static JLabel gameMenu_StockGame;
    public static JLabel gameMenu_Blackjack;

    public static JLabel stockGame_StockPrice;
    public static JLabel stockGame_StockChange;
    public static JLabel stockGame_OwnedStocks;
    public static JLabel stockGame_StatusMSG;

    // For Game Menu
    public static void gameMenu_AddLabels() {
        gameMenu_StockGame = new JLabel("Stock Game");
        gameMenu_StockGame.setBounds(10, 30, 200, 50);

        gameMenu_Blackjack = new JLabel("Blackjack");
        gameMenu_Blackjack.setBounds(10, 60, 200, 50);
    }

    public static void gameMenu_AddToPanel() {

        // Add Labels to the panel
        mainPanel.add(gameMenu_StockGame);
        mainPanel.add(gameMenu_Blackjack);
        //MainLoginScreen.mainPanel.add(status_Label);

    }


    // For Stock Game
    public static void stockGame_AddLabels() {

        mainPanel.add(gameMenu_StockGame);
        mainPanel.add(gameMenu_Blackjack);
        //MainLoginScreen.mainPanel.add(status_Label);

    }

}
