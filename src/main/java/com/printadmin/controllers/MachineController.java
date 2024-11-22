package com.printadmin.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.printadmin.entities.Machine;
import com.printadmin.persistance.DAO.MachineDAO;

public class MachineController {
    private MachineDAO machineDAO;
    public MachineController(){
        machineDAO=new MachineDAO();
    }

    
    //create Machines
    public String CreateMachine(String model, String sn){
        boolean exist= this.machineDAO.IsExisting(sn);
        if (!exist) {
            Machine newMachine= new Machine(model, sn);
        this.machineDAO.addMachine(newMachine);
        return "Creacion Exitosa";
        }else{
            return "Serial Ya existente, rectifique";
        }
    }
    //Get all machiens
    public List<Machine> ShowAll(){
        return  this.machineDAO.GetAllMachines();

    }
    //updatestate
    public String updateMachine(int id, boolean  state){
        
        this.machineDAO.MachineState(id, state);
        return "Edicion Exitosa";
    }
    //import info from a excel
    public void FromExcel(String Path,String sheet){
        try (
            FileInputStream file=new FileInputStream(new File(Path));
            Workbook wb= WorkbookFactory.create(file);
            ){
            Sheet sheete = wb.getSheet(sheet);
            for (Row row : sheete) {
                Cell model= row.getCell(0);
                Cell sn= row.getCell(1);
                Machine newMachine= new Machine(model.toString(), sn.toString());
                
            }

            

        } catch (Exception e) {
            System.out.println("Archivo no encontrado, o hoja inexistente");
            e.printStackTrace();
        }

    }
}
