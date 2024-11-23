package com.printadmin.controllers;

import java.util.List;

import com.printadmin.entities.Client;
import com.printadmin.persistance.DAO.ClientDAO;

public class ClinetController {
    private ClientDAO ClientDAO;
    public ClinetController(){
        ClientDAO= new ClientDAO();
    }
    //create Client
    public String CreateClient(String name, String last_name, String email, String dir){
        Client NewClient= new Client(name, last_name, email, dir);
        if (!NewClient.CheckEmpty()) {
            
            this.ClientDAO.addClient(NewClient);
                return "Cliente agregado con exito";
        }

        return "Imposible crear cliente, campos incompletos";
        

    }
    
    //See all clients
    public List<Client> ShowClients(){
        if(this.ClientDAO.GetAllClients().isEmpty()){ return  null; }

        return this.ClientDAO.GetAllClients();
    }
}
