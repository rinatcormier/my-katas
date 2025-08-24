package org.stepik.course217.ch4_1ex2;

import java.math.BigDecimal;
import java.util.*;

/**
 * <a href="https://stepik.org/lesson/13238/step/10?unit=3424">Problem.</a>
 */
public class Main {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int W = in.nextInt();
            List<Item> items = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int c = in.nextInt();
                int w = in.nextInt();
                items.add(new Item(w, new BigDecimal((double) c / w)));
            }
            items.sort(Comparator.comparing(Item::getItemCost));
            int remainder = W;
            double maxSum = 0.0;
            while (remainder > 0 && !items.isEmpty()) {
                Item mostExpensiveItem = items.remove(items.size() - 1);
                int w = Math.min(mostExpensiveItem.getW(), remainder);
                maxSum += (mostExpensiveItem.getItemCost().multiply(new BigDecimal(w)).doubleValue());
                remainder -= w;
            }
            System.out.printf("%.3f%n", maxSum);
        }
    }

    private static class Item {

        private final int w;
        private final BigDecimal itemCost;

        public Item(int w, BigDecimal itemCost) {
            this.w = w;
            this.itemCost = itemCost;
        }

        public int getW() {
            return w;
        }

        public BigDecimal getItemCost() {
            return itemCost;
        }
    }
}
