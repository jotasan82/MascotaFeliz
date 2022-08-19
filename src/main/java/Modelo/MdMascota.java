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
import java.util.LinkedList;


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
            statement.setInt(4, m.getPeso());
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
    
    public Mascota buscarMascota(String codigo){
        Mascota m = null;
        try(Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())){
            String consulta = "SELECT * FROM mascota WHERE codigo = ?";
            PreparedStatement statement = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, codigo);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                String cod = result.getString(2);
                String nombre = result.getString(3);
                int annioNac = result.getInt(4);
                int peso = result.getInt(5);
                String especie = result.getString(6);
                int idCliente = result.getInt(7);
                m = new Mascota(cod, nombre, annioNac, peso, especie, idCliente);
            }
            return m;
        }catch(Exception e){
        }
        return m;
    }
    
    public boolean modificarMascota(Mascota m){
        try(Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())){
            String consulta = "UPDATE mascota SET nombre = ?, annioNac = ?, peso = ?, especie = ?, idCliente = ? WHERE codigo = ?";
            PreparedStatement statement = conn.prepareStatement(consulta);
            statement.setString(1, m.getNombre());
            statement.setInt(2, m.getAnnioNac());
            statement.setInt(3, m.getPeso());
            statement.setString(4, m.getEspecie());
            statement.setInt(5, m.getIdCliente());
            statement.setString(6, m.getCodigo());
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
    
    public boolean borrarMascota(Mascota m){
        try(Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())){
            String consulta = "DELETE FROM mascota WHERE codigo = ?";
            PreparedStatement statement = conn.prepareStatement(consulta);
            statement.setString(1, m.getCodigo());
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
    
    public LinkedList<Mascota> buscarTodasMascotas(){
        LinkedList<Mascota> listaMascotas = new LinkedList<>();
        try(Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())){
            String consulta = "SELECT * FROM mascota";
            PreparedStatement statement = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                int idPK = result.getInt(1);
                String codigo = result.getString(2);
                String nombre = result.getString(3);
                int annioNac = result.getInt(4);
                int peso = result.getInt(5);
                String especie = result.getString(6);
                int idCliente = result.getInt(7);
                Mascota m = new Mascota(codigo, nombre, annioNac, peso, especie, idCliente);
                m.setIdPK(idPK);
                listaMascotas.add(m);
            }
            return listaMascotas;
        }catch(Exception e){
        }
        return listaMascotas;
    }   
}
