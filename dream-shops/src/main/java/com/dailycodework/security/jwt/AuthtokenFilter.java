package com.dailycodework.security.jwt;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;


import com.dailycodework.security.user.ShopUserDetailsService;

import jakarta.annotation.Nonnull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthtokenFilter extends OncePerRequestFilter {
    private JwtUtils jwtUtils;
    private ShopUserDetailsService shopUserDetailsService;
    @Override
    protected void doFilterInternal(@Nonnull HttpServletRequest request,
         HttpServletResponse response,
          FilterChain filterChain)
            throws ServletException, IOException {
                String jwt=parseJwt(request);
                if(StringUtils.hasText(jwt) && jwtUtils.validateToken(jwt)){
                    String username=jwtUtils.getUserNameFromToken(jwt);
                    UserDetails userDetails= shopUserDetailsService.loadUserByUsername(username);
                    Authentication auth=new UsernamePasswordAuthenticationToken(username,null,userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(auth);                    
                }

            filterChain.doFilter(request, response);
        }

        private String parseJwt(HttpServletRequest request){
            String headerAuth=request.getHeader("Authorization");
            if(StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")){
                return headerAuth.substring(7);
            }
            return null;
        }
}
