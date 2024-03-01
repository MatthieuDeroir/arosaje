package fr.madeit.arosaje.DAL;

import fr.madeit.arosaje.BO.Media;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract interface MediaRepository extends JpaRepository<Media, Integer> {
    public abstract Iterable<Media> findByUserId(Integer paramInteger);
    public abstract Iterable<Media> findByEntityTypeAndEntityId(String paramEntityType, Integer paramEntityId);
}
