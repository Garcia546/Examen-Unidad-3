/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_unidad3.Bancos.Sucursales;
import examen_unidad3.Users.Cliente;
import examen_unidad3.Users.Usuario;
import java.util.ArrayList;
public class Madero {
    static ArrayList<Usuario> listaUsuariosSucursalMadero = new ArrayList<Usuario>();
    public void registrarClientes (){
    Cliente newCliente = Cliente.registerClient();
    listaUsuariosSucursalMadero.add(newCliente);
}
}
