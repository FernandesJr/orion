package br.com.gilfercode.orion.entities;

import java.util.Objects;

public class User {

    private Long id;
    private String email;
    private String password;
    private String verificationCode;
    private boolean active;
    private Role role;

    public User(){}

    public User(Long id, String email, String password, String verificationCode, boolean active, Role role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.verificationCode = verificationCode;
        this.active = active;
        this.role = role;
    }

    /*Gets and Sets*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    /*Equals*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
