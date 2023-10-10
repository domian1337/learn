package com.domian.work.start;

import com.domian.work.person.Hero;
import com.domian.work.person.Monster;

import java.util.Random;
import java.util.Scanner;

public class Test extends Fight {
    static Random random = new Random();
    static Scanner in = new Scanner(System.in);
    static Test r = new Test();
    static Hero hero;
    static Monster monster;
    static int hp = 0;
    static int numberCurr = 0;
    static int cub = 1;

    public static void main(String[] args) {
        makeHero();
        makeMonster();
        System.out.print("Для начала битвы нажмите 1: ");
        int run = in.nextInt();
        while (run == 1){
            r.step();
            if (hero.getHealpoint()>0 && monster.getHealpoint()>0) {
                System.out.println("Здоровье героя = "+ hero.getHealpoint());
                System.out.println("Здоровье монстра = "+ monster.getHealpoint());
                System.out.println("Продолжить?");
                run = in.nextInt();
            }
            else return;
        }
    }

    public static void makeHero() {
        hero = new Hero("0", 0, 0, 0, "0", 0);
        System.out.print("Введите имя героя:");
        hero.setName(in.nextLine());
        System.out.print("Его класс:");
        hero.setType(in.nextLine());
        System.out.print("Здоровье:");
        int h = in.nextInt();
        while (h < 1) {
            System.out.print("Введите корректные данные здоровья, они дожны быть от 1 единицы:");
            h = in.nextInt();
        }
        hero.setHealpoint(h);
        hp = (int) (h * 0.3);
        System.out.print("Атаку (1-30):");
        int a = in.nextInt();
        while (30 < a || a < 1) {
            System.out.print("Введите корректные данные атаки, они дожны быть от 1 до 30 единиц:");
            a = in.nextInt();
        }
        hero.setAttack(a);
        System.out.print("Защита (1-30):");
        a = in.nextInt();
        while (30 < a || a < 1) {
            System.out.print("Введите корректные данные защиты, они дожны быть от 1 до 30 единиц:");
            a = in.nextInt();
        }
        hero.setArmor(a);
        System.out.print("Урон:");
        hero.setDamage(in.nextInt());
        System.out.println(hero);
    }

    public static void makeMonster() {
        monster = new Monster(0, 0, 0, 0);
        System.out.print("Введите данные монстра:");
        monster.setHealpoint(100);
        System.out.print("Атака (1-30):");
        int a = in.nextInt();
        while (30 < a || a < 1) {
            System.out.print("Введите корректные данные атаки, они дожны быть от 1 до 30 единиц:");
            a = in.nextInt();
        }
        monster.setAttack(a);
        System.out.print("Защита (1-30):");
        a = in.nextInt();
        while (30 < a || a < 1) {
            System.out.print("Введите корректные данные защиты, они дожны быть от 1 до 30 единиц:");
            a = in.nextInt();
        }
        monster.setArmor(a);
        System.out.print("Урон:");
        monster.setDamage(in.nextInt());
        System.out.println(monster);
    }

    @Override
    void hitHero() {
        monster.setHealpoint(monster.getHealpoint() - hero.getDamage());
        if (monster.getHealpoint() <= 0) {
            monster.dieMonster();
//            System.out.print("Создать нового мностра? Введите: Да, Нет");
//            String choose = in.nextLine();
//            if (choose == "Да" ) makeMonster();
//            else return;
        }
        hero.setHealpoint(hero.getHealpoint() - monster.getDamage());
        if (hero.getHealpoint() <= 0) die();
    }

    @Override
    void step() {
        modification();
        while (cub >= 1) {
            int number = random.nextInt(1, 7);
            if (number == 5 || number == 6) {
                hitHero();
                break;
            }
            --cub;
        }
    }

    @Override
    void resurrect(int a) {
        if (a <= 4) {
            hero.setHealpoint(hp);
            System.out.println("Вы воскресли. Осталось воскрешений:" + (4 - a));
        }
    }

    @Override
    void die() {
        numberCurr += 1;
        System.out.println("Вас убили!");
        resurrect(numberCurr);
    }

    public static void modification() {
        cub = hero.getAttack() - (monster.getArmor() + 1);
        if (cub < 1) cub = 1;
    }
}