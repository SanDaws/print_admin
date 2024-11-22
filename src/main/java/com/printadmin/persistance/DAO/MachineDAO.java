package com.printadmin.persistance.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

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

        
    } catch (Exception e) {
    }

}
//TODOget all machines paginated(5 machines per page)
//TODOupdate state to true/false(avaliable/rented)
//TODOimport info from a excel
//TODOchecks if a serial alredy exist 
}
