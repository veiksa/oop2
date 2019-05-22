package oop;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class TeamWork extends Application {

    Label vastatudTehted;
    Label vastatud;
    Label oigeid;
    Label valesid;
    Label aeg;

    Label vastatudLabel;
    Label oigeidLabel;
    Label valesidLabel;
    Label aegLabel;

    TextField tehetePiirArv;
    TextField teheteArv;
    Label tehetePiirArvLabel;
    Label teheteArvLabel;

    TextField tfTehe;
    TextField tfVastus;

    Button btnDivide;
    Button btnMultiply;
    Button btnAddition;
    Button btnSubtraction;

    Button btnVasta;
    Button btnStart;
    //Label lblAnswer;

    Button liitmine;
    Button lahutamine;
    Button korrutamine;
    Button jagamine;

    Button btnOne;
    Button btnTwo;
    Button btnThree;
    Button btnFour;
    Button btnFive;
    Button btnSix;
    Button btnSeven;
    Button btnEight;
    Button btnNine;
    Button btnZero;

    String vastatudYlesanded;

    int maxTehted = 0;
    int tehtudTehted = 0;
    long startTime = 0;
    Parameetrid teheteJaPiirArv;
    int oigedVastamised = 0;
    int valedVastamised = 0;


    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }


    public static void main(String[] args) {
        launch(args);
    }

    private void esitaKysimus() {
        if (maxTehted > tehtudTehted) {
            JuhuslikudNumbrid arvud = new JuhuslikudNumbrid(teheteJaPiirArv);
            if (tehtudTehted % 2 == 0) {
                System.out.println(tehtudTehted);

                Liitmine tehe = new Liitmine(arvud.getJuhuslikNumber1(), arvud.getJuhuslikNumber2());
                System.out.println("Kui palju on " + tehe.toString());
                tfTehe.setText(tehe.toString());
                System.out.println();
                //int kasutajaSisend = tehe.userInput();

                btnVasta.setOnMouseClicked(vastuseSyndmus -> {

                    if (tehe.Summeerimine() == Integer.parseInt(tfVastus.getCharacters().toString())) {

                        System.out.println("Õige vastus");
                        //oigeid = new Label(Integer.toString(Integer.parseInt(oigeid.getText())+ 1));
                        oigeid.setText(Integer.toString(Integer.parseInt(oigeid.getText()) + 1));
                        Stage kusimus = new Stage();
                        // küsimuse ja kahe nupu loomine
                        Label label = new Label("Oige vastus.\n");


                        // nuppude grupeerimine
                        FlowPane pane = new FlowPane(20, 20);
                        pane.setAlignment(Pos.CENTER);

                        // küsimuse ja nuppude gruppi paigutamine
                        VBox vBox = new VBox(40);
                        vBox.setAlignment(Pos.CENTER);
                        vBox.getChildren().addAll(label, pane);

                        //stseeni loomine ja näitamine
                        Scene stseen2 = new Scene(vBox);
                        kusimus.setScene(stseen2);
                        kusimus.show();
                    } else {
                        System.out.println();
                        System.out.println();
                        System.out.println("Vale vastus");
                        System.out.println("Õige vastus on " + tehe.Summeerimine());
                        valesid.setText(Integer.toString(Integer.parseInt(valesid.getText()) + 1));
                        Stage kusimus = new Stage();
                        // küsimuse ja kahe nupu loomine
                        Label label = new Label("Vale vastus! Oige vastus on: " + tehe.Summeerimine());


                        // nuppude grupeerimine
                        FlowPane pane = new FlowPane(10, 10);
                        pane.setAlignment(Pos.CENTER);

                        // küsimuse ja nuppude gruppi paigutamine
                        VBox vBox = new VBox(40);
                        vBox.setAlignment(Pos.CENTER);
                        vBox.getChildren().addAll(label, pane);

                        //stseeni loomine ja näitamine
                        Scene stseen2 = new Scene(vBox);
                        kusimus.setScene(stseen2);
                        kusimus.show();
                    }

                    tehtudTehted++;
                    esitaKysimus();

                });


            } else {
                System.out.println(tehtudTehted);


                Lahutamine tehe = new Lahutamine(arvud.getJuhuslikNumber1(), arvud.getJuhuslikNumber2());
                System.out.println("Kui palju on " + tehe.toString());
                tfTehe.setText(tehe.toString());
                System.out.println();

                btnVasta.setOnMouseClicked(vastuseSyndmus -> {

                    if (tehe.Lahutustehe() == Integer.parseInt(tfVastus.getCharacters().toString())) {
                        System.out.println();
                        System.out.println("Õige vastus");
                        oigeid.setText(Integer.toString(Integer.parseInt(oigeid.getText()) + 1));
                        Stage kusimus = new Stage();
                        // küsimuse ja kahe nupu loomine
                        Label label = new Label("Oige vastus.\n");


                        // nuppude grupeerimine
                        FlowPane pane = new FlowPane(20, 20);
                        pane.setAlignment(Pos.CENTER);

                        // küsimuse ja nuppude gruppi paigutamine
                        VBox vBox = new VBox(40);
                        vBox.setAlignment(Pos.CENTER);
                        vBox.getChildren().addAll(label, pane);

                        //stseeni loomine ja näitamine
                        Scene stseen2 = new Scene(vBox);
                        kusimus.setScene(stseen2);
                        kusimus.show();
                    } else {
                        System.out.println();
                        System.out.println("Vale vastus");
                        System.out.println("Õige vastus on " + tehe.Lahutustehe());
                        valesid.setText(Integer.toString(Integer.parseInt(valesid.getText()) + 1));
                        Stage kusimus = new Stage();
                        // küsimuse ja kahe nupu loomine
                        Label label = new Label("Vale vastus! Oige vastus on: " + tehe.Lahutustehe());


                        // nuppude grupeerimine
                        FlowPane pane = new FlowPane(10, 10);
                        pane.setAlignment(Pos.CENTER);

                        // küsimuse ja nuppude gruppi paigutamine
                        VBox vBox = new VBox(40);
                        vBox.setAlignment(Pos.CENTER);
                        vBox.getChildren().addAll(label, pane);

                        //stseeni loomine ja näitamine
                        Scene stseen2 = new Scene(vBox);
                        kusimus.setScene(stseen2);
                        kusimus.show();
                    }

                    tehtudTehted++;
                    esitaKysimus();
                });
            }
        } else {

            long endTime = System.currentTimeMillis();

            long vastamiseKestvus = (endTime - startTime) / (60 * 1000);

            System.out.println("=====================");
            System.out.println("Koik vastatud");
            System.out.println();
            System.out.println("Õigesti vastamisi: " + oigedVastamised);
            System.out.println("Valesti vastamisi: " + valedVastamised);
            System.out.println();
            System.out.println("aega kulus " + vastamiseKestvus + " minutit.");
        }
    }

    private void alusta() {
        tehtudTehted = 0;
        startTime = System.currentTimeMillis();
        teheteJaPiirArv = new Parameetrid(Integer.parseInt(teheteArv.getCharacters().toString()), Integer.parseInt(tehetePiirArv.getCharacters().toString()));
        maxTehted = teheteJaPiirArv.getTeheteArv();

        esitaKysimus();
    }


    @Override
    public void start(Stage primaryStage) {

        vastatud = new Label("0");
        oigeid = new Label("0");
        valesid = new Label("0");
        aeg = new Label("0:0,00");

        vastatudLabel = new Label("Vastatud tehteid: ");
        oigeidLabel = new Label("Õigeid vastuseid: ");
        valesidLabel = new Label("Valesid vastuseid: ");
        aegLabel = new Label("Kulunud aeg: ");

        teheteArv = new TextField();
        tehetePiirArv = new TextField();
        teheteArvLabel = new Label("Tehete arv: ");
        tehetePiirArvLabel = new Label("Suurim number: ");

        tfTehe = new TextField();
        tfVastus = new TextField();
        liitmine = new Button("+");
        lahutamine = new Button("-");
        korrutamine = new Button("*");
        jagamine = new Button("/");
        btnOne = new Button("1");
        btnTwo = new Button("2");
        btnThree = new Button("3");
        btnFour = new Button("4");
        btnFive = new Button("5");
        btnSix = new Button("6");
        btnSeven = new Button("7");
        btnEight = new Button("8");
        btnNine = new Button("9");
        btnZero = new Button("0");
        btnThree = new Button("3");
        btnFour = new Button("4");


        btnVasta = new Button("Esita Vastus");
        btnVasta.setAlignment(Pos.BOTTOM_RIGHT);
        btnStart = new Button("Tsykkel alga");
        btnStart.setAlignment(Pos.BOTTOM_LEFT);
        //lblAnswer = new Label("?");

        //lblAnswer.setAlignment(Pos.CENTER);
        //lblAnswer.setStyle("-fx-border-color: #000; -fx-padding: 5px;");
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);

        GridPane numPad = new GridPane();
        numPad.setAlignment(Pos.CENTER);

        GridPane tehteValik = new GridPane();
        tehteValik.setAlignment(Pos.CENTER);
        tehteValik.add(liitmine, 0, 0);
        tehteValik.add(lahutamine, 1, 0);
        tehteValik.add(korrutamine, 2, 0);
        tehteValik.add(jagamine, 3, 0);

        GridPane teheVastus = new GridPane();
        teheVastus.setAlignment(Pos.CENTER);
        teheVastus.add(tfTehe, 0, 0);
        teheVastus.add(tfVastus, 1, 0);

        GridPane oigedValedAeg = new GridPane();
        oigedValedAeg.setAlignment(Pos.CENTER);

        oigedValedAeg.add(vastatudLabel, 0, 0);
        oigedValedAeg.add(vastatud, 1, 0);
        oigedValedAeg.add(oigeidLabel, 0, 1);
        oigedValedAeg.add(valesidLabel, 0, 2);
        oigedValedAeg.add(aegLabel, 0, 3);
        oigedValedAeg.add(oigeid, 1, 1);
        oigedValedAeg.add(valesid, 1, 2);
        oigedValedAeg.add(aeg, 1, 3);

        GridPane teheteArvPiir = new GridPane();
        teheteArvPiir.setAlignment(Pos.CENTER);

        teheteArvPiir.add(teheteArvLabel, 0, 0);
        teheteArvPiir.add(teheteArv, 1, 0);
        teheteArvPiir.add(tehetePiirArvLabel, 0, 1);
        teheteArvPiir.add(tehetePiirArv, 1, 1);


        root.setHgap(10);
        root.setVgap(10);

        //root.add(tfTehe, 0, 0);
        //root.add(tfVastus, 1, 0);

        numPad.add(btnOne, 0, 1);
        numPad.add(btnTwo, 1, 1);
        numPad.add(btnThree, 2, 1);
        numPad.add(btnFour, 0, 2);
        numPad.add(btnFive, 1, 2);
        numPad.add(btnSix, 2, 2);
        numPad.add(btnSeven, 0, 3);
        numPad.add(btnEight, 1, 3);
        numPad.add(btnNine, 2, 3);
        numPad.add(btnZero, 1, 4);

        root.add(tehteValik, 0, 0);
        root.add(teheteArvPiir, 1, 0);
        root.add(teheVastus, 0, 1);
        root.add(numPad, 0, 2);
        root.add(oigedValedAeg, 1, 2);
        root.add(btnVasta, 0, 3);
        root.add(btnStart, 1, 3);

        btnOne.setOnMouseClicked(syndmus -> {
            tfVastus.setText(tfVastus.getCharacters().toString() + btnOne.getText());
        });

        btnTwo.setOnMouseClicked(syndmus -> {
            tfVastus.setText(tfVastus.getCharacters().toString() + btnTwo.getText());
        });

        btnThree.setOnMouseClicked(syndmus -> {
            tfVastus.setText(tfVastus.getCharacters().toString() + btnThree.getText());
        });

        btnFour.setOnMouseClicked(syndmus -> {
            tfVastus.setText(tfVastus.getCharacters().toString() + btnFour.getText());
        });

        btnFive.setOnMouseClicked(syndmus -> {
            tfVastus.setText(tfVastus.getCharacters().toString() + btnFive.getText());
        });

        btnSix.setOnMouseClicked(syndmus -> {
            tfVastus.setText(tfVastus.getCharacters().toString() + btnSix.getText());
        });

        btnSeven.setOnMouseClicked(syndmus -> {
            tfVastus.setText(tfVastus.getCharacters().toString() + btnSeven.getText());
        });

        btnEight.setOnMouseClicked(syndmus -> {
            tfVastus.setText(tfVastus.getCharacters().toString() + btnEight.getText());
        });

        btnNine.setOnMouseClicked(syndmus -> {
            tfVastus.setText(tfVastus.getCharacters().toString() + btnNine.getText());
        });

        btnZero.setOnMouseClicked(syndmus -> {
            tfVastus.setText(tfVastus.getCharacters().toString() + btnZero.getText());
        });


        btnStart.setOnMouseClicked(syndmus -> {
            alusta();
        });


        //root.add(btnClear, 0, 4, 2, 1);

        //root.add(tfTehe, 0, 2);
        //root.add(tfNum2, 1, 2);
        //root.add(lblAnswer, 0, 3, 2, 1);


        //setWidths();
        //attachCode();

        Scene scene = new Scene(root, 700, 250);
        primaryStage.setTitle("CalculatorFX 1.0");
        primaryStage.setScene(scene);
        primaryStage.show();
/*
        Parameetrid teheteJaPiirArv = new Parameetrid(Integer.parseInt(teheteArv.getCharacters().toString()), Integer.parseInt(tehetePiirArv.getCharacters().toString()));
        int piirArv = teheteJaPiirArv.getPiirArv();
        int teheteArv = teheteJaPiirArv.getTeheteArv();


        int i = 0;
        int oigedVastamised = 0;
        int valedVastamised = 0;
        long startTime = System.currentTimeMillis();

        while (i < teheteArv){
            JuhuslikudNumbrid arvud = new JuhuslikudNumbrid(teheteJaPiirArv);

            if (i % 2 == 0) {

                Liitmine tehe = new Liitmine(arvud.getJuhuslikNumber1(), arvud.getJuhuslikNumber2());
                System.out.println("Kui palju on " + tehe.toString());
                tfTehe = new TextField(tehe.toString());
                System.out.println();
                int kasutajaSisend = tehe.userInput();

                if (tehe.Summeerimine() == Integer.parseInt(tfVastus.getCharacters().toString())){
                    System.out.println();
                    System.out.println("Õige vastus");
                    oigedVastamised += 1;
                    oigeid = new Label(Integer.toString(oigedVastamised));
                    System.out.println("Õigesti vastamisi: " + oigedVastamised);
                    System.out.println("Valesti vastamisi: " + valedVastamised);
                    System.out.println();
                }else{
                    System.out.println();
                    System.out.println("Vale vastus");
                    System.out.println("Õige vastus on " + tehe.Summeerimine());
                    valedVastamised += 1;
                    valesid = new Label(Integer.toString(valedVastamised));
                    System.out.println("Õigesti vastamisi: " + oigedVastamised);
                    System.out.println("Valesti vastamisi: " + valedVastamised);
                    System.out.println();
                }


                i++;
            }else{
                Lahutamine tehe = new Lahutamine(arvud.getJuhuslikNumber1(), arvud.getJuhuslikNumber2());
                System.out.println("Kui palju on " + tehe.toString());
                System.out.println();
                int kasutajaSisend = tehe.userInput();

                if (tehe.Lahutustehe() == kasutajaSisend){
                    System.out.println();
                    System.out.println("Õige vastus");
                    oigedVastamised += 1;
                    System.out.println("Õigesti vastamisi: " + oigedVastamised);
                    System.out.println("Valesti vastamisi: " + valedVastamised);
                    System.out.println();
                }else{
                    System.out.println();
                    System.out.println("Vale vastus");
                    System.out.println("Õige vastus on " + tehe.Lahutustehe());
                    valedVastamised += 1;
                    System.out.println("Õigesti vastamisi: " + oigedVastamised);
                    System.out.println("Valesti vastamisi: " + valedVastamised);
                    System.out.println();
                }


                i++;

            }


        }
        long endTime = System.currentTimeMillis();

        long vastamiseKestvus = (endTime - startTime)/(60*1000);

        System.out.println("=====================");
        System.out.println("Koik vastatud");
        System.out.println();
        System.out.println("Õigesti vastamisi: " + oigedVastamised);
        System.out.println("Valesti vastamisi: " + valedVastamised);
        System.out.println();
        System.out.println("aega kulus " + vastamiseKestvus + " minutit.");

*/

    }
/*
    private void setWidths(){
        tfTehe.setPrefWidth(70);
        //tfNum2.setPrefWidth(70);
        btnDivide.setPrefWidth(70);
        btnMultiply.setPrefWidth(70);
        btnAddition.setPrefWidth(70);
        btnSubtraction.setPrefWidth(70);
        btnClear.setPrefWidth(150);
        lblAnswer.setPrefWidth(150);
    }
    */


}
