package fr.madeit.arosaje.SRV;

import fr.madeit.arosaje.BO.Login;
import fr.madeit.arosaje.BO.User;
import fr.madeit.arosaje.DAL.LoginRepository;
import fr.madeit.arosaje.DAL.UserRepository;
import fr.madeit.arosaje.DTO.SignUpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void registerUser(SignUpDto signUpDto) {
        User newUser = new User();

        newUser.setFirstName(signUpDto.getFirstName());
        newUser.setLastName(signUpDto.getLastName());
        newUser.setUsername(signUpDto.getUsername());
        newUser.setCreatedAt(String.valueOf(System.currentTimeMillis()));
        newUser.setUpdatedAt(String.valueOf(System.currentTimeMillis()));
        newUser.setCountry(signUpDto.getCountry());
        newUser.setCity(signUpDto.getCity());
        newUser.setZipCode(signUpDto.getZipCode());
        newUser.setStreetName(signUpDto.getStreetName());
        newUser.setStreetNumber(signUpDto.getStreetNumber());

        newUser = userRepository.save(newUser);

        Login newLogin = new Login();
        newLogin.setEmail(signUpDto.getEmail());
        newLogin.setHashedPassword(passwordEncoder.encode(signUpDto.getPassword()));
        newLogin.setUserId(newUser.getId()); // Associate with the newly created User
        loginRepository.save(newLogin);
    }

    public User logUser(String email, String password) {
        Login login = (Login) loginRepository.findByEmail(email);
        if (login == null) {
            // User not found with the provided email
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        boolean matches = passwordEncoder.matches(password, login.getHashedPassword());
        if (!matches) {
            // Password does not match
            throw new BadCredentialsException("Incorrect password for email: " + email);
        }

        // Assuming you have a method to fetch the User entity by userId
        // This part is pseudocode and needs to be adjusted based on your actual method to fetch User entity
        User user = userRepository.findById(login.getUserId()).orElseThrow(() -> new UsernameNotFoundException("User not found"));


        return user; // Successfully logged in, return the User entity
    }

}
