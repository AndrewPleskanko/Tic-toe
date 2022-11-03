package com.company;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        int allSymbol = 0;
        boolean isCombo = false;
        boolean isNumber = false;
        char place[][] = new char[3][3];
        place[0][0] = '_';//1
        place[0][1] = '_';
        place[0][2] = '_';//3
        place[1][0] = '_';
        place[1][1] = '_';//5
        place[1][2] = '_';
        place[2][0] = '_';//7
        place[2][1] = '_';
        place[2][2] = '_';//9
        System.out.println("The game has started, select the cell");
        while (isCombo != true || isNumber != true || allSymbol != -9) {
            printTable(place);
            int x;
            int y;
            Scanner scanner = new Scanner(System.in);
            x = scanner.nextInt();
            y = scanner.nextInt();
            try {
                if (place[x][y] == '_') {
                    place[x][y] = 'X';
                    allSymbol--;
                } else if (place[x][y] == 'X' || place[x][y] == 'O') {
                    System.out.println("write another number");
                    x = scanner.nextInt();
                    y = scanner.nextInt();
                }
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("You entered a number outside the range");
                System.out.println("Next time write number from 0 to 2");
                break;
            }
            Random rnd = new Random();
            x = rnd.nextInt(3);
            y = rnd.nextInt(3);
            if (place[x][y] == '_') {
                System.out.println(x);
                System.out.println(y);
                allSymbol--;
                place[x][y] = 'O';
            } else if (place[x][y] == 'X' || place[x][y] == 'O') {
                x = rnd.nextInt(3);
                y = rnd.nextInt(3);
                System.out.println(x);
                System.out.println(y);
                allSymbol--;
                place[x][y] = 'O';
            }
            if (checkWin(place, 'X')) {
                System.out.println("You wiiiiiiiiiin:)Congratulation");

            }
            if (checkWin(place, 'O')) {
                System.out.println("You Lose:(");

            }

            if (allSymbol == -9 && isCombo != true && isNumber != true) {
                System.out.println("try win the next time");
                break;
            }
        }
        printTable(place);
    }

    static void printTable(char[][] place) {
        for (int i = 0; i < place.length; i++) {
            for (int j = 0; j < place.length; j++) {
                System.out.print(place[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean checkWin(char[][] place, char symbol) {
        for (int z = 0; z < 3; z++) {
            if ((place[0][z] == symbol && place[1][z] == symbol && place[2][z] == symbol) ||
                    (place[z][0] == symbol && place[z][1] == symbol && place[z][2] == symbol)) {
                return true;
            } else if ((place[0][0] == symbol && place[1][1] == symbol && place[2][2] == symbol) ||
                    (place[0][2] == symbol && place[1][1] == symbol && place[2][0] == symbol)) {
                return true;
            }
        }
        return false;
    }
}



