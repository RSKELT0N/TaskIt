import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main extends Application {

    private Stage introStage;
    private Scene introScene;
    private BorderPane root;
    private HeaderTab headerTab;
    private OptionTab optionTab;
    private mainWindow mainWind;
    private TaskBar taskBar;
    private NewTaskWindow newTask;
    private ViewTask viewTask;
    private Scanner sc;
    private String file = new String("/Users/ryanskelton/Documents/Projects/TaskIt/data.csv");
    private HashMap<String, Task> tasks = new HashMap<String, Task>();
    private final int SCENE_WIDTH = 1200;
    private final int SCENE_HEIGHT = 800;
    private final String FONT_FAMILY = "Courier";

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.introStage = primaryStage;
        defineStage();
        introStage.show();
    }

    private void defineStage() throws IOException {
        this.introScene = new Scene(createRoot());
        introStage.setResizable(false);
        introStage.setTitle("TaskIt");
        introStage.setScene(introScene);
        displayContent();
    }

    private BorderPane createRoot() throws IOException {
        this.root = new BorderPane();
        root.setPrefSize(SCENE_WIDTH, SCENE_HEIGHT);
        createRootChildren();
        return root;
    }

    private void createRootChildren() throws IOException {
        this.headerTab = new HeaderTab(this);
        this.optionTab = new OptionTab(this);
        this.mainWind = new mainWindow(this);
        this.taskBar = new TaskBar(this);
        this.newTask = new NewTaskWindow(this);
        loadData();
    }

    public void displayContent() {
        root.setTop(headerTab);
        root.setLeft(optionTab);
        root.setCenter(mainWind);
        root.setRight(null);
    }

    public void displayCreateTask() {
        taskBar.setTranslateX(-168.7);
        root.setCenter(taskBar);
        root.setRight(newTask);
    }

    public void displayViewTask(String text) {
        taskBar.setTranslateX(-275.7);
        root.setRight(new ViewTask(this, tasks.get(text)));
    }

    public TaskBar getTaskBar() {
        return taskBar;
    }

    private void loadData() throws FileNotFoundException {

        sc = new Scanner(new File(file));
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(",");

            Task currTask;

            if (line.length != 4)
                continue;
            else {
                currTask = new Task(line[0], line[1], line[2], line[3]);
                taskBar.addSingleTask(line[0]);
                tasks.put(line[0], currTask);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    public String getFONT_FAMILY() {
        return FONT_FAMILY;
    }

    public NewTaskWindow getNewTask() {
        return newTask;
    }

    public HashMap<String, Task> getTasks() {
        return tasks;
    }

    public String getFile() {
        return file;
    }

    public OptionTab getOptionTab() {
        return optionTab;
    }
}
