package br.com.gilfercode.orion.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "tb_doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long councilNumber;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "tb_doctor_specialty",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "specialty_id")
    )
    private Set<Specialty> specialties = new HashSet<>();

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments = new ArrayList<>();

    @OneToOne
    private User user;

    public Doctor() {}

    public Doctor(Long id, String name, Long councilNumber) {
        this.id = id;
        this.name = name;
        this.councilNumber = councilNumber;
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

    public Long getCouncilNumber() {
        return councilNumber;
    }

    public void setCouncilNumber(Long councilNumber) {
        this.councilNumber = councilNumber;
    }

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    /*Equals*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor)) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(getId(), doctor.getId()) && Objects.equals(getCouncilNumber(), doctor.getCouncilNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCouncilNumber());
    }
}
