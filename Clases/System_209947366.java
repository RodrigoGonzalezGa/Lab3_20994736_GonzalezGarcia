package Clases;
import interfaces.Isystem_209947366;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.time.*;
import java.lang.System;
public class System_209947366 implements Isystem_209947366 {
    public String name;
    public int chtact;
    public User activeuser=null;
    public List<User> userlist;
    public List<Chatbot> chatbotlist;
    public int initialcht;

    public DateTimeFormatter formatofecha = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    public LocalDateTime fecha;
    public System_209947366(String name,int chtact,Chatbot... chtlist){
        this.name=name;
        this.chtact=chtact;
        this.initialcht=chtact;
        this.chatbotlist=new ArrayList<Chatbot>();
        for(Chatbot cht: chtlist){
            if(!this.chatbotlist.contains(cht)){
                this.chatbotlist.add(cht);
            }
        }
        this.userlist=new ArrayList<User>();


    }
    @Override
    public String systemgetname(){
        return this.name;
    }
    @Override
    public int systemgetchtact(){
        return this.chtact;
    }
    @Override
    public List<Chatbot> getchatbotlist(){
        return this.chatbotlist;
    }
    @Override
    public User getactiveuser(){
        return this.activeuser;
    }
    @Override
    public List<User> getuserlist(){
        return this.userlist;
    }
    @Override
    public int getinitialcht(){
        return this.initialcht;
    }
    @Override
    public void systemAddChatbot(Chatbot... chtl){
        for (Chatbot cht: chtl){
            if(!this.chatbotlist.contains(cht)){
                this.chatbotlist.add(cht);
            }
        }
    }
    @Override
    public void systemAddUser(User newuser){
        for(User userinlist:this.userlist){
            if(userinlist.name.equals(newuser.name)){
                return;
            }
        }
        this.userlist.add(newuser);
    }
    @Override
    public void systemLogin(User user){
        if(this.activeuser==null && !this.userlist.isEmpty()  && this.userlist.contains(user)){
        this.activeuser=user;
        }

    }
    @Override
    public void systemLogout(){
        //incompleto
        this.activeuser=null;
    }
    @Override
    public void systemtalk(String msg) {
        if (this.activeuser == null) {
            return;
        }
        fecha = LocalDateTime.now();
        String fechaformateada = fecha.format(formatofecha);
        this.activeuser.appendhistory(fechaformateada + " - " + this.activeuser.getname() + ":" + msg + "\n");
        for (Chatbot cht : this.chatbotlist) {
            if (cht.id == this.chtact) {
                for (Flow fl : cht.flowlist) {
                    if (fl.id == cht.flowid) {
                        for (Option op : fl.optionlist) {
                            String opidasstring= Integer.toString(op.id);
                            if (op.keywords.contains(msg.toLowerCase())) {
                                this.chtact = op.chtlink;
                                cht.flowid = op.flowlink;
                                for (Chatbot chatbottoadd : this.chatbotlist) {
                                    if (chatbottoadd.id == this.chtact) {
                                        for (Flow flowtoadd : chatbottoadd.flowlist) {
                                            if (flowtoadd.id == chatbottoadd.id) {
                                                this.activeuser.appendhistory(fechaformateada + " - " + chatbottoadd.name
                                                        + ":" + flowtoadd.nombremsg + "\n");
                                                for (Option optoadd : fl.optionlist) {
                                                    this.activeuser.appendhistory(optoadd.msg + "\n");
                                                }
                                                return;
                                            }
                                        }
                                    }
                                }

                            }
                            else if(opidasstring.equals(msg)){
                                this.chtact = op.chtlink;
                                cht.flowid = op.flowlink;
                                for (Chatbot chatbottoadd : this.chatbotlist) {
                                    if (chatbottoadd.id == this.chtact) {
                                        for (Flow flowtoadd : chatbottoadd.flowlist) {
                                            if (flowtoadd.id == chatbottoadd.id) {
                                                this.activeuser.appendhistory(fechaformateada + " - " + chatbottoadd.name
                                                        + ":" + flowtoadd.nombremsg + "\n");
                                                for (Option optoadd : fl.optionlist) {
                                                    this.activeuser.appendhistory(optoadd.msg + "\n");
                                                }
                                                return;
                                            }

                                        }
                                    }
                                }
                            }
                            else{
                                for (Chatbot chatbottoadd : this.chatbotlist) {
                                    if (chatbottoadd.id == this.chtact) {
                                        for (Flow flowtoadd : chatbottoadd.flowlist) {
                                            if (flowtoadd.id == chatbottoadd.id) {
                                                this.activeuser.appendhistory(fechaformateada + " - " + chatbottoadd.name
                                                        + ":" + flowtoadd.nombremsg + "\n");
                                                for (Option optoadd : fl.optionlist) {
                                                    this.activeuser.appendhistory(optoadd.msg + "\n");
                                                }
                                                return;
                                            }

                                        }
                                    }
                                }
                                return;
                            }
                        }
                        //añadir chatbot actual al historial
                        this.activeuser.appendhistory(fechaformateada + " - " + cht.name
                                + ":" + fl.nombremsg + "\n");
                        for (Option optoadd : fl.optionlist) {
                            this.activeuser.appendhistory(optoadd.msg + "\n");
                        }
                        return;
                    }
                }
            }
        }
    }
    @Override
    public void systemsynthesis(User user){
        java.lang.System.out.println(user.history);
    }
    }

