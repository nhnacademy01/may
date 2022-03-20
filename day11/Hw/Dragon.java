package day11.Hw;

import java.util.Random;


public class Dragon implements Runnable{
    private int level = 3;
    private int hp = 100;
    private int power = 10;

    public Dragon() { }

    public int getLevel() {return this.level;}

    public int getHp() {return this.hp;}

    public int getPower() {return this.power;}

    public void getDex(int dex) {
        this.hp -= dex;}

    public int attack() {
        Random random = new Random();
        int attackType = randomAttack();    //0이면 일반공격, 1이면 특수공격
        if (attackType == 0) {
            power =  random.nextInt(power) + 1;}
        else if (attackType == 1) {
            power =  15;}
        return power;
    }

    private int randomAttack() {
        int result;
        Random random = new Random();
        int percent = random.nextInt(100)+1;
        if (percent <= 10) {
            result = 1;
        }
        else {
            result = 0;
        }
        return result;
    }

    @Override
    public void run() {

    }
}
