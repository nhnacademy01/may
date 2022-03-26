package day11.PRGGAME;

import java.util.Random;

public class Ork implements Runnable{
    private int level = 2;
    private int hp = 40;
    private int power = 6;

    public Ork() { }

    public int getLevel() {return this.level;}

    public int getHp() {return this.hp;}

    public int getPower() {return this.power;}

    public int attack() {
        Random random = new Random();
        int tmpDex = random.nextInt(power) + 1;
        return tmpDex;}

    public void getDex(int dex) {
        this.hp -= dex;}

    @Override
    public void run() {

    }
}


