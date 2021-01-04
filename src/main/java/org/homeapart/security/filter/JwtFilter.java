package org.homeapart.security.filter;

import lombok.RequiredArgsConstructor;
import org.homeapart.security.service.UserProvider;
import org.homeapart.security.util.CustomHeaders;
import org.homeapart.security.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtFilter  extends OncePerRequestFilter {

    private  final TokenUtils tokenUtils;

    private final UserProvider userProvider;



    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

    String authToken = request.getHeader(CustomHeaders.AUTH_HEADER);
        if (authToken != null) {
            String username = tokenUtils.getUsernameFromToken(authToken);


            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = userProvider.loadUserByUsername(username);
                if (tokenUtils.validateToken(authToken, userDetails)) {
                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
                else if (tokenUtils.canTokenBeRefreshed(authToken,tokenUtils.getCreatedDateFromToken(authToken))){
                    String refreshToken=tokenUtils.refreshToken(authToken);
                    if(refreshToken!=null){
                        UsernamePasswordAuthenticationToken authentication =
                                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authentication);

                    }

                }

            }


        }
        chain.doFilter(request, response);
    }
}
