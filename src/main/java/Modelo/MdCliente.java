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
/**
 *
 * @author pixel
 */
public class MdCliente {
    DbData dbData;
    
    public MdCliente(){
        this.dbData = new DbData();
    }
    
    public boolean crearCliente(Cliente c){
        try(Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())){
            String query = "INSERT INTO cliente (identificacion, nombres, apellidos, direccion, telefono) VALUES (?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, c.getIdentificacion());
            statement.setString(2, c.getNombre());
            statement.setString(3, c.getApellido());
            statement.setString(4, c.getDireccion());
            statement.setString(5, c.getTelefono());
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
    
    public Cliente buscarCliente(String identificacion){
        Cliente c = null;
        try(Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())){
            String consulta = "SELECT * FROM cliente AS c WHERE c.identificacion = ?";
            PreparedStatement statement = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, identificacion);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                String iden = result.getString(2);
                String nombre = result.getString(3);
                String apellido = result.getString(4);
                String direccion = result.getString(5);
                String telefono = result.getString(6);
                c = new Cliente(iden, nombre, apellido, direccion, telefono);
            }
            return c;
        }catch(Exception e){
        }
        return c;
    }
    
    public boolean actualizarCliente(Cliente c){
        try(Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())){
            String consulta = "UPDATE cliente SET nombres = ?, apellidos = ?, direccion = ?, telefono = ? WHERE identificacion = ?";
            PreparedStatement statement = conn.prepareStatement(consulta);
            statement.setString(1, c.getNombre());
            statement.setString(2, c.getApellido());
            statement.setString(3, c.getDireccion());
            statement.setString(4, c.getTelefono());
            statement.setString(5, c.getIdentificacion());
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
    
    public boolean borrarCliente(Cliente c){
        try(Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())){
            String consulta = "DELETE FROM cliente WHERE identificacion = ?";
            PreparedStatement statement = conn.prepareStatement(consulta);
            statement.setString(1, c.getIdentificacion());
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
    
    public LinkedList<Cliente> buscarTodosClientes(){
        LinkedList<Cliente> listaClientes = new LinkedList<>();
        try(Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())){
            String consulta = "SELECT * FROM cliente";
            PreparedStatement statement = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                int idPK = result.getInt(1);
                String iden = result.getString(2);
                String nombre = result.getString(3);
                String apellido = result.getString(4);
                String direccion = result.getString(5);
                String telefono = result.getString(6);
                Cliente c = new Cliente(iden, nombre, apellido, direccion, telefono);
                c.setIdPK(idPK);
                listaClientes.add(c);
            }
            return listaClientes;
        }catch(Exception e){
        }
        return listaClientes;
    }
}
