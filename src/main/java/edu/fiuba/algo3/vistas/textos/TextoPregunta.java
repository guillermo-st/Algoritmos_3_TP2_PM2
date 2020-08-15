package edu.fiuba.algo3.vistas.textos;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TextoPregunta extends Label {

    public TextoPregunta(String enunciado){
        super(enunciado);
        super.setFont(Font.font("montserrat",35));
        super.setTextFill(Color.BLACK);
        super.setWrapText(true);
    }
}
