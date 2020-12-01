import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class OptionTab extends VBox {

    private Main main;
    private Button taskButton;
    private Button settingsButton;
    private Button homeButton;
    private final int OPTION_WIDTH = 150;
    private final int OPTION_HEIGHT = 500;
    private final String HOME_LABEL_TEXT = "Home";
    private final String TASK_LABEL_TEXT = "Tasks";
    private final String SETTINGS_LABEL_TEXT = "Settings";
    private final int OPTION_LABEL_SIZE = 22;

    OptionTab(Main main) {
        super();
        this.main = main;
        setDesign();
        createChildren();
    }

    private void setDesign() {
        setPrefSize(OPTION_WIDTH, OPTION_HEIGHT);
        setBackground(new Background(new BackgroundFill(Color.rgb(139,140,148),null,null)));
        setAlignment(Pos.TOP_CENTER);
    }

    private Button createHomeButton() {
        this.homeButton = new Button(HOME_LABEL_TEXT);
        homeButton.setBackground(new Background(new BackgroundFill(Color.rgb(139,140,148),null,new Insets(0,0,20,0))));

        this.homeButton.setPrefSize(OPTION_WIDTH,50);
        homeButton.setFont(Font.font(main.getFONT_FAMILY(), OPTION_LABEL_SIZE));

        homeButton.setOnMouseEntered(e -> homeButton.setStyle("-fx-background-color: rgba(103,103,112);"));
        homeButton.setOnMouseExited(e -> homeButton.setStyle("-fx-background-color: rgb(139,140,148);"));
        return homeButton;
    }

    private Button createTaskButton() {
        this.taskButton = new Button(TASK_LABEL_TEXT);
        taskButton.setBackground(new Background(new BackgroundFill(Color.rgb(139,140,148),null,null)));

        this.taskButton.setPrefSize(OPTION_WIDTH,50);
        taskButton.setFont(Font.font(main.getFONT_FAMILY(), OPTION_LABEL_SIZE));

        taskButton.setOnMouseEntered(e -> taskButton.setStyle("-fx-background-color: rgba(103,103,112);"));
        taskButton.setOnMouseExited(e -> taskButton.setStyle("-fx-background-color: rgb(139,140,148);"));
        return taskButton;
    }

    private Button createSettingsButton() {
        this.settingsButton = new Button(SETTINGS_LABEL_TEXT);
        settingsButton.setBackground(new Background(new BackgroundFill(Color.rgb(139, 140, 148), null, null)));

        this.settingsButton.setPrefSize(OPTION_WIDTH, 50);
        settingsButton.setFont(Font.font(main.getFONT_FAMILY(), OPTION_LABEL_SIZE));

        settingsButton.setOnMouseEntered(e -> settingsButton.setStyle("-fx-background-color: rgba(103,103,112);"));
        settingsButton.setOnMouseExited(e -> settingsButton.setStyle("-fx-background-color: rgb(139,140,148);"));
        return settingsButton;
    }

    private Label createTitle() {
        Label title = new Label("Option Tab");
        title.setFont(Font.font(main.getFONT_FAMILY(), 20));
        title.setPadding(new Insets(20,0,10,0));
        title.setStyle("-fx-font-weight: bold");
        return title;
    }


    private void createChildren() {
        getChildren().add(createTitle());
        getChildren().add(new Separator());
        getChildren().add(createHomeButton());
        getChildren().add(createTaskButton());
        getChildren().add(createSettingsButton());
    }
}
