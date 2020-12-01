import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class mainWindow extends VBox {
    private Main main;
    private Label title;
    private final int MAIN_WIDTH = 500;
    private final int MAIN_HEIGHT = 400;

    mainWindow(Main main) {
        super();
        this.main = main;
        setDesign();
        createChildren();
    }

    private void setDesign() {
        setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        setAlignment(Pos.CENTER);
        setPrefSize(MAIN_WIDTH, MAIN_HEIGHT);
    }

    private void createChildren() {
        getChildren().add(createTitle());
    }

    private Label createTitle() {
        title = new Label("Overall Tasks");
        title.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(50),null)));
        title.setStyle("-fx-border-radius: 100px");
        title.setFont(Font.font(55));
        title.setPrefWidth(600);
        title.setPrefHeight(60);
        title.setTranslateY(-240);
        title.setAlignment(Pos.CENTER);

        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.rgb(0,0,0,0.7));
        title.setEffect(shadow);
        return title;
    }
}
