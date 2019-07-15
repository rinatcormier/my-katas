package ch__5_2__2;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int currentByte;
        int previousByte = -1;
        while ((currentByte = System.in.read()) != -1) {
            if (currentByte != 13 && currentByte != 10 && previousByte == 13) {
                System.out.write(previousByte);
            }
            if (currentByte != 13 || previousByte == 13) {
                System.out.write(currentByte);
            }
            previousByte = currentByte;
        }
        if (previousByte == 13) {
            System.out.write(previousByte);
        }
        System.out.flush();
    }
}
