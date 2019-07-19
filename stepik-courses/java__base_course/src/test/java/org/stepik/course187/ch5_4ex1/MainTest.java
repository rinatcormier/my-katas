package org.stepik.course187.ch5_4ex1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

class MainTest {
    @Test
    void testDeserializeAnimalArray() throws IOException {

        Animal[] animals = {
                new Animal("Lion"),
                new Animal("Elephant"),
                new Animal("Monkey")
        };

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeInt(animals.length);
            for (Animal animal : animals) {
                oos.writeObject(animal);
            }
        }

        Animal[] deserializedAnimals = Main.deserializeAnimalArray(baos.toByteArray());
        for (int i = 0; i < deserializedAnimals.length; i++) {
            Assertions.assertThat(deserializedAnimals[i]).isEqualTo(animals[i]);
        }
    }
}