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


public class MdMascota {
    DbData dbData;
    
    public MdMascota(){
        this.dbData = new DbData();
    }
    
    public boolean crearMascota(Mascota m){
        try(Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())){
            String query ="INSERT INTO mascota (codigo, nombre, annioNac, peso, especie, idCliente) VALUES (?,?,?,?,?,?);";
            PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, m.getCodigo());
            statement.setString(2, m.getNombre());
            statement.setInt(3, m.getAnnioNac());
            statement.setDouble(4, m.getPeso());
            statement.setString(5, m.getEspecie());
            statement.setInt(6, m.getIdCliente());
            int filasInsertadas = statement.executeUpdate();
            if(filasInsertadas > 0){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            return false;
        }
    }
    
}
