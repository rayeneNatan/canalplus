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
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import com.canalplus.blueprint.enumeration.CanalEnum;

import lombok.Data;

@Data
@Entity
@Table(name = "advisor")
public class Advisor implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -6206345087724826926L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advisorID;

    @Column
    private String username;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    private CanalEnum canal;

    @CreatedDate
    private LocalDateTime createDate = LocalDateTime.now();

    public Advisor() {
	super();
    }

    public Advisor(String username, CanalEnum canal) {
	this.username = username;
	this.canal = canal;
    }

}
