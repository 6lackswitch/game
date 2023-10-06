package org.game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в игру");
        Scanner scanner = new Scanner(System.in);
        Battle battle = new Battle(scanner);
        battle.round();
        System.out.println("Игра окончена. Чтобы повторить введите \"retry\". Для выхода любое другое значение");
        String input = scanner.nextLine();
        if (input.equals("retry")) {
            main(args);
        }
    }
}