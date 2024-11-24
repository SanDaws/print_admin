package com.printadmin.controllers;

import java.time.LocalDate;
import java.util.List;

import com.printadmin.entities.Rental;
import com.printadmin.persistance.DAO.RentalDAO;

public class RentalController {
    
    private RentalDAO RentalDAO;

    public RentalController() {
        RentalDAO = new  RentalDAO();
    }
    //TODOadd machines
    public void CreateRental(String starDate, String endDate, boolean state, int client_id, int machine_id){
        LocalDate StarDate= LocalDate.parse(starDate);
        LocalDate EndDate= LocalDate.parse(endDate);
        Rental rent= new Rental(StarDate, EndDate, client_id, machine_id);
        this.RentalDAO.addRental(rent);

    }
    //TODOshow all the rentasl only active / inactive
    public List<Rental> Show(boolean option){
        if (this.RentalDAO.getRentals(false).isEmpty()) {return null;}
        return this.RentalDAO.getRentals(option);


    }

    //TODOupdate state to true/false(active/disable)




    
}
