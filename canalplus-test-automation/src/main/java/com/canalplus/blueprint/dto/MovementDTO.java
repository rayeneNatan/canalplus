package com.canalplus.blueprint.dto;

import java.time.LocalDateTime;

import com.canalplus.blueprint.enumeration.MovementEnum;

import lombok.Data;

@Data
public class MovementDTO {

    private Long mvmtID;

    private String value;

    private MovementEnum movementType = MovementEnum.UNKNOWN;

    private AdvisorDTO advisor;

    private LocalDateTime modifDate = LocalDateTime.now();

    public MovementDTO() {
	
    }
}
