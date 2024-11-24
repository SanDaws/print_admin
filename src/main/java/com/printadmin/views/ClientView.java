package com.printadmin.views;

import java.util.List;
import java.util.Scanner;

import com.printadmin.controllers.ClinetController;
import com.printadmin.entities.Client;

public class ClientView {
    ClinetController ClinetController;
    public Scanner sc = new Scanner(System.in);
    public ClientView(){
        ClinetController= new ClinetController();
    }

        public void Menu(){
            int opcion;
    
        
            do{
                System.out.println("""
                === cliente ===
                1. Nuevo cliente
                2. Ver Clientes
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
                    CreateClient();
                break;
        
                    case 2:
                    ShowClients();
                    
    
                    break;

    
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
    
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
            }
            public void CreateClient(){
                //name
                System.out.print("Name:");
                String name = sc.nextLine();
                //lastname

                System.out.print("LastName:");
                String LastName = sc.nextLine();
                //email

                System.out.print("email:");
                String email = sc.nextLine();
                //direccion

                System.out.print("direccion:");
                String dir = sc.nextLine();
                
                String creation=this.ClinetController.CreateClient(name, LastName, email, dir);
                System.out.println(creation);
            }
        public void ShowClients(){
            if(this.ClinetController.ShowClients() != null){
                List<Client> clients=this.ClinetController.ShowClients();
                for (Client cli: clients) {
                    System.out.println(cli.toString());
                }
            }
            System.out.println("No hay usuarios existentes");
        }

    


}
