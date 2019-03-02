package my.rinat.kata.jmh;

import org.junit.jupiter.api.Test;

/**
 * This is a set of unit tests to validate the code is working as expected.
 */
class PersonTest {
    @Test
    void ageStatistics() {
        /*
        fixme:
        Assert.assertEquals(Person.NUMBER_OF_PEOPLE,
                            Person.getJDKPeople().stream().mapToInt(Person::getAge).summaryStatistics().getCount());
        Assert.assertEquals(Person.NUMBER_OF_PEOPLE,
                            Person.getECPeople().asLazy().collectInt(Person::getAge).summaryStatistics().getCount());*/
    }

    @Test
    void weightStatisticsJDK() {
        /*
        fixme:
        Assert.assertEquals(Person.NUMBER_OF_PEOPLE,
                            Person.getJDKPeople().stream().mapToDouble(Person::getWeightInPounds).summaryStatistics().getCount());
        Assert.assertEquals(Person.NUMBER_OF_PEOPLE,
                            Person.getECPeople().asLazy().collectDouble(Person::getWeightInPounds).summaryStatistics().getCount());*/
    }

    @Test
    void heightStatisticsJDK() {
        /*
        fixme:
        Assert.assertEquals(Person.NUMBER_OF_PEOPLE,
                            Person.getJDKPeople().stream().mapToDouble(Person::getHeightInInches).summaryStatistics().getCount());
        Assert.assertEquals(Person.NUMBER_OF_PEOPLE,
                            Person.getECPeople().asLazy().collectDouble(Person::getHeightInInches).summaryStatistics().getCount());*/
    }
}
