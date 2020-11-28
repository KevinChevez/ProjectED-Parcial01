/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javafx.event.Event;
import javafx.event.EventHandler;
import vista.VistaPaciente;

/**
 *
 * @author Kevin Chevez pc
 */
public class ControladorPaciente implements EventHandler<Event> {
    private VistaPaciente vistaPaciente;
    private ControladorAtencion controladorAtencion;

    public ControladorPaciente(VistaPaciente vistaPaciente, ControladorAtencion controladorAtencion) {
        this.vistaPaciente = vistaPaciente;
        this.controladorAtencion = controladorAtencion;
    }
    
    
    public void mostrarFormulario(){
        
    }
    
    public void cargarFormulario(){
        
    }

    @Override
    public void handle(Event t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public VistaPaciente getVistaPaciente() {
        return vistaPaciente;
    }

    public void setVistaPaciente(VistaPaciente vistaPaciente) {
        this.vistaPaciente = vistaPaciente;
    }

    public ControladorAtencion getControladorAtencion() {
        return controladorAtencion;
    }

    public void setControladorAtencion(ControladorAtencion controladorAtencion) {
        this.controladorAtencion = controladorAtencion;
    }
    
    
    
}
