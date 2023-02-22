package br.com.gilfercode.orion.entities;

import java.util.Objects;

public class Clinic {

    private Long id;
    private String name;
    private String cnpj;
    private String imageUrl;

    public Clinic(){}

    public Clinic(Long id, String name, String cnpj, String imageUrl) {
        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
        this.imageUrl = imageUrl;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /*Equals*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Clinic)) return false;
        Clinic clinic = (Clinic) o;
        return Objects.equals(getId(), clinic.getId()) && Objects.equals(getCnpj(), clinic.getCnpj());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCnpj());
    }
}
