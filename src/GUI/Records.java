package GUI;

import Database.DB;
import Database.GameData;
import GameLogic.BoardPostion;
import GameLogic.GameLogic;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.AnchorPane;
import sun.plugin.javascript.navig.Anchor;

public  class Records extends ScrollPane {

    protected final AnchorPane pane;
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
    Vector<Button> buttons=new Vector<>() ;
    
    DB db;
    Vector<GameData> games;
    Game gm;
    Scene ss;
    public ReplayGame rg;
    int idx;

    public Records() throws SQLException {
        pane = new AnchorPane();
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
        
        db=new DB();
        games=db.getAllRecords();
        System.out.println(games.size());
        int size=db.getAllRecords().size();
        for(int i=0;i<size;i++)
        {
            buttons.add(new Button(games.elementAt(i).getName()));
        }
        pane.setMinHeight(pane.getHeight()+650);
        boolean color=true;
        float y=115.0f;
        for(Button btn : buttons )
        {
            pane.setLeftAnchor(btn, 256.0);
            pane.setRightAnchor(btn, 268.0);
            btn.setLayoutX(256.0);
            btn.setLayoutY(y+=65);
            btn.setMnemonicParsing(false);
            btn.setPrefHeight(44.0);
            btn.setPrefWidth(266.0);
            if(color)
            {
                 btn.getStyleClass().add("button2");
                 color=false;
            }
            else
                
            {
                btn.getStyleClass().add("button1");
                color=true;

            }
            
            pane.getChildren().add(btn);
               
            
        }

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(800.0);

        pane.setPrefHeight(590.0);
        pane.setPrefWidth(790.0);
        pane.setStyle("-fx-background-color: white;");

        imageView.setFitHeight(77.0);
        imageView.setFitWidth(422.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("images/Rec.png").toExternalForm()));

//        Pane.setLeftAnchor(button, 256.0);
//        Pane.setRightAnchor(button, 268.0);
//        button.setLayoutX(256.0);
//        button.setLayoutY(115.0);
//        button.setMnemonicParsing(false);
//        button.setPrefHeight(44.0);
//        button.setPrefWidth(266.0);
//        button.getStyleClass().add("button2");
//        button.setText("Game Name 1");

//        Pane.setLeftAnchor(button0, 256.0);
//        Pane.setRightAnchor(button0, 268.0);
//        button0.setLayoutX(256.0);
//        button0.setLayoutY(179.0);
//        button0.setMnemonicParsing(false);
//        button0.setPrefHeight(44.0);
//        button0.setPrefWidth(266.0);
//        button0.getStyleClass().add("button1");
//        button0.setText("Game Name 2");

//        Pane.setLeftAnchor(button1, 256.0);
//        Pane.setRightAnchor(button1, 268.0);
//        button1.setLayoutX(256.0);
//        button1.setLayoutY(243.0);
//        button1.setMnemonicParsing(false);
//        button1.setPrefHeight(44.0);
//        button1.setPrefWidth(266.0);
//        button1.getStyleClass().add("button2");
//        button1.setText("Game Name 3");

//        Pane.setLeftAnchor(button2, 256.0);
//        Pane.setRightAnchor(button2, 268.0);
//        button2.setLayoutX(256.0);
//        button2.setLayoutY(307.0);
//        button2.setMnemonicParsing(false);
//        button2.setPrefHeight(44.0);
//        button2.setPrefWidth(266.0);
//        button2.getStyleClass().add("button1");
//        button2.setText("Game Name 4");

//        Pane.setLeftAnchor(button3, 256.0);
//        Pane.setRightAnchor(button3, 268.0);
//        button3.setLayoutX(256.0);
//        button3.setLayoutY(371.0);
//        button3.setMnemonicParsing(false);
//        button3.setPrefHeight(44.0);
//        button3.setPrefWidth(266.0);
//        button3.getStyleClass().add("button2");
//        button3.setText("Game Name 5");

//        Pane.setLeftAnchor(button4, 256.0);
//        Pane.setRightAnchor(button4, 268.0);
//        button4.setLayoutX(256.0);
//        button4.setLayoutY(435.0);
//        button4.setMnemonicParsing(false);
//        button4.setPrefHeight(44.0);
//        button4.setPrefWidth(266.0);
//        button4.getStyleClass().add("button1");
//        button4.setText("Game Name 6");

//        Pane.setLeftAnchor(button5, 256.0);
//        Pane.setRightAnchor(button5, 268.0);
//        button5.setLayoutX(256.0);
//        button5.setLayoutY(499.0);
//        button5.setMnemonicParsing(false);
//        button5.setPrefHeight(44.0);
//        button5.setPrefWidth(266.0);
//        button5.getStyleClass().add("button2");
//        button5.setText("Game Name 7");

//        Pane.setLeftAnchor(button6, 256.0);
//        Pane.setRightAnchor(button6, 268.0);
//        button6.setLayoutX(256.0);
//        button6.setLayoutY(559.0);
//        button6.setMnemonicParsing(false);
//        button6.setPrefHeight(44.0);
//        button6.setPrefWidth(266.0);
//        button6.getStyleClass().add("button1");
//        button6.setText("Game Name 8");

//        Pane.setLeftAnchor(button7, 256.0);
//        Pane.setRightAnchor(button7, 268.0);
//        button7.setLayoutX(256.0);
//        button7.setLayoutY(620.0);
//        button7.setMnemonicParsing(false);
//        button7.setPrefHeight(44.0);
//        button7.setPrefWidth(266.0);
//        button7.getStyleClass().add("button2");
//        button7.setText("Game Name 8");

        imageView0.setFitHeight(154.0);
        imageView0.setFitWidth(209.0);
        imageView0.setLayoutX(567.0);
        imageView0.setLayoutY(14.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("images/logo.png").toExternalForm()));
        setContent(pane);

        pane.getChildren().add(imageView);
//        pane.getChildren().add(button);
//        pane.getChildren().add(button0);
//        pane.getChildren().add(button1);
//        pane.getChildren().add(button2);
//        pane.getChildren().add(button3);
//        pane.getChildren().add(button4);
//        pane.getChildren().add(button5);
//        pane.getChildren().add(button6);
//        pane.getChildren().add(button7);
        pane.getChildren().add(imageView0);
        
        button.setOnAction(e->{


         
         
        
        
        //back button
        
        
//         gm.backbtn.setOnAction(event -> {  
//                
//                //remove image after click back
//                    
//                    scstr = new SceneStart();
//                    scstr.getStylesheets().add(getClass().getResource("style.css").toString());
//                    Scene sc = new Scene(scstr);
//                
//                    primaryStage.setScene(sc);
//                    replay.timer.stop();
//        
//        });        
        
        
        });
        
        
         //back button
         


    }
    
    public void runTimer(Game game, int num) throws SQLException {
                gm=game;
                idx=num;
                

        rg = this.new ReplayGame();
    }
    
    public class ReplayGame
    {
        int counter;
        RecordTimer timer;
        GameLogic gameLogic= new GameLogic();
        
        public ReplayGame() throws SQLException
        {
            games = db.getAllRecords();
            timer=new RecordTimer();
            counter=0;
            timer.start();
        }
        
        
       public void startReplay()
        {
            System.out.println("here");
            GameData game= games.elementAt(idx);
            
            for(BoardPostion pos : game.getGameMoves().getMoves())
            {
                System.out.println(pos.getX() + " "+pos.getY());
                
            }
            
            int x = game.getGameMoves().getMoves().elementAt(counter).getX();
            int y = game.getGameMoves().getMoves().elementAt(counter).getY();
            System.out.println("x "+x+" y "+y);
            gameLogic.playMove(x, y);
            drawPlay(x, y);
            gameLogic.printBoard();
            
            counter++;
            if(counter>=game.getGameMoves().getMoves().size())
            {
                timer.stop();
            }
        }
       
       public void drawPlay(int x,int y)
       {
           System.out.println(gameLogic.getPos(x, y).getValue());
           if(gameLogic.getPos(x, y).getValue()=='X')
            gm.GUIBoard[x][y].setImage(gm.imageX);
           else
               gm.GUIBoard[x][y].setImage(gm.imageO);
       }
    
    
    
    
        class RecordTimer extends AnimationTimer
        {
            @Override
            public void handle(long now)
            {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                startReplay();
                
            }
        }
    }
    
    
    
    
}

