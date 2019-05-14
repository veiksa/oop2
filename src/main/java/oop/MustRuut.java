package oop;

import javafx.animation.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Flow;

public class MustRuut extends Application{
    //int[] arvud = new int[]{45, 78, 59, 21, 33, 96};


    @Override
    public void start(Stage peaLava) throws Exception {
        Group juur = new Group(); // luuakse juur

    Canvas lõuend = new Canvas(1100, 700); // luuakse lõuend

    GraphicsContext gc = lõuend.getGraphicsContext2D(); // graafiline sisu
        Rectangle mustOsa = new Rectangle(0, 300, 1100, 400);
       Rectangle kollaneOsa = new Rectangle(0, 401, 1100, 300);
       kollaneOsa.setFill(Color.YELLOW);

       //Loon vapi osa
       Rectangle vapiKast = new Rectangle(400, 210, 300, 150);
       Circle vapiRing = new Circle();
       vapiRing.setCenterX(550);
       vapiRing.setCenterY(380);
       vapiRing.setRadius(150);

       //karu tegemine
        Circle karuPea = new Circle(550, 350, 100);
        karuPea.setFill(Color.YELLOW);

        Circle paremKorv = new Circle(615, 265, 35);
        paremKorv.setFill(Color.YELLOW);

        Circle vasakKorv = new Circle(485, 265, 35);
        vasakKorv.setFill(Color.YELLOW);

        Circle paremSilm = new Circle(580, 305, 15);
        Circle paremSilmaMuna = new Circle(580, 305, 5);
        paremSilmaMuna.setFill(Color.YELLOW);

        Circle vasakSilm = new Circle(520, 305, 15);
        Circle vasakSilmaMuna = new Circle(520, 305, 5);
        vasakSilmaMuna.setFill(Color.YELLOW);

        Circle nina = new Circle(550, 350, 20);

        Reflection r = new Reflection();
        r.setFraction(0.9);

        paremSilm.setEffect(r);
        paremSilmaMuna.setEffect(r);
        vasakSilm.setEffect(r);
        vasakSilmaMuna.setEffect(r);
        nina.setEffect(r);

       juur.getChildren().add(mustOsa);
       juur.getChildren().add(kollaneOsa);
       juur.getChildren().add(vapiKast);
       juur.getChildren().add(vapiRing);
       juur.getChildren().add(karuPea);
       juur.getChildren().add(paremKorv);
       juur.getChildren().add(vasakKorv);
       juur.getChildren().add(paremSilm);
       juur.getChildren().add(vasakSilm);
       juur.getChildren().add(nina);
       juur.getChildren().add(paremSilmaMuna);
       juur.getChildren().add(vasakSilmaMuna);

/*
        DropShadow vari = new DropShadow(20, Color.GREEN);

        vari.setOffsetX(20);



       Button nupp1 = new Button("Olen nõus"); // luuakse nupp

        nupp1.setLayoutX(100); // nupu paigutamine x-koordinaadi mõttes

        nupp1.setLayoutY(60); // nupu paigutamine y-koordinaadi mõttes

        nupp1.setEffect(vari);

        juur.getChildren().add(nupp1); // nupp lisatakse juure alluvaks
        /*int x = 50;
        int[] koopia = Arrays.copyOf(arvud, arvud.length);
        Arrays.sort(koopia);
        int max = koopia[koopia.length-1] + 50;
        for (int element: arvud){
            Rectangle rectangle = new Rectangle(x, max-element, 30, element); // ruut
            if (element < 50){
                rectangle.setFill(Color.BLUE);
            }
            else{
                rectangle.setFill(Color.RED);
            }
            juur.getChildren().add(rectangle);

            x = x + 40;
        }
*/


        FlowPane flow = new FlowPane();
        ListView<String> list = new ListView<String>();
        ObservableList<String> items =FXCollections.observableArrayList (
                "Otep22 on Eesti talvepealinn", "See siin on Otep22 lipp", "Kas meeldib?", "Vali vastus");
        list.setMaxHeight(100);
        list.setItems(items);
        flow.getChildren().add(list);
        flow.setAlignment(Pos.TOP_CENTER);
        //flow.setMinWidth(lõuend.getWidth());


        BorderPane border = new BorderPane();
        border.setMinWidth(lõuend.getWidth());


        Button jah = new Button("Jah");
        border.setRight(jah);
        Button ei = new Button("Ei");
        border.setLeft(ei);



        flow.getChildren().add(border);

        juur.getChildren().add(flow);

    juur.getChildren().add(lõuend);  // lõuend lisatakse juure alluvaks

    Scene stseen1 = new Scene(juur);  // luuakse stseen

    peaLava.setTitle("Otepää Lipp");  // lava tiitelribale pannakse tekst

    peaLava.setScene(stseen1); // lavale lisatakse stseen

    peaLava.show();  // lava tehakse nähtavaks

        PathTransition pathTransition = new PathTransition();
        PathTransition eiTransition = new PathTransition();

        Path path = new Path();
        Path eiPath = new Path();

        path.getElements().add(new MoveTo(550, 350));
        path.getElements().add (new CubicCurveTo(500, 300, 600, 450, 550, 350));

        eiPath.getElements().add(new MoveTo(0, 15));
        eiPath.getElements().add(new LineTo(500, 15));

        pathTransition.setDuration(Duration.millis(1000));
        pathTransition.setNode(karuPea);
        pathTransition.setPath(path);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.setAutoReverse(true);

        eiTransition.setDuration(Duration.millis(400));
        eiTransition.setNode(ei);
        eiTransition.setPath(eiPath);
        eiTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        eiTransition.setCycleCount(Timeline.INDEFINITE);
        eiTransition.setAutoReverse(true);


        ParallelTransition parallelTransition = new ParallelTransition(pathTransition, eiTransition);
        parallelTransition.play();



    }





    public static void main(String[] args) {
        launch(args);
    }
}
