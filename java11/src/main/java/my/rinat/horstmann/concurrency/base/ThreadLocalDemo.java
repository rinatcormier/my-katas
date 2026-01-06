package my.rinat.horstmann.concurrency.base;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalDemo {

    public static final ThreadLocal<SimpleDateFormat> dateFormat =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    public static void main(String[] args) {
        System.out.println("Today: " + dateFormat.get().format(new Date()));
        System.out.println("Random: " + ThreadLocalRandom.current().nextInt());
    }
}
