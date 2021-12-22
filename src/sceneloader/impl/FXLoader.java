package sceneloader.impl;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import sceneloader.impl.util.FXLoaderUtils;

import java.io.IOException;
import java.net.URL;

/**
 * Main fxml scene loader utility class used to initiate java fx controllers
 * using a simple reusable system. Where once a Resource is annotated with
 * {@link sceneloader.anno.FXRootFile} it can be loaded dynamically.
 *
 * @author -Ry
 * @version 0.2 Copyright: N/A
 */
public final class FXLoader {

    /**
     * Hide the constructor as unused.
     */
    private FXLoader() {
        // Unused
    }

    /**
     * Loads a controller and packages it into an {@link FXPackage}. Loading of
     * the resource is the same as if you were to construct an {@link
     * FXMLLoader} using some {@link URL} resource.
     *
     * @param contClass The controller class to load. Assumes that the resource
     * bundle has been annotated.
     * @param <T> The Controller of the resource to load. This is the object
     * from {@link FXMLLoader#getController()}.
     * @return Newly loaded Parent fx root and controller.
     * @throws IOException           If one occurs whilst loading the resource.
     * @throws IllegalStateException If the detected number of resources to load
     *                               is less than zero or greater than one.
     */
    public static <T> FXPackage<T> loadController(final Class<T> contClass)
            throws IOException,
            IllegalAccessException {

        final URL[] fxmlResources = FXLoaderUtils.getFXMLResources(
                contClass.getDeclaredFields()
        );

        if (fxmlResources.length == 1) {
            final FXMLLoader loader = new FXMLLoader(fxmlResources[0]);
            final Parent root = loader.load();
            final T controller = loader.getController();

            return new FXPackage<>(controller, root);

            // No bound resource to load or too many to figure out
        } else {
            throw new IllegalStateException();
        }
    }
}
