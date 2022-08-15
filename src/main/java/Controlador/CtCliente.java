/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.*;
import Modelo.MdCliente;

/**
 *
 * @author pixel
 */
public class CtCliente {
   MdCliente MdCliente;
   
   public CtCliente(){
       this.MdCliente = new MdCliente();
   }
   
   public boolean crearCliente(Cliente c){
       try{
           this.MdCliente.crearCliente(c);
       }catch (Exception e){
           return false;
       }
       return true;
   }
   
   public Cliente buscarCliente(String identificacion){
       Cliente c = null;
       c = this.MdCliente.buscarCliente(identificacion);
       return c;
   }
   
   public boolean actualizarCliente(Cliente c){
       return this.MdCliente.actualizarCliente(c);
   }
   
   public boolean borrarCliente(Cliente c){
       return this.MdCliente.borrarCliente(c);
   }
}
