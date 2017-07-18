package rashjz.info.com.az.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.social.security.SpringSocialConfigurer;
import rashjz.info.com.az.social.SimpleSocialUserDetailsService;
//import rashjz.info.com.az.configuration.SimpleSocialUserDetailsService;

/**
 *
 * @author Rashad Javadov
 */
@Configuration
@ComponentScan("rashjz.info.com.az")
@EnableWebSecurity
@PropertySource("classpath:application.properties")
public class MVCSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    Environment env;

    @Autowired
    @Qualifier("customUserDetailsService")
    UserDetailsService userDetailsService;

    @Autowired
    PersistentTokenRepository tokenRepository;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenBasedRememberMeServices getPersistentTokenBasedRememberMeServices() {
        PersistentTokenBasedRememberMeServices tokenBasedservice = new PersistentTokenBasedRememberMeServices(
                "remember-me", userDetailsService, tokenRepository);
        return tokenBasedservice;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public AuthenticationTrustResolver getAuthenticationTrustResolver() {
        return new AuthenticationTrustResolverImpl();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/resources/**", "/uploadimage", "/contact").permitAll()
                .antMatchers("/checkout").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
                .antMatchers("/profile").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
                .antMatchers("/addtocard").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
                .antMatchers("/productsuser/*").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
                .antMatchers("/editproduct").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
                .antMatchers("/product/add").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .and()
                .formLogin().loginPage("/login").failureUrl("/login?error")
                .successHandler(successHandler())
                .usernameParameter("ssoId").passwordParameter("password")
                .and()
                .logout().logoutSuccessUrl("/login?logout")
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .rememberMe().rememberMeParameter("remember-me")
                .tokenRepository(tokenRepository)
                .tokenValiditySeconds(86400)
                .and()
                .apply(getSpringSocialConfigurer())
                .and()
                .csrf().disable();

    }

    @Bean
    public SocialUserDetailsService socialUserDetailsService() {
        return new SimpleSocialUserDetailsService(userDetailsService);
    }

    @Bean
    public AuthenticationSuccessHandler successHandler() {
        return new UserLoginSuccessHandler();
    }

    @Bean
    public SpringSocialConfigurer getSpringSocialConfigurer() {
        SpringSocialConfigurer config = new SpringSocialConfigurer();
        config.alwaysUsePostLoginUrl(true);
        config.postLoginUrl("/home");
        return config;
    }
}
