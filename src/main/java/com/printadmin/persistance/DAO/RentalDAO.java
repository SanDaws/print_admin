package com.printadmin.persistance.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.printadmin.entities.Rental;
import com.printadmin.persistance.db.Dbcontext;

public class RentalDAO {
    private String table= "rentals";
    //create rental
    public void addRental(Rental objRental){
    String query=String.format("INSERT INTO %s(start_date,end_date,state,clients_id,machines_id)VALUES(?,?,?,?,?);",table);
    try (
            Connection con= Dbcontext.getConeection();
            PreparedStatement statement = con.prepareStatement(query);
            ){
                statement.setDate(1, java.sql.Date.valueOf(objRental.getStarDate()));
                statement.setDate(2, java.sql.Date.valueOf(objRental.getEndDate()));
                statement.setBoolean(3,objRental.isState() );
                statement.setInt(4, objRental.getClient_id());
                statement.setInt(5, objRental.getMachine_id());

                statement.executeLargeUpdate();

        
    } catch (Exception e) {
        e.printStackTrace();
    }

}
    //show all the rentasl only active / inactive
    public List<Rental> getRentals(boolean  election){//true/false(only active/all)
        String query;
        if (election) {
            //TODOjoin tables client(email) and machine(sn) names
            query=String.format("SELECT * FROM %s WHERE state = 1;",table);
        }else{
            //TODOjoin tables client(email) and machine(sn) names
            query=String.format("SELECT * FROM %s ORDER BY state;",table);
        }
        List<Rental> rentals= new ArrayList<>();
   
    try (
        Connection con= Dbcontext.getConeection();
            Statement statement= con.createStatement();
            ResultSet resul=statement.executeQuery(query);
        ){
            while (resul.next()) 
            {
                LocalDate satr_date= resul.getDate("start_date").toLocalDate();
                LocalDate end_date= resul.getDate("end_date").toLocalDate();
                Rental cli= new Rental(
                    satr_date,
               end_date,
               resul.getBoolean("state"),
               resul.getInt("clients_id"),
               resul.getInt("machines_id")
               );

                
               rentals.add(cli);
            }
        
    } catch (Exception e) {
        e.printStackTrace();
    }
     
    
    return rentals;
    }
//update state to true/false(active/disable)
    //
    public void editRental(int id,boolean bool){
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

}
