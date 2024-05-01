/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_unidad3.Bancos;

import examen_unidad3.Users.Capturista;
import examen_unidad3.Users.Cliente;
import examen_unidad3.Users.Gerente;
import java.util.ArrayList;
import java.util.Scanner;

import examen_unidad3.Users.Usuario;
import examen_unidad3.recursosGlobales.Estados;
import examen_unidad3.recursosGlobales.Sucursal;

/**
 *
 * @author leila_pe8dh8w
 */
public class Sistema {
    Scanner leer = new Scanner (System.in);
    static ArrayList<String> RFCList = new ArrayList<>();
    private final String CLAVE = "Cangreburguer7391";
    Gerente gerenteMadero = new Gerente("Maite", "Hernandez", "Muñoz", "2000-20-09", "Morelia", "Michoacan","Mujer","HEMUM000920MIC09", "Av. Hidalgo", 200000.90, Sucursal.MADERO, "HDKSJHJDC");
    Gerente gerenteAcueducto = new Gerente("Liam", "Lopez", "Perez", "1985-22-10", "Morelia", "Aguascalientes","Hombre","LOPEL851022HAGU07", "Av. Morelos", 200000.90, Sucursal.ACUEDUCTO, "FNHDSJSD");
    
    public void iniciarPrograma() {
        boolean claveValida = false;
        do {
            System.out.print("\nIngrese la contraseña del sistema: ");
            String clave = leer.nextLine();
            if (validarClave(clave)) {
                claveValida = true;
                Menus.menuCapturista();
            }
            else {
                System.out.println("Clave inválida, intenta de nuevo.");
            }
        } while (!claveValida);
    }
    
    
public static String generateRFC ( String name, String fatherLastName, String motherLastName,
                                       String fechaDeNacimiento){
        try {
            String nombre = name.substring(0, 2);
            String lastNameFather = fatherLastName.substring(0, 2);
            String lastNameMother = motherLastName.substring(0, 2);
            String añoNacimiento = fechaDeNacimiento.substring(2, 4);
            String mesNacimiento = fechaDeNacimiento.substring(5, 7);
            String diaNacimiento = fechaDeNacimiento.substring(8, 10);
            String newRFC = nombre + lastNameFather + lastNameMother + añoNacimiento + mesNacimiento +
                    diaNacimiento + "POO3";
            return newRFC;
        } catch (Exception e) {
            System.out.println("No fue posible generar su RFC. Ingrese los datos completos");
        }
        return null;
    }
    private boolean validarClave(String clave) {
        return clave.equals(CLAVE);
    }

   public static boolean validarRFC (String RFC){            
   while (RFCList.contains(RFC)) {    
   System.out.println();         
   System.out.println("Usuario existente en sistema.");             
   return false;          
   }       
    return true; 
   }
   
   
    public void registerClient(){
        Cliente.registerClient();
    }

    
    public static String generarCurp(String name, String fatherLastName, String motherLastName,
                                 String fechaDeNacimiento, String sexo, String estado) {
    try {
        String nombre = name.substring(0, 1);
        String apellidoPaterno = fatherLastName.substring(0, 2);
        String apellidoMaterno = motherLastName.substring(0, 2);
        String añoNacimiento = fechaDeNacimiento.substring(2, 4);
        String mesNacimiento = fechaDeNacimiento.substring(8, 10);
        String diaNacimiento = fechaDeNacimiento.substring(5, 7);
        String Sexo = sexo.substring(0, 1);
        
        // Obtener abreviatura del estado
        String estadoAbreviatura = obtenerAbreviaturaEstado(estado);
        
        // Generar CURP
        String newCURP = apellidoPaterno + apellidoMaterno + nombre + 
                         añoNacimiento + mesNacimiento + diaNacimiento +
                         Sexo + estadoAbreviatura;

        return newCURP.toUpperCase();
    } catch (Exception e) {
        System.out.println("No fue posible generar su CURP. Ingrese los datos completos");
        return null;
    }
}

    
    private static String obtenerAbreviaturaEstado(String estado) {
    for (Estados entidad : Estados.values()) {
        if (entidad.getNombre().equalsIgnoreCase(estado)) {
            return entidad.getAbreviatura();
        }
    }
    return ""; 
}
    }

