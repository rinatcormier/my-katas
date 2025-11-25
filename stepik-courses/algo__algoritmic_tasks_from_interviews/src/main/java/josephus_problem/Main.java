package josephus_problem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);) {
            int n = in.nextInt();
            int k = in.nextInt();
            int aliveCount = n;
            var killed = new boolean[n];
            int indexN = 0;
            int indexK = 1;
            while (aliveCount > 1) {
                if (!killed[indexN] && indexK == k) {
                    killed[indexN] = true;
                    aliveCount--;
                    indexK = 1;
                }
                if (!killed[indexN] && indexK < k) {
                    indexK++;
                }
                if (indexN == n - 1) {
                    indexN = 0;
                } else {
                    indexN++;
                }
            }
            indexN = 0;
            while (killed[indexN]) {
                indexN++;
            }
            System.out.println(indexN);
        }
    }
}
