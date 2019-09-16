package com.canalplus.blueprint.enumeration;

public enum CanalEnum {

    FACE("FACE"), EC("EC"), UNKNOWN("");

    private String name;

    CanalEnum(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }
}
