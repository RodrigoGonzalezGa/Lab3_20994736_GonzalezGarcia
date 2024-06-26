package Clases_209947366_GonzalezGarcia;

/**
 * Clase heredada de User, representa a un Administrador del System
 */
public class Admin_209947366_GonzalezGarcia extends User_209947366_GonzalezGarcia {
    /**
     * Constructor modificado de User
     * @param name String Nombre de usuario
     */
    public Admin_209947366_GonzalezGarcia(String name){
        super(name);
        this.name=name;
        this.history="";
        this.isadmin=true;
    }

}
