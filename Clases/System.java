package Clases;
import interfaces.Isystem;

import java.util.ArrayList;
import java.util.List;
public class System implements Isystem {
    public String name;
    public int chtact;
    public User activeuser=null;
    public List<User> userlist;
    public List<Chatbot> chatbotlist;
    public int initialcht;
    public System(String name,int chtact,Chatbot... chtlist){
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
    public void systemAddUser(User user){
        if(!this.userlist.contains(user)){
            this.userlist.add(user);
        }
    }
    @Override
    public void systemLogin(User user){
        if(this.activeuser==null){
        this.activeuser=user;
        }
    }
    @Override
    public void systemLogout(){
        //incompleto
        this.activeuser=null;
    }


}
