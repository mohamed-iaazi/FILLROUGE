package com.medo.backend.auth.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNullApi;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.swing.text.html.parser.Parser;
import java.io.IOException;


@Component
public class JwtAuthFilter extends OncePerRequestFilter {
    JwtService jwtService;

    UserDetailServiceImpl userDetailService;

    @Autowired
    public JwtAuthFilter(JwtService jwtService, UserDetailServiceImpl userDetailService) {
        this.jwtService = jwtService;
        this.userDetailService = userDetailService;

    }



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {



        try {

                String jwt = parseJwt(request);
            if (StringUtils.hasText(jwt)){

                String username =jwtService.getUsernameFromToken(jwt);

                if (username != null && SecurityContextHolder.getContext().getAuthentication()==null) {

                    UserDetails userDetails = userDetailService.loadUserByUsername(username);

                    if (userDetails != null && jwtService.validateJwtToken(jwt, userDetails)) {

                        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                        authenticationToken.setDetails(new WebAuthenticationDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authenticationToken);


                    }

                }
            }
            filterChain.doFilter(request, response);





        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }

    private String parseJwt(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7);
        }
        return null;
    }
}
