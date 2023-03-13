package br.com.gilfercode.orion.dto.scheduling;

import br.com.gilfercode.orion.entities.Scheduling;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SchedulingDTO implements Serializable {

    private Long id;

    @NotNull
    private LocalDateTime start;

    @NotNull
    private LocalDateTime finish;

    @NotNull
    private Long roomId;

    public SchedulingDTO(){}

    public SchedulingDTO(Scheduling entity){
        this.id = entity.getId();
        this.start = entity.getStart();
        this.finish = entity.getFinish();
        this.roomId = entity.getRoom().getId();
    }

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

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
}
