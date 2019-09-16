package com.canalplus.blueprint.dto;

import java.time.LocalDateTime;

import com.canalplus.blueprint.enumeration.CanalEnum;

import lombok.Data;

@Data
public class AdvisorDTO {

    private Long advisorID;

    private String username;

    private String lastName;

    private String email;

    private String password;

    private CanalEnum canal;
    
    private LocalDateTime createDate = LocalDateTime.now();
}
