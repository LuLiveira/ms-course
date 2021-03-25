package br.com.lucas.hroauth.clients;

import br.com.lucas.hroauth.vos.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "hr-user", path = "/users")
public interface UserClient {

    @GetMapping("/search")
    ResponseEntity<UserVo> findByEmail(@RequestParam final String email);
}
