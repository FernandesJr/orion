package br.com.gilfercode.orion.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authority;

    public Role(){}

    public Role(String authority) {
        this.authority = authority;
    }

    /*Gets and Sets*/
    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getDescription() {
        return authority;
    }

    public void setDescription(String authority) {
        this.authority = authority;
    }
}
