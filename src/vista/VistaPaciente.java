/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorAtencion;
import controlador.ControladorPaciente;
import modelo.Main;
import modelo.Medico;
import modelo.Paciente;
import modelo.Puesto;

/**
 *
 * @author Kevin Chevez pc
 */
public class VistaPaciente {
    private Paciente paciente;
    private ControladorPaciente cPaciente;
    private ControladorAtencion cAtencion;

    public VistaPaciente(Paciente paciente, ControladorPaciente cPaciente, ControladorAtencion cAtencion) {
        this.paciente = paciente;
        this.cPaciente = cPaciente;
        this.cAtencion = cAtencion;
    }
    
    public VistaPaciente(){
        this.paciente = new Paciente(new Puesto(), "Carlos", "Morán");
        cAtencion = new ControladorAtencion(paciente, Main.vA);
        cPaciente = new ControladorPaciente(this, cAtencion);      
    }
    
    public void verFormulario(){
        
    }
}
