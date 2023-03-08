package br.com.gilfercode.orion.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "tb_clinic")
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String cnpj;

    private String imageUrl;

    private boolean active;


    @ManyToMany(mappedBy = "clinics", fetch = FetchType.EAGER)
    private Set<User> users = new HashSet<>();

    @OneToMany(mappedBy = "clinic")
    private List<Patient> patients = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public Clinic(){}

    public Clinic(Long id){
        this.id = id;
    }

    public Clinic(Long id, String name, String cnpj, String imageUrl, Address address) {
        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
        this.imageUrl = imageUrl;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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
