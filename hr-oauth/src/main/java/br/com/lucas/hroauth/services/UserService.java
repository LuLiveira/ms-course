package br.com.lucas.hroauth.services;

import br.com.lucas.hroauth.clients.UserClient;
import br.com.lucas.hroauth.exceptions.UserNotFoundException;
import br.com.lucas.hroauth.vos.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserClient userClient;

    public UserService(final UserClient userClient) {
        this.userClient = userClient;
    }

    public UserVo findByEmail(String email) {
        var userVo = userClient.findByEmail(email).getBody();

        verifyIfUserExists(userVo);
        LOGGER.error("Usuário encontrado.");

        return userVo;
    }

    private void verifyIfUserExists(UserVo userVo) {
        if(userVo == null) {
            LOGGER.error("Usuário não encontrado.");
            throw new UserNotFoundException("Usuário não encontrado.");
        }
    }
}
