package org.example;

import org.example.models.Monster;
import org.example.models.Player;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Battle {
    private final Player player = new Player(20, 10, IntStream.range(1, 6).toArray(), 5);
    private final Monster monster = new Monster(30, 20, IntStream.range(3, 9).toArray(), 10);
    private final Scanner scanner;

    public Battle(Scanner scanner) {
        this.scanner = scanner;
    }

    public void round() {
        while(true) {
            System.out.println("Ваш ход. Чтобы бросить кубик и атаковать введите \"attack\". Для лечения введите \"heal\"");
            String action = scanner.nextLine();
            if (action.equals("attack")) {
                player.attack(monster);
                if (monster.getHealth() <= 0) {
                    System.out.println("Поздравляю, вы выиграли");
                    return;
                }
            } else if (action.equals("heal")) {
                player.heal();
            } else {
                System.out.println("Неверное значение, повторите ввод");
                round();
            }
            System.out.println("Ход монстра");
            monster.attack(player);
            if (player.getHealth() <= 0) {
                System.out.println("Вы проиграли");
                return;
            }
        }
    }
}
