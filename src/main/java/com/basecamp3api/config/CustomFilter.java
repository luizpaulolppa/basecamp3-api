package com.basecamp3api.config;

import com.basecamp3api.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class CustomFilter extends GenericFilterBean {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {


        String token = "123";
        String email = jwtTokenUtil.getUsernameFromToken(token);
        User userDetails = new User(email, "", new ArrayList());
        if (jwtTokenUtil.validateToken(token, userDetails)) {
            System.out.println("Token válido!!!");
        } else {
            System.out.println("Token inválido!!!");
        }

        filterChain.doFilter(request, response);
    }

}
