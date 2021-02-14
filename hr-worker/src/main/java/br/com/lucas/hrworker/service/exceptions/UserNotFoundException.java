package br.com.lucas.hrworker.service.exceptions;

public class UserNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public UserNotFoundException(String s){
        super(s);
    }
}
