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
        logger.info("Rolling a die player get : " + playerObj.playerRollsDie());
    }
}
