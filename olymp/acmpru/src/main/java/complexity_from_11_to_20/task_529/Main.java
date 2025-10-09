package complexity_from_11_to_20.task_529;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.function.BiConsumer;

/**
 * <a href="https://acmp.ru/index.asp?main=task&id_task=529">Задача</a>
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
        int x1 = reader.nextInt();
        int y1 = reader.nextInt();
        int x2 = reader.nextInt();
        int y2 = reader.nextInt();
        var d = Math.sqrt((Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)));
        writer.println(d);
    }
}
