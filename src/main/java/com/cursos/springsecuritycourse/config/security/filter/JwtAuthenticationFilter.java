package com.cursos.springsecuritycourse.config.security.filter;

import com.cursos.springsecuritycourse.entity.User;
import com.cursos.springsecuritycourse.repository.UserRepository;
import com.cursos.springsecuritycourse.services.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserRepository userRepository;


    public JwtAuthenticationFilter(JwtService jwtService, UserRepository userRepository){
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // 1. Obtener el header que contiene el jwt
        String authHeader =  request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            return;
        }

        // 2. Obtener el jwt desde header
        String jwt = authHeader.split(" ")[1];

        // 3. Obtener el subject/username desde el jtw
        String username = jwtService.extractUsername(jwt);

        // 4. Setear un objeto Authnetication dentro del SecurityContext

        User user = userRepository.findByUserName(username).get();

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, null, user.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        // 5. Ejecutar el resto de filtros

        filterChain.doFilter(request, response);

    }
}
