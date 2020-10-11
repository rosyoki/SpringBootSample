package com.rosyoki.spring.boot.sample.app.handler;

import com.rosyoki.spring.boot.sample.app.domain.exception.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<?> handle404(NotFoundException exception, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
//        return this.handleExceptionInternal(exception, exception.getMessage(), headers, HttpStatus.NOT_FOUND, request);

        return buildResponseEntity(new ApiError(
                HttpStatus.NOT_FOUND,
                LocalDateTime.now(),
                exception.getMessage()
        ));
    }

    private ResponseEntity<?> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getHttpStatus());
    }
}
