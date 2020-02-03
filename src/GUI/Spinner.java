package GUI;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class Spinner extends Pane {

    protected final ImageView imageView;
    protected final Label label;

    public Spinner() {

        imageView = new ImageView();
        label = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(800.0);
        setStyle("-fx-background-color: #001F31;");

        imageView.setFitHeight(505.0);
        imageView.setFitWidth(613.0);
        imageView.setLayoutX(94.0);
        imageView.setLayoutY(42.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("images/source.gif").toExternalForm()));

        label.setLayoutX(120.0);
        label.setLayoutY(502.0);
        label.setPrefHeight(42.0);
        label.setPrefWidth(561.0);
        label.setText("Waiting For Other Player To Join .....");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("Arial Black", 28.0));

        getChildren().add(imageView);
        getChildren().add(label);

    }
}
