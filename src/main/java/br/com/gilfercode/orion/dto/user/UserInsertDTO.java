package br.com.gilfercode.orion.dto.user;

import br.com.gilfercode.orion.dto.role.RoleDTO;
import br.com.gilfercode.orion.entities.Role;
import br.com.gilfercode.orion.services.validation.UserInsertValid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@UserInsertValid
public class UserInsertDTO implements Serializable {


    @NotBlank(message = "Campo requerido")
    @Email(message = "Informe um e-mail válido")
    private String email;

    @NotBlank(message = "Campo requerido")
    private String password;

    @NotNull(message = "Campo não pode ser nulo")
    private Long ClinicId;

    private Set<RoleDTO> roles = new HashSet<>();

    public UserInsertDTO() {}

    public UserInsertDTO(String email, String password, Long clinicId) {
        this.email = email;
        this.password = password;
        ClinicId = clinicId;
    }

    public void addRoleDTO(RoleDTO role){
        this.roles.add(role);
    }

    public Set<RoleDTO> getRoles() {
        return roles;
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
