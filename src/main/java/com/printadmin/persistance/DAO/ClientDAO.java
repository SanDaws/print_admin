package com.printadmin.persistance.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.printadmin.entities.Client;
import com.printadmin.persistance.db.Dbcontext;

public class ClientDAO {
    private String table= "clients";
//create new clients
public void addClient(Client objClient){
    String query=String.format("INSERT INTO %s(name,last_name,email,dir)VALUES(?,?,?,?);",table);
    try (
            Connection con= Dbcontext.getConeection();
            PreparedStatement statement = con.prepareStatement(query);
            ){
                statement.setString(1, objClient.getName());
                statement.setString(2, objClient.getLast_name());
                statement.setString(3, objClient.getEmail());
                statement.setString(4, objClient.getDir());
                
                statement.executeLargeUpdate();
        
    } catch (Exception e) {
        e.printStackTrace();
    }

}
//see all clients
public List<Client> GetAllClients(){
    List<Client> ListClient=new ArrayList<Client>();
    String query=String.format("SELECT * FROM %s;",table);
    try (
        Connection con= Dbcontext.getConeection();
            Statement statement= con.createStatement();
            ResultSet resul=statement.executeQuery(query);
        ){
            while (resul.next()) 
            {
                Client cli= new Client(
                    resul.getInt("id"),
               resul.getString("name"),
               resul.getString("last_name") ,
               resul.getString("email"),
               resul.getString("dir"));
                
               ListClient.add(cli);
            }
        
    } catch (Exception e) {
        e.printStackTrace();
    }
    return  ListClient;
}
}
