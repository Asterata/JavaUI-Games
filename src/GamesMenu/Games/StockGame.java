package GamesMenu.Games;

import GamesMenu.Labels;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


import static GamesMenu.Buttons.*;
import static GamesMenu.Labels.SG_OwnedStocksLabel;
import static GamesMenu.Labels.stockGame_AddLabels;
import static GamesMenu.MainGameMenu.GM_mainFrame;

public class StockGame implements ActionListener {

    public static JFrame SG_mainFrame;
    public static JPanel SG_mainPanel;

    public static List<Integer> SG_boughtStocks = new ArrayList();

    public static int SG_stockPrice = 0;
    public static int SG_currentDay = 0;
    private static int SG_profit = 0;


    public static String totalDays = "1";
    public static String minPrice = "1";
    public static String maxPrice = "2";
    private static String selection;

    private static boolean allowedToPlay = false;


    public static void stockGame() {
        SG_mainFrame = new JFrame("Stock Game");
        SG_mainPanel = new JPanel();

        SG_mainPanel.setLayout(null);
        SG_mainFrame.setSize(500, 500);

        // adding the buttons, labels andfields
        Labels.stockGame_AddLabels();

        games_AddBackButton();
        games_GameButtons(1);

        // Adding Event Listeners


        SG_mainFrame.add(SG_mainPanel);
        SG_mainFrame.setVisible(true);


        SG_mainFrame.setSize(500, 500);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SG_PlayButton) {
            totalDays = JOptionPane.showInputDialog("Please enter how many rounds you want to play.",5);
            minPrice = JOptionPane.showInputDialog("Please enter the minimum stock price that you want.",0);
            maxPrice = JOptionPane.showInputDialog("Please enter the maximum stock price that you want.",20);

            // Controling the player input settings

            if (Integer.parseInt(totalDays) <= 0) {
                System.out.println("[ERROR] The total rounds can't be 0 or lower than zero ");
                return;
            } else if (Integer.parseInt(minPrice) < 0 || Integer.parseInt(maxPrice) < 0) {
                System.out.println("[ERROR] The minimum or maximum stock price can't be lower than zero ");
                return;
            } else {
                playStockGame(true);
            }
            stockGame_AddLabels();
            // continue here
        }

        if (e.getSource() == games_BackButton) {
            System.out.println("Back Button Pressed");
            GM_mainFrame.setVisible(true);
            SG_mainFrame.dispose();

        }

        // Main Game Buttons
        if (e.getSource() == SG_BuyButton) {
            System.out.println("[INFO] You bought a stock");
            SG_buyStock();
        }

        if (e.getSource() == SG_SellButton) {
            System.out.println("[INFO] You sold a stock");
            selection = JOptionPane.showInputDialog("Please select the selling method. (Write 'all' to sell all or write '1' to sell the 1st day) \"");
            if (selection.equals("all")) {
                SG_sellStock(0,true);
            } else {
                SG_sellStock(Integer.parseInt(selection),false);
            }
        }

        if (e.getSource() == SG_PassButton) {
            SG_passDay();
        }







    }

    private static void SG_passDay() {
        System.out.println("[INFO] Next Day");
        System.out.println(totalDays);
        SG_currentDay++;
        if (SG_currentDay <= Integer.parseInt(totalDays)) {
            Labels.SG_currentDayLabel.setText("Day: " + SG_currentDay);
            SG_createStockPrice();
        }
    }

    private static void SG_buyStock() {
        SG_boughtStocks.add(SG_stockPrice);
        SG_OwnedStocksLabel.setText("Owned Stocks: " + SG_boughtStocks);
        SG_passDay();
    }

    private static void SG_sellStock(int day,boolean sellAll) {
        if (!sellAll) {
            int j = SG_boughtStocks.get(day - 1);
            SG_profit = SG_profit + (SG_stockPrice - j);
            SG_boughtStocks.remove(day - 1);
        } else {
            for (int i = 0; i < SG_boughtStocks.size(); i++) {
                SG_profit = SG_profit + (SG_stockPrice - SG_boughtStocks.get(i));

            }
            SG_boughtStocks.clear();
        }
        SG_OwnedStocksLabel.setText("Owned Stocks: " + SG_boughtStocks);
        SG_passDay();
    }

    private static void SG_createStockPrice() {
        SG_stockPrice = (int) (Math.random() * (Integer.parseInt(maxPrice) - Integer.parseInt(minPrice)) + Integer.parseInt(minPrice));
        System.out.println("[INFO] Current stock price is: " + SG_stockPrice);
        Labels.SG_StockPriceLabel.setText("Current Stock Price: " + SG_stockPrice); // fix overwriting
    }

    private static void playStockGame(boolean allowedToPlay) {
        if (allowedToPlay) {
            System.out.println("[INFO] The game is starting");
            SG_createStockPrice();
            //stockGame_AddLabels();
        }
    }





}
