import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class InputBox extends TextField {
    private final int INPUT_WIDTH = 150;
    private final int INPUT_HEIGHT = 30;

    public InputBox() {
        setDesign();
    }

    private void setDesign() {
        setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), null)));
        setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
        setFont(Font.font("Courier"));
        setPrefSize(INPUT_WIDTH, INPUT_HEIGHT);
    }
}
