import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

public class HeaderTab extends VBox {

    private Main main;
    private Label headLabel;
    private ImageView tradeMarkImageHolder;
    private Image tradeMarkImage;
    private final int HEADER_WIDTH = 1000;
    private final int HEADER_HEIGHT = 80;
    private final String APPLICATION_NAME = "TaskIt";
    private final int APPLICATION_NAME_SIZE = 70;

    HeaderTab(Main main) {
        super();
        this.main = main;
        setDesign();
        createTradeMark();
        createChildren();
    }

    private void setDesign() {
        setBackground(new Background(new BackgroundFill(Color.rgb(92,30,2), null, null)));
        setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        setAlignment(Pos.TOP_RIGHT);
        setPrefSize(HEADER_WIDTH, HEADER_HEIGHT);
    }

    private Node createTradeMark() {
        this.tradeMarkImageHolder = new ImageView();
        tradeMarkImageHolder.setFitWidth(80);
        tradeMarkImageHolder.setFitHeight(80);
        tradeMarkImageHolder.setTranslateX(-1060);
        tradeMarkImageHolder.setTranslateY(-40);

        this.tradeMarkImage = new Image("/Images/TaskIt.png");
        tradeMarkImageHolder.setImage(tradeMarkImage);
        return tradeMarkImageHolder;
    }

    private Label createHeadLabel() {
        headLabel = new Label(APPLICATION_NAME);
        headLabel.setFont(Font.font(main.getFONT_FAMILY(), FontPosture.ITALIC, APPLICATION_NAME_SIZE));
        headLabel.setTextFill(Color.BLACK);
        headLabel.setTranslateX(-25);
        headLabel.setTranslateY(25);
        return headLabel;
    }

    private void createChildren() {
        getChildren().add(createHeadLabel());
        getChildren().add(createTradeMark());
    }
}
