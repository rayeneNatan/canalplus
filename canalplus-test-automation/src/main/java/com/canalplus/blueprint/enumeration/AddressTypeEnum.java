package com.canalplus.blueprint.enumeration;

public enum AddressTypeEnum {

    PRINCIPAL("principal"), 
    SECONDARY("secondary"), 
    UNKNOWN("");

    private String name;

    AddressTypeEnum(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }
}
