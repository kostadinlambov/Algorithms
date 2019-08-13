package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fractional_Knapsack {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Item> items = new ArrayList<>();

        double capacity = Double.parseDouble(reader.readLine().split(": ")[1]);
        double itemsCount = Double.parseDouble(reader.readLine().split(": ")[1]);

        for (int i = 0; i < itemsCount; i++) {
            double[] tokens = Arrays.stream(reader.readLine()
                    .split(" -> "))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            Item currentItem = new Item(tokens[0], tokens[1]);

            items.add(currentItem);
        }

        items.sort((x, y) -> {
            double ratioFirstItem = x.getPrice() / x.getWeight();
            double ratioSecondItem = y.getPrice() / y.getWeight();

            if (ratioFirstItem >= ratioSecondItem) {
                return -1;
            }

            return 1;
        });

        int count = 0;
        double totalPrice = 0;

        while (capacity > 0 && count < itemsCount) {

            double currentItemPrice = items.get(count).getPrice();
            double currentItemWeight = items.get(count).getWeight();

            if (capacity >= currentItemWeight) {
                capacity -= currentItemWeight;
                System.out.println(String.format("Take 100%% of item with price %.2f and weight %.2f",
                        currentItemPrice, currentItemWeight));

            } else {
                double percentage =  (capacity / currentItemWeight)* 100;

                System.out.println(String.format("Take %.2f%% of item with price %.2f and weight %.2f",
                        percentage, currentItemPrice, currentItemWeight));

                capacity -= currentItemWeight;
                currentItemPrice = (percentage / 100) * currentItemPrice;

            }
            count++;
            totalPrice += currentItemPrice;
        }

        System.out.println(String.format("Total price: %.2f",  totalPrice));
    }
}

class Item {
    private double price;
    private double weight;

    public Item(double price, double weight) {
        this.price = price;
        this.weight = weight;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
