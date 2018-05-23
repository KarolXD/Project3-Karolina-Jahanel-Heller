/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domain.Cronometro;
import domain.Thread1;
import domain.UnsynchronizedBuffer;
import static gui.ControlPanel.global;
import java.awt.Graphics;
//import java.awt.Image;
import javafx.scene.image.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.FileNotFoundException;
import java.nio.BufferOverflowException;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.image.Image;

/**
 *
 * @author karol
 */
public class StartGame extends Application implements Runnable {

    private ControlPanel cPane;
    private Pane pane;
    private Canvas canvas;
    private Scene scene;
    private GraphicsContext gc;
    private Image backgroundEasy,backgroundMedium,backgroundDifficult;
    private Button star;
    private Thread thread;
    Thread1 t1;
    private Timeline timeline;
    private final Label timerLabel = new Label();
    private final DoubleProperty timeSeconds = new SimpleDoubleProperty();
    private Duration time = Duration.ZERO;

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Start game ");
        initComponents(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void run() {
        long start;
        long elapsed;
        long wait;
        int fps = 30;
        long time = 1000 / fps;

        while (true) {
            try {
                start = System.nanoTime();
                elapsed = System.nanoTime() - start;
                wait = time - elapsed / 1000000;
                Thread.sleep(wait);
                GraphicsContext gc = this.canvas.getGraphicsContext2D();
                loadingImage(gc);
            } catch (InterruptedException ex) {
            }
        }

    }

    public void initComponents(Stage primaryStage) throws Exception {
        
        try{
        pane = new Pane();//Instanciamos el JFRAME

       
        backgroundEasy = new Image("/assets/easy.jpeg/");
        backgroundMedium = new Image("/assets/medio.png/");
        backgroundDifficult = new Image("/assets/dificult1.jpeg/");

         javafx.scene.image.Image clockImage = new javafx.scene.image.Image("/assets/clock.png");
        ImageView clockIV = new ImageView(clockImage);

        
        timerLabel.textProperty().bind(timeSeconds.asString());
        timerLabel.setTextFill(Color.WHITE);
        timerLabel.setStyle("-fx-font-size: 5em;");

        Button button = new Button("Start", clockIV);

        button.relocate(180, 730);
        button.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                if (timeline != null) {

                } else {
                    timeline = new Timeline(
                            new KeyFrame(Duration.millis(200),//100
                                    new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent t) {
                                    Duration duration = ((KeyFrame) t.getSource()).getTime();
                                    time = time.add(duration);

                                    timeSeconds.set(time.toSeconds());

                                }
                            })
                    );
                    timeline.setCycleCount(Timeline.INDEFINITE);//INDEFINITE
                    timeline.play();
                }
            }
        });

        VBox vb = new VBox(10);

        vb.getChildren().addAll(timerLabel);//, splitTimerLabel);
        vb.relocate(40, 700);

        pane.getChildren().addAll(vb);//VB
        pane.getChildren().addAll(button, clockIV);

        ///////////////////////////////// 
        pane.setStyle("-fx-background-color:  #C0392B ");
        pane.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY)));

        scene = new Scene(pane, 710, 800); //INSTANCIAMOS LA SCENA, CON TAMAÑO Y COLOR DE FONDO

        canvas = new Canvas(700, 700);//instanciamos el JPanel
        canvas.relocate(0, 0);//le ponemos una ubicacion dentro del JFRAME

        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BURLYWOOD);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
       // loadingImage(gc);

        pane.getChildren().add(canvas);
      //  UnsynchronizedBuffer sharedLocation = new UnsynchronizedBuffer();
       //t1= new Thread1(-50,100,1);//, 0, 0);
      //  t1.start();
        
         this.thread = new Thread(this);
         this.thread.start();
        
        }
        catch (BufferOverflowException ex){}
         //catch (FileNotFoundException ex){}
    }
//  
//    public static void main (String arv[]){
//        launch(arv);}

    public void loadingImage(GraphicsContext gc) {
        if (global.equals("Easy")) {

            gc.drawImage(backgroundEasy, 0, 0);
          //  gc.drawImage(this.t1.getImage(), this.t1.getX(), this.t1.getY());
        } else if (global.equals("Medium")) {

            gc.drawImage(backgroundMedium, 0, 0);
        } else if (global.equals("Difficult")) {

            gc.drawImage(backgroundDifficult, 0, 0);
        }
    }

}
