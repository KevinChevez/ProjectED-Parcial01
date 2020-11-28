/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javafx.event.Event;
import javafx.event.EventHandler;
import modelo.Paciente;
import vista.VistaAtencion;

/**
 *
 * @author Kevin Chevez pc
 */
public class ControladorAtencion implements EventHandler<Event>{
    private Paciente paciente;
    private VistaAtencion vistaAtencion;

    public ControladorAtencion(Paciente paciente, VistaAtencion vistaAtencion) {
        this.paciente = paciente;
        this.vistaAtencion = vistaAtencion;
    }
    
    
    
    public void añadirPaciente(Paciente paciente){
        
    }
    
    public void atenderPaciente(){
        
    }
    
    public void registrarDiagnostico(){
        
    }
    
    public void registrarReceta(){
        
    }

    @Override
    public void handle(Event t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public VistaAtencion getVistaAtencion() {
        return vistaAtencion;
    }

    public void setVistaAtencion(VistaAtencion vistaAtencion) {
        this.vistaAtencion = vistaAtencion;
    }
    
    
}
