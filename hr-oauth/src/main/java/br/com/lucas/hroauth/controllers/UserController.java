package br.com.lucas.hroauth.controllers;

import br.com.lucas.hroauth.services.UserService;
import br.com.lucas.hroauth.vos.UserVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/search")
    public ResponseEntity<UserVo> findByEmail(@RequestParam String email){
        var userVo = userService.findByEmail(email);
        return ResponseEntity.ok(userVo);
    }
}
