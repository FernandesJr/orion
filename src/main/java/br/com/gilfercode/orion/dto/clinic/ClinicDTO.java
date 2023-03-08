package br.com.gilfercode.orion.dto.clinic;

import br.com.gilfercode.orion.dto.address.AddressDTO;
import br.com.gilfercode.orion.entities.Clinic;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.Objects;

public class ClinicDTO implements Serializable {

    private Long id;

    @NotBlank
    private String name;

    private String cnpj;

    @NotBlank
    private String imageUrl;

    private AddressDTO address;

    private boolean active;

    public ClinicDTO(){}

    public ClinicDTO(Long id, String name, String cnpj, String imageUrl, AddressDTO addressDTO, boolean active) {
        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
        this.imageUrl = imageUrl;
        this.address = addressDTO;
        this.active = active;
    }

    public ClinicDTO(Clinic entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.cnpj = entity.getCnpj();
        this.imageUrl = entity.getImageUrl();
        this.address = new AddressDTO(entity.getAddress());
        this.active = entity.isActive();
    }

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

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO addressDTO) {
        this.address = addressDTO;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClinicDTO)) return false;
        ClinicDTO clinicDTO = (ClinicDTO) o;
        return Objects.equals(getId(), clinicDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
