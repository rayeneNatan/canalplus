package com.canalplus.blueprint.enumeration;

public enum MovementEnum {

    ADRESS_CHANGE("ADRESS_CHANGE"),

    UNKNOWN("");

    private String name;

    MovementEnum(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }
}
