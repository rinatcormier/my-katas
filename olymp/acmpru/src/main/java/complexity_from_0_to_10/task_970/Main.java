package complexity_from_0_to_10.task_970;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.function.BiConsumer;

/**
 * <a href="https://acmp.ru/index.asp?main=task&id_task=970">Задача</a>
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
        final int a1 = reader.nextInt();
        final int a2 = reader.nextInt();
        final int a3 = reader.nextInt();
        final boolean equalityExists = (a1 + a2 == a3) || (a1 + a3 == a2) || (a2 + a3 == a1);
        writer.println(equalityExists ? "YES" : "NO");
    }
}
