package org.game.models;

public class Player extends Entity{
    private final double fullHP;
    private int healCount = 0;
    public Player(int health, int attack, int[] damage, int armor) {
        this.name = "Игрок";
        this.fullHP = health;
        this.health = health;
        this.attack = attack;
        this.damage = damage;
        this.armor = armor;
    }

    public void heal() {
        if (healCount < 5) {
            int thirdHP = (int) (fullHP * 0.3);
            health = health + thirdHP;
            healCount++;
            System.out.println("Игрок вылечился на " + thirdHP);
        } else {
            System.out.println("Превышено количество лечений");
        }
    }
}
