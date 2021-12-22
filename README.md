# SimpleFXLoader
Simple JavaFX Scene/Object hierarchy loader that can load dynamically some Controller Class once
some annotations are used. This only works for scenes that are loaded from `.FXML` files.

### Usage
From two Files, a `Java Controller class` and a `.FXML` object hierarchy.

#### Main.java
```
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sceneloader.impl.FXLoader;
import sceneloader.impl.FXPackage;

public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Static class loading mechanism for packaging a loaded object
        // hierarchy
        final FXPackage<SampleController> cont
                = FXLoader.loadController(SampleController.class);

        primaryStage.setScene(new Scene(cont.getRoot()));
        primaryStage.show();
    }
}
```
##### SampleController.java
```
import sceneloader.anno.FXRootFile;
import java.net.URL;

public class SampleController {
    // Annotate the target fxml with FXRootFile so that it can be targeted
    // when using the FXLoader.
    @FXRootFile
    private static final URL SCENE_FXML
            = SampleController.class.getResource("SampleScene.fxml");
}
```
