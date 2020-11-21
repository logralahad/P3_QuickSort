/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

/**
 *
 * @author logra
 */
public class Lista {
    
    Nodo inicio = null;
    Nodo fin = null;
    
    public Nodo crearNodo(int dato){
        Nodo nuevo = new Nodo();
        nuevo.anterior = null;
        nuevo.siguiente = null;
        nuevo.dato = dato;
        return nuevo;
    }
    

    public void insertar(int dato){
        Nodo nuevo = crearNodo(dato);
        if(isEmpty()){
            inicio = nuevo;
            fin = nuevo;
        }
        else{
            nuevo.anterior = fin;
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }
    
    public void recorrer(){
        Nodo aux = inicio;
        while(aux != null){
            System.out.print(aux.dato + " ");
            aux = aux.siguiente;
        }
    }
    
    public Nodo particion(Nodo raiz, Nodo ultimo){        
        Nodo i = raiz.anterior;
        Nodo j = raiz;
        int temp;
        
        while(j != ultimo){
            if(j.dato <= ultimo.dato){
                if(i == null){
                    i = raiz;
                }else{
                    i = i.siguiente;
                }
                temp = i.dato;
                i.dato = j.dato;
                j.dato = temp;               
            }
            j = j.siguiente;
        }
        
        if(i == null){
            i = raiz;
        }
        else{
            i = i.siguiente;
        }
        
        temp = i.dato;
        i.dato = ultimo.dato;
        ultimo.dato = temp;
        
        return i;
    }
    
    public void sortrecursivo(Nodo alto, Nodo bajo){
        if(bajo != null && alto != bajo && alto != bajo.siguiente){
            Nodo temp = particion(alto, bajo);
            sortrecursivo(alto, temp.anterior);
            sortrecursivo(temp.siguiente, bajo);
        }
    }
    
    public void quickSort(){
        sortrecursivo(inicio, fin);
    }
    
    public int tam(Lista a){
        Nodo aux = a.inicio;
        int cont = 1;
        while(aux != null){
            aux = aux.siguiente;
            cont++;
        }
        return cont;
    }
    
    public boolean isEmpty(){
        return (inicio == null) && (fin == null);
    }

}