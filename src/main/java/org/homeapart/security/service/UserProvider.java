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
        //private final RoleRepository roleRepository;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Landlord landlord=landlordService.findByLogin(username);
            User user=userService.findByLogin(username);

try{
                if (user!=null) {
                    return new org.springframework.security.core.userdetails.User(
                            user.getLogin(),
                            user.getPassword(),
                            user.getRole()
                    );
                } else if (landlord!=null){
                 return new org.springframework.security.core.userdetails.User(
                            landlord.getLogin(),
                            landlord.getPassword(),
                            AuthorityUtils.commaSeparatedStringToAuthorityList(roleRepository.findUserRoles(user.getId())
                                    .stream().map(Role::getRoleName).map(SystemRoles::name)
                                    .collect(Collectors.joining(",")))
                    );


                }
                else throw new UsernameNotFoundException(String.format("No user or landlord found with login '%s'.", username));
            } catch (Exception e) {
                throw new UsernameNotFoundException("User or landlord with this login not found");
            }
        }
    }
    }
}
