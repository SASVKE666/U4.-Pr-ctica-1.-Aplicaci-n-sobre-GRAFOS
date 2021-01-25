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
public class NodoG {
    char valor;
    NodoG sig;
    NodoG ant;
    NodoA ari;
    
    public  NodoG(char x){
        valor=x;
        sig=null;
        ant=null;
        ari=null;
    }
}
