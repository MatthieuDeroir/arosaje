package fr.madeit.arosaje.SRV;

import fr.madeit.arosaje.BO.User;
import fr.madeit.arosaje.DAL.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {this.userRepository = userRepository;}

    public List<User> getAllByIdentifier(String userIdentifier) {
        return userRepository.findAllByUsernameOrFirstNameOrLastName(userIdentifier,userIdentifier,userIdentifier);
    }
}
