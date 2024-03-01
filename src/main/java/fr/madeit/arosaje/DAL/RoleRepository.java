package fr.madeit.arosaje.DAL;

import fr.madeit.arosaje.BO.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
