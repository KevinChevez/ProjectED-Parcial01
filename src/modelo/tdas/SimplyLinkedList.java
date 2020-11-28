/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.tdas;

import modelo.exceptions.ValorNuloException;

/**
 *
 * @author JOVEN EJEMPLAR
 */
public class SimplyLinkedList<E> implements List<E> {
    private Node<E> first;
    private Node<E> last;
    private int current;
    
    public SimplyLinkedList(){
        first=last=null; // No es necesario, pero esto indica cuando la lista está vacía
        current = 0;
    }
    
    //INNER CLASS carrito de la montaña rusa
    private class Node<E>{
        private E data;
        private Node<E> next;
        
        public Node(E data){
            this.data=data;
        }
    }
    
    @Override
    public boolean addFirst(E element) { //tiempo de ejecución C (constante)
        if(element == null) return false;
        Node<E> n = new Node<>(element);
        if(isEmpty()){
            first = last= n;
        }else{
            n.next = first;
            first = n;
        }
        current++;
        return true;
    }

    @Override
    public boolean addLast(E element) { //tiempo de ejecución C (constante)
        if(element == null) return false;
        Node<E> n = new Node<>(element);
        if(isEmpty()){
            first = last= n; //apuntan al carro incial
            //current ++;
            //return true;
        }
        else{
            last.next = n; //el ultimo carro apunta al nuevo carro para que se enganche
            last = n;
            //current++;
            //return true;
        }
        current++;
        return true;
    }

    @Override
    public boolean add(E element, int index) {
        if(element == null) return false;
        if(index>=current || index<0) return false;
        if(index==0) return addFirst(element);
        if(index==current-1) return addLast(element);
        int i = 0;
        Node<E> nodo = first;
        while(i++<index-1){
            nodo = nodo.next;
        }
        Node<E> tmp = nodo.next;
        Node<E> n = new Node<>(element);
        //nodo.next = null;
        nodo.next = n;
        n.next=tmp;
        current++;
        return true;
    }

    @Override
    public E get(int index) throws ValorNuloException{
        if(isEmpty()) throw new ValorNuloException("La lista está vacía");
        if(index>=current || index <0) throw new ValorNuloException("Valor fuera de rango");
        if(index == 0) return getFirst();
        if(index == current-1) return getLAst();
        int i = 0;
        Node<E> nodo = first;
        //System.out.println(current);
        while(i++<index){            
            //i++;
            //System.out.println(i+" - "+nodo.data);
            nodo = nodo.next;
        }            
        return nodo.data;
    }

    @Override
    public int size() {
        return current;
    }

    @Override
    public boolean isEmpty() {
        return (first == null && last == null);
    }

    @Override
    public boolean remove(int index) {
        if(isEmpty()) return false;
        if(index>=current || index <0) return false;
        if(index==0) return removeFirst();
        if(index==current-1) return removeLast();
        int i = 0;
        Node<E> node = first;
        while(i++<index-1){
            node = node.next;
        }
        Node<E> tmp = node.next;
        Node<E> tmp2 = tmp.next;
        
        /*tmp.data =null; //Help GC
        tmp.next = null; //CREO QUE NO ES NECESARIO BORRAR LO QUE HAY DETRÁS DEL tmp2
        */
        node.next = null;
        node.next = tmp2;
        
        current--;
        return true;
    }

    @Override
    public boolean contains(E element) {
        if(element==null) return false;
        //if(first==null && last==null) return false;
        for(Node<E> i = first; i!=null; i = i.next){
            if(i.data.equals(element)) return true;
        }
        return false;
    }

    @Override
    public boolean removeFirst() { //tiempo de ejecución (C) constante
        if(isEmpty()) return false;
        if(first == last){
            first.data=null; //Ayuda a desalojar el carro y que garbage collector se lo lleve más rápido
            first = last = null;
        }else{
            Node<E> tmp = first;//node temporal            
            //first.next=null; //está mal, porque luego se refencia al vacío
            first = first.next;
            tmp.data=null; //Ayuda a desalojar el carro y que garbage collector se lo lleve más rápido
            tmp.next=null;
        }
        current--;
        return true;
    }

    @Override
    public boolean removeLast() { //tiempo de ejecución O(N)
        if(isEmpty()) return false;
        if(first == last){
            first.data=null; //Ayuda a desalojar el carro y que garbage collector se lo lleve más rápido
            first = last = null;
        }else{
            Node<E> prev = getPrevious(last);
            last.data=null; //AYUDA A GC, desalojamos en carro
            last=null;
            last=prev;
        }
        current--;
        return true;
    }
    
    private Node<E> getPrevious(Node<E> p){ //recibe un nodo y regresa el previo de ese nodo
//        for(Node<E> i = first; i!=null;i=i.next){
//            if(i.next == p) return i;
//        } //un for con un if es un while
//        return null;
        Node<E> i = first;
        while(i!=null && i.next!=p) i = i.next;
            //System.out.println( (i!=null)+ " - " + (i.next!=p)+ " - "+i.next.next.data + " Actual: "+i.data);
        //System.out.println("Final: "+i.data);
        return i;
        
        /*int i = 1;
        Node<E> node = first;
        while(i++<current-1){
            node = node.next;
            System.out.println(i+" - "+current);
        }
        System.out.println("fuera "+i);
        return node;*/
    }

    @Override
    public E getFirst() throws ValorNuloException{ 
        if(isEmpty()) throw new ValorNuloException("Lista vacía"); //lanzar una excepción
        else return first.data;
    }

    @Override
    public E getLAst() throws ValorNuloException{
        //if(isEmpty()) return null; //lanzar una excepcion
        if(isEmpty()) throw new ValorNuloException("Lista vacía");
        else return last.data;
    }
    
    @Override
    public String toString(){
        //mejora de clase
        if(isEmpty()) return("[]");
//        StringBuilder sb = new StringBuilder();
//        sb.append("[");
//        for(Node<E> i = first; i!=last; i=i.next){
//            sb.append(i.data);
//            sb.append(", ");
//        }
//        sb.append(last.data);
//        sb.append("]");
//        return sb.toString();
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");
//        for(Node<E> i = first; i!=null; i=i.next){
//            sb.append(i.data);
//            if(i!=last)sb.append(", ");
//        }
//        sb.append("]");
//        return sb.toString();
        Node<E> i = first;
        while(i!=null && i!=last){
            sb.append(i.data);
            sb.append(", "); //mejora para 
            i= i.next;
        }
        sb.append(last.data);
        sb.append("]");
        return sb.toString();
        
    }
}
