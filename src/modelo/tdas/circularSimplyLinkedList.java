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
public class circularSimplyLinkedList<E> implements List<E>{
    private Node<E> last;
    private int current;
    
    public circularSimplyLinkedList(){
        last = null;
        current = 0;
    }
    
    private class Node<E>{
        private E data;
        private Node<E> next;
        
        public Node(E data){
            this.data = data;
            next = null;
        }
    }
    
    @Override
    public boolean addFirst(E element) {
        Node<E> node = new Node<>(element);
        if (element == null) return false;
        else if(isEmpty()){
            last=node;
            node.next=node;
        }else{
            node.next=last.next;
            last.next=node;
        }
        current++;
        return true;
    }

    @Override
    public boolean addLast(E element) {
        Node<E> node = new Node<>(element);
        if(element==null) return false;
        else if(isEmpty()){
            last=node;
            last.next=node;            
        }else{
            node.next = last.next;
            last.next = node;
            last = node;
        }
        current++;
        return true;
    }

    @Override
    public boolean add(E element, int index) {
        Node<E> newNode = new Node<>(element);
        Node<E> first = last.next;
        if(element==null || index<0 || index>=current) return false;
        else if(isEmpty()||index==0) return addFirst(element);
        else if(index==current-1) return addLast(element);
        else{
            while(index-->1){
                first = first.next;
            }
            Node<E> tmp = first.next;
            first.next = newNode;
            newNode.next = tmp;
        }
        
        current++;
        return true;
    }

    @Override
    public E get(int index) throws ValorNuloException {
        Node<E> first = last.next;
        if(isEmpty()) throw new ValorNuloException("Lista vacía");
        if(index<0 || index>=current) throw new ValorNuloException("Valor fuera de rango");
        else if(index==0) return getFirst();
        else if(index==current-1) return getLAst();
        else{
            while(index-->0){
                first = first.next;
            }            
        }
        return first.data;
    }

    @Override
    public int size() {
        return current;
    }

    @Override
    public boolean isEmpty() {
        return (last==null);
    }

    @Override
    public boolean remove(int index) {
        if(isEmpty() || index<0 || index>=current) return false;
        else if(index == 0) return removeFirst();
        else if(index == current-1) return removeLast();
        else{
            Node<E> node = last.next;
            while(index-->1){
                node = node.next;
            }
            Node<E> nodeDelete = node.next;
            node.next = nodeDelete.next; //enganchando al siguiente del nodo a eliminar
            
            nodeDelete.data=null;
            nodeDelete.next=null;
        }
        current--;
        return true;
    }

    @Override
    public boolean contains(E element) {
        if(element == null || isEmpty()) return false;
        Node<E> nodeItr = last.next;
        do{
            if(nodeItr.data.equals(element)) return true;
            nodeItr = nodeItr.next;
        }
        while(nodeItr!=last.next);
        return false;
    }

    @Override
    public boolean removeFirst() {
        if(isEmpty()) return false;
        else if(last == last.next){
            System.out.println("Hay un solo elemento");
            last.data=null;
            last.next=null;
            last = null;
        }else{
            Node<E> first = last.next;
            last.next = first.next;

            first.data=null; //HELP GC
            first.next = null;
        }
        current--;
        return true;
    }

    @Override
    public boolean removeLast() {
        if(isEmpty()) return false;
        else if(last == last.next){
            last.data=null;
            last.next=null;
            last = null;
        }
        else{
            Node<E> previous = getPrev(last);

            previous.next = last.next;

            last.data=null;
            last.next = null;

            last = previous;
        }
        current--;
        return true;
    }
    
    private Node<E> getPrev(Node<E> p){
        if(isEmpty()){
            System.out.println("Algo anda mal "+last);
            return null;
        }
        Node<E> nodeItr = last.next;
        while(nodeItr.next!=last){
            nodeItr=nodeItr.next;
            //System.out.println(nodeItr.data);
        }
        //System.out.println("Devuelve \"Punultimo\": "+nodeItr.data);
        return nodeItr;
       
        /*Node<E> q = this.last;
        do{
            System.out.println(q.data);
            if(q.next == p)return q;
            q = q.next;
        }while(q!=last);
        return null;*/
    }

    @Override
    public E getFirst() throws ValorNuloException {
        if(isEmpty()) throw new ValorNuloException("Lista vacía"); //lanzar una excepción
        else return last.next.data;
    }

    @Override
    public E getLAst() throws ValorNuloException {
        if(isEmpty()) throw new ValorNuloException("Lista vacía"); //lanzar una excepción
        else return last.data;
    }
    
    @Override
    public String toString(){
        if(isEmpty()) return("[]");
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        /*for(Node<E> i = last.next; i!=last; i=i.next){
            sb.append(i.data);
            sb.append(", ");
        }*/
        Node<E> i = last.next;
        while(i!=last&&i!=null){
            sb.append(i.data);
            sb.append(", ");
            i=i.next;
        }
        /*Node<E> nodeItr = last.next;
        while(nodeItr.next!=last){
            nodeItr=nodeItr.next;
            System.out.println(nodeItr.data);
        }*/
        sb.append(last.data);
        sb.append("]");
        return sb.toString();
    }
}
