package org.bootcamp.evaluacion001.exceptions;

import org.bootcamp.evaluacion001.services.impl.AfpServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ControllerAdvice
@RestController // interceptar todas las excepciones que salgan del api
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    private static final org.slf4j.Logger log =  org.slf4j.LoggerFactory.getLogger(ResponseExceptionHandler.class);

    @ExceptionHandler(ModelNotFoundException.class)
    public  final ResponseEntity<ExceptionResponse> handleModelNotFoundException(ModelNotFoundException model, WebRequest web){
        var exception = new ExceptionResponse(LocalDateTime.now(), model.getMessage(), web.getDescription(false));
        log.error(exception.toString());
        return new ResponseEntity<ExceptionResponse>(exception,HttpStatus.NOT_FOUND);
    }

    @Override
    public final ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        var errorList = ex.getBindingResult().getAllErrors().stream().map(x->x.getDefaultMessage()).collect(Collectors.toList());
        String mensaje = errorList.toString();
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), mensaje, request.getDescription(false));
        log.error(exceptionResponse.toString());
        return new ResponseEntity<Object>(exceptionResponse,HttpStatus.BAD_REQUEST);
    }
}
