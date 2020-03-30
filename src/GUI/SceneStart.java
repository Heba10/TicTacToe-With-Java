package GUI;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

/**
 *
 * @author Ali Gomaa
 */
public class SceneStart extends Pane {

    protected final ImageView Logo;
    protected final Button btnPc;
    protected final Button btnPlayer;
    protected final Button btnOnline;
    protected final Button backbtn;
    protected final ImageView backbtnImage;

    public SceneStart() {

        Logo = new ImageView();
        btnPc = new Button();
        btnPlayer = new Button();
        btnOnline = new Button();
        backbtn = new Button();
        backbtnImage = new ImageView();

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

        btnPc.setLayoutX(191.0);
        btnPc.setLayoutY(312.0);
        btnPc.setMnemonicParsing(false);
        btnPc.setPrefHeight(54.0);
        btnPc.setPrefWidth(418.0);
        btnPc.getStyleClass().add("button1");
        btnPc.setText("Play VS PC");
        btnPc.setCursor(Cursor.HAND);
        btnPc.setFont(Font.loadFont(SceneStart.class.getResource("Fonts/z-arista.alternate.ttf").toExternalForm(), 25));

        btnPlayer.setLayoutX(190.0);
        btnPlayer.setLayoutY(391.0);
        btnPlayer.setMnemonicParsing(false);
        btnPlayer.setPrefHeight(54.0);
        btnPlayer.setPrefWidth(418.249);
        btnPlayer.getStyleClass().add("button2");
        btnPlayer.setText("Play VS Player");
        btnPlayer.setCursor(Cursor.HAND);
        btnPlayer.setFont(Font.loadFont(SceneStart.class.getResource("Fonts/z-arista.alternate.ttf").toExternalForm(), 25));

        btnOnline.setLayoutX(190.0);
        btnOnline.setLayoutY(468.0);
        btnOnline.setMnemonicParsing(false);
        btnOnline.setPrefHeight(54.0);
        btnOnline.setPrefWidth(418.249);
        btnOnline.getStyleClass().add("button1");
        btnOnline.setText("Play Online");
        btnOnline.setCursor(Cursor.HAND);
        btnOnline.setFont(Font.loadFont(SceneStart.class.getResource("Fonts/z-arista.alternate.ttf").toExternalForm(), 25));

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

        
        getChildren().add(Logo);
        getChildren().add(btnPc);
        getChildren().add(btnPlayer);
        getChildren().add(btnOnline);
        getChildren().add(backbtn);

    }
}
