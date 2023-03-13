package br.com.gilfercode.orion.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_scheduling")
public class Scheduling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime start;

    @Column(nullable = false)
    private LocalDateTime finish;

    @ManyToOne
    private Room room;

    public Scheduling(){}

    public Scheduling(Long id, LocalDateTime start) {
        this.id = id;
        this.start = start;
    }

    /*Gets and Sets*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getFinish() {
        return finish;
    }

    public void setFinish(LocalDateTime finish) {
        this.finish = finish;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    /*Equals*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Scheduling)) return false;
        Scheduling that = (Scheduling) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
