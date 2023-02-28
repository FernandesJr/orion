package br.com.gilfercode.orion.dto;

import br.com.gilfercode.orion.entities.User;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class UserDTO implements Serializable {

    private Long id;
    private String email;
    private Set<RoleDTO> roles = new HashSet<>();
    private Set<Long> clinicsId = new HashSet<>();

    public UserDTO(){}

    public String getEmail() {
        return email;
    }

    public UserDTO(Long id, String email, Set<RoleDTO> roles) {
        this.id = id;
        this.email = email;
        this.roles = roles;
    }

    public UserDTO(User entity) {
        this.id = entity.getId();
        this.email = entity.getEmail();
        entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
        entity.getClinics().forEach(clinic -> this.clinicsId.add(clinic.getId()));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleDTO> roles) {
        this.roles = roles;
    }

    public Set<Long> getClinicsId() {
        return clinicsId;
    }

    public void setClinicsId(Set<Long> clinics) {
        this.clinicsId = clinics;
    }
}
