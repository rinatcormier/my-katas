package complexity_from_11_to_20.task_818;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.function.BiConsumer;

/**
 * <a href="https://acmp.ru/index.asp?main=task&id_task=818">Задача</a>
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
        int r = 0;
        for (int i = 0; i < n; i++) {
            r += reader.nextInt();
        }
        writer.println(r - (n - 1));
    }
}
