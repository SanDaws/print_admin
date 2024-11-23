package com.printadmin.entities;

public class Client {
    
    //defines client entity
    private int id;
    private String name;
    private  String lastName;
    private String email;
    private String dir;
    
    public Client() {// for foreing key
    }
    
    public Client(int id, String name, String last_name, String email, String dir) {
        this.id = id;
        this.name = name;
        this.lastName = last_name;
        this.email = email;
        this.dir = dir;
    }
    public Client(String name, String last_name, String email, String dir) {
        this.name = name;
        this.lastName = last_name;
        this.email = email;
        this.dir = dir;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLast_name() {
        return lastName;
    }
    public void setLast_name(String last_name) {
        this.lastName = last_name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDir() {
        return dir;
    }
    public void setDir(String dir) {
        this.dir = dir;
    }
    public boolean CheckEmpty(){
        return  name == null || name.isEmpty() ||
               lastName == null || lastName.isEmpty() ||
               email == null || email.isEmpty() ||
               dir == null || dir.isEmpty();
    }


    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", last_name=" + lastName + ", email=" + email + ", dir=" + dir;
    }

}
