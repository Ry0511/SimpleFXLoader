package sceneloader.impl.util;

import sceneloader.anno.FXRootFile;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class which wraps the underlying data access for generically
 * obtaining data from a class.
 *
 * @author -Ry
 * @version 0.1 Copyright: N/A
 */
public final class FXLoaderUtils {

    ///////////////////////////////////////////////////////////////////////////
    // Could probably merge this class into FXLoader but pulling them apart
    // still might be best. Things that go into here are more so the
    // underlying implementations of the methods that are held in the
    // FXLoader.java class.
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Hide the constructor.
     */
    private FXLoaderUtils() {
        // Unused
    }

    /**
     * Collects all static, URL, and Annotated with {@link FXRootFile} fields
     * from the provided Field list.
     *
     * @param classArgs The Class attributes to load.
     * @return All Static, URL, and Annotated with {@link FXRootFile}
     * attributes.
     * @throws IllegalAccessException If one occurs whilst trying to obtain the
     *                                underlying Field data.
     */
    public static URL[] getFXMLResources(final Field[] classArgs)
            throws IllegalAccessException {

        final List<URL> fxmlRoots = new ArrayList<>();

        // Collect all fields which are declared as FXRoot Resources.
        for (Field arg : classArgs) {
            final Annotation[] annotations = arg.getAnnotations();

            // For all fields 'annotated', that are 'static' with the type
            // 'URL' collect them.
            for (Annotation anno : annotations) {
                if (anno instanceof FXRootFile
                        && arg.getType().equals(URL.class)
                        && Modifier.isStatic(arg.getModifiers())) {

                    arg.setAccessible(true);
                    fxmlRoots.add((URL) arg.get(null));
                }
            }
        }

        return fxmlRoots.toArray(new URL[0]);
    }
}
