import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class NewTaskWindow extends VBox {
    private Main main;
    private Label title;
    private GridPane infoLayout;
    private ButtonOpt save;
    private InputBox nameInput;
    private InputBox descInput;
    private TextArea commentTextArea;
    private DatePicker dateInput;
    private BufferedWriter writer;


    public NewTaskWindow(Main main) throws IOException {
        this.main = main;
        writer = new BufferedWriter(new FileWriter(main.getFile(), true));
        createTitle();
        createInfoLayout();
        createSaveButton();
        createChildren();
    }


    private Label createTitle() {
        title = new Label("New Task");
        title.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(50), null)));
        title.setStyle("-fx-border-radius: 100px");
        title.setFont(Font.font(main.getFONT_FAMILY(), 45));
        title.setTranslateY(-20);
        title.setTranslateX(-165);
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
        infoLayout.setTranslateX(-290);
        infoLayout.setVgap(10);
        infoLayout.setHgap(5);

        //Name
        LabelTag name = new LabelTag("Name ");
        nameInput = new InputBox();
        infoLayout.add(name,0,1);
        infoLayout.add(nameInput,1,1);
        //Separator
        infoLayout.add(new Separator(), 0,2);
        //Description
        LabelTag desc = new LabelTag("Description ");
        descInput = new InputBox();
        descInput.setMinWidth(400);
        infoLayout.add(desc,0,3);
        infoLayout.add(descInput,1,3);
        //Separator
        infoLayout.add(new Separator(), 0,4);
        //Comments
        LabelTag comment = new LabelTag("Comments");
        commentTextArea = new TextArea();
        commentTextArea.setPrefSize(200,100);
        commentTextArea.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
        infoLayout.add(comment,0,5);
        infoLayout.add(commentTextArea, 1,5);
        //Separator
        infoLayout.add(new Separator(), 0,6);
        //Date
        LabelTag date = new LabelTag("Date ");
        dateInput = new DatePicker();
        dateInput.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
        infoLayout.add(date,0,25);
        infoLayout.add(dateInput, 1,25);
    }

    private void createSaveButton() {
        save = new ButtonOpt("Save", new OptionTab(main));
        save.setTranslateX(360);
        save.setTranslateY(20);
    }

    private void createChildren() {
        getChildren().add(title);
        getChildren().add(infoLayout);
        getChildren().add(save);
    }

    public void writeTask() throws IOException {
        writer.write(main.getNewTask().nameInput.getText()+","
                +main.getNewTask().descInput.getText()+","
                +main.getNewTask().commentTextArea.getText()+","
                +main.getNewTask().dateInput.getEditor().getText()+"\n");
        writer.close();
    }

    public InputBox getNameInput() {
        return nameInput;
    }

    public InputBox getDescInput() {
        return descInput;
    }

    public TextArea getCommentTextArea() {
        return commentTextArea;
    }

    public DatePicker getDateInput() {
        return dateInput;
    }

    public ButtonOpt getSave() {
        return save;
    }
}
