package com.printadmin.persistance.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.printadmin.entities.Machine;
import com.printadmin.persistance.db.Dbcontext;

public class MachineDAO {
    private String table= "machines";
//TODOCreate Machines
public void addMachine(Machine objMachine){
    String query=String.format("INSERT INTO %s(model,sn,state)VALUES(?,?,?);",table);
    try (
            Connection con= Dbcontext.getConeection();
            PreparedStatement statement = con.prepareStatement(query);
            ){
                statement.setString(1, objMachine.getModel());
                statement.setString(2, objMachine.getSn());
                statement.setBoolean(3,objMachine.isState() );
                statement.executeLargeUpdate();

        
    } catch (Exception e) {
        e.printStackTrace();
    }

}
//get all machines paginated(5 machines per page)
public List<Machine> GetAllMachines(){
    List<Machine> Machines= new ArrayList<>();
    String query=String.format("SELECT * FROM %s;",table);
    try (
        Connection con= Dbcontext.getConeection();
            Statement statement= con.createStatement();
            ResultSet resul=statement.executeQuery(query);
        ){
            while (resul.next()) 
            {
                Machine cli= new Machine(
                    resul.getInt("id"),
               resul.getString("model"),
               resul.getString("sn") ,
               resul.getBoolean("state"));
                
               Machines.add(cli);
            }
        
    } catch (Exception e) {
    }
     
    
    return Machines;
}
//update state to true/false(avaliable/rented)
public void editUser(int id,boolean bool){
    String alterUserQuery=  String.format("UPDATE %s SET state=? WHERE id=%d",table,id);
    try (
        Connection con= Dbcontext.getConeection();
        PreparedStatement statement = con.prepareStatement(alterUserQuery);
    ){
        statement.setBoolean(1, bool);
        statement.executeLargeUpdate();
        
    } catch (Exception e) {
        e.printStackTrace();
    }

}

//checks if a serial alredy exist
public boolean IsExisting(String serial){
    //TODOtestthsi
    boolean isThere= false;
    String query=String.format("SELECT EXISTS(SELECT 1 FROM %s WHERE sn LIKE ?);",table);
    try (
        Connection con= Dbcontext.getConeection();
            PreparedStatement statement= con.prepareStatement(query);
        ){
            statement.setString(1,"%" + serial + "%");
            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    isThere = result.getBoolean(1); // Lee el valor booleano de la primera columna
                }
            }
        
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    return isThere;

}
//TODOimport info from a excel
}
