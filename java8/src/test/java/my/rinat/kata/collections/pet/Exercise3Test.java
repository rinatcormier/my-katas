/*
 * Copyright (c) 2017 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package my.rinat.kata.collections.pet;

import org.assertj.core.api.Assertions;
import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.multimap.set.MutableSetMultimap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.factory.Multimaps;
import org.eclipse.collections.impl.factory.Sets;
import org.junit.jupiter.api.Test;

/**
 * In the slides leading up to this exercise you should have learned about the following APIs.
 * <p/>
 * {@link Bag}<br>
 * {@link MutableBag}<br>
 * {@link MutableList#toBag()}<br>
 * <br>
 * {@link Multimap}<br>
 * {@link MutableList#groupBy(Function)}<br>
 * {@link MutableList#groupByEach(Function)}<br>
 * {@link Multimaps}<br>
 *
 * @see <a href="http://eclipse.github.io/eclipse-collections-kata/pet-kata/#/6">Exercise 3 Slides</a>
 */
class Exercise3Test extends PetDomainForKata {

    @Test
    void getCountsByPetType() {
        MutableList<PetType> petTypes = this.people.flatCollect(Person::getPets).collect(Pet::getType);

        // Do you recognize this pattern?
        MutableMap<PetType, Integer> petTypeCounts = Maps.mutable.empty();
        for (PetType petType : petTypes) {
            Integer count = petTypeCounts.get(petType);
            if (count == null) {
                count = 0;
            }
            petTypeCounts.put(petType, count + 1);
        }

        Assertions.assertThat(petTypeCounts.get(PetType.CAT)).isEqualTo(2);
        Assertions.assertThat(petTypeCounts.get(PetType.DOG)).isEqualTo(2);
        Assertions.assertThat(petTypeCounts.get(PetType.HAMSTER)).isEqualTo(2);
        Assertions.assertThat(petTypeCounts.get(PetType.SNAKE)).isEqualTo(1);
        Assertions.assertThat(petTypeCounts.get(PetType.TURTLE)).isEqualTo(1);
        Assertions.assertThat(petTypeCounts.get(PetType.BIRD)).isEqualTo(1);

        // Hint: use the appropriate method on this.people to create a Bag<PetType>
        Bag<PetType> counts = null;
        Assertions.assertThat(counts.occurrencesOf(PetType.CAT)).isEqualTo(2);
        Assertions.assertThat(counts.occurrencesOf(PetType.DOG)).isEqualTo(2);
        Assertions.assertThat(counts.occurrencesOf(PetType.HAMSTER)).isEqualTo(2);
        Assertions.assertThat(counts.occurrencesOf(PetType.SNAKE)).isEqualTo(1);
        Assertions.assertThat(counts.occurrencesOf(PetType.TURTLE)).isEqualTo(1);
        Assertions.assertThat(counts.occurrencesOf(PetType.BIRD)).isEqualTo(1);
    }

    @Test
    void getPeopleByLastName() {
        // Do you recognize this pattern?
        MutableMap<String, MutableList<Person>> lastNamesToPeople = Maps.mutable.empty();
        for (Person person : this.people) {
            String lastName = person.getLastName();
            MutableList<Person> peopleWithLastName = lastNamesToPeople.get(lastName);
            if (peopleWithLastName == null) {
                peopleWithLastName = Lists.mutable.empty();
                lastNamesToPeople.put(lastName, peopleWithLastName);
            }
            peopleWithLastName.add(person);
        }
        Assertions.assertThat(lastNamesToPeople.get("Smith")).hasSize(3);

        // Hint: use the appropriate method on this.people to create a Multimap<String, Person>
        Multimap<String, Person> byLastNameMultimap = null;

        Assertions.assertThat(byLastNameMultimap.get("Smith")).hasSize(3);
    }

    @Test
    void getPeopleByTheirPets() {
        // Do you recognize this pattern?
        MutableMap<PetType, MutableSet<Person>> peopleByPetType = Maps.mutable.empty();

        for (Person person : this.people) {
            MutableList<Pet> pets = person.getPets();
            for (Pet pet : pets) {
                PetType petType = pet.getType();
                MutableSet<Person> peopleWithPetType = peopleByPetType.get(petType);
                if (peopleWithPetType == null) {
                    peopleWithPetType = Sets.mutable.empty();
                    peopleByPetType.put(petType, peopleWithPetType);
                }
                peopleWithPetType.add(person);
            }
        }

        Assertions.assertThat(peopleByPetType.get(PetType.CAT)).hasSize(2);
        Assertions.assertThat(peopleByPetType.get(PetType.DOG)).hasSize(2);
        Assertions.assertThat(peopleByPetType.get(PetType.HAMSTER)).hasSize(1);
        Assertions.assertThat(peopleByPetType.get(PetType.TURTLE)).hasSize(1);
        Assertions.assertThat(peopleByPetType.get(PetType.BIRD)).hasSize(1);
        Assertions.assertThat(peopleByPetType.get(PetType.SNAKE)).hasSize(1);

        // Hint: use the appropriate method on this.people with a target collection to create a MutableSetMultimap<String, Person>
        // Hint: this.people is a MutableList, so it will return a MutableListMultimap without a target collection
        MutableSetMultimap<PetType, Person> multimap = null;

        Assertions.assertThat(multimap.get(PetType.CAT)).hasSize(2);
        Assertions.assertThat(multimap.get(PetType.DOG)).hasSize(2);
        Assertions.assertThat(multimap.get(PetType.HAMSTER)).hasSize(1);
        Assertions.assertThat(multimap.get(PetType.TURTLE)).hasSize(1);
        Assertions.assertThat(multimap.get(PetType.BIRD)).hasSize(1);
        Assertions.assertThat(multimap.get(PetType.SNAKE)).hasSize(1);
    }
}
