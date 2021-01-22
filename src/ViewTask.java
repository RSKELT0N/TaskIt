import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

public class ViewTask extends VBox {
    private Main main;
    private Label title;
    private Task task;
    private GridPane infoLayout;

    public ViewTask(Main main, Task task) {
        this.main = main;
        this.task = task;
        createTitle();
        createInfoLayout();
        createChildren();
    }

    private Label createTitle() {
        title = new Label(task.name);
        title.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(50), null)));
        title.setStyle("-fx-border-radius: 100px");
        title.setFont(Font.font(main.getFONT_FAMILY(), 45));
        title.setTranslateY(-20);
        title.setTranslateX(-320);
        title.setPrefWidth(350);
        title.setPrefHeight(20);
        title.setAlignment(Pos.CENTER);

        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.rgb(0, 0, 0, 0.7));
        title.setEffect(shadow);
        return title;
    }

    private void createInfoLayout() {
        infoLayout = new GridPane();
        infoLayout.setTranslateY(50);
        infoLayout.setTranslateX(-500);
        infoLayout.setVgap(20);
        infoLayout.setHgap(5);

        //Description
        LabelTag desc = new LabelTag("Description");
        infoLayout.add(desc, 0, 0);
        //Separator
        Line line2 = new Line();
        line2.setStroke(Color.BLACK);
        line2.setStartX(0);
        line2.setStartX(140);
        infoLayout.add(line2, 0, 1);
        //Description Input
        TextArea descText = new TextArea();
        descText.setPrefSize(150, 50);

        for (int i = 0; i < task.description.length(); i++) {
            if ((i % 35) == 0 && i != 0) {
                descText.appendText("-");
                descText.appendText("\n");
            }
            descText.appendText(String.valueOf(task.description.charAt(i)));
        }
        infoLayout.add(descText, 0, 2);
        //Comments
        LabelTag comments = new LabelTag("Comments");
        infoLayout.add(comments, 0, 3);
        //Separator
        Line line3 = new Line();
        line3.setStroke(Color.BLACK);
        line3.setStartX(0);
        line3.setStartX(140);
        infoLayout.add(line3, 0, 4);
        //Comments Box
        TextArea comment = new TextArea();
        comment.setPrefSize(350, 150);

        for (int i = 0; i < task.comments.length(); i++) {
            if ((i % 50) == 0 && i != 0) {
                comment.appendText("-");
                comment.appendText("\n");
            }
            comment.appendText(String.valueOf(task.comments.charAt(i)));
        }
//        comment.setDisable(true);
        infoLayout.add(comment, 0, 5);
        //Date
        LabelTag date = new LabelTag("Date");
        infoLayout.add(date, 0, 6);
        //Separator
        Line line4 = new Line();
        line4.setStroke(Color.BLACK);
        line4.setStartX(0);
        line4.setStartX(140);
        infoLayout.add(line4, 0, 7);
        //Date Box
        TextArea dateBox = new TextArea();
        dateBox.setPrefSize(100, 20);
        dateBox.setText(task.date);
//        dateBox.setDisable(true);
        infoLayout.add(dateBox, 0, 8);
    }

    private void createChildren() {
        getChildren().add(title);
        getChildren().add(infoLayout);
    }

}
