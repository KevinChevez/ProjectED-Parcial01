/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 *
 * @author Kevin Chevez pc
 */
public class Video {
    private String path;
    private HiloVideo hilo;

    public Video(String path) {
        this.path = path;
    }
    
    public MediaView mostrarVideo(){
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer medPlayer = new MediaPlayer(media);
        MediaView medView = new MediaView(medPlayer);
//        DoubleProperty mvWidth = medView.fitWidthProperty();
//        DoubleProperty mvHeight = medView.fitHeightProperty();
//        mvWidth.bind(Bindings.selectDouble(medView.sceneProperty(), "width"));
//        mvHeight.bind(Bindings.selectDouble(medView.sceneProperty(), "height"));
        medView.setFitHeight(350);
        medPlayer.setAutoPlay(true);

        hilo = new HiloVideo(medView);      
        Thread thread = new Thread(hilo);
        thread.start();
        return medView;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public HiloVideo getHilo() {
        return hilo;
    }

    public void setHilo(HiloVideo hilo) {
        this.hilo = hilo;
    }
       
}
