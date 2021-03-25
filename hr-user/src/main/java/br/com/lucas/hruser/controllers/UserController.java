package br.com.lucas.hruser.controllers;

import br.com.lucas.hruser.entities.User;
import br.com.lucas.hruser.services.UserService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<User> findById(@RequestParam String email){
        return ResponseEntity.ok(userService.findByEmail(email));
    }
}
