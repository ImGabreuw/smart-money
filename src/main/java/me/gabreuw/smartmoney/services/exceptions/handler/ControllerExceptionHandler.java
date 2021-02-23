package me.gabreuw.smartmoney.services.exceptions.handler;

import me.gabreuw.smartmoney.services.exceptions.EntityNotFound;
import me.gabreuw.smartmoney.services.exceptions.StandardException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(EntityNotFound.class)
    public ResponseEntity<StandardException> entityNotFound(EntityNotFound exception, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardException standardException = new StandardException(
                System.currentTimeMillis(),
                status.value(),
                "Entidade não encontrada.",
                exception.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity
                .status(status)
                .body(standardException);
    }

}
