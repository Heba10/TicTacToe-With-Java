/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import com.sun.org.glassfish.gmbal.GmbalMBean;
import GameLogic.BoardPostion;
import GameLogic.GameLogic;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Ali Gomaa
 */
public class TicTacToe extends Application {
    Game game;
    char startSymbol;
    
    
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
        
        Scenepvp pvp = new Scenepvp();
        Scene pvpsc = new Scene(pvp);
        
        CreateGame CG = new CreateGame();
        Scene CreateGameSC = new Scene(CG);
        
        game = new Game();
        Scene gm = new Scene(game);
        
        Records records = new Records();
        Scene rec = new Scene(records);
        ////////////////////////

        
        //Adding Style Sheets
        sc1.getStylesheets().add(getClass().getResource("style.css").toString());
        sc2.getStylesheets().add(getClass().getResource("style.css").toString());
        scStart.getStylesheets().add(getClass().getResource("style.css").toString());
        scChoose.getStylesheets().add(getClass().getResource("style.css").toString());
        pvpsc.getStylesheets().add(getClass().getResource("style.css").toString());
        CG.getStylesheets().add(getClass().getResource("style.css").toString());
        game.getStylesheets().add(getClass().getResource("style.css").toString());
        records.getStylesheets().add(getClass().getResource("style.css").toString());
        ///////////////////
        
        //Actions 
         scene.button.setOnAction((ActionEvent e) -> {
            
            stage.setScene(sc2);
            stage.show();
        });
         
         /////scene 2 handeling where you can start or view records 
         scene2.btnStart.setOnAction(e -> {
            stage.setScene(scStart);
            stage.show();
        });
         
         scene2.btnViewRecords.setOnAction(e -> {
             stage.setScene(rec);
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
                Game pvpGame = new Game();
                Scene pvpGameScene = new Scene(pvpGame);
                
                
                pvpGame.backbtn.setOnAction(event -> {
                    stage.setScene(scStart);
                    stage.show();
                });
                
                stage.setScene(pvpGameScene);
                stage.show();
       
            });  
            
     
            ////////////
            
            //create game partition
            CG.button.setOnAction(e -> {
                stage.setScene(pvpsc);
                stage.show();
            });
            
     
            
        //choose x or o scene buttons handeling
            choose.btnX.setOnAction(e -> {
                stage.setScene(gm);
                startSymbol='X';
                new GameBuilder();
            });
       
            choose.btnO.setOnAction(e -> {
                stage.setScene(gm);
                startSymbol='O';
                new GameBuilder();
            });
            
        ///////////////////
            
            
            
         
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
                stage.setScene(scStart);
                stage.show(); 
            });
             
             
             
             
             
             
             
        
     
        stage.setTitle("GAMSH Tic Tac Toe");
        stage.setScene(sc1);
        stage.show();
        stage.setResizable(false); 
    }



    
    public static void main(String[] args) {
        launch(args);
    }
    
    
    class GameBuilder
    {
        GameLogic gameLogic;

        public GameBuilder()
        {
            gameLogic=new GameLogic(startSymbol);
            if(startSymbol=='o')game.imageViewTurn.setImage(game.imageO);
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
         int x,y;
         
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
                     if(gameLogic.playMove(x, y))
                     {
                         
//                         button.setText(String.valueOf(gameLogic.getPos(x,y).getValue()));
                         if(gameLogic.getPos(x, y).getValue()=='X')
                         imageView.setImage(game.imageX);
                         else
                             imageView.setImage(game.imageO);
                     }
                     if(gameLogic.isWin())
                     {
//                         winLabel.setText("player win");
                         highlightWin(Color.GREEN,gameLogic);
//                         disableAllBtns();
                     }
                     else
                     {
                          drawComputerMove();
                          
                     }  
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
        System.out.println("now comp turn"+x+" "+y+" "+gameLogic.getPos(x, y).getValue());
        if(gameLogic.getPos(x, y).getValue()=='X')
           game.GUIBoard[x][y].setImage(game.imageX);
         else
           game.GUIBoard[x][y].setImage(game.imageO);
        gameLogic.printBoard();
//        game.GUIBoard[x][y].setText(String.valueOf(gameLogic.getPos(x, y).getValue()));
        if(gameLogic.isWin())
        {
//            winLabel.setText("computer win");
//            disableAllBtns();
            highlightWin(Color.RED,gameLogic);
        }
     }
        
    }
    }
    
    class VsComputer extends GameBuilder
    {
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
    
    
    
    
    
    
    
    
}