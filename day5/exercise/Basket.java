package day5.exercise;

import java.util.ArrayList;

public class Basket {
    private final ArrayList<Food> foods = new ArrayList<>();

    public ArrayList<Food> foodLists() {
        return foods;
    }

    public void add(Food food) {
        foods.add(food);
    }
}
