/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorAtencion;
import controlador.ControladorPaciente;
import java.io.File;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.Atencion;
import modelo.Paciente;
import modelo.tdas.ArrayList;

/**
 *
 * @author Kevin Chevez pc
 */
public class VistaAtencion {
    private Atencion atencion;
    private VistaVideo vVideo;
    private VistaPuesto vPuesto;
    private VistaPaciente vPaciente;
    private ControladorAtencion cAtencion;
    private BorderPane root;
    
    private HBox seccionTop;
    private HBox seccionCentro = new HBox();
    private HBox seccionBottom;
    private VBox seccionVideo;
    
    public VistaAtencion(){
        vVideo = new VistaVideo(this);
        vPuesto = new VistaPuesto();
        vPaciente = new VistaPaciente();
        
        root = new BorderPane();
        seccionTop = new HBox();
        seccionBottom = new HBox();
        seccionVideo = new VBox();
        
        crearSecTop();
        crearSeccionCenter();
        crearSeccionBottom();
    }
    
    public void crearSecTop(){
        String hora = new Date().toLocaleString();
        ObservableList<String> opciones = FXCollections.observableArrayList();
        opciones.addAll("Atencion","Puestos", "Pacientes");
        
        ComboBox combo = new ComboBox(opciones);
        combo.setPromptText("Cambiar de Pestaña");
        //combo.setEditable(true);
        Label tiempo = new Label(hora);
        
        seccionTop.getChildren().addAll(combo, tiempo);
        root.setTop(seccionTop);
    }
    
    public void crearSeccionCenter(){
        crearSeccionVideo();
        VBox column1 = new VBox();
        VBox column2 = new VBox();
        Label turno = new Label("TURNO");
        Label puesto = new Label("PUESTO");
        column1.getChildren().add(turno);
        column2.getChildren().add(puesto);
        
        List<Paciente> tmp = new LinkedList<>();
        for(int i = 0; i<4; i++){
            Label iTurno = new Label();
            Label iPuesto = new Label();
            if(!Atencion.pacientes.isEmpty()){
                Paciente p = Atencion.pacientes.poll();
                tmp.add(p);
                iTurno.setText(p.getPuesto().getPaciente().getTurno());
                iPuesto.setText(p.getPuesto().getNumPuesto()+"");
            }
            column1.getChildren().add(iTurno);
            column2.getChildren().add(iPuesto);
        }
        Atencion.pacientes.addAll(tmp);
        seccionCentro.getChildren().addAll(column1, column2);
        root.setCenter(seccionCentro);
        
    }
    public void crearSeccionVideo(){
        String pathImge = "src/imagenes/verVideo.png";
        Image imagen = new Image(new File(pathImge).toURI().toString());
        ImageView verImagen = new ImageView(imagen);
        verImagen.setFitHeight(350);
        verImagen.setFitWidth(350);
//        DoubleProperty mvWidth = verImagen.fitWidthProperty();
//        DoubleProperty mvHeight = verImagen.fitHeightProperty();
//        mvWidth.bind(Bindings.selectDouble(verImagen.sceneProperty(), "width"));
//        mvHeight.bind(Bindings.selectDouble(verImagen.sceneProperty(), "height"));
        verImagen.setOnMouseClicked((MouseEvent me)->{
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    seccionVideo.getChildren().clear();
                    vVideo.mostrarVideos();
                }
            });
        });
        seccionVideo.getChildren().add(verImagen);
        seccionCentro.getChildren().add(seccionVideo);
    }
    
    public void crearSeccionBottom(){
        Label lb = new Label("Horario de atención de Lunes a Viernes de 10 a 18 hs / Sábados");
        seccionBottom.getChildren().add(lb);
        root.setBottom(seccionBottom);
    }

    public BorderPane getRoot() {
        return root;
    }

    public void setRoot(BorderPane root) {
        this.root = root;
    }

    public HBox getSeccionTop() {
        return seccionTop;
    }

    public void setSeccionTop(HBox seccionTop) {
        this.seccionTop = seccionTop;
    }

    public HBox getSeccionCentro() {
        return seccionCentro;
    }

    public void setSeccionCentro(HBox seccionCentro) {
        this.seccionCentro = seccionCentro;
    }

    public HBox getSeccionBottom() {
        return seccionBottom;
    }

    public void setSeccionBottom(HBox seccionBottom) {
        this.seccionBottom = seccionBottom;
    }

    public VBox getSeccionVideo() {
        return seccionVideo;
    }

    public void setSeccionVideo(VBox seccionVideo) {
        this.seccionVideo = seccionVideo;
    }
    
    
}
