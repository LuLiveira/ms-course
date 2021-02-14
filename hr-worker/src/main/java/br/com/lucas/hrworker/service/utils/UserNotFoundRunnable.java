package br.com.lucas.hrworker.service.utils;

import br.com.lucas.hrworker.service.exceptions.UserNotFoundException;

public class UserNotFoundRunnable implements Runnable {

    @Override
    public void run() {
        throw new UserNotFoundException("User not found.");
    }
    
}
