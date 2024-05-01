/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_unidad3.Users;

import examen_unidad3.Bancos.Sistema;
import examen_unidad3.recursosGlobales.Rol;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author leila_pe8dh8w
 */
public class Usuario {
    String name;
    String motherLastName;
    String fatherLastName;
    String fechaDeNacimiento;
    String city;
    String Estado;
    String CURP;
    String direccion;
    Rol userRol;
    double salary;
    String RFC;
    static ArrayList<String> RFCList = new ArrayList<>();

    public Usuario(String name, String motherLastName, String fatherLastName,
                   String fechaDeNacimiento, String city, String estado, String CURP,
                   String direccion, Rol userRol, double salary, String RFC) {
        this.name = name;
        this.motherLastName = motherLastName;
        this.fatherLastName = fatherLastName;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.city = city;
        Estado = estado;
        this.CURP = CURP;
        this.direccion = direccion;
        this.userRol = userRol;
        this.salary = salary;
        this.RFC=RFC;
    }

    public Usuario(String name, String motherLastName, String fatherLastName,
                   String fechaDeNacimiento, String city, String estado, String CURP,
                   String direccion, Rol userRol, String RFC) {
        this.name = name;
        this.motherLastName = motherLastName;
        this.fatherLastName = fatherLastName;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.city = city;
        Estado = estado;
        this.CURP = CURP;
        this.direccion = direccion;
        this.userRol = userRol;
        this.RFC = RFC;
    }
//    Constructor para clientes, no tiene salario.

    public String mostrarInformacion (){
        return String.format("Nombre completo : %s %s %s. Fecha de nacimiento: %s CURP: %s Ciudad: %s Estado: %s  Direccion: %s "
                 + name, motherLastName, fatherLastName,  fechaDeNacimiento, CURP, city, Estado, direccion);
    }
    public String mostrarInformacionAsalariados (){
        return String.format("Nombre completo : %s %s %s. Fecha de nacimiento: %s CURP: %s Ciudad: %s Estado: %s  Direccion: %s  Salario: %.2f "
                + name, motherLastName, fatherLastName,  fechaDeNacimiento, CURP, city, Estado, direccion, salary);
    }

    public Rol getUserRol() {
        return userRol;
    }

    public void setUserRol(Rol userRol) {
        this.userRol = userRol;
    }
    
    public static ArrayList <String> registerUser(Rol userRol){
        Scanner leer = new Scanner (System.in);
        ArrayList<String> datosComun = new ArrayList <String>();
        System.out.println("Escribir todo con mayúsculas.");
        System.out.print("Ingrese el nombre: ");
        String name = leer.nextLine();
        name.toUpperCase();
        System.out.print("Ingrese el apellido paterno: ");
        String fatherLastName = leer.nextLine();
        fatherLastName.toUpperCase();
        System.out.print("Ingrese el apellido materno: ");
        String motherLastName = leer.nextLine();
        motherLastName.toUpperCase();
        System.out.print("Ingrese la fecha de nacimiento formato AAAA-DD-MM: ");
        String fechaNacimiento = leer.nextLine();
        System.out.print("Ciudad: ");
        String city = leer.nextLine();
        city.toUpperCase();
        System.out.print("Estado: ");
        String estado = leer.nextLine();
        estado.toUpperCase();
        System.out.print("Sexo: ");
        String sexo = leer.nextLine();
        String curp = Sistema.generarCurp(name, fatherLastName, motherLastName, fechaNacimiento, sexo, estado);
        System.out.print("Domicilio: ");
        String direccion = leer.nextLine();
        datosComun.addAll(Arrays.asList(name, fatherLastName, motherLastName, fechaNacimiento, city, estado, curp, direccion));
        return datosComun;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMotherLastName() {
        return motherLastName;
    }

    public void setMotherLastName(String motherLastName) {
        this.motherLastName = motherLastName;
    }

    public String getFatherLastName() {
        return fatherLastName;
    }

    public void setFatherLastName(String fatherLastName) {
        this.fatherLastName = fatherLastName;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }
    public static ArrayList<Usuario> eliminarUsuario(ArrayList<Usuario> listaUsuarios, String RFC) {
        ArrayList<Usuario> listaUsuariosEliminar = new ArrayList<Usuario>();
        for (Usuario usuarioEliminar : listaUsuarios) {
            if (!usuarioEliminar.getRFC().equals(RFC)) {
                listaUsuariosEliminar.add(usuarioEliminar);
            }
        }
        // Devuelve la lista modificada sin el usuario especificado
        listaUsuarios.clear(); // Limpiar la lista original
        listaUsuarios.addAll(listaUsuariosEliminar); // Agregar los elementos restantes
        return listaUsuarios;
    }
}