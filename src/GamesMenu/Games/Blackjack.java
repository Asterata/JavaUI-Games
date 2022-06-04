package GamesMenu.Games;


import javax.swing.*;

import GamesMenu.Buttons;

import static GamesMenu.Buttons.*;
// import GM_mainFrame
import static GamesMenu.MainGameMenu.GM_mainFrame;
import static GamesMenu.Labels.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import static GamesMenu.Labels.blackJack_AddLabels;

public class Blackjack implements ActionListener {
    // TODO:
    //  Implement a dealer(AI) and player
    //  Implement a deck of cards
    //  Implement hit and stay sounds, logic
    //  Implement a easter egg ;)

    private static HashMap<Character, Integer> cards = new HashMap<Character, Integer>(); 
    private static HashMap<Character, Integer> cardPoints = new HashMap<Character, Integer>();


    private final int stop1 = 18, stop2 = 19, stop3 = 20, stop4 = 21;

    private static int playerScore = 0;
    private static int dealerScore = 0;

    public static JFrame BJ_mainFrame;
    public static JPanel BJ_mainPanel;


    /**
     * This method is used to remove the card from the card deck
     * @param {char} card
     */
    private static void removeCard(char card) {
        cards.put(card, cards.get(card) - 1);
    }

    /**
     * This method is used to check if the deck has the selected card
     * @param {char} card
     * @return true if the deck has the card, false if it doesn't
     */
    private static boolean checkIfValid(char card) {
        if (cards.get(card) == 0) {
            return false;
        }
        return true;
    }

    /**
     * This method returns a random card from the deck
     * @return Random card
     */
    private static char getRandomCard() {
        char[] k = {'A', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'J', 'Q', 'K'};
        int random = (int) (Math.random() * k.length);
        char card = k[random];

        if (checkIfValid(card)) {
            removeCard(card);
            return card;
        } else {
            return getRandomCard();
        }
    }

    private static void dealerPlay() {
        char dealerCard = getRandomCard();
        
        if (dealerScore <= 10) {
            if (dealerCard == 'A') {
                dealerScore += cardPoints.get('Z');
            } else {            
                dealerScore += cardPoints.get(dealerCard);
            }
        } else {
            dealerScore += cardPoints.get(dealerCard);
        }




        if (dealerScore > 21) {
            dealerScore = 0;
        }
    }


    public static void startBlackjack() {

        cards.put('A', 4);
        cards.put('2', 4);
        cards.put('3', 4);
        cards.put('4', 4);
        cards.put('5', 4);
        cards.put('6', 4);
        cards.put('7', 4);
        cards.put('8', 4);
        cards.put('9', 4);
        cards.put('0', 4); // 0 meaning is 10
        cards.put('J', 4);
        cards.put('Q', 4);
        cards.put('K', 4);

        cardPoints.put('Z', 11); // Z is the other ace value
        cardPoints.put('A', 1);
        cardPoints.put('2', 2);
        cardPoints.put('3', 3);
        cardPoints.put('4', 4);
        cardPoints.put('5', 5);
        cardPoints.put('6', 6);
        cardPoints.put('7', 7);
        cardPoints.put('8', 8);
        cardPoints.put('9', 9);
        cardPoints.put('0', 10);
        cardPoints.put('J', 10);
        cardPoints.put('Q', 10);
        cardPoints.put('K', 10);


        BJ_mainFrame = new JFrame("Blackjack");
        BJ_mainPanel = new JPanel();

        BJ_mainPanel.setLayout(null);
        BJ_mainFrame.setSize(500, 500);

        // adding the buttons, labels and fields
        blackJack_AddLabels();

        //games_AddBackButton();
        //games_GameButtons(1);
        Buttons.games_GameButtons(2);
        Buttons.games_AddBackButton(2);


        BJ_mainFrame.add(BJ_mainPanel);
        BJ_mainFrame.setVisible(true);


        BJ_mainFrame.setSize(500, 500);





    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == games_BackButton) {
            System.out.println("[INFO] Back Button Pressed");
            // Resetting the game
            

            // dispose!
            GM_mainFrame.setVisible(true);
            BJ_mainFrame.dispose();
        }
        
    }
}
