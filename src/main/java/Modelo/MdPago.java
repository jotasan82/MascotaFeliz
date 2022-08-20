/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Clases.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class MdPago {
    DbData dbData;
    
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
}
