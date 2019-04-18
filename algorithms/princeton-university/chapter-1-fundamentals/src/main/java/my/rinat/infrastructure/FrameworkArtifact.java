package my.rinat.infrastructure;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * <p>Annotation just marks any class (method, constructor etc.) which is required
 * by some frameworks but IDE shows warning that class (method, constructor etc.) is "never used".</p>
 *
 * @see <a href="https://stackoverflow.com/a/38899030/2892373">How to configure IntelliJ IDEA</a>
 */
@Retention(value = RetentionPolicy.SOURCE)
public @interface FrameworkArtifact {
    String usedBy() default "";
}
