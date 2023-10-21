package com.kurtfinancial.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter
        implements SmartInitializingSingleton
{
    private AuthenticationManagerBuilder authMgrBuilder;
    private AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManagerBuilder authMgrBuilder) {
        this.authMgrBuilder = authMgrBuilder;
    }

    @Override
    public void afterSingletonsInstantiated() {
        this.authenticationManager = authMgrBuilder.getObject();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

    }
}
