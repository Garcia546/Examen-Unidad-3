
package examen_unidad3.Users;

import examen_unidad3.Bancos.Sistema;
import examen_unidad3.recursosGlobales.Rol;
import examen_unidad3.recursosGlobales.Sucursal;
public class Gerente extends Usuario{
    Sucursal sucursal;

    public Gerente(String name,  String fatherLastName,String motherLastName, String fechaDeNacimiento, String city, String estado,String sexo, String CURP, String direccion, double salary ,Sucursal sucursalingresada, String RFC) {
        
        super(name, motherLastName, fatherLastName, fechaDeNacimiento, city, estado, CURP, direccion, Rol.GERENTE, salary, RFC);
        sucursal = sucursalingresada ;
    }

    
    
    
}
