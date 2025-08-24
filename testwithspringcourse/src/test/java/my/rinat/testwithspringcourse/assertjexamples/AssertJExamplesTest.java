package my.rinat.testwithspringcourse.assertjexamples;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJExamplesTest {

    @Test
    public void whenUsingDescribingOfMessage() {
        assertThat(Boolean.TRUE)
                .describedAs("True can't be equal to False")
                .isEqualTo(true);
    }

    @Test
    public void whenUsingOverridingOfMessage() {
        assertThat(Boolean.TRUE)
                .overridingErrorMessage("True can't be equal to False")
                .isEqualTo(true);
    }

    @Test
    public void whenAssertComparableValues() {
        assertThat(new BigDecimal("1.0"))
                .isEqualByComparingTo(new BigDecimal("1.0"));
    }

    @Test
    public void whenAssertingReferences() {
        assertThat(new Object())
                .isNotSameAs(new Object());
    }

    @Test
    public void whenListDoesNotContainItem() {
        assertThat(List.of("1", "2"))
                .doesNotContain("3");
    }
}
