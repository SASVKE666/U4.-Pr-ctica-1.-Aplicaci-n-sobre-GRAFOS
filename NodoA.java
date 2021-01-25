/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.grafodireccionado;

/**
 *
 * @author REAL
 */
public class NodoA {
    NodoG direccion;
    NodoA sig;
    NodoA ant;
    
    public NodoA(NodoG destino){
        direccion=destino;
        sig=null;
        ant=null;
    }
}
