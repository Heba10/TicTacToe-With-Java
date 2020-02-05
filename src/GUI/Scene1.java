package GUI;

import java.awt.Color;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Scene1 extends Pane {

    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final Button button;
    protected final TextField textField;
    protected final Label label;

    public Scene1() {

        imageView = new ImageView();
        imageView0 = new ImageView();
        button = new Button();
        textField = new TextField();
        label = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(800.0);

        imageView.setFitHeight(620.0);
        imageView.setFitWidth(820.0);
        imageView.setLayoutX(0.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("images/background.png").toExternalForm()));
        

        imageView0.setFitHeight(212.0);
        imageView0.setFitWidth(377.0);
        imageView0.setLayoutX(212.0);
        imageView0.setLayoutY(56.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("images/logo.png").toExternalForm()));

        button.setLayoutX(286.0);
        button.setLayoutY(451.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(47.0);
        button.setPrefWidth(226.0);
        button.getStyleClass().add("button1");
        button.setText("Start");
        button.setFont(Font.loadFont(Scene1.class.getResource("Fonts/z-arista.alternate.ttf").toExternalForm(), 22));
        button.setCursor(Cursor.HAND);
        //button.defaultButtonProperty().bind(button.focusedProperty());
        
        //fire enter button
        button.setOnKeyPressed(event -> {
        if (event.getCode().equals(KeyCode.ENTER)) {
            button.fire();
        }
    }
    );


        textField.setLayoutX(200.0);
        textField.setLayoutY(373.0);
        textField.setPrefHeight(47.0);
        textField.setPrefWidth(399.0);
        textField.getStyleClass().add("textInput");
        textField.setAlignment(Pos.CENTER);
        textField.setFont(Font.font ("Verdana",FontWeight.BOLD, 20));

        label.setLayoutX(240.0);
        label.setLayoutY(315.0);
        label.setText("Enter Your Name");
        label.setFont(Font.loadFont(Scene1.class.getResource("Fonts/AGENTORANGE.TTF").toExternalForm(), 25));

        getChildren().add(imageView);
        getChildren().add(imageView0);
        getChildren().add(button);
        getChildren().add(textField);
        getChildren().add(label);
        
        
        
        
        

    }

    public TextField getTextField() {
        return textField;
    }
    
}
