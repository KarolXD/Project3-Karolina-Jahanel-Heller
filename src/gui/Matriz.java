/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domain.Thread1;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import matriz.Object;

/**
 *
 * @author karol
 */
public class Matriz extends Application implements Runnable {
    // Object 

    // int numeros[][] = {{1, 0, 1, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 1}};
    int numeros[][] = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1},
        {1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1},
        {1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1},
        {1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1},
        {1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1},
        {1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1},
        {0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1},
        {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},};

    GraphicsContext gc;
    Pane pane;
    Canvas canvas;
    Scene scene;
    int ejeX;
    Object object[][] = new Object[25][25];
    int ejeY;
    private Timeline timeline;
    private final Label timerLabel = new Label();
    private final DoubleProperty timeSeconds = new SimpleDoubleProperty();
    private Duration time = Duration.ZERO;
    Thread thread;
    Thread1 thread1;

    public void matriz() {

        for (int x = 0; x < numeros.length; x++) {
            for (int y = 0; y < numeros[x].length; y++) {
                if (numeros[x][y] == 1) {

                    gc.setFill(Color.BLACK);
                    gc.fillRect(y * 40, x * 40, 40, 40);

                    object[x][y] = new Object(y * 40, x * 40, 40, 40, 1);
                } else {
                    gc.setFill(Color.WHITE);

                    gc.fillRect(y * 40, x * 40, 40, 40);
                    object[x][y] = new Object(y * 40, x * 40, 40, 40, 0);

                }
            }

        }

    }

    public void timer() {

        javafx.scene.image.Image clockImage = new javafx.scene.image.Image("/assets/clock.png");
        ImageView clockIV = new ImageView(clockImage);

        timerLabel.textProperty().bind(timeSeconds.asString());
        timerLabel.setTextFill(Color.TOMATO);
        timerLabel.setStyle("-fx-font-size: 5em;");

        Button button = new Button("Start", clockIV);

        button.relocate(280, 730);
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
    }

    public void evento() {
        canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                MouseButton button = event.getButton();
                ejeY = (int) event.getY();
                ejeX = (int) event.getX();

                if (button == MouseButton.PRIMARY) {
                    probar();
                } else if (button == MouseButton.SECONDARY) {

                } else if (button == MouseButton.MIDDLE) {

                }
            }
        });
    }

    public void probar() {
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                if ((ejeX >= object[i][j].getX() && ejeX <= object[i][j].getX() + object[i][j].getWidth())
                        && (ejeY >= object[i][j].getY() && ejeY <= object[i][j].getY() + object[i][j].getHeigth())) {
                    if (object[i][j].getNum() == 0) {
                        gc = canvas.getGraphicsContext2D();
                        gc.setFill(Color.BLACK);
                        gc.fillRect(object[i][j].getX(), object[i][j].getY(), 40, 40);
                        object[i][j] = new Object(j * 40, i * 40, 40, 40, 1);
                        //    gc.strokeRoundRect(object[i][j].getX(), object[i][j].getY(), 40, 40, 10, 10);

                    } else {
                        gc = canvas.getGraphicsContext2D();
                        gc.setFill(Color.WHITE);
                        gc.fillRect(object[i][j].getX(), object[i][j].getY(), 40, 40);
                        object[i][j] = new Object(j * 40, i * 40, 40, 40, 0);
                    }

                }
            }
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.pane = new Pane();
        this.scene = new Scene(pane, 700, 800);
        this.canvas = new Canvas(700, 700);
        canvas.relocate(0, 0);

        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BURLYWOOD);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        this.pane.getChildren().add(canvas);
        matriz();
        evento();
        timer();

        primaryStage.setTitle("Mosaic Maker ");
        primaryStage.setScene(scene);

        //Inicializamos cada hilo (personaje) y lo iniciamos
//        this.thread1 = new Thread1(-50, 400, 0);
//        this.thread1.start();

//            this.rc = new RunningCharacter(-50, 500, 0);
//            this.rc.start();
//            
//            this.jc = new JumpingCharacter(450, 370, 2);
//            this.jc.start();
//            
        this.thread = new Thread(this);
        this.thread.start();

        primaryStage.show();

    }

   

   

    @Override
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
               
            } catch (InterruptedException ex) {
            }
        }
    }

}
