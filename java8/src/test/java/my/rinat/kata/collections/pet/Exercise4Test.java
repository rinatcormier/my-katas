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
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * In this set of tests, wherever you see .stream() replace it with an Eclipse Collections alternative.
 */
class Exercise4Test extends PetDomainForKata {

    @Test
    void getAgeStatisticsOfPets() {
        // Try to use a MutableIntList here instead
        // Hints: flatMap = flatCollect, map = collect, mapToInt = collectInt
        MutableList<Integer> petAges = this.people
                .stream()
                .flatMap(person -> person.getPets().stream())
                .map(pet -> pet.getAge())
                .collect(Collectors.toCollection(FastList::new));

        // Try to use an IntSet here instead
        Set<Integer> uniqueAges = petAges.toSet();
        // IntSummaryStatistics is a class in JDK 8 - Try and use it with MutableIntList.forEach()
        IntSummaryStatistics stats = petAges.stream().mapToInt(i -> i).summaryStatistics();
        // Is a Set<Integer> equal to an IntSet?
        // Hint: Try IntSets instead of Sets as the factory
        Assertions.assertThat(uniqueAges).isEqualTo(Sets.mutable.with(1, 2, 3, 4));
        // Try to leverage min, max, sum, average from the Eclipse Collections primitive api
        Assertions.assertThat(petAges.stream().mapToInt(i -> i).min().getAsInt()).isEqualTo(stats.getMin());
        Assertions.assertThat(petAges.stream().mapToInt(i -> i).max().getAsInt()).isEqualTo(stats.getMax());
        Assertions.assertThat(petAges.stream().mapToInt(i -> i).sum()).isEqualTo(stats.getSum());
        Assertions.assertThat(petAges.stream().mapToInt(i -> i).average().getAsDouble()).isEqualTo(stats.getAverage(), Assertions.within(0.0));
        Assertions.assertThat(petAges.size()).isEqualTo(stats.getCount());

        // Hint: Match = Satisfy
        Assertions.assertThat(petAges.stream().allMatch(i -> i > 0)).isTrue();
        Assertions.assertThat(petAges.stream().anyMatch(i -> i == 0)).isFalse();
        Assertions.assertThat(petAges.stream().noneMatch(i -> i < 0)).isTrue();

        // Don't forget to comment this out or delete it when you are done
        Assertions.fail("Refactor to Eclipse Collections");
    }

    @Test
    void streamsToECRefactor1() {
        //find Bob Smith
        Person person =
                this.people.stream()
                        .filter(each -> each.named("Bob Smith"))
                        .findFirst().get();

        //get Bob Smith's pets' names
        String names =
                person.getPets().stream()
                        .map(Pet::getName)
                        .collect(Collectors.joining(" & "));

        Assertions.assertThat(names).isEqualTo("Dolly & Spot");

        // Don't forget to comment this out or delete it when you are done
        Assertions.fail("Refactor to Eclipse Collections");
    }

    @Test
    void streamsToECRefactor2() {
        // Hint: Try to replace the Map<PetType, Long> with a Bag<PetType>
        Map<PetType, Long> countsStream =
                Collections.unmodifiableMap(
                        this.people.stream()
                                .flatMap(person -> person.getPets().stream())
                                .collect(Collectors.groupingBy(Pet::getType,
                                        Collectors.counting())));

        Assertions.assertThat(countsStream.get(PetType.CAT)).isEqualTo(2L);
        Assertions.assertThat(countsStream.get(PetType.DOG)).isEqualTo(2L);
        Assertions.assertThat(countsStream.get(PetType.HAMSTER)).isEqualTo(2L);
        Assertions.assertThat(countsStream.get(PetType.SNAKE)).isEqualTo(1L);
        Assertions.assertThat(countsStream.get(PetType.TURTLE)).isEqualTo(1L);
        Assertions.assertThat(countsStream.get(PetType.BIRD)).isEqualTo(1L);

        // Don't forget to comment this out or delete it when you are done
        Assertions.fail("Refactor to Eclipse Collections");
    }

    /**
     * The purpose of this test is to determine the top 3 pet types.
     */
    @Test
    void streamsToECRefactor3() {
        // Hint: The result of groupingBy/counting can almost always be replaced by a Bag
        // Hint: Look for the API on Bag that might return the top 3 pet types
        List<Map.Entry<PetType, Long>> favoritesStream =
                this.people.stream()
                        .flatMap(p -> p.getPets().stream())
                        .collect(Collectors.groupingBy(Pet::getType, Collectors.counting()))
                        .entrySet()
                        .stream()
                        .sorted(Comparator.comparingLong(e -> -e.getValue()))
                        .limit(3)
                        .collect(Collectors.toList());

        Assertions.assertThat(favoritesStream).hasSize(3);
        Assertions.assertThat(favoritesStream).contains(new AbstractMap.SimpleEntry<>(PetType.CAT, 2L));
        Assertions.assertThat(favoritesStream).contains(new AbstractMap.SimpleEntry<>(PetType.DOG, 2L));
        Assertions.assertThat(favoritesStream).contains(new AbstractMap.SimpleEntry<>(PetType.HAMSTER, 2L));

        // Don't forget to comment this out or delete it when you are done
        Assertions.fail("Refactor to Eclipse Collections");
    }
}
