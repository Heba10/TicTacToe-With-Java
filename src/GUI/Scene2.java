package GUI;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class Scene2 extends Pane {

    protected final ImageView Logo;
    protected final Button btnStart;
    protected final Button btnViewRecords;
    protected final Button btnViewScores;
    protected final Button backbtn;
    protected final ImageView backimage;

    public Scene2() {

        Logo = new ImageView();
        btnStart = new Button();
        btnViewRecords = new Button();
        btnViewScores = new Button();
        backbtn = new Button();
        backimage = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(800.0);
        setStyle("-fx-background-color: white;");

        Logo.setFitHeight(186.962);
        Logo.setFitWidth(353.447);
        Logo.setLayoutX(223.0);
        Logo.setLayoutY(60.0);
        Logo.setPickOnBounds(true);
        Logo.setPreserveRatio(true);
        Logo.setImage(new Image(getClass().getResource("images/logo.png").toExternalForm()));

        btnStart.setAlignment(javafx.geometry.Pos.CENTER);
        btnStart.setLayoutX(254.0);
        btnStart.setLayoutY(309.0);
        btnStart.setMnemonicParsing(false);
        btnStart.setPrefHeight(48.0);
        btnStart.setPrefWidth(291.0);
        btnStart.getStyleClass().add("button1");
        btnStart.setText("Start");
        btnStart.setTextAlignment(javafx.scene.text.TextAlignment.JUSTIFY);
        btnStart.setCursor(Cursor.HAND);
        btnStart.setFont(Font.loadFont(Scene2.class.getResource("Fonts/z-arista.alternate.ttf").toExternalForm(), 25));

        btnViewRecords.setLayoutX(254.0);
        btnViewRecords.setLayoutY(390.0);
        btnViewRecords.setMnemonicParsing(false);
        btnViewRecords.setPrefHeight(48.0);
        btnViewRecords.setPrefWidth(291.271);
        btnViewRecords.getStyleClass().add("button2");
        btnViewRecords.setText("View RecordS");
        btnViewRecords.setTextAlignment(javafx.scene.text.TextAlignment.JUSTIFY);
        btnViewRecords.setCursor(Cursor.HAND);
        btnViewRecords.setFont(Font.loadFont(Scene2.class.getResource("Fonts/z-arista.alternate.ttf").toExternalForm(), 25));
        
        btnViewScores.setLayoutX(254.0);
        btnViewScores.setLayoutY(474.0);
        btnViewScores.setMnemonicParsing(false);
        btnViewScores.setPrefHeight(48.0);
        btnViewScores.setPrefWidth(291.271);
        btnViewScores.getStyleClass().add("button1");
        btnViewScores.setText("View ScoreS");
        btnViewRecords.setTextAlignment(javafx.scene.text.TextAlignment.JUSTIFY);
        btnViewScores.setCursor(Cursor.HAND);
        btnViewScores.setFont(Font.loadFont(Scene2.class.getResource("Fonts/z-arista.alternate.ttf").toExternalForm(), 25));

        backbtn.setLayoutX(48.0);
        backbtn.setLayoutY(38.0);
        backbtn.setMnemonicParsing(false);
        backbtn.setPrefHeight(45.0);
        backbtn.setPrefWidth(23.0);
        backbtn.setStyle("-fx-background-color: white;");
        

        backimage.setFitHeight(40.0);
        backimage.setFitWidth(22.0);
        backimage.setPickOnBounds(true);
        backimage.setPreserveRatio(true);
        backimage.setImage(new Image(getClass().getResource("images/back.png").toExternalForm()));
        backbtn.setGraphic(backimage);
        backbtn.setCursor(Cursor.HAND);

        getChildren().add(Logo);
        getChildren().add(btnStart);
        getChildren().add(btnViewRecords);
        getChildren().add(btnViewScores);
        getChildren().add(backbtn);

    }
}
