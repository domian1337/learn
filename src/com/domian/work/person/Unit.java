package com.domian.work.person;

public class Unit {
    private int healpoint;
    private int attack;
    private int armor;
    private int damage;

    public Unit(int healpoint,int attack, int armor, int damage) {
        this.healpoint = healpoint;
        this.attack = attack;
        this.armor = armor;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getHealpoint() {
        return healpoint;
    }

    public void setHealpoint(int healpoint) {
        this.healpoint = healpoint;
    }



}
