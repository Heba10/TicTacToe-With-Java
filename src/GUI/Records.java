package GUI;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public  class Records extends ScrollPane {

    protected final AnchorPane anchorPane;
    protected final ImageView imageView;
    protected final Button button;
    protected final Button button0;
    protected final Button button1;
    protected final Button button2;
    protected final Button button3;
    protected final Button button4;
    protected final Button button5;
    protected final Button button6;
    protected final Button button7;
    protected final ImageView imageView0;

    public Records() {

        anchorPane = new AnchorPane();
        imageView = new ImageView();
        button = new Button();
        button0 = new Button();
        button1 = new Button();
        button2 = new Button();
        button3 = new Button();
        button4 = new Button();
        button5 = new Button();
        button6 = new Button();
        button7 = new Button();
        imageView0 = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(800.0);

        anchorPane.setPrefHeight(590.0);
        anchorPane.setPrefWidth(790.0);
        anchorPane.setStyle("-fx-background-color: white;");

        imageView.setFitHeight(77.0);
        imageView.setFitWidth(422.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("images/Rec.png").toExternalForm()));

        AnchorPane.setLeftAnchor(button, 256.0);
        AnchorPane.setRightAnchor(button, 268.0);
        button.setLayoutX(256.0);
        button.setLayoutY(115.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(44.0);
        button.setPrefWidth(266.0);
        button.getStyleClass().add("button2");
        button.setText("Game Name 1");

        AnchorPane.setLeftAnchor(button0, 256.0);
        AnchorPane.setRightAnchor(button0, 268.0);
        button0.setLayoutX(256.0);
        button0.setLayoutY(179.0);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(44.0);
        button0.setPrefWidth(266.0);
        button0.getStyleClass().add("button1");
        button0.setText("Game Name 2");

        AnchorPane.setLeftAnchor(button1, 256.0);
        AnchorPane.setRightAnchor(button1, 268.0);
        button1.setLayoutX(256.0);
        button1.setLayoutY(243.0);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(44.0);
        button1.setPrefWidth(266.0);
        button1.getStyleClass().add("button2");
        button1.setText("Game Name 3");

        AnchorPane.setLeftAnchor(button2, 256.0);
        AnchorPane.setRightAnchor(button2, 268.0);
        button2.setLayoutX(256.0);
        button2.setLayoutY(307.0);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(44.0);
        button2.setPrefWidth(266.0);
        button2.getStyleClass().add("button1");
        button2.setText("Game Name 4");

        AnchorPane.setLeftAnchor(button3, 256.0);
        AnchorPane.setRightAnchor(button3, 268.0);
        button3.setLayoutX(256.0);
        button3.setLayoutY(371.0);
        button3.setMnemonicParsing(false);
        button3.setPrefHeight(44.0);
        button3.setPrefWidth(266.0);
        button3.getStyleClass().add("button2");
        button3.setText("Game Name 5");

        AnchorPane.setLeftAnchor(button4, 256.0);
        AnchorPane.setRightAnchor(button4, 268.0);
        button4.setLayoutX(256.0);
        button4.setLayoutY(435.0);
        button4.setMnemonicParsing(false);
        button4.setPrefHeight(44.0);
        button4.setPrefWidth(266.0);
        button4.getStyleClass().add("button1");
        button4.setText("Game Name 6");

        AnchorPane.setLeftAnchor(button5, 256.0);
        AnchorPane.setRightAnchor(button5, 268.0);
        button5.setLayoutX(256.0);
        button5.setLayoutY(499.0);
        button5.setMnemonicParsing(false);
        button5.setPrefHeight(44.0);
        button5.setPrefWidth(266.0);
        button5.getStyleClass().add("button2");
        button5.setText("Game Name 7");

        AnchorPane.setLeftAnchor(button6, 256.0);
        AnchorPane.setRightAnchor(button6, 268.0);
        button6.setLayoutX(256.0);
        button6.setLayoutY(559.0);
        button6.setMnemonicParsing(false);
        button6.setPrefHeight(44.0);
        button6.setPrefWidth(266.0);
        button6.getStyleClass().add("button1");
        button6.setText("Game Name 8");

        AnchorPane.setLeftAnchor(button7, 256.0);
        AnchorPane.setRightAnchor(button7, 268.0);
        button7.setLayoutX(256.0);
        button7.setLayoutY(620.0);
        button7.setMnemonicParsing(false);
        button7.setPrefHeight(44.0);
        button7.setPrefWidth(266.0);
        button7.getStyleClass().add("button2");
        button7.setText("Game Name 8");

        imageView0.setFitHeight(154.0);
        imageView0.setFitWidth(209.0);
        imageView0.setLayoutX(567.0);
        imageView0.setLayoutY(14.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("images/logo.png").toExternalForm()));
        setContent(anchorPane);

        anchorPane.getChildren().add(imageView);
        anchorPane.getChildren().add(button);
        anchorPane.getChildren().add(button0);
        anchorPane.getChildren().add(button1);
        anchorPane.getChildren().add(button2);
        anchorPane.getChildren().add(button3);
        anchorPane.getChildren().add(button4);
        anchorPane.getChildren().add(button5);
        anchorPane.getChildren().add(button6);
        anchorPane.getChildren().add(button7);
        anchorPane.getChildren().add(imageView0);

    }
}