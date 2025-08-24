package my.rinat.testwithspringcourse.myrunner;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(MyRunner.class)
public class MyRunnerTest {
    @Test
    public void testRunner() {
        System.out.println("Test runner message...");
    }
}
