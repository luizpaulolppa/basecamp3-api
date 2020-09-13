package com.basecamp3api.exception;

import com.basecamp3api.dto.ErrorDTO;
import com.basecamp3api.dto.MessageErrorDTO;

import java.util.ArrayList;
import java.util.List;

public class BusinessException extends RuntimeException {

    private List<MessageErrorDTO> messagesError;

    public BusinessException(String message) {
        messagesError = new ArrayList();
        messagesError.add(new MessageErrorDTO(message));
    }

    public ErrorDTO getErrors() {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setErrors(messagesError);
        return errorDTO;
    }
}
