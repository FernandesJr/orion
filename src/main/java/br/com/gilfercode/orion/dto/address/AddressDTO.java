package br.com.gilfercode.orion.dto.address;

import br.com.gilfercode.orion.entities.Address;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class AddressDTO implements Serializable {

    private Long id;

    @NotBlank
    private String street;

    @NotBlank
    private String district;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    @NotNull
    private Integer number;

    @NotBlank
    private String cep;

    private String complement;

    public AddressDTO(){}

    public AddressDTO(Long id, String street, String district, String city,
                      String state, Integer number, String cep, String complement) {
        this.id = id;
        this.street = street;
        this.district = district;
        this.city = city;
        this.state = state;
        this.number = number;
        this.cep = cep;
        this.complement = complement;
    }

    public AddressDTO(Address entity) {
        this.id = entity.getId();
        this.street = entity.getStreet();
        this.district = entity.getDistrict();
        this.city = entity.getCity();
        this.state = entity.getState();
        this.number = entity.getNumber();
        this.cep = entity.getCep();
        this.complement = entity.getComplement();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }
}
