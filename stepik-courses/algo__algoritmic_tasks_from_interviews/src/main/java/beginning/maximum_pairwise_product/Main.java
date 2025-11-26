package beginning.maximum_pairwise_product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long getMaxPairwiseProduct(long[] numbers) {
        int maxIndex1 = 0;
        int n = numbers.length;

        for (int index = 1; index < n; index++) {
            if (numbers[index] > numbers[maxIndex1]) {
                maxIndex1 = index;
            }
        }

        int maxIndex2 = maxIndex1 == 0 ? 1 : 0;
        for (int index = 1; index < n; index++) {
            if (maxIndex1 != index && numbers[index] > numbers[maxIndex2]) {
                maxIndex2 = index;
            }
        }

        return numbers[maxIndex1] * numbers[maxIndex2];
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextLong();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

}
