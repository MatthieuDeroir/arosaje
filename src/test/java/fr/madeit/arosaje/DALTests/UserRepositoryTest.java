package fr.madeit.arosaje.DALTests;

import fr.madeit.arosaje.BO.User;
import fr.madeit.arosaje.DAL.FournisseurRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class FournisseurRepositoryTest {
    @Autowired
    private FournisseurRepository dao;

    @Test
    public void testSave() {
        User user = new User(1, "Test");
        User savedUser = dao.save(user);

        assertEquals(user, savedUser);
        assertNotNull(savedUser.getId());
    }

    @Test
    public void testFindByRaisonSociale() {
        User user = new User(1, "Test");
        dao.save(user);

        User foundUser = dao.findByRaisonSociale("Test");

        assertEquals(user, foundUser);
    }
}
