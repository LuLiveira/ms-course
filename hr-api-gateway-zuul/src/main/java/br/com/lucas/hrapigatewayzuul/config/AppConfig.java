package br.com.lucas.hrapigatewayzuul.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import static java.lang.String.format;

@RefreshScope
@Configuration
public class AppConfig {
    private static Logger LOGGER = LoggerFactory.getLogger(AppConfig.class);

    @Value("${jwt.secret}")
    private String signingKey;

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        LOGGER.info(format(" jwt.secret >>>>>>> %s ", signingKey));

        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
        tokenConverter.setSigningKey(signingKey);
        return tokenConverter;
    }

    @Bean
    public JwtTokenStore jwtTokenStore(){return new JwtTokenStore(jwtAccessTokenConverter());}

}
