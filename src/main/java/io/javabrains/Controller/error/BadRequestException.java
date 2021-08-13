package io.javabrains.Controller.error;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;
import io.javabrains.Model.Entity;
public class BadRequestException extends AbstractThrowableProblem {
    private Entity entity;

    BadRequestException(String massage, Entity entity){
        super(null, massage, Status.BAD_REQUEST);
        this.entity = entity;
    }


}
