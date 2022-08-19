/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.*;
import Modelo.MdPlan;
import java.util.LinkedList;
import javax.swing.JComboBox;
/**
 *
 * @author Pixel
 */
public class CtPlan {
    MdPlan MdPlan;
    
    public CtPlan(){
        this.MdPlan = new MdPlan();
    }
    
    public boolean crearPlan(Plan p){
        try{
            this.MdPlan.crearPlan(p);
        }catch (Exception e){
            return false;
        }
        return true;
    }
    
    public Plan buscarPlan(String codigo){
        Plan p = null;
        p = this.MdPlan.buscarPlan(codigo);
        return p;
    }
    
    public boolean actualizarPlan(Plan p){
        return this.MdPlan.actualizarPlan(p);
    }
    
    public boolean borrarPlan(Plan p){
        return this.MdPlan.borrarPlan(p);
    }
    
    public LinkedList<Plan> listarTodosPlanes(){
       LinkedList<Plan> resultado = new LinkedList();
       try{
           resultado = this.MdPlan.buscarTodosPlanes();
       }catch(Exception e){
           
       }
       return resultado;
   }
   
   public int obtenerIdPKPlanComboBox(LinkedList<Plan> pl, JComboBox cbPlan){
       //guardo la posición del comboBox con lo que selecciono el usuario
       int indiceComboPlan = -1;
       indiceComboPlan = cbPlan.getSelectedIndex();
       
       int idPKPlan = -1;//variable para almacenar la PK del Cliente, si no selecciona nada toma el valor de -1
       int indiceListaPlan = -1; //var para comparar la lista con el combo
       
       /*Pregunto si hay algo seleccionado en el combo, si el #elementos de la lista es mayor que el indice del combo
       y si los nombres del combo y la lista son iguales
       */
       if(indiceComboPlan >= 0 && pl.size() > indiceComboPlan && cbPlan.getSelectedItem().toString().equals(pl.get(indiceComboPlan).getNombre())){
           indiceListaPlan = indiceComboPlan; //guardo el valor del indice del combo el indicelista
           
           //en idPKCliente guardo lo que tiene la lista en la posicion indiceListaCliente y llevo el id_cliente
           idPKPlan = pl.get(indiceListaPlan).getIdPK();
       }
       return idPKPlan;
   }
}
