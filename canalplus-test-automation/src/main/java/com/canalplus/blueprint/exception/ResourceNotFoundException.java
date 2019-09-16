package com.canalplus.blueprint.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = -4273749534197457336L;

    private String resourceName;

    private String fieldName;

    private Object fieldValue;

    public ResourceNotFoundException(final String resourceName, final String fieldName) {
	super(String.format("%s : %s not found. '", resourceName, fieldName));
	this.resourceName = resourceName;
	this.fieldName = fieldName;
    }

    public ResourceNotFoundException() {
    }

}
