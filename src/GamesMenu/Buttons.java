package GamesMenu;

import GamesMenu.Games.StockGame;

import javax.swing.*;

import java.awt.event.ActionListener;


public class Buttons {
    public static JButton helpButton;
    public static JButton stockGameButton;
    public static JButton blackjackButton;

    public static JButton games_BackButton;

    public static JButton SG_HelpButton;
    public static JButton SG_PlayButton;
    public static JButton SG_SellButton;
    public static JButton SG_BuyButton;
    public static JButton SG_PassButton;

    // For MainGameMenu
    public static void gameMenu_AddButtons() {
        // Help button
        helpButton = new JButton("Need Help?");
        helpButton.setBounds(370, 420, 100, 30);


        // Stock Game Button
        stockGameButton = new JButton("Play");
        stockGameButton.setBounds(90,48,80,15);

        // Blackjack Button
        blackjackButton = new JButton("Play");
        blackjackButton.setBounds(90,90,80,15);
    }

    public static void gameMenu_AddToPanel() {
        MainGameMenu.GM_mainPanel.add(helpButton);
        MainGameMenu.GM_mainPanel.add(stockGameButton);
        MainGameMenu.GM_mainPanel.add(blackjackButton);
    }


    public static void games_AddBackButton() {
        games_BackButton = new JButton("Back");
        games_BackButton.setBounds(16, 420, 80, 30);
        games_BackButton.addActionListener(new StockGame());
        StockGame.SG_mainPanel.add(games_BackButton);

    }
    // For StockGame
    /*
        1 = Stock Game
        2 = Blackjack
     */
    public static void games_GameButtons(int game) {
        // Stock Game Buttons
        if (game == 1) {

            SG_HelpButton = new JButton("Need Help?");
            SG_HelpButton.setBounds(350, 420, 120, 30);
            SG_HelpButton.addActionListener(new StockGame());
            StockGame.SG_mainPanel.add(SG_HelpButton);

            SG_PlayButton = new JButton("Play");
            SG_PlayButton.setBounds(200,420,80,30);
            SG_PlayButton.addActionListener(new StockGame());
            StockGame.SG_mainPanel.add(SG_PlayButton);

            SG_BuyButton = new JButton("Buy");
            SG_BuyButton.setBounds(100,150,80,30);
            SG_BuyButton.addActionListener(new StockGame());
            StockGame.SG_mainPanel.add(SG_BuyButton);

            SG_SellButton = new JButton("Sell");
            SG_SellButton.setBounds(190,150,80,30);
            SG_SellButton.addActionListener(new StockGame());
            StockGame.SG_mainPanel.add(SG_SellButton);

            SG_PassButton = new JButton("Pass");
            SG_PassButton.setBounds(280,150,80,30);
            SG_PassButton.addActionListener(new StockGame());
            StockGame.SG_mainPanel.add(SG_PassButton);



        }

        // Blackjack Buttons
        else if (game == 2) {

        }
    }







    // gona fix idk how to do it
    public static void gameMenu_AddActionListeners(ActionListener action) {
        helpButton.addActionListener(action);
        stockGameButton.addActionListener(action);
        blackjackButton.addActionListener(action);
    }


}
