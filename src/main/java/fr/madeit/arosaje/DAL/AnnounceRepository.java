package fr.madeit.arosaje.DAL;

import fr.madeit.arosaje.BO.Announce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnounceRepository extends JpaRepository<Announce, Integer> {
    Iterable<Announce> findByAnnouncerId(Integer announcerId);

    Iterable<Announce> findByPlantId(Integer plantId);

    Iterable<Announce> findByTitle(String title);

    Iterable<Announce> findByStartDate(String startDate);

    Iterable<Announce> findByEndDate(String endDate);

}
