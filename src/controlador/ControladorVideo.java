/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import javafx.event.Event;
import javafx.event.EventHandler;
import modelo.Video;
import modelo.tdas.circularDoublyLinkedList;
import vista.VistaVideo;

/**
 *
 * @author Kevin Chevez pc
 */
public class ControladorVideo implements EventHandler<Event> {
    private VistaVideo vistaVideo;  

    public ControladorVideo(VistaVideo vistaVideo) {
        this.vistaVideo = vistaVideo;
    }
    
    
    public circularDoublyLinkedList<Video> cargarVideos(String nombre){
        circularDoublyLinkedList<Video> videos = new circularDoublyLinkedList<>();
        try(Scanner sc = new Scanner(new File(nombre))){
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                Video p =  new Video(line);
                videos.addFirst(p);
            }
        }catch(Exception e){
            System.out.println("Archivo no se puede abrir");
        }
        return videos;
    }
    
    
    private void mostrarVideos(){
        
    }
    
    private void pararVideos(){
        
    }

    @Override
    public void handle(Event t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public VistaVideo getVistaVideo() {
        return vistaVideo;
    }

    public void setVistaVideo(VistaVideo vistaVideo) {
        this.vistaVideo = vistaVideo;
    }
    
    
}
