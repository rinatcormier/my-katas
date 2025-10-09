package complexity_from_11_to_20.task_854;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.function.BiConsumer;

/**
 * <a href="https://acmp.ru/index.asp?main=task&id_task=854">Задача</a>
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
        int tRoom = reader.nextInt();
        int tCond = reader.nextInt();
        String mode = reader.next();
        switch (mode) {
            case "heat":
                writer.println(Math.max(tRoom, tCond));
                break;
            case "freeze":
                writer.println(Math.min(tRoom, tCond));
                break;
            case "auto":
                writer.println(tCond);
                break;
            case "fan":
                writer.println(tRoom);
                break;
        }
    }
}
