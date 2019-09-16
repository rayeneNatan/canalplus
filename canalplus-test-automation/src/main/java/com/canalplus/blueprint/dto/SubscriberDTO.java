package com.canalplus.blueprint.dto;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class SubscriberDTO {

    private Long id;

    private String username;

    private String lastName;

    private String email;

    private String password;

    private AddressDTO address;

    public AdvisorDTO advisor;

    private Set<MovementDTO> movements = new HashSet<>();

    private LocalDateTime createDate = LocalDateTime.now();

}
