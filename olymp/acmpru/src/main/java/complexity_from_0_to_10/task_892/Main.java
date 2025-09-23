package complexity_from_0_to_10.task_892;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.function.BiConsumer;

/**
 * <a href="https://acmp.ru/index.asp?main=task&id_task=892">Задача</a>
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
        String season;
        if (n < 3) {
            season = "Winter";
        } else if (n < 6) {
            season = "Spring";
        } else if (n < 9) {
            season = "Summer";
        } else if (n < 12) {
            season = "Autumn";
        } else if (n < 13) {
            season = "Winter";
        } else {
            season = "Error";
        }
        writer.println(season);
    }
}
