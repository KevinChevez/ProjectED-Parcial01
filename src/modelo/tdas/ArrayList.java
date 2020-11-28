/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.tdas;

/**
 *
 * @author JOVEN EJEMPLAR
 */
public class ArrayList<E> implements List<E>{
    private E[] array;
    private int current;
    
    public ArrayList(){
        this.array = (E[])new Object[10];
    }
    
    public ArrayList(int capacity){
        this.array = (E[]) new Object[capacity];
    }

    @Override
    public boolean addFirst(E element) { //tiempo de ejecución O(N)+epsilon
        if(element == null) return false;
        if(current == array.length) addCapacity(1,0);    
        else{
            for(int i=current-1; i>=0; i--){
                array[i+1]=array[i];
            }
        }
        array[0]=element;
        current++;
        return true;
    }

    @Override
    public boolean addLast(E element) { // Tiempo de ejecucion constante
        if (element==null) return false;
        if (current==array.length) addCapacity(0,0);
        array[current++]=element;
        return true;
    }
    
    private void addCapacity(int offset, int index){
        E[] tmp = (E[])new Object[array.length + (array.length*2/3)];
        for(int i = index; i<array.length ; i++){
            tmp[i+offset]=array[i];
        }
        for(int i = 0; i<index; i++){
            tmp[i]=array[i];
        }
        array = tmp; 
    }
            
    @Override
    public boolean add(E element, int index) {
        if(element==null) return false;
        else if(current==array.length) addCapacity(1,index);
        else if(index < 0 || index > current) return false;
        else if(index == 0){
            return addFirst(element); 
        }
        else if(index == current){
            return addLast(element);
        }
        else if(index < current){
            for(int i=current-1; i>=index; i--){
                array[i+1]=array[i];
            }
        }
        array[index]=element;
        current++;
        return true;
    }

    @Override
    public E get(int index) {
        return array[index];
    }

    @Override
    public int size() {
        return current; //devuelve el current
    }

    @Override
    public boolean isEmpty() {
        return current == 0;
    }

    @Override
    public boolean remove(int index) {
        if(isEmpty()) return false;
        if(index<0) return false;
        else if(index>current) return false;
        else if(index==0) return removeFirst();
        else if(index==current-1) return removeLast();
        for(int i=index; i<current-1; i++){
            array[i]=array[i+1];
        }
        array[--current]=null;
        return true;
    }

    @Override
    public boolean contains(E element) { //tiempo de ejecución O(N)
        if(element == null) return false; //MEJORA DE ALGORITMO
        for(int i=0; i<current; i++){
            if(array[i].equals(element))return true;
        }
        return false;
    }

    @Override
    public boolean removeFirst() { //tiempo de ejecución O(N)
        if(isEmpty()) return false;
         
        for(int i = 0; i<current-1 ; i++){
            array[i]=array[i+1];
        }
        array[--current] = null;
        return true;
    }

    @Override
    public boolean removeLast() { //tiempo de ejecución C (constante)
        if(isEmpty()) return false;
        array[--current]=null;
        return true;
    }

    @Override
    public E getFirst() {
        return(array[0]);
    }

    @Override
    public E getLAst() {
        return(array[current-1]);
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i=0; i<current-1; i++){
            sb.append(array[i]+",");
        }
        sb.append(array[current-1]+"]");
        return sb.toString();
    }
    
    public int current(){
        return this.current;
    }
    
    @Override
    public boolean equals(Object o){ //tiempo de ejecución O(N)
        if(o == null) return false;
        if(this == o) return true; //Si el mimsmo que invocó al método es 0
        if(this.getClass() != o.getClass()) return false;
        //Una vez hechos los 3 checks ahora si buscamos similitud
        
        ArrayList<E> other = (ArrayList<E>)o;
        if(this.size() != other.size()) return false;
        for(int i = 0; i<this.size(); i++){
            if(!array[i].equals(other.array[i])) return false;
        }
        return true;
    }
}
