package br.com.gilfercode.orion.entities;

import br.com.gilfercode.orion.enums.TypesRole;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authority;

    public Role(){}

    public Role(TypesRole role) {
        this.id = role.getCod();
        this.authority = role.getDesc();
    }

    public Role(String authority) {
        this.authority = authority;
    }

    /*Gets and Sets*/
    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
