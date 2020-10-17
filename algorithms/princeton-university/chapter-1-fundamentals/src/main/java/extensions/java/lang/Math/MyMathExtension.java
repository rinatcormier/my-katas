package extensions.java.lang.Math;

import manifold.ext.rt.api.Extension;
import my.rinat.infrastructure.FrameworkArtifact;

@Extension
public class MyMathExtension {

    // todo: implement Euclid's algorithm
    @FrameworkArtifact(usedBy = "manifold.systems")
    @Extension
    public static int gcd(int p, int q) {
        throw new UnsupportedOperationException();
    }
}
