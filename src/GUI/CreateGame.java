package tictactoe;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class CreateGame extends Pane {

    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final Button button;
    protected final Button button0;
    protected final Button backbtn;
    protected final ImageView backbtnImage;

    public CreateGame() {

        imageView = new ImageView();
        imageView0 = new ImageView();
        button = new Button();
        button0 = new Button();
        backbtn = new Button();
        backbtnImage = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(800.0);
        setStyle("-fx-background-color: white;");

        imageView.setFitHeight(62.877);
        imageView.setFitWidth(393.511);
        imageView.setLayoutY(95.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("images/online.png").toExternalForm()));

        imageView0.setFitHeight(118.114);
        imageView0.setFitWidth(223.292);
        imageView0.setLayoutX(551.0);
        imageView0.setLayoutY(67.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("images/logo.png").toExternalForm()));

        button.setLayoutX(203.0);
        button.setLayoutY(269.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(55.0);
        button.setPrefWidth(393.082);
        button.getStyleClass().add("button1");
        button.setText("Create Game");
        button.setFont(Font.loadFont(Scene1.class.getResource("Fonts/z-arista.alternate.ttf").toExternalForm(), 22));

        button0.setLayoutX(203.0);
        button0.setLayoutY(397.0);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(55.0);
        button0.setPrefWidth(393.082);
        button0.getStyleClass().add("button2");
        button0.setText("Join Game");
        button0.setFont(Font.loadFont(Scene1.class.getResource("Fonts/z-arista.alternate.ttf").toExternalForm(), 22));
        
        
        backbtn.setLayoutX(48.0);
        backbtn.setLayoutY(38.0);
        backbtn.setMnemonicParsing(false);
        backbtn.setPrefHeight(45.0);
        backbtn.setPrefWidth(37.0);
        backbtn.setStyle("-fx-background-color: white;");

        backbtnImage.setFitHeight(40.0);
        backbtnImage.setFitWidth(22.0);
        backbtnImage.setPickOnBounds(true);
        backbtnImage.setPreserveRatio(true);
        backbtnImage.setImage(new Image(getClass().getResource("images/back.png").toExternalForm()));
        backbtn.setGraphic(backbtnImage);
        backbtn.setCursor(Cursor.HAND);

        getChildren().add(imageView);
        getChildren().add(imageView0);
        getChildren().add(button);
        getChildren().add(button0);
        getChildren().add(backbtn);

    }
}
