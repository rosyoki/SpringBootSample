package com.rosyoki.spring.boot.sample.app.handler;

import com.rosyoki.spring.boot.sample.app.domain.exception.BusinessException;
import com.rosyoki.spring.boot.sample.app.domain.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<?> handle404(NotFoundException notFoundException, WebRequest request) {
        return buildResponseEntity(new ApiError(
                HttpStatus.NOT_FOUND,
                LocalDateTime.now(),
                notFoundException.getMessage()
        ));
    }

    @ExceptionHandler({BusinessException.class})
    public ResponseEntity<?> handleBusinessException(BusinessException businessException, WebRequest request) {
        log.debug(">>> BusinessException >>>> ");
        return buildResponseEntity(new ApiError(
                HttpStatus.CONFLICT,
                LocalDateTime.now(),
                businessException.getMessage()
        ));
    }

    private ResponseEntity<?> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getHttpStatus());
    }
}
