
package examen_unidad3.Users;

import examen_unidad3.Bancos.Sistema;
import examen_unidad3.recursosGlobales.Rol;

import java.util.ArrayList;
import java.util.Scanner;

public class EjecutivoVentas extends Usuario
{

    static ArrayList<EjecutivoVentas> listaEjecutivos = new ArrayList<EjecutivoVentas>();

    public EjecutivoVentas(String name, String motherLastName, String fatherLastName, String fechaDeNacimiento, String city, String estado, String CURP, String direccion, Rol userRol, double salary, String RFC)
    {
        super(name, motherLastName, fatherLastName, fechaDeNacimiento, city, estado, CURP, direccion, userRol, salary, RFC);
    }


    public static void registrarEjecutivoVentas()
    {
        Scanner leer = new Scanner(System.in);

        ArrayList<String> datosComun = Usuario.registerUser(Rol.EJECUTIVO_DE_VENTA);

        String nameClient = datosComun.get(0);
        String fatherLastNameEjecutivo = datosComun.get(1);
        String motherLastNameEjecutivo = datosComun.get(2);
        String fechaDeNacimiento = datosComun.get(3);
        String cityEjecutivo = datosComun.get(4);
        String estadoEjecutivo = datosComun.get(5);
        String CURPEjecutivo = datosComun.get(6);
        String direccionEjecutivo = datosComun.get(7);

        System.out.println("Digita tu salario: ");
        double salary = leer.nextDouble();

        String RFCEjecutivo = Sistema.generateRFC(nameClient, fatherLastNameEjecutivo, motherLastNameEjecutivo, fechaDeNacimiento);
        if (RFCEjecutivo!= null) {
            RFCList.add(RFCEjecutivo);
            Sistema.validarRFC(RFCEjecutivo);
            EjecutivoVentas newEjecutivo = new EjecutivoVentas(nameClient, fatherLastNameEjecutivo, motherLastNameEjecutivo,
                    fechaDeNacimiento, cityEjecutivo, estadoEjecutivo, CURPEjecutivo, direccionEjecutivo,  Rol.EJECUTIVO_DE_VENTA, salary, RFCEjecutivo);
            listaEjecutivos.add(newEjecutivo);

            System.out.println("Ejecutivo de ventas registrado con éxito. Su rfc es:" + RFCEjecutivo+ " su CURP es: "+ CURPEjecutivo);
        }
        else {
            System.out.println("Inténtelo de nuevo.");
        }
    }

    public static void modificarEjecutivo()
    {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el RFC del ejecutivo a modificar: ");
        String modificarRFC = leer.nextLine();
        for (EjecutivoVentas buscarEjecutivoModificar : listaEjecutivos){
            if (buscarEjecutivoModificar.getRFC().equals(modificarRFC)) {
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
                    System.out.println("8. Salario");
                    System.out.println("9. Salir.");
                    opcionModificar = leer.nextInt();
                    leer.nextLine();
                    switch (opcionModificar) {
                        case 1:
                            System.out.println("Ingrese el nuevo nombre");
                            String newName = leer.nextLine().toUpperCase();
                            buscarEjecutivoModificar.setName(newName);
                            buscarEjecutivoModificar.setRFC(Sistema.generateRFC(newName, buscarEjecutivoModificar.getFatherLastName(),buscarEjecutivoModificar.getMotherLastName(), buscarEjecutivoModificar.getFechaDeNacimiento()));
                            break;
                        case 2:
                            System.out.println("Ingrese el nuevo apellido Paterno");

                            String newFatherLastName = leer.nextLine().toUpperCase();
                            buscarEjecutivoModificar.setFatherLastName(newFatherLastName);
                            buscarEjecutivoModificar.setRFC(Sistema.generateRFC(buscarEjecutivoModificar.getName(), newFatherLastName,buscarEjecutivoModificar.getMotherLastName(), buscarEjecutivoModificar.getFechaDeNacimiento()));
                            break;
                        case 3:
                            System.out.println("Ingrese el nuevo apellido Materno");
                            String newMotherLastName = leer.nextLine().toUpperCase();
                            buscarEjecutivoModificar.setMotherLastName(newMotherLastName);
                            buscarEjecutivoModificar.setRFC(Sistema.generateRFC(buscarEjecutivoModificar.getName(), buscarEjecutivoModificar.getFatherLastName(), newMotherLastName, buscarEjecutivoModificar.getFechaDeNacimiento()));
                            break;
                        case 4:
                            System.out.println("Ingrese la nueva Fecha de Nacimiento: ");
                            String newFechaDeNacimiento = leer.nextLine().toUpperCase();
                            buscarEjecutivoModificar.setFechaDeNacimiento(newFechaDeNacimiento);
                            buscarEjecutivoModificar.setRFC(Sistema.generateRFC(buscarEjecutivoModificar.getName(), buscarEjecutivoModificar.getFatherLastName(), buscarEjecutivoModificar.getMotherLastName(), newFechaDeNacimiento));
                            break;
                        case 5:
                            System.out.println("Ingrese la ciudad: ");
                            String newCity = leer.nextLine().toUpperCase();
                            buscarEjecutivoModificar.setCity(newCity);
                            break;
                        case 6:
                            System.out.println("Ingrese el estado: ");
                            String newEstado = leer.nextLine().toUpperCase();
                            buscarEjecutivoModificar.setEstado(newEstado);
                            break;
                        case 7:
                            System.out.println("Ingrese el domicilio: ");
                            String newDomicilio = leer.nextLine().toUpperCase();
                            buscarEjecutivoModificar.setDireccion(newDomicilio);
                            break;
                        case 8:
                            System.out.println("Ingrese el nuevo salario: ");
                            double newSalary = leer.nextFloat();
                            buscarEjecutivoModificar.setSalary(newSalary);
                            break;

                        default:
                            System.out.println("\nOpción no válida");

                    }
                } while (opcionModificar != 9);

            }
        }
    }




    public  String mostrarInformacion(){
        return String.format(super.mostrarInformacionAsalariados() );

    }

    public static void mostrarEjecutivos(ArrayList<EjecutivoVentas> listaEjecutivos ){

        if(listaEjecutivos.isEmpty())
        {
            System.out.println("\nNo hay clientes registrados");
        }
        else {
            for(EjecutivoVentas ejecutivosSucursal: listaEjecutivos){
                System.out.println(ejecutivosSucursal.mostrarInformacion());
            }
        }

    }
}
