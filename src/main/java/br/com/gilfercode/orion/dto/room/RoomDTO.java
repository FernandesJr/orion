package br.com.gilfercode.orion.dto.room;

import br.com.gilfercode.orion.dto.scheduling.SchedulingDTO;
import br.com.gilfercode.orion.entities.Room;
import br.com.gilfercode.orion.services.validation.RoomValid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

@RoomValid
public class RoomDTO implements Serializable {

    private Long id;

    @NotNull
    private Integer number;

    @NotBlank
    private String name;

    @NotNull
    private LocalTime startAppointments;

    @NotNull
    private LocalTime finishAppointments;

    @NotNull
    private Long clinicId;

    private List<SchedulingDTO> scheduling;

    public RoomDTO(){}

    public RoomDTO(Long id, Integer number, String name, LocalTime startAppointments, LocalTime finishAppointments) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.startAppointments = startAppointments;
        this.finishAppointments = finishAppointments;
    }

    public RoomDTO(Room entity) {
        this.id = entity.getId();
        this.number = entity.getNumber();
        this.name = entity.getName();
        this.startAppointments = entity.getStartAppointments();
        this.finishAppointments = entity.getFinishAppointments();
        this.clinicId = entity.getClinic().getId();
        entity.getScheduling().forEach(e -> addScheduling(new SchedulingDTO(e)));
    }

    public void addScheduling(SchedulingDTO schedulingDTO){
        this.scheduling.add(schedulingDTO);
    }

    public List<SchedulingDTO> getScheduling(){
        return scheduling;
    }

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

    public Long getClinicId() {
        return clinicId;
    }

    public void setClinicId(Long clinicId) {
        this.clinicId = clinicId;
    }
}
