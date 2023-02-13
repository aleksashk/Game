package ru.philimonov;

import java.util.Scanner;

public class TicTacToe {
    static char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}};
    static int turn = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            printBoard();
            System.out.println("Enter row and column: ");
            int row = sc.nextInt();
            int col = sc.nextInt();
            if (gameBoard[row][col] == ' ') {
                if (turn % 2 == 1) {
                    gameBoard[row][col] = 'X';
                } else {
                    gameBoard[row][col] = 'O';
                }
                turn++;
            } else {
                System.out.println("This cell is already occupied. Try again.");
            }
            if (checkWin('X')) {
                printBoard();
                System.out.println("X wins!");
                break;
            }
            if (checkWin('O')) {
                printBoard();
                System.out.println("O wins!");
                break;
            }
            if (turn > 9) {
                printBoard();
                System.out.println("Draw.");
                break;
            }
        }
        sc.close();
    }

    public static void printBoard() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(gameBoard[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean checkWin(char player) {
// check rows
        for (int i = 0; i < 5; i += 2) {
            if (gameBoard[i][0] == player && gameBoard[i][2] == player && gameBoard[i][4] == player) {
                return true;
            }
        }
// check columns
        for (int i = 0; i < 5; i += 2) {
            if (gameBoard[0][i] == player && gameBoard[2][i] == player && gameBoard[4][i] == player) {
                return true;
            }
        }
// check diagonals
        if (gameBoard[0][0] == player && gameBoard[2][2] == player && gameBoard[4][4] == player) {
            return true;
        }
        if (gameBoard[0][4] == player && gameBoard[2][2] == player && gameBoard[4][0] == player) {
            return true;
        }
        return false;
    }
}
