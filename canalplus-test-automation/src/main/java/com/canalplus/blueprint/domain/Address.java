package com.canalplus.blueprint.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import com.canalplus.blueprint.enumeration.AddressTypeEnum;
import com.canalplus.blueprint.enumeration.CountryEnum;

import lombok.Data;

@Data
@Entity
@Indexed
@Table(name = "address")
public class Address implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -935401238715757971L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressID;

    @Enumerated(EnumType.STRING)
    private CountryEnum country;

    @Field
    private String state;

    @Field
    private String street;

    @Field
    private int number;

    @Field
    private String city;

    @Field
    private String zip;

    @Field
    private Boolean active;

    @Enumerated(EnumType.STRING)
    private AddressTypeEnum type;

    public Address() {
	super();
    }

    public Address(CountryEnum country, Boolean active, AddressTypeEnum type) {
	this.country = country;
	this.active = active;
	this.type = type;
    }

    @Override
    public String toString() {

	StringBuffer stringBuffer = new StringBuffer();
	stringBuffer.append("Address:");
	stringBuffer.append(this.street);
	stringBuffer.append(", Number:");
	stringBuffer.append(this.number);
	stringBuffer.append(", City:");
	stringBuffer.append(this.city);
	stringBuffer.append(", State:");
	stringBuffer.append(this.state);
	stringBuffer.append(", Postal Code:");
	stringBuffer.append(this.zip);

	return stringBuffer.toString();
    }
}
