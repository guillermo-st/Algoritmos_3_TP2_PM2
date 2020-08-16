package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorGanador;
import edu.fiuba.algo3.controladores.ControladorTerminarJuego;
import edu.fiuba.algo3.vistas.botones.BotonTerminarJuego;
import edu.fiuba.algo3.vistas.seccionesVista.GrillaGanador;
import edu.fiuba.algo3.vistas.textos.AlgoHootPrincipal;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VistaGanador extends StackPane {

    private static final String GRIS = "D8DDEF";
    private Stage stage;

    public VistaGanador(Stage stage){

        this.stage = stage;
        ControladorGanador controladorGanador = new ControladorGanador();

        Image imagen = new Image("file:"+System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/fondoInicio.jpg");
        BackgroundImage fondoImagen = new BackgroundImage(imagen,null,null, BackgroundPosition.CENTER,null);
        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);


        GrillaGanador grilla = new GrillaGanador(1280,720);
        grilla.setAlignment(Pos.CENTER);

        VBox cajaLogo = new VBox();
        cajaLogo.setAlignment(Pos.CENTER);
        AlgoHootPrincipal textoAlgoHootInicio = new AlgoHootPrincipal(GRIS);
        // textoAlgoHootInicio.setAlignment(Pos.CENTER);
        cajaLogo.getChildren().add(textoAlgoHootInicio);

        VBox cajaGanador = new VBox();
        cajaGanador.setAlignment(Pos.CENTER);
        Label textoGanador = new Label(controladorGanador.obtenerResultadoFinal());
        textoGanador.setFont(Font.font("montserrat",40));
        textoGanador.setTextFill(Color.web(GRIS));
        cajaGanador.getChildren().add(textoGanador);
        //textoGanador.setAlignment(Pos.CENTER);

        VBox cajaInferior = new VBox();
        cajaInferior.setAlignment(Pos.CENTER);
        BotonTerminarJuego botonTerminarJuego = new BotonTerminarJuego(new ControladorTerminarJuego());
        cajaInferior.getChildren().add(botonTerminarJuego);

        grilla.add(cajaLogo,0,0);
        grilla.add(textoGanador,0,1);
        grilla.add(cajaInferior, 0, 2);
        super.getChildren().add(grilla);
    }
}
