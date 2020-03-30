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
    protected final ImageView backbtnImage;
    protected final Button backbtn;
    
    
    Vector<Button> buttons=new Vector<>() ;
    
    DB db;
    public Vector<GameData> games;
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
        backbtn = new Button();
        backbtnImage = new ImageView();
        
//        db=new DB();
////        games=db.getAllRecords();
//        System.out.println(games.size());
//        int size=db.getAllRecords().size();
//        for(int i=0;i<size;i++)
//        {
//            buttons.add(new Button(games.elementAt(i).getName()));
//        }
//        pane.setMinHeight(pane.getHeight()+650);
//        boolean color=true;
//        float y=115.0f;
//        for(Button btn : buttons )
//        {
//            pane.setLeftAnchor(btn, 256.0);
//            pane.setRightAnchor(btn, 268.0);
//            btn.setLayoutX(256.0);
//            btn.setLayoutY(y+=65);
//            btn.setMnemonicParsing(false);
//            btn.setPrefHeight(44.0);
//            btn.setPrefWidth(266.0);
//            if(color)
//            {
//                 btn.getStyleClass().add("button2");
//                 color=false;
//            }
//            else
//                
//            {
//                btn.getStyleClass().add("button1");
//                color=true;
//
//            }
//            
//            pane.getChildren().add(btn);
//               
//            
//        }

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



        imageView0.setFitHeight(154.0);
        imageView0.setFitWidth(209.0);
        imageView0.setLayoutX(567.0);
        imageView0.setLayoutY(14.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("images/logo.png").toExternalForm()));
        setContent(pane);
        
        
        backbtn.setLayoutX(48.0);
        backbtn.setLayoutY(100.0);
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
        
        

        pane.getChildren().add(imageView);
        pane.getChildren().add(imageView0);
        pane.getChildren().add(backbtn);
        



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
        GameLogic gameLogic;
        GameData game;
        
        public ReplayGame() throws SQLException
        {
            games = db.getAllRecords();
            timer=new RecordTimer();
            counter=0;
             game= games.elementAt(idx);
            gameLogic = new GameLogic(game.getStartSymbol().charAt(0));
            timer.start();
        }
        
        
       public void startReplay()
        {
            
//            GameData game= games.elementAt(idx);
            System.out.println("start= "+game.getStartSymbol().charAt(0));
//            gameLogic = new GameLogic(game.getStartSymbol().charAt(0));
            
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
    
    public void refreshGames() throws SQLException
    {
        //remove all prevoius btns
        for(Button btn : buttons)
        {
            pane.getChildren().remove(btn);
            
        }
        //remove btns form th vector
        buttons.removeAllElements(); 
        db=new DB();
        games=db.getAllRecords();
//        games=db.getAllRecords();
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
    }
    
    
    
    
}

