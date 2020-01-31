package tictactoe;

import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Game extends Pane {

    protected final ImageView imageView;
    protected final Button btn20;
    protected final ImageView view20;
    protected final Button btn21;
    protected final ImageView view21;
    protected final Button btn22;
    protected final ImageView view22;
    protected final Button btn10;
    protected final ImageView view10;
    protected final Button btn11;
    protected final ImageView view11;
    protected final Button btn12;
    protected final ImageView view12;
    protected final Button btn00;
    protected final ImageView view00;
    protected final Button btn01;
    protected final ImageView view01;
    protected final Button btn02;
    protected final ImageView view02;
    protected final ImageView scoreXiv;
    protected final ImageView scoreOiv;
    protected final ImageView drawsiv;
    protected final Button btnRecord;
    protected final ImageView ivRecord;
    protected final Button btnSave;
    protected final ImageView ivSave;
    protected final Button backbtn;
    protected final ImageView backbtnImage;
    protected final Button[][] arrBtn;
    protected final ImageView imageX;
    
    protected  int count = 0;
    protected  void checkAndAdd(){
        count++;
        
        
        if(count == 3)
        {
            System.out.println("Hellooo");
            count = 0;
        }
        
    
    };
    public Game() {
       
        
        imageView = new ImageView();
        btn20 = new Button();
        view20 = new ImageView();
        btn21 = new Button();
        view21 = new ImageView();
        btn22 = new Button();
        view22 = new ImageView();
        btn10 = new Button();
        view10 = new ImageView();
        btn11 = new Button();
        view11 = new ImageView();
        btn12 = new Button();
        view12 = new ImageView();
        btn00 = new Button();
        view00 = new ImageView();
        btn01 = new Button();
        view01 = new ImageView();
        btn02 = new Button();
        view02 = new ImageView();
        scoreXiv = new ImageView();
        scoreOiv = new ImageView();
        drawsiv = new ImageView();
        btnRecord = new Button();
        ivRecord = new ImageView();
        backbtn = new Button();
        backbtnImage = new ImageView();
        btnSave = new Button();
        ivSave = new ImageView();
        imageX = new ImageView();
        
       
    //Array Of Buttons        
        arrBtn = new Button[3][3];
        arrBtn[0][0] = btn00;
        arrBtn[0][1] = btn01;
        arrBtn[0][2] = btn02;
        arrBtn[1][0] = btn10;
        arrBtn[1][1] = btn11;
        arrBtn[1][2] = btn12;
        arrBtn[2][0] = btn20;
        arrBtn[2][1] = btn21;
        arrBtn[2][2] = btn22;
        /////////
        imageX.setImage(new Image(getClass().getResource("images/x.png").toExternalForm()));
        

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(800.0);
        setStyle("-fx-background-color: white;");

        imageView.setFitHeight(569.0);
        imageView.setFitWidth(569.0);
        imageView.setLayoutX(205.0);
        imageView.setLayoutY(26.0);
        imageView.setPickOnBounds(true);
        imageView.setImage(new Image(getClass().getResource("images/borders.png").toExternalForm()));

        btn20.setLayoutX(206.0);
        btn20.setLayoutY(420.0);
        btn20.setMnemonicParsing(false);
        btn20.setPrefHeight(180.0);
        btn20.setPrefWidth(180.0);
        btn20.setStyle("-fx-background-color: transparent;");

        view20.setFitHeight(160.0);
        view20.setFitWidth(160.0);
        view20.setPickOnBounds(true);
        view20.setPreserveRatio(true);
        btn20.setGraphic(view20);

        btn21.setLayoutX(396.0);
        btn21.setLayoutY(420.0);
        btn21.setMnemonicParsing(false);
        btn21.setPrefHeight(180.0);
        btn21.setPrefWidth(196.0);
        btn21.setStyle("-fx-background-color: transparent;");

        view21.setFitHeight(160.0);
        view21.setFitWidth(160.0);
        view21.setPickOnBounds(true);
        view21.setPreserveRatio(true);
        btn21.setGraphic(view21);

        btn22.setLayoutX(596.0);
        btn22.setLayoutY(420.0);
        btn22.setMnemonicParsing(false);
        btn22.setPrefHeight(180.0);
        btn22.setPrefWidth(180.0);
        btn22.setStyle("-fx-background-color: transparent;");

        view22.setFitHeight(160.0);
        view22.setFitWidth(160.0);
        view22.setPickOnBounds(true);
        view22.setPreserveRatio(true);
        btn22.setGraphic(view22);

        btn10.setLayoutX(206.0);
        btn10.setLayoutY(220.0);
        btn10.setMnemonicParsing(false);
        btn10.setPrefHeight(190.0);
        btn10.setPrefWidth(180.0);
        btn10.setStyle("-fx-background-color: transparent;");

        view10.setFitHeight(160.0);
        view10.setFitWidth(160.0);
        view10.setPickOnBounds(true);
        view10.setPreserveRatio(true);
        btn10.setGraphic(view10);

        btn11.setLayoutX(396.0);
        btn11.setLayoutY(220.0);
        btn11.setMnemonicParsing(false);
        btn11.setPrefHeight(190.0);
        btn11.setPrefWidth(196.0);
        btn11.setStyle("-fx-background-color: transparent;");

        view11.setFitHeight(160.0);
        view11.setFitWidth(160.0);
        view11.setPickOnBounds(true);
        view11.setPreserveRatio(true);
        btn11.setGraphic(view11);

        btn12.setLayoutX(596.0);
        btn12.setLayoutY(220.0);
        btn12.setMnemonicParsing(false);
        btn12.setPrefHeight(190.0);
        btn12.setPrefWidth(171.0);
        btn12.setStyle("-fx-background-color: transparent;");

        view12.setFitHeight(160.0);
        view12.setFitWidth(160.0);
        view12.setPickOnBounds(true);
        view12.setPreserveRatio(true);
        btn12.setGraphic(view12);

        btn00.setLayoutX(206.0);
        btn00.setLayoutY(30.0);
        btn00.setMnemonicParsing(false);
        btn00.setPrefHeight(180.0);
        btn00.setPrefWidth(180.0);
        btn00.setStyle("-fx-background-color: transparent;");

        view00.setFitHeight(160.0);
        view00.setFitWidth(160.0);
        view00.setPickOnBounds(true);
        view00.setPreserveRatio(true);
        btn00.setGraphic(view00);

        btn01.setLayoutX(402.0);
        btn01.setLayoutY(30.0);
        btn01.setMnemonicParsing(false);
        btn01.setPrefHeight(180.0);
        btn01.setPrefWidth(183.0);
        btn01.setStyle("-fx-background-color: transparent;");

        view01.setFitHeight(160.0);
        view01.setFitWidth(160.0);
        view01.setPickOnBounds(true);
        view01.setPreserveRatio(true);
        btn01.setGraphic(view01);

        btn02.setLayoutX(596.0);
        btn02.setLayoutY(30.0);
        btn02.setMnemonicParsing(false);
        btn02.setPrefHeight(180.0);
        btn02.setPrefWidth(180.0);
        btn02.setStyle("-fx-background-color: transparent;");

        view02.setFitHeight(160.0);
        view02.setFitWidth(160.0);
        view02.setPickOnBounds(true);
        view02.setPreserveRatio(true);
        btn02.setGraphic(view02);

        scoreXiv.setFitHeight(39.0);
        scoreXiv.setFitWidth(107.0);
        scoreXiv.setLayoutX(41.0);
        scoreXiv.setLayoutY(120.0);
        scoreXiv.setPickOnBounds(true);
        scoreXiv.setPreserveRatio(true);
        scoreXiv.setImage(new Image(getClass().getResource("images/scoreX.png").toExternalForm()));

        scoreOiv.setFitHeight(39.0);
        scoreOiv.setFitWidth(107.0);
        scoreOiv.setLayoutX(41.0);
        scoreOiv.setLayoutY(237.0);
        scoreOiv.setPickOnBounds(true);
        scoreOiv.setPreserveRatio(true);
        scoreOiv.setImage(new Image(getClass().getResource("images/scoreO.png").toExternalForm()));

        drawsiv.setFitHeight(33.0);
        drawsiv.setFitWidth(72.0);
        drawsiv.setLayoutX(48.0);
        drawsiv.setLayoutY(354.0);
        drawsiv.setPickOnBounds(true);
        drawsiv.setPreserveRatio(true);
        drawsiv.setImage(new Image(getClass().getResource("images/draw.png").toExternalForm()));

        btnRecord.setLayoutX(50.0);
        btnRecord.setLayoutY(450.0);
        btnRecord.setMnemonicParsing(false);
        btnRecord.setPrefHeight(49.0);
        btnRecord.setPrefWidth(44.0);
        btnRecord.setStyle("-fx-background-color: white;");
        btnRecord.setGraphic(ivRecord);
        btnRecord.setCursor(Cursor.HAND);

        ivRecord.setFitHeight(73.0);
        ivRecord.setFitWidth(75.0);
        ivRecord.setLayoutX(45.0);
        ivRecord.setLayoutY(491.0);
        ivRecord.setPickOnBounds(true);
        ivRecord.setPreserveRatio(true);
        ivRecord.setImage(new Image(getClass().getResource("images/record.png").toExternalForm()));
        
        
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
        
        
        btnSave.setLayoutX(55.0);
        btnSave.setLayoutY(520.0);
        btnSave.setMnemonicParsing(false);
        btnSave.setPrefHeight(50.0);
        btnSave.setPrefWidth(50.0);
        btnSave.setStyle("-fx-background-color: white;");
        btnSave.setCursor(Cursor.HAND);

        ivSave.setFitHeight(50.0);
        ivSave.setFitWidth(50.0);
        ivSave.setPickOnBounds(true);
        ivSave.setPreserveRatio(true);
        ivSave.setImage(new Image(getClass().getResource("images/save.png").toExternalForm()));
        btnSave.setGraphic(ivSave);
        
        
        //looooooggggggiiiic Hereeeeeeeee
        
        //set X and O
            arrBtn[0][0].setOnAction(e ->{
                view00.setImage(new Image(getClass().getResource("images/x.png").toExternalForm()));
                checkAndAdd();
                
            });
            
            
            arrBtn[0][1].setOnAction(e ->{
                view01.setImage(new Image(getClass().getResource("images/x.png").toExternalForm()));
                checkAndAdd();
            });
            
            arrBtn[0][2].setOnAction(e ->{
                view02.setImage(new Image(getClass().getResource("images/x.png").toExternalForm()));
                checkAndAdd();
            });
            
          
         
            
            
        // handeling alert on clicking save
        
            btnSave.setOnAction(e -> {
                
                 Alert a = new Alert(AlertType.CONFIRMATION); 
                 a.setContentText("Do You Want To Save ?"); 
                 a.setGraphic(null);
                 a.setHeaderText(null);
                 a.setResizable(false);
                 a.setTitle("Save");
                 a.show();

            });
            
             
            
            
            
        
        

        getChildren().add(imageView);
        getChildren().add(btn20);
        getChildren().add(btn21);
        getChildren().add(btn22);
        getChildren().add(btn10);
        getChildren().add(btn11);
        getChildren().add(btn12);
        getChildren().add(btn00);
        getChildren().add(btn01);
        getChildren().add(btn02);
        getChildren().add(scoreXiv);
        getChildren().add(scoreOiv);
        getChildren().add(drawsiv);
        getChildren().add(btnRecord);
        getChildren().add(ivSave);
        getChildren().add(btnSave);
        getChildren().add(ivRecord);
        getChildren().add(backbtn);

    }
}
