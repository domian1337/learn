package com.domian.work.person;

import com.domian.work.person.Unit;

public class Monster extends Unit {
 private String nameMonster = "Monster";
    public Monster(int healpoint, int attack, int armor, int damage) {
        super(healpoint, attack, armor, damage);
    }

    @Override
    public String toString() {
        return nameMonster + " имеет: атака = "+getAttack()+", hp = "+getHealpoint()+", защита = "+getArmor()+ " урон= = "+getDamage();
    }

    public static void dieMonster() {
        System.out.println("Monster died");
    }
}
