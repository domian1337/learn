package com.domian.work.person;

public class Hero extends Unit {
    private String type;
    private  String name;

    public Hero(String name, int healpoint, int attack, int armor, String type, int damage) {
        super(healpoint, attack, armor, damage);
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Герой " + getName()+" класса "+type+" имеет: атака = "+getAttack()+", hp = "+getHealpoint()+", защита = "+getArmor();
    }
}