package org.homeapart.security.service;

import lombok.RequiredArgsConstructor;


import org.homeapart.domain.Landlord;
import org.homeapart.domain.Role;
import org.homeapart.domain.enums.SystemRole;
import org.homeapart.service.LandlordService;
import org.homeapart.service.UserService;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserProvider implements UserDetailsService {

        private final UserService userService;
        private final LandlordService landlordService;




        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


           // Optional<User>optionalUser1=userService.findByLogin(username);
          //  Optional<Landlord>optionalUser=landlordService.findByLogin(username);
                if (landlordService.findByLogin(username).isPresent()) {
                    Landlord user = landlordService.findByLogin(username).get();
                    return new org.springframework.security.core.userdetails.User(
                            user.getLogin(),
                            user.getPassword(),
                            AuthorityUtils.commaSeparatedStringToAuthorityList(landlordService.findRole(user.getId()).stream()
                                    .map(Role::getRole)
                                    .map(SystemRole::name)
                                    .collect(Collectors.joining(",")))
                    );
                }
                else if (userService.findByLogin(username).isPresent()){
                    org.homeapart.domain.User user=userService.findByLogin(username).get();
                    return new User(
                            user.getLogin(),
                            user.getPassword(),
                            AuthorityUtils.commaSeparatedStringToAuthorityList(userService.findRole(user.getId()).stream()
                                    .map(Role::getRole)
                                    .map(SystemRole::name)
                                    .collect(Collectors.joining(",")))
                    );
                }
                else throw new UsernameNotFoundException(String.format("No user or landlord found with login '%s'.", username));

            }
        }



