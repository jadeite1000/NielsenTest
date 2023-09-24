package exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@ControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class NielsenServiceExceptionHandler extends ResponseEntityExceptionHandler{

    private static final String VERSION = "0.2";


    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<Object> handleUnknownServerException(RuntimeException ex, WebRequest request) {
     
        ErrorMessage errorMessage = new ErrorMessage("500", ex.getMessage());
        List<ErrorMessage> errors = new ArrayList<>();

        errors.add(errorMessage);
        return ResponseEntity.status(500).body(
                ErrorResponse.builder()
                        .version(VERSION)
                        .httpStatusCode(500)
                        .errors(errors)
                        .build());
    }
    
    @ExceptionHandler(value = {HttpClientErrorException.class})
    public ResponseEntity<Object> handleHttpClientErrorException(HttpClientErrorException ex, WebRequest request) {
        
        int statusCode = ex.getRawStatusCode();
        ErrorMessage errorMessage = new ErrorMessage(String.valueOf(statusCode), ex.getMessage());
        List<ErrorMessage> errors = new ArrayList<>();

        errors.add(errorMessage);
        return ResponseEntity.status(statusCode).body(
                ErrorResponse.builder()
                        .version(VERSION)
                        .httpStatusCode(statusCode)
                        .errors(errors)
                        .build());
    }
    
    @ExceptionHandler(value = {ResponseStatusException.class})
    public ResponseEntity<Object> handleResponseStatusException(ResponseStatusException ex, WebRequest request) {
       
        int statusCode = ex.getRawStatusCode();
     
        ErrorMessage errorMessage = new ErrorMessage(String.valueOf(statusCode), ex.getMessage());
        List<ErrorMessage> errors = new ArrayList<>();
        errors.add(errorMessage);
        return ResponseEntity.status(statusCode)
                .body(ErrorResponse.builder().version(VERSION).httpStatusCode(statusCode).errors(errors).build());
    }

    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        int statusCode = 400;
        ErrorMessage errorMessage = new ErrorMessage(String.valueOf(statusCode), ex.getMessage());
        List<ErrorMessage> errors = new ArrayList<>();
        errors.add(errorMessage);
        return ResponseEntity.status(400).body(
                ErrorResponse.builder()
                        .version(VERSION)
                        .httpStatusCode(statusCode)
                        .errors(errors)
                        .build());
    }
    
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {
        
        int statusCode = 500;
        ErrorMessage errorMessage = new ErrorMessage(String.valueOf(statusCode), ex.getMessage());
        List<ErrorMessage> errors = new ArrayList<>();
      
        errors.add(errorMessage);
        return ResponseEntity.status(statusCode).body(
                ErrorResponse.builder()
                        .version(VERSION)
                        .httpStatusCode(statusCode)
                        .errors(errors)
                        .build());
    }
}
