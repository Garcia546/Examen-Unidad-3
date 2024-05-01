package examen_unidad3.Users;

import examen_unidad3.Bancos.Sistema;
import examen_unidad3.recursosGlobales.Rol;

import java.util.ArrayList;
import java.util.Scanner;

public class Inversionista extends Usuario
{
    private double fondo;
    public Inversionista(String name, String motherLastName, String fatherLastName, String fechaDeNacimiento, String city, String estado, String CURP, String direccion, Rol userRol, double salary, String RFC, double fondo)
    {
        super(name, motherLastName, fatherLastName, fechaDeNacimiento, city, estado, CURP, direccion, userRol, salary, RFC);
        this.fondo = fondo;
    }


    public static void registrarInversionista()
    {
        Scanner leer = new Scanner(System.in);

        ArrayList<String> datosComun = Usuario.registerUser(Rol.INVERSIONISTA);

        String nameInversionista = datosComun.get(0);
        String fatherLastNameInversionista = datosComun.get(1);
        String motherLastNameInversionista = datosComun.get(2);
        String fechaDeNacimiento = datosComun.get(3);
        String cityInversionista = datosComun.get(4);
        String estadoInversionista = datosComun.get(5);
        String CURPInversionista = datosComun.get(6);
        String direccionInversionista = datosComun.get(7);

        System.out.println("Digita tu salario: ");
        double salary = leer.nextDouble();

        System.out.println("Ingresa tus fondos disponibles: ");
        double fondos = leer.nextDouble();

        String RFCInversionista = Sistema.generateRFC(nameInversionista, fatherLastNameInversionista, motherLastNameInversionista, fechaDeNacimiento);
        if (RFCInversionista!= null) {
            RFCList.add(RFCInversionista);
            Sistema.validarRFC(RFCInversionista);
            Inversionista newInversionista = new Inversionista(nameInversionista, fatherLastNameInversionista, motherLastNameInversionista,
                    fechaDeNacimiento, cityInversionista, estadoInversionista, CURPInversionista, direccionInversionista,  Rol.EJECUTIVO_DE_VENTA, salary, RFCInversionista, fondos);


            System.out.println("Inversionista registrado con éxito. Su rfc es:" + RFCInversionista+ " su CURP es: "+ CURPInversionista);
        }
        else {
            System.out.println("Inténtelo de nuevo.");
        }
    }

    public static void modificarInversionista()
    {
        Scanner leer = new Scanner(System.in);

        System.out.println("Ingrese el RFC del cliente a modificar: ");
        String modificarRFC = leer.nextLine();
        for (Usuario  buscarInversionistaModificar : listaUsuariosSucursalMadero){
            if (buscarInversionistaModificar.getRFC().equals(modificarRFC)) {
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
                    System.out.println("10. Fondos");
                    System.out.println("11. Salir.");
                    opcionModificar = leer.nextInt();
                    leer.nextLine();
                    switch (opcionModificar) {
                        case 1:
                            System.out.println("Ingrese el nuevo nombre");
                            String newName = leer.nextLine().toUpperCase();
                            buscarInversionistaModificar.setName(newName);
                            buscarInversionistaModificar.setRFC(Sistema.generateRFC(newName, buscarInversionistaModificar.getFatherLastName(),buscarInversionistaModificar.getMotherLastName(), buscarInversionistaModificar.getFechaDeNacimiento()));
                            break;
                        case 2:
                            System.out.println("Ingrese el nuevo apellido Paterno");

                            String newFatherLastName = leer.nextLine().toUpperCase();
                            buscarInversionistaModificar.setFatherLastName(newFatherLastName);
                            buscarInversionistaModificar.setRFC(Sistema.generateRFC(buscarInversionistaModificar.getName(), newFatherLastName,buscarInversionistaModificar.getMotherLastName(), buscarInversionistaModificar.getFechaDeNacimiento()));
                            break;
                        case 3:
                            System.out.println("Ingrese el nuevo apellido Materno");
                            String newMotherLastName = leer.nextLine().toUpperCase();
                            buscarInversionistaModificar.setMotherLastName(newMotherLastName);
                            buscarInversionistaModificar.setRFC(Sistema.generateRFC(buscarInversionistaModificar.getName(), buscarInversionistaModificar.getFatherLastName(), newMotherLastName, buscarInversionistaModificar.getFechaDeNacimiento()));
                            break;
                        case 4:
                            System.out.println("Ingrese la nueva Fecha de Nacimiento: ");
                            String newFechaDeNacimiento = leer.nextLine().toUpperCase();
                            buscarInversionistaModificar.setFechaDeNacimiento(newFechaDeNacimiento);
                            buscarInversionistaModificar.setRFC(Sistema.generateRFC(buscarInversionistaModificar.getName(), buscarInversionistaModificar.getFatherLastName(), buscarInversionistaModificar.getMotherLastName(), newFechaDeNacimiento));
                            break;
                        case 5:
                            System.out.println("Ingrese la ciudad: ");
                            String newCity = leer.nextLine().toUpperCase();
                            buscarInversionistaModificar.setCity(newCity);
                            break;
                        case 6:
                            System.out.println("Ingrese el estado: ");
                            String newEstado = leer.nextLine().toUpperCase();
                            buscarInversionistaModificar.setEstado(newEstado);
                            break;
                        case 7:
                            System.out.println("Ingrese el domicilio: ");
                            String newDomicilio = leer.nextLine().toUpperCase();
                            buscarInversionistaModificar.setDireccion(newDomicilio);
                            break;
                        case 8:
                            System.out.println("Ingrese el salario: ");
                            double newSalary = leer.nextDouble();
                            buscarInversionistaModificar.setSalary(newSalary);
                            break;

                        case 9:
                            System.out.println("Ingrese nuevo fondo: ");
                            double newFondo = leer.nextDouble();
                            buscarInversionistaModificar.setSalary(newFondo);
                            break;

                        case 10:
                            break;

                        default:
                            System.out.println("\nOpción no válida");

                    }
                } while (opcionModificar != 10);

            }
            }
        }
    }



