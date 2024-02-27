package fr.madeit.arosaje.DAL;

import fr.madeit.arosaje.BO.Species;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeciesRepository extends JpaRepository<Species, Integer> {
    Iterable<Species> findByName(String name);

}
