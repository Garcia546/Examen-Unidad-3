package examen_unidad3.recursosGlobales;

import examen_unidad3.Users.Usuario;

public class UsuarioEnSesion
{
    private static UsuarioEnSesion instancia;
    private Usuario usuarioActual;

    //constructor privado
    private UsuarioEnSesion(){
    }

    //estático para no tener que crear un nuevo objeto cada que usemos esta clase
    public static UsuarioEnSesion obtenerInstancia()
    {
        if(instancia == null)
        {
            instancia = new UsuarioEnSesion();
        }
        return instancia;
    }

    public Usuario getUsuarioActual()
    {
        return usuarioActual;
    }

    public void setUsuarioActual(Usuario usuarioActual)
    {
        this.usuarioActual = usuarioActual;
    }

    public boolean hayUsuarioEnSesion()
    {
        return usuarioActual != null;
    }

    public void cerrarSesion()
    {
        instancia = null;
        usuarioActual = null;
    }
}
