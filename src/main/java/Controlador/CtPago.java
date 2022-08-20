/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.*;
import Modelo.MdPago;

public class CtPago {
    MdPago MdPago;
    
    public CtPago(){
        this.MdPago = new MdPago();
    }
    
    public boolean crearPago(Pago p){
       try{
           this.MdPago.crearPago(p);
       }catch (Exception e){
           return false;
       }
       return true;
    }
    
    public Pago buscarPago(int cuota, int idFkMascota){
       Pago p = null;
       p = this.MdPago.buscarPago(cuota, idFkMascota);
       return p;
    }
}