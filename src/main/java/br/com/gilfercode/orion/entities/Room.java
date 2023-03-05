package br.com.gilfercode.orion.entities;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long number;

    private String name;

    private LocalTime startAppointments;

    private LocalTime finishAppointments;

    @OneToMany
    private List<Scheduling> schedulings;

    @ManyToOne
    private Clinic clinic;

    public Room(){}

    public Room(Long id, Long number, String name, Clinic clinic) {
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

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
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
