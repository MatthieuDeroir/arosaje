package fr.madeit.arosaje.DAL;

import fr.madeit.arosaje.BO.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Integer> {
    Iterable<Plant> findByOwnerId(Integer userId);

    Iterable<Plant> findBySpeciesId(Integer speciesId);

    Iterable<Plant> findByCurrentState(String currentState);
}
