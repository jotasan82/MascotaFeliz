/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Clases.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MdPago {
    DbData dbData;
    private int idPago;
    
    public MdPago(){
        this.dbData = new DbData();
    }
    
    public boolean crearPago(Pago p){
        try(Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())){
            String query = "INSERT INTO pago (fechaPago, numeroCuotas, idMascota, idPlan) VALUES (?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getFechaPago());
            statement.setInt(2, p.getNumeroCuotas());
            statement.setInt(3, p.getIdMascota());
            statement.setInt(4, p.getIdPlan());
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            return false;
        }
    }
    
    public Pago buscarPago(int cuota, int idFkMascota){
        Pago p = null;
        try(Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())){
            String consulta = "SELECT * FROM pago WHERE numeroCuotas = ? AND idMascota = ?";
            PreparedStatement statement = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, cuota);
            statement.setInt(2, idFkMascota);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                idPago = result.getInt(1);
                String fecha = result.getString(2);
                int numCuota = result.getInt(3);
                int idMascota = result.getInt(4);
                int idPlan = result.getInt(5);
                p = new Pago(fecha, numCuota, idMascota, idPlan);
            }
            return p;
        }catch(Exception e){
        }
        return p;
    }
    
    public boolean modificarPago(Pago p){
        try(Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())){
            String consulta = "UPDATE pago SET fechaPago = ?, numeroCuotas = ?, idMascota = ?, idPlan = ? WHERE idPago = ?";
            PreparedStatement statement = conn.prepareStatement(consulta);
            statement.setString(1, p.getFechaPago());
            statement.setInt(2, p.getNumeroCuotas());
            statement.setInt(3, p.getIdMascota());
            statement.setInt(4, p.getIdPlan());
            statement.setInt(5, idPago);
            int filasActualizadas = statement.executeUpdate();
            if(filasActualizadas > 0){
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }
    
    public boolean borrarPago(){
        try(Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())){
            String consulta = "DELETE FROM pago WHERE idPago = ?";
            PreparedStatement statement = conn.prepareStatement(consulta);
            statement.setInt(1, idPago);
            int filasActualizadas = statement.executeUpdate();
            if(filasActualizadas > 0){
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
