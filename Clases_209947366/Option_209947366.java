package Clases_209947366;

import interfaces_209947366.Ioption_209947366;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa las opciones de un flujo de las interacciones
 */
public class Option_209947366 implements Ioption_209947366 {
    /**
     * Identificador del Option
     */
    public int id;
    /**
     * Mensaje del Option
     */
    public String msg;
    /**
     * Enlace al Chatbot que continua la interaccion
     */
    public int chtlink;
    /**
     * Enlace al Flow del Chatbot que continua con la interaccion
     */
    public int flowlink;
    /**
     * Keywords del Option que permiten interactuar con este
     */
    public List<String> keywords;

    /**
     * Contstructor de la clase Option
     * @param id Int: Identificador del Option, permite interactuar con este
     * @param msg String: Mensaje que se muestra al usuario a la hora de interactuar
     * @param chtlink Int: Indica el Chatbot la que esta enlazado la Option
     * @param flowlink Int: Indica el Flow del Chatbot a utilizar en la siguiente interaccion
     * @param keywords List String: Palabras que se pueden utilizar para interactuar con el Chatbot
     */
    public Option_209947366(int id, String msg, int chtlink, int flowlink, String... keywords){
        this.id=id;
        this.msg=msg;
        this.chtlink=chtlink;
        this.flowlink=flowlink;
        this.keywords= new ArrayList<>();
        for(String key:keywords){
            this.keywords.add(key.toLowerCase());
        }
    }

    /**
     * Selector del Id del Option
     * @return Int: Id del Option
     */
    @Override
    public int getid() {
        return id;

    }

    /**
     * Selector del mensaje del option
     * @return String: Mensaje del Option
     */
    @Override
    public String getmsg(){
        return msg;
    }

    /**
     * Selector del id del Chatbot que continua la interaccion
     * @return Int: Chatbot link
     */
    @Override
    public int getchtlink(){
        return chtlink;
    }

    /**
     * Selector del link al Flow que continua con la interaccion
     * @return Int:Flow link
     */
    @Override
    public int getflowlink(){
        return flowlink;
    }

    /**
     * Selector de la lista de keywords del Option
     * @return List String: Lista de Keywords
     */
    @Override
    public List<String> getkeywords(){
        return keywords;
    }
}