package org.game.models;

import java.util.Arrays;
import java.util.Random;

public abstract class Entity {
    protected String name;
    protected int health;
    protected int attack;
    protected int[] damage;
    protected int armor;

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int[] getDamage() {
        return damage;
    }

    public int getArmor() {
        return armor;
    }

    public void attack(Entity entity) {
        int difference = this.getAttack() - entity.getArmor() + 1;
        int[] cubeValues = new int[difference];
        for (int i = 0; i < difference; i++) {
            cubeValues[i] = new Random().nextInt(6 - 1) + 1;
        }
        System.out.println("Кубик брошен. Значения " + Arrays.toString(cubeValues));
        if(Arrays.stream(cubeValues).anyMatch(x -> x >= 5)) {
            int rnd = new Random().nextInt(this.getDamage().length);
            entity.takeDamage(this.getDamage()[rnd]);
            System.out.println("Сущность " + this.getName() + " нанес сущности " + entity.getName() + " " + this.getDamage()[rnd] + " урона");
            System.out.println("Здоровье " + entity.getName() + " равно " + entity.getHealth());
        } else {
            System.out.println("Не повезло");
        }
    }

    public void takeDamage(int damage) {
        this.health = this.health - damage;
    }
}
