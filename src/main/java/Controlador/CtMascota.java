/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.*;
import Modelo.MdMascota;
import java.util.LinkedList;
import javax.swing.JComboBox;


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
    
    public boolean modificarMascota(Mascota m){
       return this.MdMascota.modificarMascota(m);
    }
    
    public boolean borrarMascota(Mascota m){
       return this.MdMascota.borrarMascota(m);
    }
    
    public LinkedList<Mascota> listarTodasMascotas(){
       LinkedList<Mascota> resultado = new LinkedList();
       try{
           resultado = this.MdMascota.buscarTodasMascotas();
       }catch(Exception e){
           
       }
       return resultado;
   }
   
   public int obtenerIdPKMascotaComboBox(LinkedList<Mascota> ma, JComboBox cbMascota){
       //guardo la posición del comboBox con lo que selecciono el usuario
       int indiceComboMascota = -1;
       indiceComboMascota = cbMascota.getSelectedIndex();
       
       int idPKMascota = -1;//variable para almacenar la PK del Cliente, si no selecciona nada toma el valor de -1
       int indiceListaMascota = -1; //var para comparar la lista con el combo
       
       /*Pregunto si hay algo seleccionado en el combo, si el #elementos de la lista es mayor que el indice del combo
       y si los nombres del combo y la lista son iguales
       */
       if(indiceComboMascota >= 0 && ma.size() > indiceComboMascota && cbMascota.getSelectedItem().toString().equals(ma.get(indiceComboMascota).getNombre())){
           indiceListaMascota = indiceComboMascota; //guardo el valor del indice del combo el indicelista
           
           //en idPKCliente guardo lo que tiene la lista en la posicion indiceListaCliente y llevo el id_cliente
           idPKMascota = ma.get(indiceListaMascota).getIdPK();
       }
       return idPKMascota;
   }
}
