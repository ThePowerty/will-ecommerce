package com.williams.will_ecommerce.auth.security.config;

import com.williams.will_ecommerce.auth.entities.util.Permission;
import com.williams.will_ecommerce.auth.security.jwt.filter.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Clase para la configuración de seguridad Spring Security
 */
@Configuration
@EnableWebSecurity // permite a Spring aplicar esta configuracion a la configuraicon de seguridad global
public class SecurityConfig {

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private UnauthorizedEntryPoint authEntryPoint;

    @Autowired
    private CustomAccessDeniedHandler accessDeniedHandler;

    @Autowired
    private JwtAuthenticationFilter authenticationFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(sessionMangaConfig -> sessionMangaConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(authorize -> {
                            authorize.requestMatchers("/auth/**").permitAll();

                            // UserController
                            authorize.requestMatchers(HttpMethod.GET, "/user/{id}").hasAnyAuthority(Permission.READ_USERS.name(), Permission.MANAGE_ROLES.name());
                            authorize.requestMatchers(HttpMethod.GET, "/user").hasAnyAuthority(Permission.READ_USERS.name(), Permission.MANAGE_ROLES.name());
                            authorize.requestMatchers(HttpMethod.DELETE, "/user/{id}").hasAnyAuthority(Permission.DELETE_USERS.name(), Permission.MANAGE_ROLES.name());
                            authorize.requestMatchers(HttpMethod.GET, "/user/count").hasAnyAuthority(Permission.READ_USERS.name(), Permission.MANAGE_ROLES.name());
                            authorize.requestMatchers(HttpMethod.GET, "/user/role/{role}").hasAnyAuthority(Permission.READ_USERS.name(), Permission.MANAGE_ROLES.name());

                            // CarController
                            authorize.requestMatchers(HttpMethod.GET, "/cars").hasAnyAuthority(Permission.READ_VEHICLES.name(), Permission.MANAGE_ROLES.name());
                            authorize.requestMatchers(HttpMethod.GET, "/cars/{id}").hasAnyAuthority(Permission.READ_VEHICLES.name(), Permission.MANAGE_ROLES.name());
                            authorize.requestMatchers(HttpMethod.GET, "/cars/doors/{doors}").hasAnyAuthority(Permission.READ_VEHICLES.name(), Permission.MANAGE_ROLES.name());
                            authorize.requestMatchers(HttpMethod.GET, "/cars/manufacturer/{manufacturer}").hasAnyAuthority(Permission.READ_VEHICLES.name(), Permission.MANAGE_ROLES.name());
                            authorize.requestMatchers(HttpMethod.GET, "/cars/model/{model}").hasAnyAuthority(Permission.READ_VEHICLES.name(), Permission.MANAGE_ROLES.name());
                            authorize.requestMatchers(HttpMethod.GET, "/cars/fuelType/{fuelType}").hasAnyAuthority(Permission.READ_VEHICLES.name(), Permission.MANAGE_ROLES.name());
                            authorize.requestMatchers(HttpMethod.GET, "/cars/status/{status}").hasAnyAuthority(Permission.READ_VEHICLES.name(), Permission.MANAGE_ROLES.name());
                            authorize.requestMatchers(HttpMethod.GET, "/cars/seats/{seats}").hasAnyAuthority(Permission.READ_VEHICLES.name(), Permission.MANAGE_ROLES.name());
                            authorize.requestMatchers(HttpMethod.POST, "/cars").hasAnyAuthority(Permission.CREATE_VEHICLES.name(), Permission.MANAGE_ROLES.name());
                            authorize.requestMatchers(HttpMethod.DELETE, "/cars/{id}").hasAnyAuthority(Permission.DELETE_VEHICLES.name(), Permission.MANAGE_ROLES.name());
                            authorize.requestMatchers(HttpMethod.DELETE, "/cars").hasAnyAuthority(Permission.DELETE_VEHICLES.name(), Permission.MANAGE_ROLES.name());

                            // EmployeeController
                            authorize.requestMatchers(HttpMethod.POST, "/employee").hasAnyAuthority(Permission.CREATE_EMPLOYEES.name(), Permission.MANAGE_ROLES.name());
                            authorize.requestMatchers(HttpMethod.PUT, "/employee/{id}").hasAnyAuthority(Permission.UPDATE_EMPLOYEES.name(), Permission.MANAGE_ROLES.name());
                            authorize.requestMatchers(HttpMethod.PUT, "/employee/permission/{id}/{role}").hasAnyAuthority(Permission.MANAGE_ROLES.name());
                            authorize.requestMatchers(HttpMethod.GET, "/employee/{id}").hasAnyAuthority(Permission.READ_EMPLOYEES.name(), Permission.MANAGE_ROLES.name());
                            authorize.requestMatchers(HttpMethod.GET, "/employee").hasAnyAuthority(Permission.READ_EMPLOYEES.name(), Permission.MANAGE_ROLES.name());
                            authorize.requestMatchers(HttpMethod.DELETE, "/employee/{id}").hasAnyAuthority(Permission.DELETE_EMPLOYEES.name(), Permission.MANAGE_ROLES.name());

                            // SalesController
                            authorize.requestMatchers(HttpMethod.GET, "/sales").hasAnyAuthority(Permission.READ_SALES.name(), Permission.MANAGE_ROLES.name());
                            authorize.requestMatchers(HttpMethod.GET, "/sales/{id}").hasAnyAuthority(Permission.READ_SALES.name(), Permission.MANAGE_ROLES.name());
                            authorize.requestMatchers(HttpMethod.GET, "/sales/status/{saleStatus}").hasAnyAuthority(Permission.READ_SALES.name(), Permission.MANAGE_ROLES.name());
                            authorize.requestMatchers(HttpMethod.POST, "/sales").hasAnyAuthority(Permission.CREATE_SALES.name(), Permission.MANAGE_ROLES.name());
                            authorize.requestMatchers(HttpMethod.DELETE, "/sales/{id}").hasAnyAuthority(Permission.DELETE_SALES.name(), Permission.MANAGE_ROLES.name());
                            authorize.requestMatchers(HttpMethod.DELETE, "/sales").hasAnyAuthority(Permission.DELETE_SALES.name(), Permission.MANAGE_ROLES.name());
                            authorize.requestMatchers(HttpMethod.DELETE, "/sales/many/{ids}").hasAnyAuthority(Permission.DELETE_SALES.name(), Permission.MANAGE_ROLES.name());

                            authorize.anyRequest().authenticated();
                        }
                )
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .exceptionHandling(exceptionHandling -> exceptionHandling
                        .authenticationEntryPoint(authEntryPoint)
                        .accessDeniedHandler(accessDeniedHandler));
        return http.build();
    }

}
