/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_unidad3.Users;

import examen_unidad3.Bancos.Sistema;
import examen_unidad3.recursosGlobales.Rol;

import java.util.ArrayList;

/**
 *
 * @author leila_pe8dh8w
 */
import java.util.Scanner;

public class Capturista extends Usuario
{
    public Capturista(String name, String motherLastName, String fatherLastName, String fechaDeNacimiento, String city, String estado, String CURP, String direccion, Rol userRol, double salary, String RFC)
    {
        super(name, motherLastName, fatherLastName, fechaDeNacimiento, city, estado, CURP, direccion, userRol, salary, RFC);
    }
    public static void registerCapturista(){
        Scanner leer = new Scanner (System.in);
        ArrayList<String> datosComun = Usuario.registerUser(Rol.CLIENTE);
        String nameClient = datosComun.get(0);
        String fatherLastNameCapturista = datosComun.get(1);
        String motherLastNameCapturista = datosComun.get(2);
        String fechaDeNacimiento = datosComun.get(3);
        String cityCapturista = datosComun.get(4);
        String estadoCapturista = datosComun.get(5);
        String CURPCapturista = datosComun.get(6);
        String direccionCapturista = datosComun.get(7);
        String RFCCapturista = Sistema.generateRFC(nameClient, fatherLastNameCapturista, motherLastNameCapturista, fechaDeNacimiento);
        System.out.println("Salario: ");
        Double salaryCapturista = leer.nextDouble();
        if (RFCCapturista!= null) {
            RFCList.add(RFCCapturista);
            Sistema.validarRFC(RFCCapturista);
            Capturista newCapturista = new Capturista(nameClient, fatherLastNameCapturista, motherLastNameCapturista,
                    fechaDeNacimiento, cityCapturista, estadoCapturista, CURPCapturista, direccionCapturista, Rol.CAPTURISTA, salaryCapturista, RFCCapturista);
            Bancos.Sucursales.listaUsuariosSucursalMadero.add(newCapturista);
            System.out.println("Capturista registrado con éxito. Su rfc es:" + RFCCapturista+ " su CURP es: "+ CURPCapturista);
        }
        else {
            System.out.println("Inténtelo de nuevo.");
        }
    }
    public static void modificarCapturista() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el RFC del cliente a modificar: ");
        String modificarRFC = leer.nextLine();
        for (Usuario  buscarCapturistaModificar : listaUsuariosSucursalMadero){
            if (buscarCapturistaModificar.getRFC().equals(modificarRFC)) {
                int opcionModificar;
                do {
                    System.out.println("¿Qué desea modificar?");
                    System.out.println("1. Nombre.");
                    System.out.println("2. Apellido paterno.");
                    System.out.println("3. Apellido materno.");
                    System.out.println("4. Fecha de Nacimiento.");
                    System.out.println("5. Ciudad.");
                    System.out.println("6. Estado.");
                    System.out.println("7. Domicilio.");
                    System.out.println("8. Sexo.");
                    System.out.println("9. Salario.");
                    System.out.println("10. Salir.");
                    opcionModificar = leer.nextInt();
                    leer.nextLine();
                    switch (opcionModificar) {
                        case 1:
                            System.out.println("Ingrese el nuevo nombre");
                            String newName = leer.nextLine().toUpperCase();
                            buscarCapturistaModificar.setName(newName);
                            buscarCapturistaModificar.setRFC(Sistema.generateRFC(newName, buscarCapturistaModificar.getFatherLastName(),buscarCapturistaModificar.getMotherLastName(), buscarCapturistaModificar.getFechaDeNacimiento()));
                            break;
                        case 2:
                            System.out.println("Ingrese el nuevo apellido Paterno");

                            String newFatherLastName = leer.nextLine().toUpperCase();
                            buscarCapturistaModificar.setFatherLastName(newFatherLastName);
                            buscarCapturistaModificar.setRFC(Sistema.generateRFC(buscarCapturistaModificar.getName(), newFatherLastName,buscarCapturistaModificar.getMotherLastName(), buscarCapturistaModificar.getFechaDeNacimiento()));
                            break;
                        case 3:
                            System.out.println("Ingrese el nuevo apellido Materno");
                            String newMotherLastName = leer.nextLine().toUpperCase();
                            buscarCapturistaModificar.setMotherLastName(newMotherLastName);
                            buscarCapturistaModificar.setRFC(Sistema.generateRFC(buscarCapturistaModificar.getName(), buscarCapturistaModificar.getFatherLastName(), newMotherLastName, buscarCapturistaModificar.getFechaDeNacimiento()));
                            break;
                        case 4:
                            System.out.println("Ingrese la nueva Fecha de Nacimiento: ");
                            String newFechaDeNacimiento = leer.nextLine().toUpperCase();
                            buscarCapturistaModificar.setFechaDeNacimiento(newFechaDeNacimiento);
                            buscarCapturistaModificar.setRFC(Sistema.generateRFC(buscarCapturistaModificar.getName(), buscarCapturistaModificar.getFatherLastName(), buscarCapturistaModificar.getMotherLastName(), newFechaDeNacimiento));
                            break;
                        case 5:
                            System.out.println("Ingrese la ciudad: ");
                            String newCity = leer.nextLine().toUpperCase();
                            buscarCapturistaModificar.setCity(newCity);
                            break;
                        case 6:
                            System.out.println("Ingrese el estado: ");
                            String newEstado = leer.nextLine().toUpperCase();
                            buscarCapturistaModificar.setEstado(newEstado);
                            break;
                        case 7:
                            System.out.println("Ingrese el domicilio: ");
                            String newDomicilio = leer.nextLine().toUpperCase();
                            buscarCapturistaModificar.setDireccion(newDomicilio);
                            break;
                        case 8:
                            System.out.println("Ingrese el salario: ");
                            double newSalary = leer.nextDouble();
                            buscarCapturistaModificar.setSalary(newSalary);
                            break;

                        case 9:
                            System.out.println("Ingrese nuevo fondo: ");
                            double newFondo = leer.nextDouble();
                            buscarCapturistaModificar.setSalary(newFondo);
                            break;

                        case 10:
                            break;


                    }
                } while (opcionModificar != 10);

            }
        }
    }



    public  String mostrarInformacion(){
        return String.format(super.mostrarInformacionAsalariados() );

    }

    public static void mostrarCapturistas(ArrayList<Capturista> listaCapturistas ){

        if(listaCapturistas.isEmpty())
        {
            System.out.println("\nNo hay clientes registrados");
        }
        else {
            for(Capturista capturistaSucursal: listaCapturistas){
                System.out.println(capturistaSucursal.mostrarInformacion());
            }
        }

    }
public static void eliminarCapturista(){
        Scanner leer= new Scanner(System.in);
    System.out.println("Ingrese el RFC del capturista a eliminar:");
    String buscarRFC = leer.nextLine();
    eliminarUsuario(lista, buscarRFC);
}

}
