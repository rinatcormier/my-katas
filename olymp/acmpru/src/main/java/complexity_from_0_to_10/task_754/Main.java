package complexity_from_0_to_10.task_754;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.function.BiConsumer;

/**
 * <a href="https://acmp.ru/index.asp?main=task&id_task=754">Задача</a>
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
        final int m1 = reader.nextInt();
        final int m2 = reader.nextInt();
        final int m3 = reader.nextInt();
        if ((m1 < 94 || m1 > 727)
                || (m2 < 94 || m2 > 727)
                || (m3 < 94 || m3 > 727)) {
            writer.println("Error");
        } else {
            writer.println(Math.max(m1, Math.max(m2, m3)));
        }
    }
}
