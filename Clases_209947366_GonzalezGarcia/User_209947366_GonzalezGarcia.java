package Clases_209947366_GonzalezGarcia;

import interfaces_209947366_GonzalezGarcia.Iuser_209947366_GonzalezGarcia;

/**
 * Clase que representa a un usuario normal
 */
public class User_209947366_GonzalezGarcia implements Iuser_209947366_GonzalezGarcia {
    /**
     * Nombre de usuario
     */
    public String name;
    /**
     * Historia del usuario
     */
    public String history;
    /**
     * Permite identificar si un usuario es un administrador
     */
    public boolean isadmin;

    /**
     * Constructor de la clase User
     * @param name String: Nombre de usuario
     */
    public User_209947366_GonzalezGarcia(String name){
        super();
        this.name=name;
        this.history="";
        this.isadmin=false;
    }

    /**
     * Selector del nombre de usuario
     * @return String: Nombre de usuario
     */
    @Override
    public String getname(){
        return this.name;
    }

    /**
     * Selector del historial del usuario
     * @return String: Historial
     */
    @Override
    public String gethistory(){
        return this.history;
    }

    /**
     * Modificador que añade texto al historial de un usuario
     * @param text String: Texto a añadir
     */
    @Override
    public void appendhistory(String text){
        this.history=this.history+text;
    }
}
