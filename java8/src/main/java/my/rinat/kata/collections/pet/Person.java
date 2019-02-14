package my.rinat.kata.collections.pet;

import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.list.mutable.FastList;

/**
 * Domain model was taken
 * from <a href="https://github.com/eclipse/eclipse-collections-kata">eclipse-collections-kata</a>
 */
class Person {

    private final String firstName;
    private final String lastName;
    private final MutableList<Pet> pets = FastList.newList();

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    String getFirstName() {
        return this.firstName;
    }

    String getLastName() {
        return this.lastName;
    }

    boolean named(String name) {
        return name.equals(this.firstName + ' ' + this.lastName);
    }

    boolean hasPet(PetType petType) {
        return this.pets.anySatisfyWith(Predicates2.attributeEqual(Pet::getType), petType);
    }

    MutableList<Pet> getPets() {
        return this.pets;
    }

    MutableBag<PetType> getPetTypes() {
        return this.pets.collect(Pet::getType, HashBag.newBag());
    }

    Person addPet(PetType petType, String name, int age) {
        this.pets.add(new Pet(petType, name, age));
        return this;
    }

    boolean isPetPerson() {
        return this.getNumberOfPets() >= 1;
    }

    int getNumberOfPets() {
        return this.pets.size();
    }
}
