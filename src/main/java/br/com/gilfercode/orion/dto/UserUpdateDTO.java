package br.com.gilfercode.orion.dto;

import br.com.gilfercode.orion.services.validation.UserUpdateValid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;

@UserUpdateValid
public class UserUpdateDTO implements Serializable {

    @NotEmpty(message = "Campo obrigatório")
    @Email(message = "Informe um e-mail válido")
    private String email;

    private String password;

    private String confirmPassword;

    private boolean active;

    private Long clinicId;

    public UserUpdateDTO() {}

    public UserUpdateDTO(String email, String password, Long clinicId) {
        this.email = email;
        this.password = password;
        this.clinicId = clinicId;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Long getClinicId() {
        return clinicId;
    }

    public void setClinicId(Long clinicId) {
        this.clinicId = clinicId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "UserUpdateDTO{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", active=" + active +
                ", clinicId=" + clinicId +
                '}';
    }
}
