package br.com.gilfercode.orion.entities;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer number;

    private String name;

    private LocalTime startAppointments;

    private LocalTime finishAppointments;

    private boolean active;

    @OneToMany
    private List<Scheduling> scheduling = new ArrayList<>();

    @ManyToOne
    private Clinic clinic;

    public Room(){}

    public Room(Long id, Integer number, String name, Clinic clinic) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.clinic = clinic;
    }

    /*Gets and Sets*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public LocalTime getStartAppointments() {
        return startAppointments;
    }

    public void setStartAppointments(LocalTime startAppointments) {
        this.startAppointments = startAppointments;
    }

    public LocalTime getFinishAppointments() {
        return finishAppointments;
    }

    public void setFinishAppointments(LocalTime finishAppointments) {
        this.finishAppointments = finishAppointments;
    }

    public List<Scheduling> getScheduling() {
        return scheduling;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    /*Equals*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return Objects.equals(getId(), room.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
