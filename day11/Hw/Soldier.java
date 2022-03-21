package day11.PRGGAME;

import java.util.Random;

public class Soldier {
    private String id;
    int level = 1;
    int hp = 100;
    int power = 10;

    public Soldier(String id) {
        this.id = id;
    }

    public String getId() {return this.id;}

    public int getLevel() {return this.level;}

    public int getHp() {return this.hp;}

    public int getPower() {return this.power;}

    public int attack() {
        Random random = new Random();
        int tmpDex = random.nextInt(power) + 1;
        return tmpDex;}

    public void getDex(int dex) {
        this.hp -= dex;}

    public void levelUp() {
        this.level = 2;
        this.hp = 150;
        this.power = 20;}

}
