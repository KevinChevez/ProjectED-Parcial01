/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javafx.scene.media.MediaView;

/**
 *
 * @author Kevin Chevez pc
 */
public class HiloVideo implements Runnable {
    private MediaView mediaView;
    private int timeMiliSec;

    public HiloVideo(MediaView mediaView) {
        this.mediaView = mediaView;
    }
    
    @Override
    public void run() {
        try{
            Thread.sleep(500);
            Atencion.tiempoVideoActual = (int)((mediaView.getMediaPlayer().getTotalDuration().toSeconds()*1000)+20);
            //System.out.println(Atencion.tiempoVideoActual);
        }
        catch(InterruptedException e){
            System.out.println("Hilo interrumpido");
        }
    }

    public int getTimeMiliSec() {
        return timeMiliSec;
    }

    public void setTimeMiliSec(int timeMiliSec) {
        this.timeMiliSec = timeMiliSec;
    }

    
    
}
