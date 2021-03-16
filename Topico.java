package pubSub;

import java.util.ArrayList;

public class Topico {
    private String nome;

    private ArrayList<String> ids = new ArrayList<>();

    public Topico(String nome){
        this.nome = nome;
    }

    public ArrayList<String> getIds(){
        return this.ids;
    }

    public void addId(String nome){
        this.ids.add(nome);
    }

    public void removerId(String nome){
        int index = this.indexOfId(nome);
        if(index != -1)
            ids.remove(index);
    }

    public int indexOfId(String nome){
        return ids.indexOf(nome);
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }


}
