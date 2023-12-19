package fr.madeit.arosaje.DAL;

import fr.madeit.arosaje.BO.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Integer> {
    Iterable<Login> findByEmail(String email);
}
