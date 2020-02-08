/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import com.sun.org.glassfish.gmbal.GmbalMBean;
import Database.DB;
import Database.GameData;
import Database.PlayerData;
import GameLogic.BoardPostion;
import GameLogic.GameLogic;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Optional;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.Action;


/**
 *
 * @author Ali Gomaa
 */
public class TicTacToe extends Application {
    Game game;
    String startSymbol;
    Game pvpGame;    
    public DB db;
   public GameData gameData;
   public PlayerData player;
   boolean isNew;
   Scenepvp pvp;
   boolean isgame;
   
    @Override
    public void start(Stage stage) throws Exception {
        
        
        //Creating Scenes
        Scene1 scene = new Scene1();
        Scene sc1 = new Scene(scene);
        
        Scene2 scene2 = new Scene2();
        Scene sc2 = new Scene(scene2);
        
        SceneStart start = new SceneStart();
        Scene scStart = new Scene(start);
        
        ChooseScene choose = new ChooseScene();
        Scene scChoose = new Scene(choose);
        
         pvp = new Scenepvp();
        Scene pvpsc = new Scene(pvp);
        
        CreateGame CG = new CreateGame();
        Scene CreateGameSC = new Scene(CG);
        
        game = new Game();
        Scene gm = new Scene(game);
        
        Spinner spn = new Spinner();
        Scene spin = new Scene(spn);
        
        Records rec = new Records();
        Scene recScene = new Scene(rec);
        
        ////////////////////////
        
        //database
        db=new DB();
        //
       
        player=new PlayerData();

        
        //Adding Style Sheets
        sc1.getStylesheets().add(getClass().getResource("style.css").toString());
        sc2.getStylesheets().add(getClass().getResource("style.css").toString());
        scStart.getStylesheets().add(getClass().getResource("style.css").toString());
        scChoose.getStylesheets().add(getClass().getResource("style.css").toString());
        pvpsc.getStylesheets().add(getClass().getResource("style.css").toString());
        CG.getStylesheets().add(getClass().getResource("style.css").toString());
        game.getStylesheets().add(getClass().getResource("style.css").toString());
        rec.getStylesheets().add(getClass().getResource("style.css").toString());
        ///////////////////
        
        //Actions 
         scene.button.setOnAction((ActionEvent e) -> {
             
            String playername=scene.getTextField().getText();
            try {
                player=db.getPlayer(playername);
                if(player==null)
                {
                    isNew=true;
                    player=new PlayerData();
                    player.setName(playername);
                }
                else
                    isNew=false;
//            
            } catch (SQLException ex) {
                
                
                ex.printStackTrace();
            }
            finally
            {
               //close connection
//              
            }
                
            stage.setScene(sc2);
            stage.show();
        });
         
         /////scene 2 handeling where you can start or view records 
         scene2.btnStart.setOnAction(e -> {
            stage.setScene(scStart);
            stage.show();
        });
         
         
         //record list buttons handler
         class BtnHandler implements EventHandler<ActionEvent>
            {
//                
                int idx;
                BtnHandler(int idx) 
                {
//                    this.btn=btn;
                    this.idx=idx;  
                }

                @Override
                public void handle(ActionEvent event)
                {
                    System.out.println("handel fun");
                      try
                    {
                       rec.runTimer(game,idx);

//                       Scene scRec = new Scene(game);
                       stage.setScene(gm);
                       stage.show();

                    } catch (SQLException ex)
                    {
                        ex.printStackTrace();
                    }
         
//                    game.backbtn.setOnAction(ev ->
//                    {
//                        stage.setScene(sc2);
//                        stage.show(); 
//                    });
                }
            }
            
            
            
         
         
         
         scene2.btnViewRecords.setOnAction(e -> {
            try {
                rec.refreshGames();
                  for(int i=0;i<rec.buttons.size();i++)
                    {
                        Button btn=rec.buttons.elementAt(i);
                        btn.setOnAction(new BtnHandler(i));
                    }
            } catch (SQLException ex) {
               ex.printStackTrace();
            }
             stage.setScene(recScene);
             stage.show();
         });
         ///////////////
         
         
         start.btnPc.setOnAction(e -> {
            stage.setScene(scChoose);
            stage.show();
        });
         
          start.btnPlayer.setOnAction(e -> {
            stage.setScene(pvpsc);
            stage.show();
        });
          
          //change text of pvp button to create game then set scene to be the new pvp
           start.btnOnline.setOnAction(e -> {
            pvp.button.setText("Create Game");
            stage.setScene(CreateGameSC);
            stage.show();
        });
           
        //pvp section
            //at player vs player when on click start choose x or o
            pvp.button.setOnAction(e -> {
                 
                System.out.println("before on action"+isgame);
                isgame=true;
                pvpGame = new Game();
                Scene pvpGameScene = new Scene(pvpGame);
                System.out.println("pvp");
            try {
                new VsLocalPlayerBuilder();
            } catch (SQLException ex) {
               ex.printStackTrace();
            }
                System.out.println("after on action"+isgame);
                
                pvpGame.backbtn.setOnAction(event -> {
                    stage.setScene(scStart);
                    stage.show();
                    isgame=false;
                });
                
                stage.setScene(pvpGameScene);
                stage.show();
       
            });  
            
     
            ////////////
            
            //create game partition
            CG.button.setOnAction(e -> {
                
                Scenepvp online = new Scenepvp();
                Scene scOnline = new Scene(online);
                online.getStylesheets().add(getClass().getResource("style.css").toString());
                
                online.label.setLayoutX(170.0);
                online.label.setLayoutY(290.0);
                
                online.textField.setVisible(false);
                online.label.setFont(Font.loadFont(Scene1.class.getResource("Fonts/AGENTORANGE.TTF").toExternalForm(), 35));
                online.label.setTextFill(Color.web("#0076a3"));
                
                String ip = "192.168.0.1";

                
                online.label.setText("Your Ip Adress Is\n     " + ip);
                
                //baaaaaaaaaack
                online.backbtn.setOnAction(event -> {
                    stage.setScene(scStart);
                    stage.show();
                });
                
                // go to wait
                online.button.setOnAction(ev ->{
                    stage.setScene(spin);
                    stage.show();
                });
                
                // set scene
                stage.setScene(scOnline);
                stage.show();
            });
            
     
            
        //choose x or o scene buttons handeling
            choose.btnX.setOnAction(e -> {
                stage.setScene(gm);
                startSymbol="X";
                new GameBuilder();
                System.out.println(isNew);
            try {
                gameData=new GameData(db.getLastGameIndex(),startSymbol);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
                gameData.setVsPlayerName("computer");
                player.incVsCompCount();
                gameData.setStartedPlayerName(player.getName());
                
            });
       
            choose.btnO.setOnAction(e -> {
                stage.setScene(gm);
                startSymbol="O";
                new GameBuilder();
            try {
                gameData=new GameData(db.getLastGameIndex(),startSymbol);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
                 player.incVsCompCount();
                gameData.setVsPlayerName("computer");
                gameData.setStartedPlayerName(player.getName());
                

            });
            
            game.btnSave.setOnAction(e -> {
                
                    TextInputDialog dialog = new TextInputDialog("Enter Game Name Here");
                    dialog.setTitle("Save Game");
                    dialog.setHeaderText("Please Enter your Game Name:");
                    dialog.setContentText(null);
                    dialog.setGraphic(null);

                    // Traditional way to get the response value.
                    Optional<String> result = dialog.showAndWait();
                    if (result.isPresent()){
                        
                        System.out.println("Your game name: " + result.get());
                        gameData.setName(result.get());
                        if(gameData!=null)
                        try {
                                 db.PushGame(gameData);
                                 if(isNew)db.pushPlayer(player);
                                 else db.updatePlayerData(player);
                             } catch (SQLException ex) {
                                 ex.printStackTrace();
                             }
                        
                    }
                    
                    
            });
            
            
//         rec.button.setOnAction((ActionEvent myevent) -> {
//         Game game2 = new Game();
//            try {
//                rec.runTimer(game2,1);
//                
//                Scene scRec = new Scene(game2);
//                stage.setScene(scRec);
//                stage.show();
//                
//            } catch (SQLException ex) {
//                Logger.getLogger(TicTacToe.class.getName()).log(Level.SEVERE, null, ex);
//            }
//         
//            game.backbtn.setOnAction(ev -> {
//            
//                stage.setScene(sc2);
//                stage.show(); 
//            
//            });
//          
//                   
//         
//         game.ivSave.setImage(null);
//         game.btnSave.setCursor(Cursor.DEFAULT);
//         
//         
//         game.ivRecord.setImage(null);
//         game.btnRecord.setCursor(Cursor.DEFAULT);
//         
//         game.drawsiv.setImage(null);
//         game.scoreOiv.setImage(null);
//         game.scoreXiv.setImage(null);
//         
//         
//         game.labelD.setText("");
//         game.labelX.setText("");
//         game.labelO.setText("");
//         
//         
//                
//         });
         
         
         
         
         //handler
         
         
         
         
         
         
         
         
         
         
            
        //////////////////
            
            
         
         //baaack sction 
            //Scene2 back button action
            scene2.backbtn.setOnAction(e -> {  
                stage.setScene(sc1);
                stage.show(); 
            });
          
          //SceneStart back button action
            start.backbtn.setOnAction(e -> {  
                stage.setScene(sc2);
                stage.show(); 
            });
            
            //Scene2 back button action
            choose.backbtn.setOnAction(e -> {  
                stage.setScene(scStart);
                stage.show(); 
            });
            
             pvp.backbtn.setOnAction(e -> {  
                stage.setScene(scStart);
                stage.show(); 
            });
             
             CG.backbtn.setOnAction(e -> {  
                stage.setScene(scStart);
                stage.show(); 
            });
             
             game.backbtn.setOnAction(e -> {  
                
                //remove image after click back
                isNew=false;
                
                 Alert a = new Alert(AlertType.CONFIRMATION);
                
                 a.setContentText("Are You Sure You Want To Exit ?");
                 a.setGraphic(null);
                 a.setHeaderText(null);
                 
                 Optional <ButtonType> result = a.showAndWait();
                 if (result.get() == ButtonType.OK)
                 {    
                    stage.setScene(scStart);
                    stage.show();
                    
                    for (int i = 0; i < 3; i++)
                        for(int j = 0; j < 3 ; j++)
                        {
                            game.GUIBoard[i][j].setImage(null);
                        }
                     System.out.println("is game ="+isgame);
                    if(gameData!=null&&isgame)
                    try {
                            gameData.setIsRecorded(0);
                            if(gameData.getWinnerName()==null)gameData.setWinnerName("not compeleted");
                            db.PushGame(gameData);
                            if(isNew)db.pushPlayer(player);
                            else db.updatePlayerData(player);
                        } catch (SQLException ex)
                        {
                          ex.printStackTrace();
                        }
                    isgame=false;
                 }
                 
                 
                 
            });
             
             
    
             
             
        stage.setTitle("GAMSH Tic Tac Toe");
        stage.setScene(sc1);
        stage.show();
        stage.setResizable(false); 
    }



    
    public static void main(String[] args) {
        launch(args);
    }
    
    public void resetGUI()
    {
        for(int i=0; i<3; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                game.GUIBoard[i][j].imageProperty().set(null);
            }
        }
        
    }
    
    class GameBuilder
    {
        GameLogic gameLogic;

        public GameBuilder()
        {
            gameLogic=new GameLogic(startSymbol.charAt(0));
            
            if(startSymbol.charAt(0)=='O')game.imageViewTurn.setImage(game.imageO);
            else game.imageViewTurn.setImage(game.imageX);
            game.btn00.setOnAction(new EventHandel(0,0,game.view00));
            game.btn01.setOnAction(new EventHandel(0,1,game.view01));
            game.btn02.setOnAction(new EventHandel(0,2, game.view02));
            game.btn10.setOnAction(new EventHandel(1,0, game.view10));
            game.btn11.setOnAction(new EventHandel(1, 1, game. view11));
            game.btn12.setOnAction(new EventHandel(1, 2, game. view12));
            game.btn20.setOnAction(new EventHandel(2, 0,  game.view20));
            game.btn21.setOnAction(new EventHandel(2, 1, game. view21));
            game.btn22.setOnAction(new EventHandel(2, 2,  game.view22));
            
        }
        
       class EventHandel implements EventHandler<ActionEvent>
       {
            protected int x,y;

            ImageView imageView;
            public EventHandel(int x,int y,ImageView imageView)
            {
                this.x=x;
                this.y=y;
                this.imageView=imageView;
            }

            @Override
            public void handle(ActionEvent event)
            {

                if(!gameLogic.isFill()&&gameLogic.getPos(x, y).getValue()=='-')
                 {
                     if(!gameLogic.isWin())
                     {
                         System.out.println(gameLogic.getSymbol());
                         System.out.println("x="+x+" y="+y);
                         if(gameLogic.playMove(x, y))
                         {
                              gameData.getGameMoves().addMove(x, y);
     //                       button.setText(String.valueOf(gameLogic.getPos(x,y).getValue()));
                             if(gameLogic.getPos(x, y).getValue()=='X')
                                imageView.setImage(game.imageX);
                             else
                                 imageView.setImage(game.imageO);
                         }
                         if(gameLogic.isWin())
                         {
     //                         winLabel.setText("player win");
                             System.out.println(isNew);
                             highlightWin(Color.GREEN,gameLogic);
     //                         disableAllBtns();
                            gameData.setWinnerName(player.getName());
                            player.incScore();
                            
                            if(gameData.getStartSymbol().charAt(0)=='X')
                            {
                                Integer value= Integer.parseInt(game.labelX.getText())+1;
                                game.labelX.setText(value.toString());
                            }
                            else
                            {
                                Integer value= Integer.parseInt(game.labelO.getText())+1;
                                game.labelO.setText(value.toString());
                            }
                             
                             
                             
                             System.out.println("player win");
                             
                             
                            
                                 
                         }
                         else if(gameLogic.isFill())
                         {
                             System.out.println("draw");
                             gameData.setWinnerName("draw");
                             
                         }
                         else
                         {
                             
                              drawComputerMove();

                         
                         }
//                             imageView.setImage(game.imageO);
                     }
                     if(gameLogic.isWin())
                     {
//                         winLabel.setText("player win");
                            highlightWin(Color.GREEN,gameLogic);
//                         disableAllBtns();
                           
                     }
                 }
                
             
            
                if(gameLogic.isFill()&&!gameLogic.isWin())

                {
     //                winLabel.setText("draw");
                }
            }

            public void highlightWin(Color c,GameLogic gLogic)
            {
                game.winPostions =gLogic.getWinPostions();
                for (int i = 0; i < 3; i++)
                {

                 int x=game.winPostions[i].getX();
                 int y=game.winPostions[i].getY();
       //          game.GUIBoard[x][y].setBackground(new Background(new BackgroundFill(c, CornerRadii.EMPTY, Insets.EMPTY)));
                }
            }


        void drawComputerMove()
        {
           BoardPostion computerPos=gameLogic.computerMove();
           int x=computerPos.getX();
           int y=computerPos.getY();
           gameData.getGameMoves().addMove(x, y,computerPos.getValue());
           System.out.println("now comp turn"+x+" "+y+" "+gameLogic.getPos(x, y).getValue());
           if(gameLogic.getPos(x, y).getValue()=='X')
              game.GUIBoard[x][y].setImage(game.imageX);
            else
              game.GUIBoard[x][y].setImage(game.imageO);
           gameLogic.printBoard();
   //        game.GUIBoard[x][y].setText(String.valueOf(gameLogic.getPos(x, y).getValue()));
           if(gameLogic.isWin())
           {
               System.out.println("computer win");
   //            disableAllBtns();
               highlightWin(Color.RED,gameLogic);
               
               if(gameData.getStartSymbol().charAt(0)=='O')
                {
                    Integer value= Integer.parseInt(game.labelX.getText())+1;
                    game.labelX.setText(value.toString());
                }
                else
                {
                    Integer value= Integer.parseInt(game.labelO.getText())+1;
                    game.labelO.setText(value.toString());
                }
              
               
               
               
           }
        
        
        game.labelTurn.setText("X Turn");
     }
        
    }
    
   
    }
    
    
     class VsLocalPlayerBuilder 
    {
        GameLogic gameLogic;

        public VsLocalPlayerBuilder() throws SQLException
        {
            gameLogic=new GameLogic();
            gameData=new GameData(db.getLastGameIndex(), "X");
            gameData.setVsPlayerName(pvp.getTextField().getText());
            gameData.setStartSymbol("X");
            gameData.setStartedPlayerName(player.getName());
            player.incVsPlayerCount();
            
//            if(startSymbol.charAt(0)=='O')pvpGame.imageViewTurn.setImage(game.imageO);
//            else pvpGame.imageViewTurn.setImage(game.imageX);
            
            
            
            pvpGame.btn00.setOnAction(new EventHandleVslocal(0,0,pvpGame.view00));
            pvpGame.btn01.setOnAction(new EventHandleVslocal(0,1,pvpGame.view01));
             pvpGame.btn02.setOnAction(new EventHandleVslocal(0,2, pvpGame.view02));
             pvpGame.btn10.setOnAction(new EventHandleVslocal(1,0, pvpGame.view10));
             pvpGame.btn11.setOnAction(new EventHandleVslocal(1, 1, pvpGame. view11));
             pvpGame.btn12.setOnAction(new EventHandleVslocal(1, 2, pvpGame. view12));
             pvpGame.btn20.setOnAction(new EventHandleVslocal(2, 0,  pvpGame.view20));
             pvpGame.btn21.setOnAction(new EventHandleVslocal(2, 1, pvpGame. view21));
             pvpGame.btn22.setOnAction(new EventHandleVslocal(2, 2,  pvpGame.view22));
            
        }
        
        

        class EventHandleVslocal implements EventHandler<ActionEvent>
        {
            
            protected int x,y;

            ImageView imageView;
            public EventHandleVslocal(int x,int y,ImageView imageView)
            {
                this.x=x;
                this.y=y;
                this.imageView=imageView;
            }

             @Override
            public void handle(ActionEvent event)
            {

                if(!gameLogic.isFill()&&gameLogic.getPos(x, y).getValue()=='-')
                 {
                     if(!gameLogic.isWin())
                     {
                         System.out.println(gameLogic.getSymbol());
                         if(gameLogic.playMove(x, y))
                         {

     //                         button.setText(String.valueOf(gameLogic.getPos(x,y).getValue()));
                             gameData.getGameMoves().addMove(x, y,gameLogic.getPos(x, y).getValue());
                             if(gameLogic.getPos(x, y).getValue()=='X')
                             imageView.setImage(game.imageX);
                             else
                                 imageView.setImage(game.imageO);
                         }
                         if(gameLogic.isWin())
                         {
                             System.out.println("winner");
                             char c=gameData.getGameMoves().getMoves().lastElement().getValue();
                             System.out.println("last ele=" +gameData.getGameMoves().getMoves().lastElement().getX());
                             System.out.println("c===="+c);
                             if(c=='X')
                                  gameData.setWinnerName(player.getName());
                             else 
                                 gameData.setWinnerName(gameData.getVsPlayerName());
//                             highlightWin(Color.GREEN,gameLogic);
     //                         disableAllBtns();
     
                        if(gameData!=null)
                        try {
                                 db.PushGame(gameData);
                                 if(isNew)db.pushPlayer(player);
                                 else db.updatePlayerData(player);
                             } catch (SQLException ex) {
                                 ex.printStackTrace();
                             }
     
     
                            
                         }
                          
                     }
                 }
               
            }
            
        }
        
    }

//    public GameData getGameData() {
//        return gameData;
//    }
//
//    public PlayerData getPlayer() {
//        return player;
//    }
//
//    public DB getDb() {
//        return db;
//    }
    
    
     
     
    
    
}
    
//    Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(5), new EventHandler<ActionEvent>() {
//
//    @Override
//    public void handle(ActionEvent event) {
//        System.out.println("this is called every 5 seconds on UI thread");
//    }
//}));
//fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
//fiveSecondsWonder.play();
     
    

