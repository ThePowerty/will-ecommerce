package com.williams.will_ecommerce.auth.security.jwt.filter;

import com.williams.will_ecommerce.auth.entities.User;
import com.williams.will_ecommerce.auth.repository.UserRepository;
import com.williams.will_ecommerce.auth.security.jwt.JwtService;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;
import java.util.regex.PatternSyntaxException;

/**
 * Se ejecuta por cada petición entrante con el fin de validar el token JWT
 * en caso de que lo sea se añade al contexto para indicar que un usuario está autenticado
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        //1. Obtener el header que contiene el jwt

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")){
            logger.warn("An error occurred while fetching header");
            filterChain.doFilter(request, response);
            return;
        }

        //2. Obtener jwt desde header
        String jwt = "";
        try {
           jwt = authHeader.split(" ")[1];
           logger.info("Getting token");
        } catch (PatternSyntaxException e) {
            logger.error("A syntax error in a regular-expression pattern");
            return;
        } catch (ExpiredJwtException e) {
            logger.warn("The token has expired", e);
            return;
        }

        //3. Obtener subject/email desde el jwt

        String email = jwtService.extractEmail(jwt);
        logger.info("Authenticated user {" + email + "}");

        //4. Setear un objeto Authentication dentro del SecurityContext

        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            logger.info("Seating user in Security Context");
            try {
                 UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                         email, null, user.getAuthorities()
                 );

                SecurityContextHolder.getContext().setAuthentication(authToken);

                //5. Ejecutar el resto de filtros

                filterChain.doFilter(request, response);
                logger.info("Executing filters");
            } catch (Exception e) {
                logger.error("An error occurred " + e);
            }
        } else {
            logger.error("Authentication Failed. Username not valid");
        }
    }
}
