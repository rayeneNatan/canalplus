package com.canalplus.blueprint.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ContractDTO {

    private Long idContract;
    
    private String name;

    private SubscriberDTO subscriber;

    private LocalDateTime createDate = LocalDateTime.now();


    public ContractDTO() {
	
    }
}
