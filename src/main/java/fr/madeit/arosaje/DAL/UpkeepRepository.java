package fr.madeit.arosaje.DAL;

import fr.madeit.arosaje.BO.Upkeep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpkeepRepository extends JpaRepository<Upkeep, Integer> {
    Iterable<Upkeep> findByPlantId(Integer plantId);

    Iterable<Upkeep> findByStatus(String status);

    Iterable<Upkeep> findByCaretakerId(Integer caretakerId);
}
