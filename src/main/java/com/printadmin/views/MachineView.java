package com.printadmin.views;

import java.util.List;
import java.util.Scanner;

import com.printadmin.controllers.MachineController;
import com.printadmin.entities.Machine;

public class MachineView {
    MachineController machineController;
    public MachineView(){
        machineController=new MachineController();
    }
    
   public Scanner sc = new Scanner(System.in);


    public void Menu(){
        int opcion;

    
        do{
            System.out.println("""
            === Maquinas ===
            1. importar de archivo
            2. crear nuevo
            3. ver todas las maquinas
            5. Salir
            Seleccione una opción: """);
            opcion = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea
            this.option(opcion);
            
        } while (opcion != 5);
    
        sc.close();
        }
        public void option(int opcion){
            switch (opcion) {
                case 1:
                importExcel();
            break;
    
                case 2:
                CreateMachine();

                break;
                case 3:
                listMachines();

                break;

            case 5:
                System.out.println("Saliendo del programa...");
                break;

            default:
                System.out.println("Opción no válida. Intente nuevamente.");
        }
        }

    public String CreateMachine(){
        System.out.print("serial:");
        String sn= sc.nextLine();
        System.out.print("modelo:");
        String model= sc.nextLine();
        if (sn.isEmpty() || model.isEmpty()) {
            return "imposible crear";
            
        }else{
            machineController.CreateMachine(model, sn);
            return "creado con exito";

        }
        
    }
    public void listMachines(){
        List<Machine> mc= this.machineController.ShowAll();
        for (Machine machi : mc) {
            System.out.println(machi.toString());
        }
        Menu();
    }
    public void importExcel(){
        System.out.print("ruta:");
        String file= sc.nextLine();
        System.out.print("hoja dentro de la ruta:");
        String sheet= sc.nextLine();
        this.machineController.FromExcel(file, sheet);
    }

}
