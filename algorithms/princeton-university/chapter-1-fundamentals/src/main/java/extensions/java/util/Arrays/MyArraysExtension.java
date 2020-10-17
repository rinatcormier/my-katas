package extensions.java.util.Arrays;

import manifold.ext.rt.api.Extension;
import my.rinat.infrastructure.FrameworkArtifact;

import java.util.Objects;

@Extension
public class MyArraysExtension {

    @FrameworkArtifact(usedBy = "manifold.systems")
    @Extension
    public static double max(double[] array) {
        Objects.requireNonNull(array);
        double max = array[0];
        for (double entry : array) {
            if (entry > max) {
                max = entry;
            }
        }
        return max;
    }

    @FrameworkArtifact(usedBy = "manifold.systems")
    @Extension
    public static double avg(double[] array) {
        Objects.requireNonNull(array);
        double sum = array[0];
        for (int i = 1; i < array.length; i++) {
            sum += array[i];
        }
        return sum / array.length;
    }

    @FrameworkArtifact(usedBy = "manifold.systems")
    @Extension
    public static double[] copy(double[] array) {
        Objects.requireNonNull(array);
        double[] copy = new double[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        return copy;
    }

    @FrameworkArtifact(usedBy = "manifold.systems")
    @Extension
    public static void reverse(double[] array) {
        Objects.requireNonNull(array);
        int size = array.length;
        for (int i = 0; i < size / 2; i++) {
            array[i] += array[size - i - 1];
            array[size - i - 1] = array[i] - array[size - i - 1];
            array[i] -= array[size - i - 1];
        }
    }

    // todo: implement square matrices multiplication
    @FrameworkArtifact(usedBy = "manifold.systems")
    @Extension
    public static double[][] multiply(double[][] a, double[][] b) {
        throw new UnsupportedOperationException();
    }
}
