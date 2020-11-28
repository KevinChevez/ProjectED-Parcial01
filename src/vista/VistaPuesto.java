/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import modelo.Puesto;
import modelo.Atencion;

/**
 *
 * @author Kevin Chevez pc
 */
public class VistaPuesto {
    private Puesto puesto;
    private BorderPane root;
    private HBox seccionCentro;

    public VistaPuesto(Puesto puesto) {
        this.puesto = puesto;
    }
    
    public VistaPuesto(){
        //Inicializar el resto manualmente
    }
    
    
    
}
