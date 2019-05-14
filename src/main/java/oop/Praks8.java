package oop;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.awt.*;
import java.util.Random;

public class Praks8 extends Application {

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    @Override
    public void start(Stage peaLava) throws Exception {

        Group juur = new Group(); // luuakse juur
        Scene stseen1 = new Scene(juur, 500, 500, Color.WHITE);

        Pane piir = new Pane();
        piir.setMaxWidth(stseen1.getWidth()-100);
        piir.setMaxHeight(stseen1.getHeight()-100);





        Circle ring = new Circle(100, 100, 50, Color.RED);

        Circle teineRing = new Circle(225, 225, 100, Color.YELLOWGREEN);

        Circle kolmasRing = new Circle(300, 300, 75, Color.YELLOW);

        Button nupp = new Button("Kliki Mind");

        piir.getChildren().add(nupp);





        juur.getChildren().add(teineRing);
        juur.getChildren().add(kolmasRing);
        juur.getChildren().add(ring);
        juur.getChildren().add(piir);

        nupp.setOnMouseEntered(syndmus -> {
            //System.out.println("registreerib");
            System.out.println(nupp.getWidth());

            nupp.setLayoutX(getRandomNumberInRange((int) nupp.getWidth(), (int)stseen1.getWidth() - (int)nupp.getWidth()));
            nupp.setLayoutY(getRandomNumberInRange((int) nupp.getHeight(), (int)stseen1.getHeight() - (int)nupp.getHeight()));
            ring.setCenterY(getRandomNumberInRange((int) ring.getRadius(), (int)stseen1.getHeight() - (int)ring.getRadius()));
            ring.setCenterX(getRandomNumberInRange((int) ring.getRadius(), (int)stseen1.getWidth() - (int)ring.getRadius()));
        });


        ring.setOnMouseEntered(syndmus -> {

            //System.out.println("hiir laks sisse");

            ring.setCenterY(getRandomNumberInRange((int) ring.getRadius(), (int)stseen1.getHeight() - (int)ring.getRadius()));
            ring.setCenterX(getRandomNumberInRange((int) ring.getRadius(), (int)stseen1.getWidth() - (int)ring.getRadius()));
            nupp.setLayoutX(getRandomNumberInRange((int) nupp.getWidth(), (int)stseen1.getHeight() - (int)nupp.getWidth()));
            nupp.setLayoutY(getRandomNumberInRange((int) nupp.getHeight(), (int)stseen1.getWidth() - (int)nupp.getHeight()));
            //ring.setFill(Color.BLUE);

        });

        ring.setOnMouseExited(syndmus -> {
            ring.setFill(Color.RED);
        });

        kolmasRing.setOnMousePressed(syndmus -> {
            teineRing.setFill(Color.YELLOW);
        });

        kolmasRing.setOnMouseReleased(syndmus -> {
            teineRing.setFill(Color.YELLOWGREEN);
        });

        teineRing.setOnMousePressed(syndmus -> {
            kolmasRing.setFill(Color.YELLOWGREEN);
        });

        teineRing.setOnMouseReleased(syndmus -> {
            kolmasRing.setFill(Color.YELLOW);
        });




        //juur.getChildren().add(ring);
    /*
        stseen1.setOnMousePressed(syndmus -> {
            int x = (int) syndmus.getX();
            int y = (int) syndmus.getY();
            Label silt = new Label("(" + x + ", " + y + ")");
            //System.out.println("(" + x + ", " + y + ")");
            silt.setLayoutX(x);
            silt.setLayoutY(y);
            juur.getChildren().add(silt);
        }
        );

        stseen1.setOnMouseReleased(syndmus -> {
            juur.getChildren().clear();
        });

        stseen1.setOnMouseDragged(syndmus -> {
            juur.getChildren().clear();
            int x = (int) syndmus.getX();
            int y = (int) syndmus.getY();
            Label silt = new Label("(" + x + ", " + y + ")");
            //System.out.println("(" + x + ", " + y + ")");
            silt.setLayoutX(x);
            silt.setLayoutY(y);
            juur.getChildren().add(silt);

        });

*/
        peaLava.setTitle("Ringid");

        peaLava.setScene(stseen1);  // lavale lisatakse stseen
        peaLava.show();  // lava tehakse nähtavaks
    }
    public static void main (String[]args){
        launch(args);
    }

}
