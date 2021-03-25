package br.com.lucas.hroauth.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import static java.lang.String.format;

@Configuration
public class AppConfig {

    private static Logger LOGGER = LoggerFactory.getLogger(AppConfig.class);

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){return new BCryptPasswordEncoder();}

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        LOGGER.info(format(" jwt.secret >>>>>>> %s ", jwtSecret));

        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
        tokenConverter.setSigningKey(jwtSecret);
        return tokenConverter;
    }

    @Bean
    public JwtTokenStore jwtTokenStore(){return new JwtTokenStore(jwtAccessTokenConverter());}
}
