package com.basecamp3api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDTO {

    private List<MessageErrorDTO> errors;

    public List<MessageErrorDTO> getErrors() {
        return errors;
    }

    public void setErrors(List<MessageErrorDTO> errors) {
        this.errors = errors;
    }
}
