package com.canalplus.blueprint.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import com.canalplus.blueprint.enumeration.MovementEnum;

import lombok.Data;

@Data
@Entity
@Table(name = "movement")
public class Movement implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -7560181593169787260L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mvmtID;

    @Column
    private String value;

    @Enumerated(EnumType.STRING)
    private MovementEnum movementType = MovementEnum.UNKNOWN;

    @ManyToOne
    @JoinColumn(name = "advisorID")
    private Advisor advisor;

    @CreatedDate
    private LocalDateTime modifDate = LocalDateTime.now();

    public Movement() {
	super();
    }

    public Movement(String value, MovementEnum movementType, Advisor advisor) {
	this.value = value;
	this.movementType = movementType;
	this.advisor = advisor;
    }

}
