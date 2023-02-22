package br.com.gilfercode.orion.entities;

import java.util.Objects;

public class Address {

    private Long id;
    private String street;
    private String district;
    private String city;
    private String state;
    private Integer number;

    public Address(){}

    public Address(Long id, String street, String district, String city, String state, Integer number) {
        this.id = id;
        this.street = street;
        this.district = district;
        this.city = city;
        this.state = state;
        this.number = number;
    }

    /*Gets and Sets*/
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

    /*Equals*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(getId(), address.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
