package GUI;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public  class ChooseScene extends Pane {

    protected final ImageView imageView;
    protected final Button btnX;
    protected final ImageView imageX;
    protected final Button btnO;
    protected final ImageView imageO;
    protected final ImageView imageView0;
    protected final Button backbtn;
    protected final ImageView backbtnImage;

    public ChooseScene() {

        imageView = new ImageView();
        btnX = new Button();
        imageX = new ImageView();
        btnO = new Button();
        imageO = new ImageView();
        imageView0 = new ImageView();
        backbtn = new Button();
        backbtnImage = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(800.0);
        setStyle("-fx-background-color: white;");

        imageView.setFitHeight(132.0);
        imageView.setFitWidth(630.0);
        imageView.setLayoutX(85.0);
        imageView.setLayoutY(116.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("images/text.png").toExternalForm()));

        btnX.setLayoutX(165.0);
        btnX.setLayoutY(312.0);
        btnX.setMnemonicParsing(false);
        btnX.setPrefHeight(116.0);
        btnX.setPrefWidth(166.0);
        btnX.setStyle("-fx-background-color: white;");
        btnX.setCursor(Cursor.HAND);

        imageX.setFitHeight(150.0);
        imageX.setFitWidth(200.0);
        imageX.setPickOnBounds(true);
        imageX.setPreserveRatio(true);
        imageX.setImage(new Image(getClass().getResource("images/x.png").toExternalForm()));
        btnX.setGraphic(imageX);

        btnO.setLayoutX(470.0);
        btnO.setLayoutY(312.0);
        btnO.setMnemonicParsing(false);
        btnO.setPrefHeight(158.0);
        btnO.setPrefWidth(154.0);
        btnO.setStyle("-fx-background-color: white;");
        btnO.setCursor(Cursor.HAND);

        imageO.setFitHeight(150.0);
        imageO.setFitWidth(200.0);
        imageO.setPickOnBounds(true);
        imageO.setPreserveRatio(true);
        imageO.setImage(new Image(getClass().getResource("images/O.png").toExternalForm()));
        btnO.setGraphic(imageO);

        imageView0.setFitHeight(45.0);
        imageView0.setFitWidth(38.0);
        imageView0.setLayoutX(381.0);
        imageView0.setLayoutY(369.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("images/or.png").toExternalForm()));
        
        
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
        getChildren().add(btnX);
        getChildren().add(btnO);
        getChildren().add(imageView0);
        getChildren().add(backbtn);

    }
}
