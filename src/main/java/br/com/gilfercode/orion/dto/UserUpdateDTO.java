package br.com.gilfercode.orion.dto;

import br.com.gilfercode.orion.services.validation.UserUpdateValid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@UserUpdateValid
public class UserUpdateDTO implements Serializable {

    @NotBlank(message = "Campo requerido")
    private String email;

    private String password;

    private String ConfirmPassword;

    @NotNull(message = "Campo não pode ser nulo")
    private Long ClinicId;

    public UserUpdateDTO() {}

    public UserUpdateDTO(String email, String password, Long clinicId) {
        this.email = email;
        this.password = password;
        ClinicId = clinicId;
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

    public Long getClinicId() {
        return ClinicId;
    }

    public void setClinicId(Long clinicId) {
        ClinicId = clinicId;
    }

    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        ConfirmPassword = confirmPassword;
    }
}
