package day11.Hw;

import java.util.Random;

public class Soldier {
    private String id;
    int level;
    int hp;
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
        power = random.nextInt(power) + 1;
        return power;}

    public void getDex(int dex) {
        this.hp -= dex;}

    public void levelUp() {
        this.level = 2;
        this.hp = 150;
        this.power = 20;}

}
