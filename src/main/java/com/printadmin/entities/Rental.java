package com.printadmin.entities;

import java.time.LocalDate;

public class Rental {
    //define rental entity
    private int id;
    private LocalDate starDate;
    private LocalDate endDate;
    private boolean  state;
    private int client_id;
    private int machine_id;
    //objects required
    private Client clientFK;
    private Machine MachineFK;
    
    private Rental(){}
    
    public Rental(LocalDate starDate, LocalDate endDate, boolean state, int client_id, int machine_id) {//creation
        this.starDate = starDate;
        this.endDate = endDate;
        this.state = state;
            this.client_id = client_id;
            this.machine_id = machine_id;
        }
        public Rental(int id, LocalDate starDate, LocalDate endDate, boolean state, int client_id, int machine_id) {// recieve
            this.id = id;
            this.starDate = starDate;
            this.endDate = endDate;
            this.state = state;
            this.client_id = client_id;
            this.machine_id = machine_id;
        }
        
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public LocalDate getStarDate() {
    return starDate;
}
public void setStarDate(LocalDate starDate) {
    this.starDate = starDate;
}
public LocalDate getEndDate() {
    return endDate;
}

public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
}

public String isState() {
    return (state==true)?"activo":"desactivado";
}
public void setState(boolean state) {
    this.state = state;
}
public int getClient_id() {
    return client_id;
}
public void setClient_id(int client_id) {
    this.client_id = client_id;
}
public int getMachine_id() {
    return machine_id;
}
public void setMachine_id(int machine_id) {
    this.machine_id = machine_id;
}



@Override
public String toString() {
    return "id=" + id + ", starDate=" + starDate + ", endDate=" + endDate + ", client_id=" + client_id
            + ", machine_id=" + machine_id + ", state=" + isState() ;
}




}
