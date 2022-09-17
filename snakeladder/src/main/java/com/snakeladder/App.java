package com.snakeladder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Player {
    int playerPosition;

    public int getPlayerPosition() { // getter to get playerPosition value
        return playerPosition;
    }

    public void setPlayerPosition(int playerPosition) {// setter to set playerPosition value
        this.playerPosition = playerPosition;
    }

    int playerRollsDie() {
        return (int) Math.floor(Math.random() * (6 - 1 + 1) + 1); // playerRollsDie to get value between 1-6
    }

    int checkOption(int dieValue) { // checks whether no-play/ladder/snake using random and switch
        int option = (int) Math.floor(Math.random() * (2 - 0 + 1) + 0);
        switch (option) {
            case 0: // if option generates 0 do nothing
                break;
            case 1:
                setPlayerPosition(playerPosition + dieValue); // if option generates 1 add dieValue to playerPosition
                break;
            case 2:
                playerPosition = playerPosition - dieValue; // if option generates 2 minus dievalue from playerPosition
                if (playerPosition < 0) {
                    setPlayerPosition(0); // if player position goes below zero assign 0 to playerPosition
                } else {
                    setPlayerPosition(playerPosition); // else setPlayer position
                }
                break;
        }
        return playerPosition; // return player position
    }

    Player() { // constructor to initialize playerPosition as zero
        playerPosition = 0;
    }
}

public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        Player playerObj = new Player();
        logger.info("Welcome Snake & Ladder Program!");
        logger.info("Intitial Player position is : " + playerObj.getPlayerPosition());
        int dieValue = playerObj.playerRollsDie();
        logger.info("Rolling a die player get : " + dieValue);
        logger.info(
                "After Checking options NoPlay/ Ladder/ Snake player position is: " + playerObj.checkOption(dieValue));
    }
}
