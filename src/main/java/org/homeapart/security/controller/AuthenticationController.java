package org.homeapart.security.controller;


import io.jsonwebtoken.impl.DefaultClaims;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.homeapart.security.model.AuthRequest;
import org.homeapart.security.model.AuthResponse;
import org.homeapart.security.service.UserProvider;
import org.homeapart.security.util.CustomHeaders;
import org.homeapart.security.util.TokenUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/authentication")
@Api( tags = "AUTHENTICATION")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;

    private final TokenUtils tokenUtils;

    private final UserProvider userProvider;

    @PostMapping
    public ResponseEntity<AuthResponse> loginUser(@RequestBody AuthRequest request) {

        /*Check login and password*/
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authenticate);


        return ResponseEntity.ok(
                AuthResponse
                        .builder()
                        .username(request.getLogin())
                        .token(tokenUtils.generateToken(userProvider.loadUserByUsername(request.getLogin())))
                        .build()
        );
    }

 //   @GetMapping("/refreshtoken")
 //   public ResponseEntity<?> refreshtoken(HttpServletRequest request) throws Exception {
 //       String refreshToken = request.getHeader(CustomHeaders.AUTH_HEADER);
 //       return ResponseEntity.ok (AuthResponse.builder()
 //
 //               .token(tokenUtils.refreshToken(refreshToken))
 //               .build());
 //   }

    }

