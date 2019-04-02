package my.rinat.kata.collections.pet;

import org.assertj.core.api.Assertions;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.factory.Lists;
import org.junit.jupiter.api.Test;

class Exercise1Test extends PetDomainForKata {

    @Test
    void getFirstNamesOfAllPeople() {
        // Replace null, with a transformation method on MutableList.
        MutableList<String> firstNames = null; // this.people...

        MutableList<String> expectedFirstNames = Lists.mutable.with("Mary", "Bob", "Ted", "Jake", "Barry", "Terry", "Harry", "John");

        Assertions.assertThat(expectedFirstNames).containsExactlyElementsOf(firstNames);
    }

    @Test
    void getNamesOfMarySmithsPets() {
        Person person = this.getPersonNamed("Mary Smith");
        MutableList<Pet> pets = person.getPets();

        // Replace null, with a transformation method on MutableList.
        MutableList<String> names = null; // pets...

        Assertions.assertThat(names.makeString()).isEqualTo("Tabby");
    }

    @Test
    void getPeopleWithCats() {
        // Replace null, with a positive filtering method on MutableList.
        MutableList<Person> peopleWithCats = null;  // this.people...

        Assertions.assertThat(peopleWithCats).hasSize(2);
    }

    @Test
    void getPeopleWithoutCats() {
        // Replace null, with a negative filtering method on MutableList.
        MutableList<Person> peopleWithoutCats = null;  // this.people...

        Assertions.assertThat(peopleWithoutCats).hasSize(6);
    }
}