package greedy_algorithms.maximum_value_of_the_loot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static double grabMaxValue(int capacity, List<Integer> costs, List<Integer> weights) {
        if (capacity == 0 || costs.isEmpty()) {
            return .0;
        }
        int maxCostIndex = maxCostIndex(costs, weights);
        int amount = Math.min(weights.get(maxCostIndex), capacity);
        double value = (double) costs.remove(maxCostIndex) * amount / weights.remove(maxCostIndex);
        return value + grabMaxValue(capacity - amount, costs, weights);
    }

    private static int maxCostIndex(List<Integer> costs, List<Integer> weights) {
        double maxCost = -1.0;
        int maxCostIndex = -1;
        for (int i = 0; i < costs.size(); i++) {
            double currentCost = (double) costs.get(i) / weights.get(i);
            if (currentCost > maxCost) {
                maxCost = currentCost;
                maxCostIndex = i;
            }
        }
        return maxCostIndex;
    }

    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int w = scanner.nextInt();
        var costs = new ArrayList<Integer>();
        var weights = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            costs.add(scanner.nextInt());
            weights.add(scanner.nextInt());
        }
        System.out.printf("%.4f\n", grabMaxValue(w, costs, weights));
    }
}