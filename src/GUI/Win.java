package GUI;

import GameLogic.GameLogic;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Win extends Pane {
    
    ImageView imageView;
    Button playBtn;
    Button exitBtn;
    Stage window = new Stage();
    
    public Win(Game currentGame , Stage myStage ,GameLogic gameLogic , ChooseScene choose)
    {
        Pane Layout = new Pane();
        Scene win = new Scene(Layout);

        win.getStylesheets().add(getClass().getResource("style.css").toString());


        imageView = new ImageView();
        playBtn = new Button();
        exitBtn = new Button(); 

        imageView.setFitHeight(384.0);
        imageView.setFitWidth(537.0);
        imageView.setLayoutX(-10.0);
        imageView.setLayoutY(-29.0);
        imageView.setImage(new Image(getClass().getResource("images/winner.gif").toExternalForm()));

        playBtn.setLayoutX(104.0);
        playBtn.setLayoutY(277.0);
        playBtn.setMnemonicParsing(false);
        playBtn.setPrefHeight(39.0);
        playBtn.setPrefWidth(110.0);
        playBtn.getStyleClass().add("button1");
        playBtn.setText("Play Again");
        playBtn.setFont(Font.loadFont(Scene1.class.getResource("Fonts/z-arista.alternate.ttf").toExternalForm(), 15));

        playBtn.setOnAction( ev -> {



           
//            Game newGame =currentGame;
//            Scene nGScene = new Scene(newGame);
            
            myStage.setScene(choose.getScene());

              for (int i = 0; i < 3; i++)
                for(int j = 0; j < 3 ; j++)
                {
                    currentGame.GUIBoard[i][j].setImage(null);
                }
              gameLogic.resetBoard();
              
            
            window.close();
            
        });
        
        
        
        exitBtn.setLayoutX(300.0);
        exitBtn.setLayoutY(277.0);
        exitBtn.setMnemonicParsing(false);
        exitBtn.setPrefHeight(39.0);
        exitBtn.setPrefWidth(110.0);
        exitBtn.getStyleClass().add("button2");
        exitBtn.setText("Exit");
        exitBtn.setFont(Font.loadFont(Scene1.class.getResource("Fonts/z-arista.alternate.ttf").toExternalForm(), 15));

        exitBtn.setOnAction( e -> {
        System.out.println("exiit");
        window.close();                               
        });
        
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Win");


        Layout.setMaxHeight(USE_PREF_SIZE);
        Layout.setMaxWidth(USE_PREF_SIZE);
        Layout.setMinHeight(USE_PREF_SIZE);
        Layout.setMinWidth(USE_PREF_SIZE);
        Layout.setPrefHeight(350.0);
        Layout.setPrefWidth(500.0);

        Layout.getChildren().add(imageView);
        Layout.getChildren().add(playBtn);
        Layout.getChildren().add(exitBtn);

        window.setScene(win);
        window.showAndWait();
        
        
    }
    
   
}
