package io.javabrains.Controller.error;

import io.javabrains.Model.Entity;

public class NullIdException extends BadRequestException{

    public NullIdException(Entity entity) {
        super("error:id passed is null", entity);
    }
}
