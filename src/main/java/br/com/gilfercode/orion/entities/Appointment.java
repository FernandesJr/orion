package br.com.gilfercode.orion.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Patient patient;

    @OneToOne
    @JoinColumn
    private Scheduling scheduling;

    private String anamnese;
    private String complaintMain;
    private Instant date;
    private String status;
    private Double price;
    private Double transferToDoctor;
    private Double profit;

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

    public Patient getPatient() {return patient;}

    public void setPatient(Patient patient) {this.patient = patient;}

    public String getComplaintMain() {return complaintMain;}

    public void setComplaintMain(String complaintMain) {this.complaintMain = complaintMain;}

    public Scheduling getScheduling() {
        return scheduling;
    }

    public void setScheduling(Scheduling scheduling) {
        this.scheduling = scheduling;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTransferToDoctor() {
        return transferToDoctor;
    }

    public void setTransferToDoctor(Double transferToDoctor) {
        this.transferToDoctor = transferToDoctor;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
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
