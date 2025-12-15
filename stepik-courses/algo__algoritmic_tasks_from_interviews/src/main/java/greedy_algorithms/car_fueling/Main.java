package greedy_algorithms.car_fueling;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int distance = scanner.nextInt();
        int fullTankDistance = scanner.nextInt();
        var refillsDistances = refillsDistances(scanner);
        System.out.println(computeMinRefillsCount(distance, fullTankDistance, refillsDistances));
    }

    private static int[] refillsDistances(Scanner scanner) {
        int refillsCount = scanner.nextInt();
        var refills = new int[refillsCount];
        for (int i = 0; i < refillsCount; i++) {
            refills[i] = scanner.nextInt();
        }
        return refills;
    }

    private static int computeMinRefillsCount(int distance, int fullTankDistance, int[] refillsDistances) {
        if (fullTankDistance >= distance) {
            return 0;
        } else if (refillsDistances.length == 0) {
            return -1;
        }
        int[] refillsDistancesPlusFinish = new int[refillsDistances.length + 1];
        System.arraycopy(refillsDistances, 0, refillsDistancesPlusFinish, 0, refillsDistances.length);
        refillsDistancesPlusFinish[refillsDistancesPlusFinish.length - 1] = distance;
        int minRefillsCount = 0;
        int lastRefillDistance = 0;
        boolean cannotReachNextDestination = false;
        for (int i = 0; i < refillsDistancesPlusFinish.length - 1; i++) {
            if (refillsDistancesPlusFinish[i] - lastRefillDistance > fullTankDistance) {
                cannotReachNextDestination = true;
                break;
            }
            if (refillsDistancesPlusFinish[i + 1] - lastRefillDistance > fullTankDistance) {
                minRefillsCount++;
                lastRefillDistance = refillsDistancesPlusFinish[i];
            }
        }
        if (!cannotReachNextDestination && (distance - lastRefillDistance) > fullTankDistance) {
            cannotReachNextDestination = true;
        }
        if (cannotReachNextDestination) {
            return -1;
        } else {
            return minRefillsCount;
        }
    }
}
