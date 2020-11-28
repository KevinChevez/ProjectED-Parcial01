/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorVideo;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaView;
import modelo.Atencion;
import modelo.Video;
import modelo.tdas.circularDoublyLinkedList;

/**
 *
 * @author Kevin Chevez pc
 */
public class VistaVideo {
    private Video video;
    private VistaAtencion vAtencion;
    private circularDoublyLinkedList<Video> listVideos;
    private ControladorVideo cVideo;
    

    public VistaVideo(Video video, VistaAtencion vAtencion, circularDoublyLinkedList<Video> listVideos, ControladorVideo cVideo) {
        this.video = video;
        this.vAtencion = vAtencion;
        this.cVideo = cVideo;
        inciarListaVideos();
    }
    
    public VistaVideo(VistaAtencion va){
        this.cVideo = new ControladorVideo(this);
        this.vAtencion =va;
        inciarListaVideos();
    }
    
    
    public void mostrarVideos(){
//        Iterator<Video> it = listVideos.iterator();
//        while(it.hasNext()){
//            try {
//                Video video = it.next();
//                MediaView mediaView = video.mostrarVideo();
//                //vAtencion.getSeccionCentro().getChildren().add(mediaView);
//                vAtencion.getSeccionVideo().getChildren().clear();
//                vAtencion.getSeccionVideo().getChildren().add(mediaView);
//                Thread.sleep(7000);
//            } catch (InterruptedException ex) {
//                String mensaje ="Lo sentimos hubo un problema: " + ex.getMessage();
//                Label lb = new Label(mensaje);
//                vAtencion.getSeccionCentro().getChildren().add(lb);
//            }
//        }
        String path = "src/videos/2.mp4";
        Video video1 = new Video(path);
        MediaView mediaView = video1.mostrarVideo();
        vAtencion.getSeccionVideo().getChildren().clear();
        vAtencion.getSeccionVideo().getChildren().add(mediaView);
    }
    
    public void inciarListaVideos(){
        this.listVideos = cVideo.cargarVideos("src/archivos/videos.txt");
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public VistaAtencion getvAtencion() {
        return vAtencion;
    }

    public void setvAtencion(VistaAtencion vAtencion) {
        this.vAtencion = vAtencion;
    }

    public circularDoublyLinkedList<Video> getListVideos() {
        return listVideos;
    }

    public void setListVideos(circularDoublyLinkedList<Video> listVideos) {
        this.listVideos = listVideos;
    }

    public ControladorVideo getcVideo() {
        return cVideo;
    }

    public void setcVideo(ControladorVideo cVideo) {
        this.cVideo = cVideo;
    }
    
    
}
