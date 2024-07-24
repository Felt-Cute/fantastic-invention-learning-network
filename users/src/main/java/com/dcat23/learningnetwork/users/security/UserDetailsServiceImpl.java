package com.dcat23.learningnetwork.users.security;

import com.dcat23.learningnetwork.users.model.Role;
import com.dcat23.learningnetwork.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * @param username the username identifying the user whose data is required
     * @return UserDetails
     * @throws UsernameNotFoundException if username is not found
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.dcat23.learningnetwork.users.model.User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        List<GrantedAuthority> authorities = mapToAuthorities(user);

        return new User(user.getUsername(), user.getPassword(), authorities);
    }

    private static List<GrantedAuthority> mapToAuthorities(com.dcat23.learningnetwork.users.model.User user) {
        return user.getRoles().stream()
                .map(Role::authority)
                .toList();
    }
}
