package my.rinat.codewars.stringincrementer;

import java.math.BigInteger;

/**
 * <p>Your job is to write a function which increments a string, to create a new string.</p>
 * <ul>
 *     <li>If the string already ends with a number, the number should be incremented by 1.</li>
 *     <li>If the string does not end with a number, the number 1 should be appended to the new string.</li>
 * </ul>
 *
 * <p>Examples:</p>
 * <code>
 *     foo -> foo1
 *     foobar23 -> foobar24
 *     foo0042 -> foo0043
 *     foo9 -> foo10
 *     foo099 -> foo100
 * </code>
 *
 * <p>Attention: If the number has leading zeros the amount of digits should be considered.</p>
 *
 * @see <a href="https://www.codewars.com/kata/54a91a4883a7de5d7800009c/train/java">Codewars: String incrementer</a>
 */
public class StringIncrementer {

    /*
     * TODO: try to implement with regex.
     *       The main idea:
     *         - extract number from the end of the string by regex
     *         - increment the number by one
     *         - format resulting number to string with leading zeros if needed
     *         - concatenate first part of the original string with resulting number
     *       Probably may be useful to read:
     *         - "Horstmann, Core Java, Volume II -- Advanced Features", 2.7 Regular Expressions
     *         - "Friedl, Mastering Regular Expressions", Common Chapters and Chapters with Java practicing
     *         - An article "https://medium.com/factory-mind/regex-tutorial-a-simple-cheatsheet-by-examples-649dc1c3f285"
     */
    public static String incrementString(String str) {
        final var reversedNumber = new StringBuilder();
        int i;
        for (i = str.length() - 1; i >= 0 && Character.isDigit(str.charAt(i)); i--) {
            reversedNumber.append(str.charAt(i));
        }
        final var strWithoutNumber = i >= 0 ? str.substring(0, i + 1) : "";
        final var bigInteger = reversedNumber.isEmpty() ? BigInteger.ONE : new BigInteger(reversedNumber.reverse().toString()).add(BigInteger.ONE);
        return strWithoutNumber + (reversedNumber.isEmpty() ? bigInteger : String.format("%0" + reversedNumber.length() + "d", bigInteger));
    }
}
