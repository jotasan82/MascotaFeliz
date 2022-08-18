/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.*;
import Modelo.MdMascota;


public class CtMascota {
    MdMascota MdMascota;
    
    public CtMascota(){
        this.MdMascota = new MdMascota();
    }
    
    public boolean crearMascota(Mascota m){
        try{
            this.MdMascota.crearMascota(m);
        }catch(Exception e){
            return false;
        }
        return true;
    }
    
    public Mascota buscarMascota(String codigo){
       Mascota m = null;
       m = this.MdMascota.buscarMascota(codigo);
       return m;
   }
}
