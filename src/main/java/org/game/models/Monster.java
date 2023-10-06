package org.game.models;

public class Monster extends Entity{
    public Monster(int health, int attack, int[] damage, int armor) {
        this.name = "Монстр";
        this.health = health;
        this.attack = attack;
        this.damage = damage;
        this.armor = armor;
    }
}
