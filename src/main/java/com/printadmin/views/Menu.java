package com.printadmin.views;

import java.util.Scanner;

public class Menu {
        public Scanner sc = new Scanner(System.in);

    public void Menu(){
        int opcion;

    
        do{
            System.out.println("""
            === Bienvenido===
            1. maquinas
            2. clientes
            3.
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
                
            break;
    
                case 2:

                break;

            case 5:
                System.out.println("Saliendo del programa...");
                break;

            default:
                System.out.println("Opción no válida. Intente nuevamente.");
        }
        }

}
