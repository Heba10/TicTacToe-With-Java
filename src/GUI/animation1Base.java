package tic;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;

public  class animation1Base extends Pane {

    protected final ImageView imageView;
    protected final Image img;
            
    public animation1Base() {
        img =new Image("tic/1.gif");
        imageView = new ImageView(img);
       

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        imageView.setFitHeight(391.0);
        imageView.setFitWidth(600.0);
        imageView.setLayoutY(5.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
         
       getChildren().add(imageView);
       //imageView.setImage(img);
        imageView.setFitWidth(800);
        imageView.setFitHeight(600);
       // imageView.setScaleY(2);
        imageView.setY(100);
        AudioClip note =new AudioClip(this.getClass().getResource("1.mp3").toString());
        note.play();
        
        
        
        
        

    }

}

