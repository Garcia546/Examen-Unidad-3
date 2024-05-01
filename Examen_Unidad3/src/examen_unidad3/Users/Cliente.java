

package examen_unidad3.Users;

import examen_unidad3.recursosGlobales.Rol;
import examen_unidad3.Bancos.Sistema;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Usuario {
    LocalDate data;
    
    public Cliente(String name, String fatherLastNameClient, String motherLastNameClient, String fechaDeNacimiento, String ciudad,
                   String estado, String CURP, String direccion, String RFC) {
        super(name, fatherLastNameClient, motherLastNameClient, fechaDeNacimiento,
                ciudad, estado, CURP, direccion, Rol.CLIENTE, RFC);

        this.data = LocalDate.now();
    }

    public static Cliente registerClient(){
        ArrayList<String> datosComun = Usuario.registerUser(Rol.CLIENTE);
        String nameClient = datosComun.get(0);
        String fatherLastNameClient = datosComun.get(1);
        String motherLastNameClient = datosComun.get(2);
        String fechaDeNacimiento = datosComun.get(3);
        String cityClient = datosComun.get(4);
        String estadoCliente = datosComun.get(5);
        String CURPClient = datosComun.get(6);
        String direccionClient = datosComun.get(7);
        String RFCClient = Sistema.generateRFC(nameClient, fatherLastNameClient, motherLastNameClient, fechaDeNacimiento);
        if (RFCClient!= null) {
            RFCList.add(RFCClient);
            Sistema.validarRFC(RFCClient);
            Cliente newCliente = new Cliente(nameClient, fatherLastNameClient, motherLastNameClient,
                    fechaDeNacimiento, cityClient, estadoCliente, CURPClient, direccionClient, RFCClient);
            System.out.println("Cliente registrado con éxito. Su rfc es:" + RFCClient+ " su CURP es: "+ CURPClient);
            return newCliente;
        }
        else {
            System.out.println("Inténtelo de nuevo.");
        }
        return null;
        }

    public static void modificarCliente()
    {
        Scanner leer = new Scanner(System.in);       
        System.out.println("Ingrese el RFC del cliente a modificar: ");        
        String modificarRFC = leer.nextLine();        
        for (Cliente buscarClienteModificar : listaUsuariosSucursalMadero){
            if (buscarClienteModificar.getRFC().equals(modificarRFC)) {
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
                    System.out.println("9. Salir.");                    
                    opcionModificar = leer.nextInt();                    
                    leer.nextLine();                    
                    switch (opcionModificar) {                       
                        case 1:                           
                                System.out.println("Ingrese el nuevo nombre");                           
                                String newName = leer.nextLine().toUpperCase();                            
                                buscarClienteModificar.setName(newName);                            
                                buscarClienteModificar.setRFC(Sistema.generateRFC(newName, buscarClienteModificar.getFatherLastName(),buscarClienteModificar.getMotherLastName(), buscarClienteModificar.getFechaDeNacimiento()));                           
                                break;                        
                                case 2:                            
                                    System.out.println("Ingrese el nuevo apellido Paterno");                            
                                    
                                    String newFatherLastName = leer.nextLine().toUpperCase();                            
                                    buscarClienteModificar.setFatherLastName(newFatherLastName);                            
                                    buscarClienteModificar.setRFC(Sistema.generateRFC(buscarClienteModificar.getName(), newFatherLastName,buscarClienteModificar.getMotherLastName(), buscarClienteModificar.getFechaDeNacimiento()));                            
                                    break;                        
                                    case 3:                            
                                        System.out.println("Ingrese el nuevo apellido Materno");                            
                                        String newMotherLastName = leer.nextLine().toUpperCase();                            
                                        buscarClienteModificar.setMotherLastName(newMotherLastName);                            
                                        buscarClienteModificar.setRFC(Sistema.generateRFC(buscarClienteModificar.getName(), buscarClienteModificar.getFatherLastName(), newMotherLastName, buscarClienteModificar.getFechaDeNacimiento()));                           
                                        break;                        
                                        case 4:                            
                                            System.out.println("Ingrese la nueva Fecha de Nacimiento: ");                            
                                            String newFechaDeNacimiento = leer.nextLine().toUpperCase();                           
                                            buscarClienteModificar.setFechaDeNacimiento(newFechaDeNacimiento);                            
                                            buscarClienteModificar.setRFC(Sistema.generateRFC(buscarClienteModificar.getName(), buscarClienteModificar.getFatherLastName(),                                    buscarClienteModificar.getMotherLastName(), newFechaDeNacimiento));                            
                                            break;                        
                                            case 5:                            
                                                System.out.println("Ingrese la ciudad: ");                            
                                                String newCity = leer.nextLine().toUpperCase();                            
                                                buscarClienteModificar.setCity(newCity);                            
                                                break;                        
                                            case 6:                            
                                                System.out.println("Ingrese el estado: ");                            
                                                String newEstado = leer.nextLine().toUpperCase();                            
                                                buscarClienteModificar.setEstado(newEstado);                            
                                                break;                        
                                            case 7:                           
                                                System.out.println("Ingrese el domicilio: ");                            
                                                String newDomicilio = leer.nextLine().toUpperCase();                            
                                                buscarClienteModificar.setDireccion(newDomicilio);                            
                     
       }                
   } while (opcionModificar != 9);       
         
            }        
        }    
    }
    public  String mostrarInformacion(){
        return String.format(super.mostrarInformacion()+" Fecha de registro: %s ", data );

    }

public static void mostrarClientes(ArrayList<Cliente> listaClientes ){

        if(listaClientes.isEmpty())
        {
            System.out.println("\nNo hay clientes registrados");
        }
        else {
            for(Cliente clienteSucursal: listaClientes){
                System.out.println(clienteSucursal.mostrarInformacion());
            }
        }

}


}
