/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author karol
 */
public class ControlPanel extends Application implements EventHandler<javafx.event.ActionEvent> {

    Pane pane;
    Scene scene;
    RadioButton easy, medium, difficult, fast, furious, smart;
    Button enter, pause, stop;
    ToggleGroup group, group2;
    public static String global, global2;
    HBox hbox, vbox, hbox2, vbox2;
    final Spinner<Integer> spinner = new Spinner<Integer>();
    final Spinner<Integer> spinner2 = new Spinner<Integer>();
    final Spinner<Integer> spinner3 = new Spinner<Integer>();
    Label text, text2, text3, lfast, lsmart, lfurious, leasy, lmedium, ldifficult;

    @Override
    public void start(Stage primaryStage) throws Exception {

        group = new ToggleGroup();
        group2 = new ToggleGroup();
        pane = new Pane();
        pane.setStyle("-fx-background-color:  #031310 ");
        pane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        Image dificult = new Image("/assets/d.png");
        ImageView dificultt = new ImageView(dificult);

        Image controlP = new Image("/assets/controlP.png");
        ImageView controlPane = new ImageView(controlP);
        
         Image characterIm = new Image("/assets/ghost.png");
        ImageView characterIV = new ImageView(characterIm);

        Image easyImage = new Image("/assets/easy.png");
        ImageView easyImageV = new ImageView(easyImage);

        Image mediumImage = new Image("/assets/2medium_1.png");
        ImageView mediumImageV = new ImageView(mediumImage);

        Image dificultImage = new Image("/assets/hard.png");
        ImageView dificultImageV = new ImageView(dificultImage);

        Image playImage = new Image("/assets/play1.png");
        ImageView playIV = new ImageView(playImage);

        Image pauseImage = new Image("/assets/pause2.png");
        ImageView pauseIV = new ImageView(pauseImage);

        Image stopImage = new Image("/assets/stop2.png");
        ImageView stopIV = new ImageView(stopImage);

        Image runImage = new Image("/assets/fastt.png");
        ImageView runIV = new ImageView(runImage);

        Image furiousImage = new Image("/assets/furious2.png");
        ImageView furiousIV = new ImageView(furiousImage);

        Image smartImage = new Image("/assets/smart1.png");
        ImageView smartIV = new ImageView(smartImage);

        Image levelIm = new Image("/assets/upload.png");
        ImageView levelIV = new ImageView(levelIm);

        
        easy = new RadioButton("Easy");
        easy.setToggleGroup(group);
        easy.setUserData("Easy");

        medium = new RadioButton("Medium");
        medium.setToggleGroup(group);
        medium.setUserData("Medium");

        difficult = new RadioButton("Difficult");

        difficult.setToggleGroup(group);
        difficult.setUserData("Difficult");

        fast = new RadioButton("Fast");
        fast.setToggleGroup(group2);
        fast.setUserData("Fast");

        furious = new RadioButton("Furious");
        furious.setToggleGroup(group2);
        furious.setUserData("Furious");

        smart = new RadioButton("Smart");
        smart.setToggleGroup(group2);
        smart.setUserData("Smart");

        enter = new Button("Play", playIV);
        this.enter.setOnAction(this);
        this.enter.relocate(90, 600);
        this.enter.setMinSize(50, 20);
        this.enter.setTextFill(Color.BLACK);
        this.enter.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));

        this.pause = new Button("Pause", pauseIV);
        this.pause.setOnAction(this);
        this.pause.relocate(180, 600);
        this.pause.setMinSize(50, 20);
        this.pause.setTextFill(Color.BLACK);
        this.pause.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));

        this.stop = new Button("Stop", stopIV);
        this.stop.setOnAction(this);
        this.stop.relocate(280, 600);
        this.stop.setMinSize(50, 20);
        this.stop.setTextFill(Color.BLACK);
        this.stop.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));

        this.text = new Label("Control Pane", controlPane);
        this.text.relocate(100, 25);//derecha ,alto
        //this.text.setMinSize(0, 0);
        this.text.setTextFill(Color.WHITE);
        this.text.setFont(Font.font("Lucida Handwriting", FontWeight.BOLD, FontPosture.ITALIC, 30));

        this.text2 = new Label("Choose a character, and quantify",characterIV);
        this.text2.relocate(60, 100);//derecha ,alto
        this.text2.setTextFill(Color.WHITE);
        this.text2.setFont(Font.font("Lucida Handwriting", FontWeight.BOLD, FontPosture.ITALIC, 16));

        this.leasy = new Label("", easyImageV);
        this.leasy.relocate(50, 460);//derecha ,alto
        //this.leasy.setMinSize(150, 300);
        this.leasy.setTextFill(Color.BURLYWOOD);
        this.leasy.setFont(Font.font("Lucida Handwriting", FontWeight.BOLD, FontPosture.ITALIC, 16));

        this.lmedium = new Label("", mediumImageV);
        this.lmedium.relocate(190, 460);//derecha ,alto
        this.lmedium.setTextFill(Color.BURLYWOOD);
        this.lmedium.setFont(Font.font("Lucida Handwriting", FontWeight.BOLD, FontPosture.ITALIC, 16));

        this.ldifficult = new Label("", dificultImageV);
        this.ldifficult.relocate(350, 460);//derecha ,alto
        this.ldifficult.setTextFill(Color.BURLYWOOD);
        this.ldifficult.setFont(Font.font("Lucida Handwriting", FontWeight.BOLD, FontPosture.ITALIC, 16));

        this.lfast = new Label("", runIV);
        this.lfast.relocate(30, 160);//derecha ,alto
        this.lfast.setTextFill(Color.BURLYWOOD);
        this.lfast.setFont(Font.font("Lucida Handwriting", FontWeight.BOLD, FontPosture.ITALIC, 16));

        this.lfurious = new Label("", furiousIV);
        this.lfurious.relocate(170, 160);//derecha ,alto
        this.lfurious.setTextFill(Color.BURLYWOOD);
        this.lfurious.setFont(Font.font("Lucida Handwriting", FontWeight.BOLD, FontPosture.ITALIC, 16));

        this.lsmart = new Label("", smartIV);
        this.lsmart.relocate(320, 160);//derecha ,alto
        this.lsmart.setTextFill(Color.BURLYWOOD);
        this.lsmart.setFont(Font.font("Lucida Handwriting", FontWeight.BOLD, FontPosture.ITALIC, 16));

        this.text3 = new Label("Choose a level",levelIV);
        this.text3.relocate(125, 400);//derecha ,alto
        this.text3.setTextFill(Color.WHITE);
        this.text3.setFont(Font.font("Lucida Handwriting", FontWeight.BOLD, FontPosture.ITALIC, 24));

        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov,
                    Toggle old_toggle, Toggle new_toggle) {
                if (group.getSelectedToggle() != null) {
                    global = group.getSelectedToggle().getUserData().toString();
                    System.out.println(group.getSelectedToggle().getUserData().toString());
                }
            }
        });

        group2.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov,
                    Toggle old_toggle, Toggle new_toggle) {
                if (group2.getSelectedToggle() != null) {
                    global2 = group2.getSelectedToggle().getUserData().toString();
                    System.out.println(group2.getSelectedToggle().getUserData().toString());
                }
            }
        });
        //Configurar que el spinner, con valoress de 0 a 100
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 0);
        spinner.setValueFactory(valueFactory);
        this.spinner.relocate(40, 300);
        this.spinner.setMinSize(30, 20);
        this.spinner.setMaxWidth(50);
        this.spinner.setMaxHeight(30);

        //Configurar que el spinner, con valoress de 0 a 100
        SpinnerValueFactory<Integer> valueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 0);
        spinner2.setValueFactory(valueFactory2);
        this.spinner2.relocate(190, 300);
        this.spinner2.setMinSize(30, 20);
        this.spinner2.setMaxWidth(50);
        this.spinner2.setMaxHeight(30);

        //Configurar que el spinner, con valoress de 0 a 100
        SpinnerValueFactory<Integer> valueFactory3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 0);
        spinner3.setValueFactory(valueFactory3);
        this.spinner3.relocate(350, 300);
        this.spinner3.setMinSize(30, 20);
        this.spinner3.setMaxWidth(50);
        this.spinner3.setMaxHeight(30);

        hbox = new HBox();
        vbox = new HBox();
        ////agrego los radioButtons al HBox, para que se pongan de forma horizontal
        vbox.getChildren().add(easy);
        vbox.getChildren().add(medium);
        vbox.getChildren().add(difficult);
        vbox.setSpacing(80);

        this.vbox.relocate(65, 530);
        this.vbox.setMinSize(30, 20);

        hbox2 = new HBox();
        vbox2 = new HBox();
        ////agrego los radioButtons al HBox, para que se pongan de forma horizontal
        vbox2.getChildren().add(fast);
        vbox2.getChildren().add(furious);
        vbox2.getChildren().add(smart);
        vbox2.setSpacing(100);

        this.vbox2.relocate(50, 335);
        this.vbox2.setMinSize(30, 20);

        scene = new Scene(pane, 470, 650);

        //Add components at pane
        pane.getChildren().add(text);
        pane.getChildren().add(text2);
        pane.getChildren().add(text3);
        pane.getChildren().add(lfast);
        pane.getChildren().add(lsmart);
        pane.getChildren().add(lfurious);
        pane.getChildren().add(leasy);
        pane.getChildren().add(lmedium);
        pane.getChildren().add(ldifficult);
        pane.getChildren().addAll(enter, playIV);
        pane.getChildren().addAll(stop, stopIV);
        pane.getChildren().addAll(pause, pauseIV);
        pane.getChildren().add(vbox);
        pane.getChildren().add(vbox2);
        pane.getChildren().add(spinner);
        pane.getChildren().add(spinner2);
        pane.getChildren().add(spinner3);
        primaryStage.setTitle("Mosaic Maker ");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(javafx.event.ActionEvent event) {
        try {
            if (((Button) event.getSource() == enter) && this.global.equals("Medium")) {
                System.out.println("HOLA");
                Matriz starGame = new Matriz();
                Stage stage = new Stage();
                starGame.start(stage);
            }
            else if(((Button)event.getSource()==enter) && this.global.equals("Difficult")){
             System.out.println("HOLA2");
                DifficultMatrix starGame = new DifficultMatrix();
                Stage stage = new Stage();
                starGame.start(stage);
            }

        } catch (Exception e) {
        }
    }

}
