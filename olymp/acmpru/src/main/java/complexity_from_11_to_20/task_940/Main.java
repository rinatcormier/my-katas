package complexity_from_11_to_20.task_940;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.function.BiConsumer;

/**
 * <a href="https://acmp.ru/index.asp?main=task&id_task=940">Задача</a>
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
        var k = reader.nextInt();
        var w = reader.next();
        var chars = w.toCharArray();
        var corrected = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (i == k - 1) {
                continue;
            }
            corrected.append(chars[i]);
        }
        writer.println(corrected);
    }
}
