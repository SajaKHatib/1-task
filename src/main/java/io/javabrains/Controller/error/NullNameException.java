package io.javabrains.Controller.error;

import io.javabrains.Model.Entity;

public class NullNameException extends BadRequestException{
    public NullNameException(Entity entity) {
        super("error:city name passed is null", entity);
    }
}
