package my.rinat.testwithspringcourse.suitesandcategories;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(CategoryA.class)
public class ATest {
    @Test
    public void testA() {
        System.out.println("testA");
    }
}
