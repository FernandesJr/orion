package br.com.gilfercode.orion.dto.clinic;

import br.com.gilfercode.orion.entities.Address;
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

    private Address address;

    public ClinicDTO(){}

    public ClinicDTO(Long id, String name, String cnpj, String imageUrl, Address address) {
        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
        this.imageUrl = imageUrl;
        this.address = address;
    }

    public ClinicDTO(Clinic entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.cnpj = entity.getCnpj();
        this.imageUrl = entity.getImageUrl();
        this.address = entity.getAddress();
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
