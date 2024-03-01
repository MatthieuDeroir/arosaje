package fr.madeit.arosaje.SRV;

import fr.madeit.arosaje.BO.Login;
import fr.madeit.arosaje.BO.User;
import fr.madeit.arosaje.DAL.LoginRepository;
import fr.madeit.arosaje.DAL.UserRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Getter

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Login login = loginRepository.findByEmail(email);
        if (login == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        User user = userRepository.findById(login.getUserId()).orElseThrow(() ->
                new UsernameNotFoundException("User not found with id: " + login.getUserId()));
        return new org.springframework.security.core.userdetails.User(email, login.getHashedPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))); // Adjust the authority as per your requirement
    }

    public User getUserByEmail(String email) {
        Login login = loginRepository.findByEmail(email);
        if (login == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return userRepository.findById(login.getUserId()).orElseThrow(() ->
                new UsernameNotFoundException("User not found with id: " + login.getUserId()));
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(() ->
                new UsernameNotFoundException("User not found with id: " + id));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }
}
