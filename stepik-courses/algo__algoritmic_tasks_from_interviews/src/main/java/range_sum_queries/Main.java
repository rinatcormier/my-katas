package range_sum_queries;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);) {
            int n = in.nextInt();
            var nums = new int[n];
            var prefixSums = new int[n];
            nums[0] = in.nextInt();
            prefixSums[0] = nums[0];
            for (int i = 1; i < n; i++) {
                nums[i] = in.nextInt();
                prefixSums[i] = nums[i] + prefixSums[i - 1];
            }
            int q = in.nextInt();
            var ranges = new int[q][2];
            for (int i = 0; i < q; i++) {
                ranges[i][0] = in.nextInt();
                ranges[i][1] = in.nextInt();
            }
            var sums = new int[q];
            for (int i = 0; i < q; i++) {
                if (ranges[i][0] == 0) {
                    sums[i] = prefixSums[ranges[i][1] - 1];
                } else {
                    sums[i] = prefixSums[ranges[i][1] - 1] - prefixSums[ranges[i][0] - 1];
                }
            }
            var sumsString = Arrays.stream(sums)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(System.lineSeparator()));
            System.out.println(sumsString);
        }
    }
}
