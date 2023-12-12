package Clases_209947366;
import interfaces_209947366.Iflow_209947366;

import java.util.ArrayList;
import java.util.List;

/**
 * Flujo de interacciones entre el usuario y el Chatbot
 */
public class Flow_209947366 implements Iflow_209947366 {
    /**
     * Identificador del Flow
     */
    public int id;
    /**
     * Nombre y mensaje del Flujo
     */
    public String nombremsg;
    /**
     * Lista de opciones del Flujo
     */
    public List<Option_209947366> optionlist;

    /**
     * Constructor de la clase Flow
     * @param id Int:identificador del Flow
     * @param msg String: Nombre y mensaje del Flujo
     * @param oplist String... Lista de opciones del Flujo
     */
    public Flow_209947366(int id, String msg, Option_209947366... oplist){
        this.id=id;
        this.nombremsg=msg;
        this.optionlist=new ArrayList<Option_209947366>();
        for(Option_209947366 op: oplist){
            if(checkidrepeat(op)){
                this.optionlist.add(op);
            }
        }
        this.optionlist=new  ArrayList<Option_209947366>(List.of(oplist));
    }

    /**
     * Selector del identificador del Flow
     * @return Int: Identificador
     */
    @Override
    public int getid(){

        return this.id;
    }

    /**
     * Selector del Nombrre y Mensaje del Flow
     * @return String Nombre y Mensaje
     */
    @Override
    public String getnamemsg(){
        return this.nombremsg;
    }

    /**
     * Selector de Options del Flow
     * @return List Option: Lista de options
     */
    @Override
    public List<Option_209947366> getoptions() {
        return this.optionlist;
    }

    /**
     * Modificador que permite añadir Options a un Flow
     * @param opl Option: Options a añadir
     */
    @Override
    public void flowAddOption(Option_209947366... opl){
            for(Option_209947366 op: opl){
                if(!(this.checkidrepeat(op))){
                    this.optionlist.add(op);
                }
            }
    }

    /**
     * Verifica que no se repitan ID dentro de los Option del Flow
     * @param op Option
     * @return Boolean
     */
    @Override
    public boolean checkidrepeat(Option_209947366 op){
        for(Option_209947366 opfromlist: this.optionlist){
            if(op.id==opfromlist.id){
                return true;
            }
        }
        return false;
    }

}
