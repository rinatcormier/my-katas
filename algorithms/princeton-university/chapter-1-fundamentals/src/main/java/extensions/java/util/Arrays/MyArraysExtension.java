package extensions.java.util.Arrays;

import manifold.ext.api.Extension;
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

    // todo: implement copying of the array
    @FrameworkArtifact(usedBy = "manifold.systems")
    @Extension
    public static double[] copy(double[] array) {
        throw new UnsupportedOperationException();
    }

    // todo: implement reversing of the array
    @FrameworkArtifact(usedBy = "manifold.systems")
    @Extension
    public static void reverse(double[] array) {
        throw new UnsupportedOperationException();
    }

    // todo: implement square matrices multiplication
    @FrameworkArtifact(usedBy = "manifold.systems")
    @Extension
    public static double[][] multiply(double[][] a, double[][] b) {
        throw new UnsupportedOperationException();
    }
}
