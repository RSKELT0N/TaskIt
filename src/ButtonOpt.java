import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import javax.management.Notification;
import java.io.IOException;

public class ButtonOpt extends Button implements Option {
    private OptionTab optionTab;
    private TaskBar taskBar;
    private String text;
    private final int OPTION_WIDTH = 150;
    private final int OPTION_HEIGHT = 27;
    private final int OPTION_LABEL_SIZE = 18;

    ButtonOpt(String text, OptionTab opt) {
        this.optionTab = opt;
        this.text = text;
        setAppearance();
        setFunctionality();
    }

    private void setAppearance() {
        setText(text);
        setBackground(new Background(new BackgroundFill(Color.rgb(139, 140, 148), null, null)));
        setPrefSize(OPTION_WIDTH, OPTION_HEIGHT);
        setFont(Font.font(optionTab.getMain().getFONT_FAMILY(), OPTION_LABEL_SIZE));
    }

    private void setFunctionality() {
        setOnMouseEntered(e -> {
            if (optionTab.getCurrSelected() != this)
                setStyle("-fx-background-color: rgba(103,103,112);");
        });

        setOnMouseExited(e -> {
            if (optionTab.getCurrSelected() != this)
                setStyle("-fx-background-color: rgb(139,140,148);");
        });

        this.setOnMouseClicked(e -> {
            optionTab.click(this);
            try {
                determineWindow();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    @Override
    public void determineWindow() throws IOException {
        switch (text) {
            case "Home":
                optionTab.getMain().displayContent();
                break;
            case "Tasks":
            case "Create Task":
                optionTab.getMain().displayCreateTask();
                break;
            case "Save": {
                optionTab.getMain().getNewTask().writeTask();
                optionTab.saveTask();
                optionTab.getMain().getNewTask().getSave().setStyle("-fx-background-color: rgb(139,140,148);");
                break;
            }
            case "Settings":
                break;
            default:
                optionTab.getMain().displayViewTask(text); break;
        }
    }
}
