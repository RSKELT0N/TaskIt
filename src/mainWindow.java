import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class mainWindow extends VBox {
    private Main main;
    private Label title;
    private final int MAIN_WIDTH = 500;
    private final int MAIN_HEIGHT = 400;

    mainWindow(Main main) {
        super();
        this.main = main;
        setDesign();
        createChildren();
    }

    private void setDesign() {
        setAlignment(Pos.CENTER);
        setPrefSize(MAIN_WIDTH, MAIN_HEIGHT);
        setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
    }

    private void createChildren() {
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Task 1", 13),
                        new PieChart.Data("Task 2", 25),
                        new PieChart.Data("Task 3", 10),
                        new PieChart.Data("Task 4", 10),
                        new PieChart.Data("Task 5", 10));

        final PieChart chart = new PieChart(pieChartData);
        chart.setMaxHeight(350);
        chart.setTranslateX(-20);
        chart.setTranslateY(60);
        chart.setTitle("Completed Tasks");

        getChildren().add(chart);
        getChildren().add(createTitle());
    }

    private Label createTitle() {
        title = new Label("Overall Tasks");
        title.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(50), null)));
        title.setStyle("-fx-border-radius: 100px");
        title.setFont(Font.font(main.getFONT_FAMILY(), 45));
        title.setPrefWidth(600);
        title.setPrefHeight(60);
        title.setTranslateY(-490);
        title.setAlignment(Pos.CENTER);

        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.rgb(0, 0, 0, 0.7));
        title.setEffect(shadow);
        return title;
    }
}
