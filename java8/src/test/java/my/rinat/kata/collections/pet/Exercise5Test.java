/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package my.rinat.kata.collections.pet;

import org.assertj.core.api.Assertions;
import org.eclipse.collections.api.partition.list.PartitionMutableList;
import org.eclipse.collections.api.set.primitive.MutableIntSet;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Exercise5Test extends PetDomainForKata {

    @Test
    void partitionPetAndNonPetPeople() {
        PartitionMutableList<Person> partitionMutableList = null;
        Assertions.assertThat(partitionMutableList.getSelected()).hasSize(7);
        Assertions.assertThat(partitionMutableList.getRejected()).hasSize(1);
    }

    @Test
    void getOldestPet() {
        Pet oldestPet = null;
        Assertions.assertThat(oldestPet.getType()).isEqualTo(PetType.DOG);
        Assertions.assertThat(oldestPet.getAge()).isEqualTo(4);
    }

    @Test
    void getAveragePetAge() {
        double averagePetAge = 0;
        Assertions.assertThat(averagePetAge).isEqualTo(1.8888888888888888, Assertions.within(0.00001));
    }

    @Test
    void addPetAgesToExistingSet() {
        // Hint: Use petAges as a target collection
        MutableIntSet petAges = IntSets.mutable.with(5);
        Assertions.assertThat(petAges).isEqualTo(IntSets.mutable.with(1, 2, 3, 4, 5));
    }

    @Test
    void refactorToEclipseCollections() {
        // Replace List and ArrayList with Eclipse Collections types
        List<Person> people = new ArrayList<>();
        people.add(new Person("Mary", "Smith").addPet(PetType.CAT, "Tabby", 2));
        people.add(new Person("Bob", "Smith")
                .addPet(PetType.CAT, "Dolly", 3)
                .addPet(PetType.DOG, "Spot", 2));
        people.add(new Person("Ted", "Smith").addPet(PetType.DOG, "Spike", 4));
        people.add(new Person("Jake", "Snake").addPet(PetType.SNAKE, "Serpy", 1));
        people.add(new Person("Barry", "Bird").addPet(PetType.BIRD, "Tweety", 2));
        people.add(new Person("Terry", "Turtle").addPet(PetType.TURTLE, "Speedy", 1));
        people.add(new Person("Harry", "Hamster")
                .addPet(PetType.HAMSTER, "Fuzzy", 1)
                .addPet(PetType.HAMSTER, "Wuzzy", 1));
        people.add(new Person("John", "Doe"));

        // Replace Set and HashSet with Eclipse Collections types
        Set<Integer> petAges = new HashSet<>();
        for (Person person : people) {
            for (Pet pet : person.getPets()) {
                petAges.add(pet.getAge());
            }
        }

        //extra bonus - convert to a primitive collection
        Assertions.assertThat(petAges).isEqualTo(Sets.mutable.with(1, 2, 3, 4)).withFailMessage("Extra Credit - convert to a primitive collection");

        Assertions.fail("Refactor to Eclipse Collections");
    }
}
