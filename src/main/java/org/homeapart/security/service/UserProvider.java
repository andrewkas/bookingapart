package org.homeapart.security.service;

import lombok.RequiredArgsConstructor;
import org.homeapart.domain.Landlord;
import org.homeapart.domain.User;
import org.homeapart.service.LandlordService;
import org.homeapart.service.UserService;
import org.springframework.security.core.authority.AuthorityUtils;
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
           // Optional<User>optionalUser=userService.findByLogin(username);

try{
            Optional<Landlord>optionalUser=landlordService.findByLogin(username);
                if (optionalUser.isPresent()) {
                    Landlord user=optionalUser.get();
                    return new org.springframework.security.core.userdetails.User(
                            user.getLogin(),
                            user.getPassword(),
                            AuthorityUtils.commaSeparatedStringToAuthorityList(user.getLandlordRole().toString())

                    );



                }
                else throw new UsernameNotFoundException(String.format("No user or landlord found with login '%s'.", username));
            } catch (Exception e) {
                throw new UsernameNotFoundException("User or landlord with this login not found");
            }
        }
    }


