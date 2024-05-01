/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_unidad3.Bancos;

import examen_unidad3.Users.Capturista;
import examen_unidad3.Users.Cliente;
import examen_unidad3.Users.EjecutivoVentas;
import examen_unidad3.Users.Inversionista;

import java.util.Scanner;

/**
 *
 * @author leila_pe8dh8w
 */

    public class Menus
{
 
    Scanner leer = new Scanner(System.in);
    
    
    public static void menuGerente() {
        Scanner leer = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n\t***Menu de Gerente****");
            System.out.println("1) Registrar cliente.");
            System.out.println("2) Mostrar lista de clientes");
            System.out.println("3) Modificar clientes");
            System.out.println("4) Eliminar clientes");
            System.out.println("5) Registrar ejecutivo de venta.");
            System.out.println("6) Mostrar lista de ejecutivos de cuenta");
            System.out.println("7) Modificar ejecutivo de cuenta");
            System.out.println("8) Eliminar ejecutivo de cuenta");
            System.out.println("9) Registrar capturista");
            System.out.println("10) Mostrar lista de capturistas");
            System.out.println("11) Modificar capturista");
            System.out.println("12) Eliminar capturista");
            System.out.println("13) Registrar inversionista");
            System.out.println("14) Mostrar lista de inversionistas");
            System.out.println("15) Modificar inversionista");
            System.out.println("16) Eliminar inversionista");
            System.out.println("17) Ver solicitudes de tarjetas");
            System.out.println("18) Autorizar / rechazar solicitudes de tarjetas.");
            System.out.println("19) Consultar movimientos de inversionistas");
            System.out.println("20) Cerrar sesión.");
            
            System.out.println("\nAcción a realizar: ");
            opcion = leer.nextInt();
            
            switch (opcion) 
            {
                case 1:
                    Cliente.registerClient();
                    break;
                    
                case 2:

                    break;
                    
                case 3:
                    Cliente.modificarCliente();
                    break;
                    
                case 4:
                    break;
                    
                case 5:
                    EjecutivoVentas.registrarEjecutivoVentas();
                    break;
                    
                case 6:
                    break;
                    
                case 7:
                    EjecutivoVentas.modificarEjecutivo();
                    break;
                    
                case 9:
                    Capturista.registerCapturista();
                    break;
                    
                case 10: 
                    break;
                    
                case 11:
                    Capturista.modificarCapturista();
                    break;
                    
                case 12:
                    break;
                    
                case 13:
                    Inversionista.registrarInversionista();
                    break;
                    
                case 14:
                    break;
                    
                case 15:
                    Inversionista.modificarInversionista();
                    break;
                    
                case 16:
                    break;

                case 17:
                    break;

                case 18:
                    break;

                case 19:
                    break;

                case 20:
                    break;
                default: System.out.println("\nOpción no válida");
            }
        } while (opcion != 15);
    }
    
    
    public static void menuCapturista() {
        Scanner leer = new Scanner(System.in);
        int opcion;
        
        do 
        {
            System.out.println("\n\t***Menu de capturista****");
            System.out.println("1) Registrar ejecutivo de venta.");
            System.out.println("2) Mostrar lista de ejecutivos de cuenta");
            System.out.println("3) Modificar ejecutivo de cuenta");
            System.out.println("4) Eliminar ejecutivo de cuenta");
            
            System.out.println("\nAcción a realizar: ");
            opcion = leer.nextInt();
            switch (opcion) 
            {
                
                case 1:
                    Cliente.registerClient();
                    break;
                    
                case 2:
                    break;
                    
                case 3:
                    break;
                    
                case 4:
                    break;
                    
                case 5:
                    break;
                    
                default: System.out.println("\nOpción no válida");
            }
        } while (opcion != 5);
    }
    
    public static void menuEjecutivoCuenta() {
        Scanner leer = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n\t***Menu de ejecutivo de cuenta****");
            System.out.println("1) Registrar cliente.");
            System.out.println("2) Mostrar lista de clientes");
            System.out.println("3) Modificar clientes");
            System.out.println("4) Eliminar clientes");
            System.out.println("5) Cerrar sesión.");
            
            System.out.println("\nAcción a realizar: ");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    Cliente.registerClient();
                    break;
                    
                case 2:
                    break;
                    
                case 3:
                    break;
                    
                case 4:
                    break;
                    
                case 5:
                    break;
                    
                default: System.out.println("\nOpción no válida");
            }
        } while (opcion != 5);
    }
    
    public static void menuCliente() {
        Scanner leer = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n\t***Menu de cliente****");
            System.out.println("1) Ver información.");
            System.out.println("2) Ver fondos");
            System.out.println("3) Solicitar tarjeta");
            System.out.println("4) Ver solicitudes");
            System.out.println("5) Cerrar sesión.");
            
            System.out.println("\nAcción a realizar: ");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    Cliente.registerClient();
                    break;
                    
                case 2:
                    break;
                    
                case 3:
                    break;
                    
                case 4:
                    break;
                    
                case 5:
                    break;
                    
                case 6:
                    break;
                    
                default: System.out.println("\nOpción no válida");
            }
        } while (opcion != 6);
    }
    
    
    public static void menuInversionista() 
    {
        Scanner leer = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("\n\t***Menu de cliente****");
            System.out.println("1) Ver información.");
            System.out.println("2) Ver fondos de inversión");
            System.out.println("3) Realizar fondo de inversión");
            System.out.println("4) Cerrar sesión.");
            
            System.out.println("\nAcción a realizar: ");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    Cliente.registerClient();
                    break;
                    
                case 2:
                    break;
                    
                case 3:
                    break;
                    
                case 4:
                    break;
                    
                case 5:
                    break;
                    
                default: System.out.println("\nOpción no válida");
            }
        } while (opcion != 5);
    }
    
}
