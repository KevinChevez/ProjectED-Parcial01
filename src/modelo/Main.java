/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vista.VistaAtencion;

/**
 *
 * @author Kevin Chevez pc
 */
public class Main extends Application{
    public static VistaAtencion vA;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        vA = new VistaAtencion();
        
        Scene escena = new Scene(vA.getRoot(), 600, 400);
        
        stage.setScene(escena);
        stage.show();
    }
    
//    public static iniciarDatos(){
//        
//    }
}
