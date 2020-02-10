package GUI;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class Scores extends Pane {

    protected final TableView tableView;
    protected final TableColumn tableColumn;
    protected final TableColumn tableColumn0;
    protected final TableColumn tableColumn1;
    protected final TableColumn tableColumn2;
    protected final TableColumn tableColumn3;
    protected final Label label;

    public Scores() {

        tableView = new TableView();
        tableColumn = new TableColumn();
        tableColumn0 = new TableColumn();
        tableColumn1 = new TableColumn();
        tableColumn2 = new TableColumn();
        tableColumn3 = new TableColumn();
        label = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(800.0);
        setStyle("-fx-background-color: white;");

        tableView.setLayoutX(-4.0);
        tableView.setLayoutY(108.0);
        tableView.setPrefHeight(496.0);
        tableView.setPrefWidth(806.0);

        tableColumn.setPrefWidth(160.0);
        tableColumn.setText("Game Name");

        tableColumn0.setPrefWidth(160.0);
        tableColumn0.setText("Player 1");

        tableColumn1.setMinWidth(0.0);
        tableColumn1.setPrefWidth(160.0);
        tableColumn1.setText("Player 2");

        tableColumn2.setPrefWidth(160.0);
        tableColumn2.setText("Winner");

        tableColumn3.setMinWidth(0.0);
        tableColumn3.setPrefWidth(160.0);
        tableColumn3.setText("Time");

        label.setLayoutX(170.0);
        label.setLayoutY(5.0);
        label.setText("Game ScoreS");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#0f69cf"));
        label.setFont(new Font("Arial Narrow", 60.0));
        label.setFont(Font.loadFont(Scene1.class.getResource("Fonts/AGENTORANGE.TTF").toExternalForm(), 50));

        tableView.getColumns().add(tableColumn);
        tableView.getColumns().add(tableColumn0);
        tableView.getColumns().add(tableColumn1);
        tableView.getColumns().add(tableColumn2);
        tableView.getColumns().add(tableColumn3);
        getChildren().add(tableView);
        getChildren().add(label);

    }
}
