package br.com.gilfercode.orion.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Patient {

    private Long id;
    private String name;
    private String cpf;
    private LocalDate dateBirth;
    private String phone;
    private Address address;
    private List<Appointment> appointments = new ArrayList<>();

    public Patient(){}

    public Patient(Long id, String name, String cpf, LocalDate dateBirth, String phone, Address address) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.dateBirth = dateBirth;
        this.phone = phone;
        this.address = address;
    }

    /*Gets and Sets*/
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    /*Equals*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return Objects.equals(getId(), patient.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
