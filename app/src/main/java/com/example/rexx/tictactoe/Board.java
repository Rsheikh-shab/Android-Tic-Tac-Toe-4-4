package com.example.rexx.tictactoe;

/**
 * Created by Rexx on 3/1/2018.
 */

import java.util.Random;

public class Board {

    private static final Random RANDOM = new Random();
    private char[] elts;
    private char currentPlayer;
    private boolean ended;

    public Board() {
        elts = new char[16];
        newGame();
    }

    public boolean isEnded() {
        return ended;
    }

    public char play(int x, int y) {
        if (!ended  &&  elts[4 * y + x] == ' ') {
            elts[4 * y + x] = currentPlayer;
            changePlayer();
        }

        return checkEnd();
    }

    public void changePlayer() {
        currentPlayer = (currentPlayer == 'X' ? 'O' : 'X');
    }

    public char getElt(int x, int y) {
        return elts[4 * y + x];
    }

    public void newGame() {
        for (int i = 0; i  < elts.length; i++) {
            elts[i] = ' ';
        }

        currentPlayer = 'X';
        ended = false;
    }

    public char checkEnd() {
        for (int i = 0; i < 4; i++) {
            if (getElt(i, 0) != ' ' &&
                    getElt(i, 0) == getElt(i, 1)  &&
                    getElt(i, 1) == getElt(i, 2)  &&
                    getElt(i, 2) == getElt(i, 3)  &&
                    getElt(i, 3) == getElt(i, 0)) {
                ended = true;
                return getElt(i, 0);
            }

            if (getElt(0, i) != ' ' &&
                    getElt(0, i) == getElt(1, i)  &&
                    getElt(1, i) == getElt(2, i)  &&
                    getElt(2, i) == getElt(3, i)  &&
                    getElt(3, i) == getElt(0, i)) {
                ended = true;
                return getElt(0, i);
            }
        }

        if (getElt(0, 0) != ' '  &&
                getElt(0, 0) == getElt(1, 1)  &&
                getElt(1, 1) == getElt(2, 2)  &&
                getElt(2, 2) == getElt(3, 3)  &&
                getElt(3, 3) == getElt(0, 0)) {
            ended = true;
            return getElt(0, 0);
        }

//        if (getElt(1, 0) != ' '  &&
//                getElt(1, 0) == getElt(0, 0)  &&
//                getElt(0, 0) == getElt(0, 1)  &&
//                getElt(1, 0) == getElt(2, 2)  &&
//                getElt(2, 2) == getElt(0, 1)) {
//            ended = true;
//            return getElt(1, 0);

//        if (getElt(2, 0) != ' '  &&
//                getElt(2, 0) == getElt(1, 1)  &&
//                getElt(1, 1) == getElt(0, 2)  &&
//                getElt(2, 0) == getElt(3, 3)  &&
//                getElt(3, 3) == getElt(0, 2)) {
//            ended = true;
//            return getElt(2, 0);

        if (getElt(3, 0) != ' '  &&
                getElt(3, 0) == getElt(2, 2)  &&
                getElt(2, 2) == getElt(0, 3)  &&
                getElt(3, 0) == getElt(1, 1)  &&
                getElt(1, 1) == getElt(0, 3)) {
            ended = true;
            return getElt(3, 0);
        }

        for (int i = 0; i < 16; i++) {
            if (elts[i] == ' ')
                return ' ';
        }

        return 'T';
    }

    public char computer() {
        if (!ended) {
            int position = -1;

            do {
                position = RANDOM.nextInt(16);
            } while (elts[position] != ' ');

            elts[position] = currentPlayer;
            changePlayer();
        }

        return checkEnd();
    }

}