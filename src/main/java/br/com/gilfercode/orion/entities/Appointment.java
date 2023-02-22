package br.com.gilfercode.orion.entities;

import java.time.Instant;
import java.util.Objects;

public class Appointment {

    private Long id;
    private Doctor doctor;
    private String anamnese;
    private Instant date;
    private String status;

    public Appointment(){}

    public Appointment(Long id, Doctor doctor, String anamnese, Instant date, String status) {
        this.id = id;
        this.doctor = doctor;
        this.anamnese = anamnese;
        this.date = date;
        this.status = status;
    }

    /*Gets and Sets*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getAnamnese() {
        return anamnese;
    }

    public void setAnamnese(String anamnese) {
        this.anamnese = anamnese;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /*Equals*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appointment)) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
