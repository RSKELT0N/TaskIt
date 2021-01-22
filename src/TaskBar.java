import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class TaskBar extends VBox {
    private Main main;
    private ButtonOpt createTask;
    private OptionTab optTab;
    private GridPane listOfTasks;
    private ScrollPane scrollBar;
    private static int CREATE_TASK_WIDTH = 150;
    private static int CREATE_TASK_HEIGHT = 600;

    public TaskBar(Main main) {
        super();
        this.main = main;
        optTab = new OptionTab(main);
        listOfTasks = new GridPane();
        createTask = new ButtonOpt("Create Task", optTab);
        setDesign();
        addTasks();
        createChildren();
    }

    private void setDesign() {
        setMaxSize(CREATE_TASK_WIDTH,CREATE_TASK_HEIGHT);
        setBackground(new Background(new BackgroundFill(Color.rgb(187,188,196),null,null)));
        setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        setTranslateX(-168.7);
        setTranslateY(51.5);
    }

    private void addTasks() {
        Button s = new Button();
        s.setStyle("-fx-background-color: rgb(187,188,196);");
        s.setPrefSize(150,30);
        listOfTasks.add(s,0,0);
        listOfTasks.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));

        scrollBar = new ScrollPane(listOfTasks);
        scrollBar.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollBar.setHmax(0);
    }

    private void createChildren() {
        getChildren().add(createTask);
        Separator s = new Separator();
        s.setStyle("-fx-background-color: rgb(0,0,0);");
        getChildren().addAll(new Separator());
        getChildren().add(scrollBar);
    }

    public void addSingleTask(String text) {
        listOfTasks.add(new ButtonOpt(text,optTab),0,main.getTasks().size());
    }

    public GridPane getListOfTasks() {
        return listOfTasks;
    }

    public OptionTab getOptTab() {
        return optTab;
    }
}
