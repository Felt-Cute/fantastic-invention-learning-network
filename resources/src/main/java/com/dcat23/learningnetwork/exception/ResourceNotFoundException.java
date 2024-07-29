package com.dcat23.learningnetwork.exception;

import com.dcat23.exception.GenericNotFoundException;
import lombok.Getter;

@Getter
public class ResourceNotFoundException extends GenericNotFoundException {

    public ResourceNotFoundException(Long resourceId) {
        super(resourceId);
    }
}
