/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Kevin Chevez pc
 */
public class Paciente extends Usuario{
    private int edad;
    private String genero;
    private String sintoma;
    private int prioridad;
    private String turno;
    private Puesto puesto;

    public Paciente(int edad, String genero, String sintoma, int prioridad, String turno, Puesto puesto, String nombre, String apellido) {
        super(nombre, apellido);
        this.edad = edad;
        this.genero = genero;
        this.sintoma = sintoma;
        this.prioridad = prioridad;
        this.turno = turno;
        this.puesto = puesto;
    }

    public Paciente(Puesto puesto, String nombre, String apellido) {
        super(nombre, apellido);
        this.puesto = puesto;
        this.edad = 18;
        this.genero = "Masculino";
        this.sintoma = "fiebre";
        this.prioridad = 3;
        this.turno = "A2";
    }
   
    

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
}
