/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuras2d;

/**
 *
 * @author Ruben
 */
public interface Dibujable {

    static final String ROJO = "Rojo";
    static final String VERDE = "Verde";
    static final String AZUL = "Azul";
    static final String AMARILLO = "Amarillo";
    static final String NEGRO = "Negro";
    static final String BLANCO = "Blanco";

    //metodos
    default void dibujar() {
    }

    default void rellenar() {
    }
}
