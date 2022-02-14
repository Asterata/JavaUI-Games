package GamesMenu;

import GamesMenu.Games.StockGame;
import LoginScreen.MainLoginScreen;

import javax.swing.*;

import static GamesMenu.Games.StockGame.*;
import static GamesMenu.MainGameMenu.GM_mainPanel;

public class Labels {

    public static JLabel gameMenu_StockGame;
    public static JLabel gameMenu_Blackjack;

    public static JLabel SG_currentDayLabel;
    public static JLabel SG_StockPriceLabel;
    public static JLabel SG_StockChangeLabel;
    public static JLabel SG_OwnedStocks;
    public static JLabel GS_StatusMSG;
    public static JLabel  SG_OwnedStocksLabel;

    //public static JLabel

    // For Game Menu
    public static void gameMenu_AddLabels() {
        gameMenu_StockGame = new JLabel("Stock Game");
        gameMenu_StockGame.setBounds(10, 30, 200, 50);

        gameMenu_Blackjack = new JLabel("Blackjack");
        gameMenu_Blackjack.setBounds(10, 60, 200, 50);
    }

    public static void gameMenu_AddToPanel() {

        // Add Labels to the panel
        GM_mainPanel.add(gameMenu_StockGame);
        GM_mainPanel.add(gameMenu_Blackjack);
        //MainLoginScreen.mainPanel.add(status_Label);

    }


    // For Stock Game
    public static void stockGame_AddLabels() {

        SG_currentDayLabel = new JLabel("Day: ");
        SG_currentDayLabel.setBounds(50, 35, 100, 50);
        StockGame.SG_mainPanel.add(SG_currentDayLabel);

        SG_StockPriceLabel = new JLabel("Current Stock Price: ");
        SG_StockPriceLabel.setBounds(50, 60, 180, 30);
        StockGame.SG_mainPanel.add(SG_StockPriceLabel);

        SG_OwnedStocksLabel = new JLabel("Owned Stocks: ");
        SG_OwnedStocksLabel.setBounds(50, 65, 400, 50);
        StockGame.SG_mainPanel.add(SG_OwnedStocksLabel);

        //MainLoginScreen.mainPanel.add(status_Label);

    }

}
