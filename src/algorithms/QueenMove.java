package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class QueenMove {
    private static final int FIELD_SIZE = 8;
    private static int[] primaryBoard;
    private static int[] finalBoard;


    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        int testsAmount = input.charAt(0) - '0';
        String[] task = input.split(" ");

        for (int i = 1; i <= testsAmount; i++) {
            initBoards(task, i);
            placeQueensWhichNotUnderAttack();
            placeRestOfQueens();
            int steps = countSteps();
            System.out.print(steps);
        }


//        System.out.println();
//        System.out.println(Arrays.toString(finalBoard));
    }


    private static void initBoards(String[] task, int testNumber) {
        initPrimaryBoard(task, testNumber);
        initFinalBoard();
    }
    private static void initPrimaryBoard(String[] task, int testNumber) {
        primaryBoard = new int[FIELD_SIZE];
        for (int i = 0; i < FIELD_SIZE; i++) {
            int idx = 1 + i + (FIELD_SIZE * (testNumber - 1));
            primaryBoard[i] = Integer.parseInt(task[idx]);

        }
    }

    private static void initFinalBoard() {
        finalBoard = new int[FIELD_SIZE];
        Arrays.fill(finalBoard, -1);
    }

    private static void placeQueensWhichNotUnderAttack() {
        for (int i = 0; i < finalBoard.length; i++) {
            finalBoard[i] = primaryBoard[i];
            if (isUnderAttack(i)) {
                finalBoard[i] = -1;
            }
        }
    }

    private static void placeRestOfQueens() {
        for (int i = 1; i < finalBoard.length; i++) {
            placeQueen(i);
            int counter = 0;
            while (isUnderAttack(i)) {
                if (counter < 7) {
                    moveQueen(i);
                    counter++;
                } else {
                    i--;
                    counter = 0;
                    moveQueen(i - 1);
                }
            }
        }
    }

    private static void placeQueen(int i) {
        if (finalBoard[i] == -1) {
            finalBoard[i] = primaryBoard[i];
        }
    }

    private static void moveQueen(int i) {
        finalBoard[i] = (finalBoard[i] + 1) % finalBoard.length;
    }


    private static int countSteps() {
        int steps = 0;
        for (int i = 0; i < FIELD_SIZE; i++) {
            if (primaryBoard[i] != finalBoard[i]) {
                steps++;
            }
        }
        return steps;
    }

    private static boolean isUnderAttack(int myPosition) {
        for (int i = 0; i < finalBoard.length && finalBoard[i] >= 0; i++) {
            if (myPosition == i) continue;
            if (isUnderRowAttack(myPosition, i) || underDiagonalAttack(myPosition, i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean underDiagonalAttack(int myPosition, int checkingPosition) {
        boolean firstDiagonalAttack = finalBoard[myPosition]
                                   == finalBoard[checkingPosition] - (myPosition - checkingPosition);
        boolean secondDiagonalAttack = finalBoard[myPosition]
                                    == finalBoard[checkingPosition] + (myPosition - checkingPosition);
        return (firstDiagonalAttack || secondDiagonalAttack);
    }


    private static boolean isUnderRowAttack(int myPosition, int checkingPosition) {
        return finalBoard[myPosition] == finalBoard[checkingPosition];
    }

}
