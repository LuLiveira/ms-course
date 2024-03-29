package br.com.lucas.hroauth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.time.Duration;

@RefreshScope
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtAccessTokenConverter jwtAccessTokenConverter;
    private final JwtTokenStore jwtTokenStore;
    private final AuthenticationManager authenticationManager;

    @Value("${oauth.client.name}")
    private String clientId;
    @Value("${oauth.client.secret}")
    private String clientSecret;

    public AuthorizationServerConfig(BCryptPasswordEncoder bCryptPasswordEncoder, JwtAccessTokenConverter jwtAccessTokenConverter, JwtTokenStore jwtTokenStore, AuthenticationManager authenticationManager) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.jwtAccessTokenConverter = jwtAccessTokenConverter;
        this.jwtTokenStore = jwtTokenStore;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
       security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient(clientId)
                .secret(bCryptPasswordEncoder.encode(clientSecret))
                .scopes("read", "write")
                .authorizedGrantTypes("password")
                .accessTokenValiditySeconds(Duration.ofMillis(86400).toMillisPart());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                .tokenStore(jwtTokenStore)
                .accessTokenConverter(jwtAccessTokenConverter);
    }
}
