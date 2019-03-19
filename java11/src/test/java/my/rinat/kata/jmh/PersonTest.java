package my.rinat.kata.jmh;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This is a set of unit tests to validate the code is working as expected.
 */
class PersonTest {
    @Test
    void ageStatistics() {
        Assertions.assertThat(Person.getJDKPeople().stream().mapToInt(Person::getAge).summaryStatistics().getCount()).isEqualTo(Person.NUMBER_OF_PEOPLE);
        Assertions.assertThat(Person.getECPeople().asLazy().collectInt(Person::getAge).summaryStatistics().getCount()).isEqualTo(Person.NUMBER_OF_PEOPLE);
    }

    @Test
    void weightStatisticsJDK() {
        Assertions.assertThat(Person.getJDKPeople().stream().mapToDouble(Person::getWeightInPounds).summaryStatistics().getCount()).isEqualTo(Person.NUMBER_OF_PEOPLE);
        Assertions.assertThat(Person.getECPeople().asLazy().collectDouble(Person::getWeightInPounds).summaryStatistics().getCount()).isEqualTo(Person.NUMBER_OF_PEOPLE);
    }

    @Test
    void heightStatisticsJDK() {
        Assertions.assertThat(Person.getJDKPeople().stream().mapToDouble(Person::getHeightInInches).summaryStatistics().getCount()).isEqualTo(Person.NUMBER_OF_PEOPLE);
        Assertions.assertThat(Person.getECPeople().asLazy().collectDouble(Person::getHeightInInches).summaryStatistics().getCount()).isEqualTo(Person.NUMBER_OF_PEOPLE);
    }
}
