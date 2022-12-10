package PosBackend.Config.security;

import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
@KeycloakConfiguration
public class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter {
    @Override
    protected org.springframework.security.web.authentication.session.SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(keycloakAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.authorizeRequests() .antMatchers("/h2/**").permitAll()
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                //.antMatchers("/categorie/**").hasAnyAuthority("ADMIN", "MANAGER")
                .antMatchers("/commande/**").hasAuthority("VENDEUR")
                //.antMatchers("/entrepot/**").hasAuthority("ADMIN")
                .antMatchers("/entreprise/**").hasAuthority("ADMIN");
               // .antMatchers("/manager/**").hasAuthority("ADMIN")

                //.antMatchers("/produit/**").hasAuthority("MANAGER");
                //.antMatchers("/vendeur/**").hasAnyAuthority("MANAGER", "ADMIN");
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}


