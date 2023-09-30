package com.sfd.msa.user.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class BlockPetitionConfig extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(request.getMethod().equals("OPTIONS") || request.getMethod().equals("HEAD")){
            response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }else{
            filterChain.doFilter(request, response);
        }
    }
}
