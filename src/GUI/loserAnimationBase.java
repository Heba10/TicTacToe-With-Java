package tic;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;

public class loserAnimationBase extends Pane {

    protected final ImageView imageView;

    public loserAnimationBase() {
        Image img = new Image("tic/5.gif");
        imageView = new ImageView(img);

       // imageView = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        imageView.setFitHeight(387.0);
        imageView.setFitWidth(600.0);
        imageView.setLayoutY(7.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        getChildren().add(imageView);
         
        //imageView.setFitWidth(1000);
        imageView.setFitHeight(400);
       
       // imageView.setScaleY(2);
        imageView.setY(100);
        imageView.setX(200);
        
        AudioClip note =new AudioClip(this.getClass().getResource("3.mp3").toString());
        AudioClip note2 =new AudioClip(this.getClass().getResource("2.mp3").toString());
        note.play();
        note2.play();
    }
}
