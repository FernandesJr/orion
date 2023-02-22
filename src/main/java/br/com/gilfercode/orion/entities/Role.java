package br.com.gilfercode.orion.entities;

public class Role {

    private String description;

    public Role(){}

    public Role(String description) {
        this.description = description;
    }

    /*Gets and Sets*/
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
