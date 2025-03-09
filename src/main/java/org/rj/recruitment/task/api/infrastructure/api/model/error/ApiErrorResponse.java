package org.rj.recruitment.task.api.infrastructure.api.model.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class ApiErrorResponse {

    private int status;
    private String message;
}
