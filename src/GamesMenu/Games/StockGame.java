package GamesMenu.Games;

// Importing our java libraries
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

// Importing our modules
import GamesMenu.GetHelp;
import GamesMenu.Labels;
import static GamesMenu.Buttons.*;
import static GamesMenu.Labels.SG_OwnedStocksLabel;
import static GamesMenu.Labels.stockGame_AddLabels;
import static GamesMenu.MainGameMenu.GM_mainFrame;


// TODO:
//  add a label to show the current profit
//  delete first and last chars in bought stocks '[', ']'


// FIXME:
//  Stock price label overwrite

public class StockGame implements ActionListener {

    public static JFrame SG_mainFrame;
    public static JPanel SG_mainPanel;

    public static List<Integer> SG_boughtStocks = new ArrayList();

    public static int SG_stockPrice = 0;
    public static int SG_currentDay = 1;
    private static int SG_profit = 0;


    public static String SG_totalDays = "0";
    public static String SG_minPrice = "1";
    public static String SG_maxPrice = "2";
    private static String selection;

    private static boolean canPlay = false;


    public static void stockGame() {
        SG_mainFrame = new JFrame("Stock Game");
        SG_mainPanel = new JPanel();

        SG_mainPanel.setLayout(null);
        SG_mainFrame.setSize(500, 500);

        // adding the buttons, labels andfields
        Labels.stockGame_AddLabels();

        games_AddBackButton();
        games_GameButtons(1);

        SG_mainFrame.add(SG_mainPanel);
        SG_mainFrame.setVisible(true);


        SG_mainFrame.setSize(500, 500);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SG_PlayButton) {
            // Getting the user input
            SG_totalDays = JOptionPane.showInputDialog("Please enter how many rounds you want to play.",5);
            SG_minPrice = JOptionPane.showInputDialog("Please enter the minimum stock price that you want.",0);
            SG_maxPrice = JOptionPane.showInputDialog("Please enter the maximum stock price that you want.",20);

            // Controlling the player input settings
            if (Integer.parseInt(SG_totalDays) <= 0) {
                JOptionPane.showMessageDialog(null, "[ERROR] The total rounds can't be 0 or lower than zero ");
                System.out.println("[ERROR] The total rounds can't be 0 or lower than zero ");
                return;
            } else if (Integer.parseInt(SG_minPrice) < 0 || Integer.parseInt(SG_maxPrice) < 0) {
                JOptionPane.showMessageDialog(null, "[ERROR] The minimum or maximum stock price can't be lower than zero ");
                System.out.println("[ERROR] The minimum or maximum stock price can't be lower than zero ");
                return;
            } else {
                playStockGame(true);
            }
            stockGame_AddLabels();
            // continue here
        }

        // Back Button
        if (e.getSource() == games_BackButton) {
            System.out.println("Back Button Pressed");

            // Resetting the game
            SG_resetGame();

            // dispose!
            GM_mainFrame.setVisible(true);
            SG_mainFrame.dispose();
        }

        // Help Button
        // Getting an error, but it works
        // ERROR:
        // class GamesMenu.GetHelp cannot be cast to class java.awt.event.ActionListener
        // (GamesMenu.GetHelp is in unnamed module of loader 'app'; java.awt.event.ActionListener is in module java.desktop of loader 'bootstrap')
        if (e.getSource() == SG_HelpButton) {
            SG_HelpButton.addActionListener((ActionListener) new GetHelp("https://github.com/Asteriva/JavaUI-Games"));
        }

        // Main Game Buttons
        if (SG_canPass()) {
            if (e.getSource() == SG_BuyButton) {
                System.out.println("[INFO] You bought a stock");
                SG_buyStock();
            }

            if (e.getSource() == SG_SellButton) {
                System.out.println("[INFO] You sold a stock");
                selection = JOptionPane.showInputDialog("Please select the selling method. (Write 'all' to sell all or write 'N' (number) to sell the Nth day) \"");
                if (selection.equals("all")) {
                    SG_sellStock(0, true);
                } else {
                    SG_sellStock(Integer.parseInt(selection), false);
                }
            }

            if (e.getSource() == SG_PassButton) {
                SG_passDay();
            }
        } else {
            System.out.println("[ERROR] You can't pass the day");
        }

        if (SG_currentDay == Integer.parseInt(SG_totalDays)) {
            SG_gameEnded();
        }


        /* will be implemented later
        if (e.getSource() == SG_ResetButton) {
            SG_resetGame();
        }
         */






    }

    // Reset the game
    private static void SG_resetGame() {
        SG_boughtStocks.clear();
        canPlay = false;
        SG_totalDays = "0";
        SG_minPrice = "1";
        SG_maxPrice = "2";
        SG_profit = 0;
        SG_stockPrice = 0;
        SG_currentDay = 1;
    }

    // What happens when the game ends
    private static void SG_gameEnded() {
        JOptionPane.showMessageDialog(null, "Game Ended. Your profit is: " + SG_profit);
        System.out.println("[INFO] Stock Game Ended");

        SG_resetGame();
    }

    // Can we pass the day?
    private static boolean SG_canPass() {
        if (SG_currentDay <= Integer.parseInt(SG_totalDays)) {
            return true;
        }
        return false;
    }

    // What happens when the player passes the day
    private static void SG_passDay() {
        if (canPlay) {
            System.out.println("[INFO] Next Day");
            System.out.println(SG_totalDays);
            SG_currentDay++;
            if (SG_currentDay <= Integer.parseInt(SG_totalDays)) {
                Labels.SG_currentDayLabel.setText("Day: " + SG_currentDay);
                SG_createStockPrice();
            }
        }
    }

    // Player buys a stock
    private static void SG_buyStock() {
        if (canPlay) {
            SG_boughtStocks.add(SG_stockPrice);
            SG_OwnedStocksLabel.setText("Owned Stocks: " + SG_boughtStocks);
            SG_passDay();
        }
    }

    // Player sells a stock
    private static void SG_sellStock(int day,boolean sellAll) {
        if (canPlay) {
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
    }

    // Create the stock price with random value
    private static void SG_createStockPrice() {
        SG_stockPrice = (int) (Math.random() * (Integer.parseInt(SG_maxPrice) - Integer.parseInt(SG_minPrice)) + Integer.parseInt(SG_minPrice));
        System.out.println("[INFO] Current stock price is: " + SG_stockPrice);
        Labels.SG_StockPriceLabel.setText("Current Stock Price: " + SG_stockPrice); // fix overwriting
    }

    // Start the Stock Game
    private static void playStockGame(boolean allowedToPlay) {
        if (allowedToPlay) {
            canPlay = true;
            System.out.println("[INFO] The game is starting");
            SG_createStockPrice();
            //stockGame_AddLabels();
        }
    }





}
