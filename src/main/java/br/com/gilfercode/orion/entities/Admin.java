package br.com.gilfercode.orion.entities;

import java.util.Objects;

public class Admin {

    private Long id;
    private String name;

    public Admin(){}

    public Admin(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /*Gets and Sets*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*Equals*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Admin)) return false;
        Admin admin = (Admin) o;
        return Objects.equals(getId(), admin.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
