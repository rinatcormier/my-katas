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
}
