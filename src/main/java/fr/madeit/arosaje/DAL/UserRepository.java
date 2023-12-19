package fr.madeit.arosaje.DAL;

import fr.madeit.arosaje.BO.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "mes-fournisseurs", collectionResourceRel = "tab")
public interface FournisseurRepository extends JpaRepository<User, Integer> {

    @RestResource(path = "par-raison-sociale")
    public User findByRaisonSociale(@Param("raison-sociale") String nom);


}
