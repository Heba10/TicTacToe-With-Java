/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Ali Gomaa
 */
public class TicTacToe extends Application {
    
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
        
        Game game = new Game();
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
            });
       
            choose.btnO.setOnAction(e -> {
                stage.setScene(gm);
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
    
}
