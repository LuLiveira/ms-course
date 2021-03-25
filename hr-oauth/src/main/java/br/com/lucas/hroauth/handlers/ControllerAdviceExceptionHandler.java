package br.com.lucas.hroauth.handlers;

import br.com.lucas.hroauth.exceptions.UserNotFoundException;
import br.com.lucas.hroauth.handlers.utils.Erro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerAdviceExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Erro> handleUserNotFoundException(UserNotFoundException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Erro(e::getMessage, request::getServletPath));
    }

}
