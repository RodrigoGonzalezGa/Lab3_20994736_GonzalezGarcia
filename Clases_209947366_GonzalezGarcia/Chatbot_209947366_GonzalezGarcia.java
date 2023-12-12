package Clases_209947366_GonzalezGarcia;

import interfaces_209947366_GonzalezGarcia.Ichatbot_209947366_GonzalezGarcia;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa a los Chatbots con los cuales se puede interactuar
 */
public class Chatbot_209947366_GonzalezGarcia implements Ichatbot_209947366_GonzalezGarcia {
    /**
     * Int: Identificador del Chatbot
     */
    public int id;
    /**
     * String: Nombre del Chatbot
     */
    public String name;
    /**
     * String: Mensaje del Chatbot
     */
    public String msg;
    /**
     * Int: ID del Flow actual del Chatbot
     */
    public int flowid;
    /**
     * Int: ID del Flow inicial del Chatbot
     */
    public int initialflow;
    /**
     * List Flow: Lista de Flows de un Chatbot
     */
    public List<Flow_209947366_GonzalezGarcia> flowlist;

    /**
     * Contsructor de la clae Chatbot
     * @param id Int: Identificador del Chatbot
     * @param name String: Nombre del Chatbot
     * @param msg String: Mensaje del Chatbot
     * @param flowid Int: ID del Flow inicial del Chatbot
     * @param fl List Flow: Lista de Flows de un Chatbot
     */
    public Chatbot_209947366_GonzalezGarcia(int id, String name, String msg, int flowid, Flow_209947366_GonzalezGarcia... fl){
        this.id=id;
        this.name=name;
        this.msg=msg;
        this.flowid=flowid;
        this.initialflow=flowid;
        this.flowlist=new ArrayList<Flow_209947366_GonzalezGarcia>();
        for(Flow_209947366_GonzalezGarcia flow: fl){
            if(!this.flowlist.contains(flow)){
                this.flowlist.add(flow);
            }
        }
    }

    /**
     * Selector del ID del Chatbot
     * @return Int: Identificador
     */
    @Override
    public int getid(){
        return this.id;
    }

    /**
     * Selector del Nombre del Chatbot
     * @return String: Nombre
     */
    @Override
    public String getname(){
        return this.name;
    }

    /**
     * Selector del Mensaje del Chatbot
     * @return Stirng: Mensaje
     */
    @Override
    public String getmsg(){
        return this.msg;
    }

    /**
     * Selector del ID del Flow del Chatbot
     * @return Int: Flow ID
     */
    @Override
    public int getflowid(){
        return this.flowid;
    }

    /**
     * Selector del ID del Flow Inicial del Chatbot
     * @return Int: Flow ID
     */
    @Override
    public int getinitialflow(){
        return this.initialflow;
    }

    /**
     * Selector de la lista de Flows del Chatbot
     * @return List Flow: Lista de Flows
     */
    @Override
    public List<Flow_209947366_GonzalezGarcia> getflows(){
        return this.flowlist;
    }

    /**
     * Verifica que un Flow no se repita dentro de una lista en base de su ID
     * @param fl Flow a añadir
     * @return Boolean
     */
    @Override
    public boolean checkidrepeat(Flow_209947366_GonzalezGarcia fl){
        for(Flow_209947366_GonzalezGarcia flowfromlist:this.flowlist){
            if(fl.id==flowfromlist.id){
                return true;
            }
        }
        return false;
    }

    /**
     * Modificador que añade un Flow a un Chatbot
     * @param flowlist Lista de Flows a añadir
     */
    @Override
    public void chatbotAddFlow(Flow_209947366_GonzalezGarcia... flowlist){
        for (Flow_209947366_GonzalezGarcia fl: flowlist){
            if(!this.checkidrepeat(fl)){
                this.flowlist.add(fl);
            }
        }
    }

    /**
     * Devuelve al Chatbot a su estado inicial
     */
    @Override
    public void resetchatbot(){
        this.flowid=this.initialflow;
    }

    /**
     * Modifica para cambiar el Flow actual a un Id del Flow entregado
     * @param flid Int: Id del Flow actual
     */
    @Override
    public void setflowactual(int flid){
        this.flowid=flid;
    }

}
