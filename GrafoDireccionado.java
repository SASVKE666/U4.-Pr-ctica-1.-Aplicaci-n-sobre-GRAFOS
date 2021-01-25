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
public class GrafoDireccionado {
    protected NodoG ini=null;
    protected NodoG fin=null;
    protected NodoA direccion;

    
    
    protected boolean existe(char x, char y){
        NodoG origen=new NodoG(x);
        NodoG destino=new NodoG(y);
        
        if(origen==null || destino==null){
            return false;
        }
        
        for(origen=ini;origen!=null;origen=origen.sig){
            if(origen.valor==x){
                for(destino=ini;destino!=null;destino=destino.sig){
                    if(destino.valor==y){
                        return true;
                    }
                }
            }
        }
 
        return false;
    }
  
    public boolean pushNodo(char x){
        
        NodoG temp=new NodoG(x);
        
        if(temp==null){
            return false;
        }
        
        if(ini==null && fin== null){
            ini=fin=temp;
            return true;
        }
            
        fin.sig=temp;
        temp.ant=fin;
        fin=temp;
        
        return true;
    }
    
    public boolean pushArista(char x,char y){
        
        NodoG origen=buscar(x);
        
        if(origen==null ){
            return false;
        }
        
        NodoG destino=buscar(y);
        
        if(destino==null ){
            return false;
        }
        
        NodoA temp=new NodoA(destino);
                        
        if(temp==null){
            return false;
        }
                        
        if(origen.ari==null){
            origen.ari=temp;
        return true;
        }
        
        NodoA t2=origen.ari;
        
        while(t2.sig!=null){
            t2=t2.sig;
        }
        
        t2.sig=temp;
        temp.ant=t2;

        return false;
        
    }
    
    protected NodoG buscar(char x){
        NodoG temp= ini;
        do{
            if(temp.valor==x){
                return temp;
            }
            temp=temp.sig;
        }while(temp!=null);
        return temp;
    }
    
    protected boolean buscarA(NodoG temp,NodoG e){
        for(NodoA temp2=temp.ari;temp2!=null;temp=temp.sig){
            if(temp2.direccion==e){
               return true; 
            } 
        }
        return false;
    }
    
    public boolean popNodo(char x){
        if(ini==null && fin==null){
            return false;
        }
        
        NodoG e=buscar(x);
        if(e==null){
            return false;
        }
        
        //VERIFICA SI ES ISLA EL NODO A ELIMINAR
        if(e.ari!=null){
            return false;
        }
        
        for(NodoG temp=ini;temp!=null;temp=temp.sig){
            if(buscarA(temp,e)==true){
                return false;
            }
        }
        
        if(ini==fin && ini==e){
            ini=fin=null;
            return true;
        }
        
        if(ini==e){
            NodoG temp=ini.sig;
            ini.sig=null;
            temp.ant=null;
            ini=temp;
            return true;
        }
        
        if(fin==e){
            NodoG temp=fin.ant;
            temp.sig=null;
            fin.ant=null;
            fin=temp;
            return true;
        }
        
        e.ant.sig=e.sig;
        e.sig.ant=e.ant;
        e.sig=e.ant=null;
        return true;
    }
    
    public boolean popArista(char x,char y){
        NodoG origen=buscar(x);
        
        if(origen==null){
            return false;
        }
        
        if(origen.ari==null){
            return false;
        }
        
        NodoA temp=origen.ari;
        
        do{
            if(temp.direccion.valor==y){
                if(temp==origen.ari){
                    origen.ari=temp.sig;
                    temp.direccion=null;
                    temp.sig=null;
                    origen.ari.ant=null;
                    return true;
                }else{
                    if(temp.sig==null){
                        temp.ant.sig=null;
                        temp.direccion=null;
                        temp.ant=null;
                        return true;
                    }
                    
                    temp.ant.sig=temp.sig;
                    temp.sig.ant=temp.ant;
                    temp.sig=null;
                    temp.ant=null;
                    temp.direccion=null;
                    return true;
                }
            }
            temp=temp.sig;
        }while(temp!=null);

        return false;
    }
    
    public String mostrar(){
        if(ini==null && fin==null){
            return "LISTA VACIA";
        }
        return mostrar(ini);
    }
    
    private String mostrar(NodoG temp){
        if(temp==null){
            return"";
        }
        return temp.valor+" \n "+mostrar(temp.sig);
                
    }

}
