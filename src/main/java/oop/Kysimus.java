package oop;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Kysimus extends Application {

    public void start(Stage peaLava) {

        BorderPane piir = new BorderPane();

        // tekstivälja loomine ja lisamine piiripaanile (üles)
        TextField kysimus = new TextField();
        kysimus.setText("Mitu merisiga on keelatud Sveitsis omada?");

        piir.setTop(kysimus);

/*
        // sündmuse lisamine tekstiväljale (klahvisündmus reageerib
        // ainult enter-i vajutamisele)
        kysimus.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    kysimus.setText("nüüd vajutasin ENTER");
                }
            }
        });
*/
        // listivaate loomine ja lisamine piiripaanile (keskele)
        ListView<String> list = new ListView<String>();
        ObservableList<String> items = FXCollections.observableArrayList("Ühte", "Kahte",
                "Kolme", "Rohkem");
        list.setItems(items);
        piir.setCenter(list);


        TextField valitudVastus = new TextField();
        valitudVastus.setText(" ");
        TextField vastus = new TextField();
        vastus.setText("Sinu vastus on ");

        // listivaate omaduse kuulamine (kui midagi valitakse,
        // siis see omadus muutub)
        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> ov, String oldValue, String newValue) {
                valitudVastus.setText(newValue);
                System.out.println(valitudVastus.getCharacters().toString().equals(newValue));

            }
        });


        // teine piiripaan, mis pannakse esimesele piiripaanile alla
        // teisele piiripaanile tuleb 2 nuppu, üks vasakule ja
        // üks paremale
        BorderPane piir3 = new BorderPane();
        Button kinnitusNupp = new Button("Kinnita vastus");
        piir3.setRight(valitudVastus);
        piir3.setLeft(vastus);
        piir3.setBottom(kinnitusNupp);

        piir.setBottom(piir3);

/*
        // hiiresündmuse lisamine teisele piiripaanile
        piir2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                kysimus.setText("nüüd uus tekst");
            }
        });

*/
        // klahvisündmuse lisamine esimele nupule
        kinnitusNupp.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {

                if (valitudVastus.getCharacters().toString().equals("Ühte")){
                    Stage kusimus = new Stage();
                    // küsimuse ja kahe nupu loomine
                    Label label = new Label("Oige vastus.\nMerisead on sotsiaalsed loomad ja yksi muutuvad nad kurvaks.");



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


                }else{
                    Stage kusimus = new Stage();
                    // küsimuse ja kahe nupu loomine
                    Label label = new Label("Vale vastus.");


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

            }
        });




/*
        // aknasündmuse lisamine
        peaLava.setOnHiding(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent event) {
                // luuakse teine lava
                Stage kusimus = new Stage();
                // küsimuse ja kahe nupu loomine
                Label label = new Label("Proovid uuesti?");
                Button okButton = new Button("Jah");
                Button cancelButton = new Button("Ei");

                // sündmuse lisamine nupule Jah
                okButton.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        kusimus.hide();
                    }
                });

                // sündmuse lisamine nupule Ei
                cancelButton.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        peaLava.show();
                        kusimus.hide();
                    }
                });

                // nuppude grupeerimine
                FlowPane pane = new FlowPane(10, 10);
                pane.setAlignment(Pos.CENTER);
                pane.getChildren().addAll(okButton, cancelButton);

                // küsimuse ja nuppude gruppi paigutamine
                VBox vBox = new VBox(10);
                vBox.setAlignment(Pos.CENTER);
                vBox.getChildren().addAll(label, pane);

                //stseeni loomine ja näitamine
                Scene stseen2 = new Scene(vBox);
                kusimus.setScene(stseen2);
                kusimus.show();
            }
        }); //siin lõpeb aknasündmuse kirjeldus
*/

        // stseeni loomine ja näitamine
        Scene stseen1 = new Scene(piir, 300, 200, Color.SNOW);
        peaLava.setTitle("Sündmused");
        peaLava.setResizable(false);
        peaLava.setScene(stseen1);
        peaLava.show();
    }

    public static void main (String[]args){
        launch(args);
    }
}
