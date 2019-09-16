package com.canalplus.blueprint.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Data
@Entity
@DynamicUpdate
@Table(name = "subscriber")
public class Subscriber implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -7560181593169787260L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String password;

    @OneToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "addressID")
    private Address address;

    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "advisorID")
    public Advisor advisor;

    @OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
    @JoinColumn(name = "subscriberID")
    private Set<Movement> movements = new HashSet<>();

    @CreatedDate
    private LocalDateTime createDate = LocalDateTime.now();

    public Subscriber() {
	super();
    }


    public Subscriber(String username, Address address) {
	this.username = username;
	this.address = address;
    }

}
