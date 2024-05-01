
package examen_unidad3.Users;

public class inicioSesion {
    
    static inicioSesion instancia;

   
    private Usuario usuarioActual;
    
    private inicioSesion(){}
    
    public static inicioSesion obtenerInstancia(){
        if(instancia==null){
            instancia=new inicioSesion();
        }
        return instancia;
    }
    
    public Usuario getUsuarioActual(){
        return usuarioActual;
    }
    
    public  void setUsuarioActual(Usuario usuarioActual){
        this.usuarioActual = usuarioActual;
    }
    
    public boolean hayUsuarioEnSesion(){
        return usuarioActual!=null;
    }
    
    public void cerrarSesion(){
        instancia = null;
        usuarioActual = null;
    }
}
