package com.canalplus.blueprint.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CountryEnum {

    FRANCE("France"),
    
    UNKNOWN("");

    private String name;

    CountryEnum(String name) {
	this.name = name;
    }

    @JsonValue
    public String getName() {
	return name;
    }
}
