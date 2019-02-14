package my.rinat.kata.collections.pet;

class Pet {
    private final PetType type;
    private final String name;
    private final int age;

    Pet(PetType type, String name, int age) {
        this.type = type;
        this.name = name;
        this.age = age;
    }

    public PetType getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}
