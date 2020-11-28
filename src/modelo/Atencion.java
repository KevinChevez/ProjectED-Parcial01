/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.PriorityQueue;
import modelo.exceptions.ValorNuloException;
import modelo.tdas.DoublyLinkedList;

/**
 *
 * @author Kevin Chevez pc
 */
public class Atencion {
    public static PriorityQueue<Paciente> pacientes = new PriorityQueue<>();
    public static DoublyLinkedList<Puesto> puestos = new DoublyLinkedList<>();
    public static int tiempoVideoActual = 0;
    
    public Atencion(){
        
    }
    
    /**
     * Este método añade un paciente pasado como parámetro a la lista de pacientes
     * @param paciente Recibe como parámetro un paciente para agregar a la lista de pacientes
     */
    public static void añadirPaciente(Paciente paciente){
        pacientes.offer(paciente);
    }
    
    public static void atenderPaciente(){
        if(!pacientes.isEmpty()) pacientes.poll();
    }
    
    public static Puesto getPuesto(Paciente paciente) throws ValorNuloException{
        return puestos.get(paciente.getPuesto());
    }
    
    
}
