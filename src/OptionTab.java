import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class OptionTab extends VBox implements Clicked {

    private Main main;
    private ButtonOpt taskButton;
    private ButtonOpt settingsButton;
    private ButtonOpt homeButton;
    private final int OPTION_WIDTH = 150;
    private final int OPTION_HEIGHT = 500;
    private ButtonOpt currSelected;

    OptionTab(Main main) {
        super();
        this.main = main;
        setDesign();
        createChildren();
        currSelected = homeButton;
    }

    private void setDesign() {
        setPrefSize(OPTION_WIDTH, OPTION_HEIGHT);
        setBackground(new Background(new BackgroundFill(Color.rgb(139, 140, 148), null, null)));
        setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        setAlignment(Pos.TOP_CENTER);
    }


    private Label createTitle() {
        Label title = new Label("Option Tab");
        title.setFont(Font.font(main.getFONT_FAMILY(), 20));
        title.setPadding(new Insets(20, 0, 10, 0));
        title.setStyle("-fx-font-weight: bold");
        return title;
    }


    private void createChildren() {
        getChildren().add(createTitle());
        getChildren().add(new Separator());
        getChildren().add((homeButton = new ButtonOpt("Home", this)));
        getChildren().add((taskButton = new ButtonOpt("Tasks", this)));
        getChildren().add((settingsButton = new ButtonOpt("Settings", this)));
    }

    @Override
    public void click(ButtonOpt obj) {

        if (currSelected != obj) {
            //Prev Select to change colour
            currSelected.setStyle("-fx-background-color: rgb(139,140,148);");
            //Update currSelected Button
            currSelected = obj;
            //Update New Button colour
            obj.setStyle("-fx-background-color: rgba(103,103,112);");
        }
    }

    public void saveTask() {

        //Gather Info
        String name = main.getNewTask().getNameInput().getText();
        String desc = main.getNewTask().getDescInput().getText();
        String comments = main.getNewTask().getCommentTextArea().getText();
        String date = main.getNewTask().getDateInput().getEditor().getText();

        //Validate info
        if(name.isEmpty())
            return;

        //Save info
        main.getTaskBar().getListOfTasks().add(new ButtonOpt(name, main.getTaskBar().getOptTab()), 0, main.getTasks().size());
        main.getTasks().put(name, new Task(name, desc, comments, date));

        //Clear Information
        main.getNewTask().getNameInput().setText("");
        main.getNewTask().getDescInput().setText("");
        main.getNewTask().getCommentTextArea().setText("");
        main.getNewTask().getDateInput().getEditor().clear();


    }

    public Main getMain() {
        return main;
    }

    public Object getCurrSelected() {
        return currSelected;
    }
}
