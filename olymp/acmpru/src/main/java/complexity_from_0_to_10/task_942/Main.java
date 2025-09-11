package complexity_from_0_to_10.task_942;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiConsumer;

/**
 * <a href="https://acmp.ru/index.asp?main=task&id_task=942">Задача</a>
 */
public class Main {
    public static void main(String[] args) {
        new Shell().execute((reader, writer) -> new Program(reader, writer).run());
    }
}

class Shell {
    void execute(BiConsumer<Scanner, PrintWriter> code) {
        try (var scanner = new Scanner(System.in); var writer = new PrintWriter(System.out)) {
            code.accept(scanner, writer);
        }
    }
}

class Program {

    private final Scanner reader;
    private final PrintWriter writer;

    Program(Scanner reader, PrintWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    void run() {
        final int n = reader.nextInt();
        var tasks = new int[n];
        for (int i = 0; i < n; i++) {
            tasks[i] = reader.nextInt();
        }
        int course1 = 0;
        int course1Fine = 0;
        var sorted = new int[n];
        System.arraycopy(tasks, 0, sorted, 0, tasks.length);
        Arrays.sort(sorted);
        for (int task : sorted) {
            course1 = course1 + (task + course1Fine);
            course1Fine += task;
        }
        int course3 = 0;
        int course3Fine = 0;
        for (int i = tasks.length - 1; i >= 0; i--) {
            course3 = course3 + (tasks[i] + course3Fine);
            course3Fine = course3Fine + tasks[i];
        }
        int course5 = 0;
        int course5Fine = 0;
        for (int task : tasks) {
            course5 = course5 + (task + course5Fine);
            course5Fine = course5Fine + task;
        }
        int winner = 5;
        if (course1 <= course5 && course1 <= course3) {
            winner = 1;
        }
        if (course3 <= course5 && winner > 1) {
            winner = 3;
        }
        writer.println(winner);
    }
}
