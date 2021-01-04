package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    final char SIGN_X = 'x';
    final char SIGN_O = 'o';
    final char SIGN_EMPTY = '.';
    char[][] table;
    int[][] playingField;
    Random random;
    Scanner scanner;

    public static void main(String[] args) {

    }

    void TicTacToe(){
        random = new Random();
        scanner = new Scanner(System.in);
        table = new char[3][3];
        playingField = new int[][]{
                {0 , 1 , 2},
                {3 , 4 , 5},
                {6 , 7 , 8}
        };

    }

    void game() {
        initTable();

        while (true) {
            turnHuman();
            if (checkWin(SIGN_X)) {
                System.out.println("YOU WIN");
                break;
            }
            if (isTableFull()) {
                System.out.println("Sorry, DRAW");
                break;
            }
            turnComputer();
            if (checkWin(SIGN_O)){
                System.out.println("Computer WIN");
                break;
            }
            if (isTableFull()) {
                System.out.println("Sorry, DRAW");
                break;
            }
        }
        System.out.println("GAME OVER");
        printTable();
    }

    private void turnHuman() {
        int x, y;
        do {
            System.out.println("Введите номер поля: ");
            x = scanner.nextInt();
            y = scanner.nextInt();
        }while (!isCellValid(x,y));
        table[x][y] = SIGN_X;
    }

    private void turnComputer() {
        int x, y;
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (!isCellValid(x, y));
        table[y][x] = SIGN_O;
    }

    private boolean isTableFull() {
    }

    private boolean checkWin(char sign_x) {
    }

    private boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= 3|| y >= 3)
            return false;
        return table[y][x] == SIGN_EMPTY;
    }

    private void initTable() {
        for (char[] k: table) {
            for (char i : k) {
                i = SIGN_EMPTY;
            }
        }
    }
    public void printTable(){
        for (char[] k: table) {
            for (char i : k) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}



