package br.com.gilfercode.orion.dto;

import br.com.gilfercode.orion.services.validation.UserInsertValid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@UserInsertValid
public class UserInsertDTO implements Serializable {


    private String email;

    @NotBlank(message = "Campo requerido")
    private String password;

    @NotNull(message = "Campo não pode ser nulo")
    private Long ClinicId;

    public UserInsertDTO() {}

    public UserInsertDTO(String email, String password, Long clinicId) {
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
}
