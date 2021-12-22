package sceneloader.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used to mark some static field in some class as being an FXRoot
 * resource which should be used when loading the class.
 *
 * @author -Ry
 * @version 0.1 Copyright: N/A
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface FXRootFile {
    ///////////////////////////////////////////////////////////////////////////
    // Never really used annotations so there is a lot that I don't understand.
    // Did some research but not much seemed to make sense. Technically don't
    // need an annotation for the usage I applied however it helps with code
    // clarity.
    ///////////////////////////////////////////////////////////////////////////
}
