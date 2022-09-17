package com.snakeladder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Player {
    private static final Logger logger = LogManager.getLogger(App.class);
    private int playerPosition;
    int numberOfRolls = 0;
    int option = 0;

    public int getPlayerPosition() { // getter to get playerPosition value
        return playerPosition;
    }

    public void setPlayerPosition(int playerPosition) {// setter to set playerPosition value
        this.playerPosition = playerPosition;
    }

    int playerRollsDie() {
        numberOfRolls += 1;
        return (int) Math.floor(Math.random() * (6 - 1 + 1) + 1); // playerRollsDie to get value between 1-6
    }

    int checkOption(int dieValue) { // checks whether no-play/ladder/snake using random and switch
        option = (int) Math.floor(Math.random() * (2 - 0 + 1) + 0);
        switch (option) {
            case 0: // if option generates 0 do nothing
                break;
            case 1:
                setPlayerPosition(getPlayerPosition() + dieValue); // if option generates 1 add dieValue to //
                                                                   // playerPosition
                if (getPlayerPosition() > 100) { // if playerPosition goes beyond 100 decrement to previous value
                    // by subtracting with die value
                    setPlayerPosition(getPlayerPosition() - dieValue);
                    break;
                }
                break;
            case 2:
                playerPosition = playerPosition - dieValue; // if option generates 2 minus dievalue from playerPosition
                if (getPlayerPosition() < 0) {
                    setPlayerPosition(0); // if player position goes below zero assign 0 to playerPosition
                } else {
                    setPlayerPosition(playerPosition); // else setPlayer position
                }
                break;
        }
        return playerPosition; // return player position
    }

    void play(Player player) { // play method expects a playerObject and works accordingly
        // becomes 100
        int dieValue = player.playerRollsDie();
        logger.info("Rolling a die player get : " + dieValue);
        logger.info(
                "After Checking options NoPlay/ Ladder/ Snake player position is: "
                        + player.checkOption(dieValue));

    }

    Player() { // constructor to initialize playerPosition as zero
        playerPosition = 0;
    }
}

class PlayWith2Players {
    private static final Logger logger = LogManager.getLogger(App.class);

    void playerWins(Player p1, Player p2) { // when either player reaches playerPosition 100
        if (p1.getPlayerPosition() == 100) {
            logger.info("Player 1 wins!!");
            logger.info("Total number of rolls are :" + p1.numberOfRolls);
            System.exit(0);
        } else if (p2.getPlayerPosition() == 100) {
            logger.info("Player 2 wins!!");
            logger.info("Total number of rolls are :" + p1.numberOfRolls);
            System.exit(0);
        }
    }

    void playWith2Players(Player p1, Player p2) {
        while (p1.getPlayerPosition() < 100 && p2.getPlayerPosition() < 100) { // play until either player's
            // playerPosition reaches 100

            logger.info("Player1's turn :");
            p1.play(p1);
            while (p1.option == 1) { // if player1 gets option 1 i.e. Ladder play again
                if (p1.getPlayerPosition() == 100) {// check if player reaches 100
                    playerWins(p1, p2);
                }
                logger.info("Player1's turn :");
                p1.play(p1);
            }
            logger.info("Player2's turn :");
            p2.play(p2);
            while (p2.option == 1) { // if player2 gets option 1 i.e. Ladder play again
                if (p2.getPlayerPosition() == 100) {
                    playerWins(p1, p2);
                }
                logger.info("Player2's turn :");
                p2.play(p2);
            }
        }
        playerWins(p1, p2);
    }

}

public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        Player playerObj = new Player();
        Player playerObj2 = new Player();
        PlayWith2Players play = new PlayWith2Players();
        logger.info("Welcome Snake & Ladder Program!");
        logger.info("Intitial Player 1 position is : " + playerObj.getPlayerPosition());
        logger.info("Intitial Player 2 position is : " + playerObj2.getPlayerPosition());
        play.playWith2Players(playerObj, playerObj2);
    }

}