package my.rinat.horstmann.concurrency.tagirvaleevexamples;

/**
 * The Initialize-On-Demand Holder Class idiom. Use it instead of Double-Checked Locking idiom.
 *
 * @see <a href="https://web.archive.org/web/20200721185434/https://www.ibm.com/developerworks/library/j-jtp03304/">Fixing the Java Memory Model, Part 2</a>
 */
@SuppressWarnings("unused")
public class InitializeOnDemandIdiomExample {

    private static class LazySomethingHolder {
        public static Something something = new Something();
    }

    @SuppressWarnings("ClassEscapesDefinedScope")
    public static Something getInstance() {
        return LazySomethingHolder.something;
    }
}

class Something {
}
