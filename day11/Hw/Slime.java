package day11.PRGGAME;

import java.util.Random;

public class Slime {
    private int level = 1;
    private int hp = 30;
    private int power = 4;

    public Slime() { }

    public int getLevel() {return this.level;}

    public int getHp() {return this.hp;}

    public int getPower() {return this.power;}

    public int attack() {
        Random random = new Random();
        int tmpDex = random.nextInt(power) + 1;
        return tmpDex;}

    public void getDex(int dex) {
        this.hp -= dex;}
}
