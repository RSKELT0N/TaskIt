import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LabelTag extends Label {
    private String text;

    LabelTag(String text) {
        this.text = text;
        setDesign();
    }

    private void setDesign() {
        setFont(Font.font("Courier", FontWeight.MEDIUM, 22));
        setText(text);
    }
}
