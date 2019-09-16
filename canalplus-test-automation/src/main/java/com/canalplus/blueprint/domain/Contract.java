package com.canalplus.blueprint.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Data
@Entity
@DynamicUpdate
@Table(name = "contract")
public class Contract implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 7988310176428839538L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContract;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "idSubscriber")
    private Subscriber subscriber;

    @CreatedDate
    private LocalDateTime createDate = LocalDateTime.now();

    public Contract() {
	super();
    }

    public Contract(String name) {
	this.name = name;
    }

}
