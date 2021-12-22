package sceneloader.impl;

import javafx.scene.Parent;

import java.util.Objects;

/**
 * Wraps some Java FX package instance bundle. That being some Object hierarchy
 * has been loaded and a Controller class has been set.
 *
 * @param <T> The type of the controller class.
 * @author -Ry
 * @version 0.1 Copyright: N/A
 */
public class FXPackage<T> {

    /**
     * The controller object instance which controls the parent/object
     * hierarchy.
     */
    private final T pController;

    /**
     * The root of the literal object hierarchy that was loaded from some FXML
     * file.
     */
    private final Parent pRoot;

    /**
     * Constructs the package from the base Controller and Object hierarchy.
     *
     * @param controller The controller object.
     * @param root The object hierarchy.
     * @throws NullPointerException If the controller or root is null.
     */
    public FXPackage(final T controller,
                     final Parent root) {
        this.pController = Objects.requireNonNull(controller);
        this.pRoot = Objects.requireNonNull(root);
    }

    /**
     * @return The controller object instance of the fx package.
     */
    public T getController() {
        return pController;
    }

    /**
     * @return The root of the fxml resource that was loaded.
     */
    public Parent getRoot() {
        return pRoot;
    }
}
