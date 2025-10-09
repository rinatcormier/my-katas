package complexity_from_11_to_20.task_23;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.function.BiConsumer;

/**
 * <a href="https://acmp.ru/index.asp?main=task&id_task=23">Задача</a>
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
        int n = reader.nextInt();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        writer.println(sum);
    }
}
