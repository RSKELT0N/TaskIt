import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class HeaderTab extends VBox {

    private Main main;
    private Label headLabel;
    private ImageView tradeMarkImageHolder;
    private Image tradeMarkImage;
    private final int HEADER_WIDTH = 1200;
    private final int HEADER_HEIGHT = 100;
    private final String APPLICATION_NAME = "TaskIt";
    private final int APPLICATION_NAME_SIZE = 70;

    HeaderTab(Main main) {
        super();
        this.main = main;
        setDesign();
        createChildren();
    }

    private void setDesign() {
        setBackground(new Background(new BackgroundFill(Color.rgb(68, 69, 77), null, null)));
        setAlignment(Pos.TOP_RIGHT);
        setPrefSize(HEADER_WIDTH, HEADER_HEIGHT);
    }

    private Node createTradeMark() {
        this.tradeMarkImageHolder = new ImageView();
        tradeMarkImageHolder.setFitWidth(40);
        tradeMarkImageHolder.setFitHeight(40);
        tradeMarkImageHolder.setX(-100);

        this.tradeMarkImage = new Image("/Images/TaskIt.png");
        tradeMarkImageHolder.setImage(tradeMarkImage);
        return tradeMarkImageHolder;
    }

    private Label createHeadLabel() {
        headLabel = new Label(APPLICATION_NAME);
        headLabel.setFont(Font.font(main.getFONT_FAMILY(),APPLICATION_NAME_SIZE));
        headLabel.setTextFill(Color.LIGHTGRAY);
        headLabel.setTranslateX(-25);
        headLabel.setTranslateY(25);
        return headLabel;
    }

    private void createChildren() {
        getChildren().add(createHeadLabel());
//        getChildren().add(createTradeMark());
    }
}
