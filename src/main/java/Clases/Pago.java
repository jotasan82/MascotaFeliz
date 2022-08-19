/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Pixel
 */
public class Pago {
    private String fechaPago;
    private int numeroCuotas;
    private int idMascota;
    private int idPlan;

    public Pago(String fechaPago, int numeroCuotas, int idMascota, int idPlan) {
        this.fechaPago = fechaPago;
        this.numeroCuotas = numeroCuotas;
        this.idMascota = idMascota;
        this.idPlan = idPlan;
    }
    
    

    /**
     * @return the fechaPago
     */
    public String getFechaPago() {
        return fechaPago;
    }

    /**
     * @param fechaPago the fechaPago to set
     */
    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    /**
     * @return the numeroCuotas
     */
    public int getNumeroCuotas() {
        return numeroCuotas;
    }

    /**
     * @param numeroCuotas the numeroCuotas to set
     */
    public void setNumeroCuotas(int numeroCuotas) {
        this.numeroCuotas = numeroCuotas;
    }

    /**
     * @return the idMascota
     */
    public int getIdMascota() {
        return idMascota;
    }

    /**
     * @param idMascota the idMascota to set
     */
    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    /**
     * @return the idPlan
     */
    public int getIdPlan() {
        return idPlan;
    }

    /**
     * @param idPlan the idPlan to set
     */
    public void setIdPlan(int idPlan) {
        this.idPlan = idPlan;
    }
}
