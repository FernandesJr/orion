package br.com.gilfercode.orion.dto.clinic;

import br.com.gilfercode.orion.dto.address.AddressDTO;
import br.com.gilfercode.orion.services.validation.ClinicInsertValid;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@ClinicInsertValid
public class ClinicInsertDTO implements Serializable {

    @NotBlank
    private String name;

    @NotBlank
    private String cnpj;

    private String imageUrl;

    private boolean active;

    @Valid
    @NotNull
    private AddressDTO address;

    public ClinicInsertDTO(){}

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

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO addressDto) {
        this.address = addressDto;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
