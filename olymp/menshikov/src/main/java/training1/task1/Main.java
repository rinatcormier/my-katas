package training1.task1;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.stream.IntStream;

/**
 * <a href="https://acmp.ru/asp/do/index.asp?main=task&id_course=5&id_section=29&id_topic=137&id_problem=853">Задача</a>
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
        int from = reader.nextInt();
        int limit = reader.nextInt();
        int[] primes = new PrimeGenerator(limit).generate(from);
        if (isNotEmpty(primes)) {
            Arrays.stream(primes).forEach(writer::println);
        } else {
            writer.println("Absent");
        }
    }

    private boolean isNotEmpty(int[] array) {
        return array.length > 0;
    }
}

/**
 * Sieve of Eratosthenes.
 */
class PrimeGenerator {

    private final boolean[] sieve;

    public PrimeGenerator(int limit) {
        this.sieve = new boolean[limit + 1];
    }

    public int[] generate(int from) {
        boolean[] crossedOutMultiples = crossOutMultiples();
        return IntStream
                .range(from, crossedOutMultiples.length)
                .filter(number -> !crossedOutMultiples[number])
                .toArray();
    }

    private boolean[] crossOutMultiples() {
        for (int number = 2; number < determineIterationLimit(); number++) {
            for (int multiple = (number * number); multiple < sieve.length; multiple += number) {
                sieve[multiple] = true;
            }
        }
        return sieve;
    }

    private int determineIterationLimit() {
        // Every multiple in the array has a prime factor that
        // is less than or equal to the root of the array size,
        // so we don't have to cross out multiples of numbers
        // larger than that root.
        double iterationLimit = Math.sqrt(sieve.length) + 1;
        return (int) iterationLimit;
    }
}
