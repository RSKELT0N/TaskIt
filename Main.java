import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage introStage;
    private Scene introScene;
    private BorderPane root;
    private HeaderTab headerTab;
    private OptionTab optionTab;
    private mainWindow mainWind;
    private final int SCENE_WIDTH = 1200;
    private final int SCENE_HEIGHT = 700;
    private final String FONT_FAMILY = "Courier";

    @Override
    public void start(Stage primaryStage) {
        this.introStage = primaryStage;
        defineStage();
        introStage.show();
    }

    private void defineStage() {
        this.introScene = new Scene(createRoot());
        introStage.setResizable(false);
        introStage.setScene(introScene);
        displayContent();
    }

    private BorderPane createRoot() {
        this.root = new BorderPane();
        root.setPrefSize(SCENE_WIDTH, SCENE_HEIGHT);
        createRootChildren();
        return root;
    }

    private void createRootChildren() {
        this.headerTab = new HeaderTab(this);
        this.optionTab = new OptionTab(this);
        this.mainWind = new mainWindow(this);
    }

    private void displayContent() {
        root.setTop(headerTab);
        root.setLeft(optionTab);
        root.setCenter(mainWind);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public String getFONT_FAMILY() {
        return FONT_FAMILY;
    }
}
