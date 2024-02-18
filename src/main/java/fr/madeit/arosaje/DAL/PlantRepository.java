package fr.madeit.arosaje.DAL;

import fr.madeit.arosaje.BO.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlantRepository extends JpaRepository<Plant, Integer> {

    Plant getById(Integer id);
    Iterable<Plant> findByOwnerId(Integer ownerId);

    Iterable<Plant> findBySpeciesId(Integer speciesId);

    Iterable<Plant> findByCurrentState(String currentState);
}
