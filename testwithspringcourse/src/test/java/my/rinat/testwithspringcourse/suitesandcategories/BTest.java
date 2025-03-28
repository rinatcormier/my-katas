package my.rinat.testwithspringcourse.suitesandcategories;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(CategoryB.class)
public class BTest {
    @Test
    public void testB() {
        System.out.println("testB");
    }
}
