package extensions.java.util.Arrays;

import manifold.ext.api.Extension;
import my.rinat.infrastructure.FrameworkArtifact;

@Extension
public class MyArraysExtension {

    // todo: implement linear maximum searching
    @FrameworkArtifact(usedBy = "manifold.systems")
    @Extension
    public static double max(double[] array) {
        throw new UnsupportedOperationException();
    }

    // todo: implement the average of the array values computing
    @FrameworkArtifact(usedBy = "manifold.systems")
    @Extension
    public static double avg(double[] array) {
        throw new UnsupportedOperationException();
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
