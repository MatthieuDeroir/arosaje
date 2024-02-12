package fr.madeit.arosaje.DAL;

import fr.madeit.arosaje.BO.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

//@RepositoryRestResource(path = "users")
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAllByUsernameOrFirstNameOrLastName(String username, String firstName, String lastName);

    @RestResource(path = "by-username")
    Iterable<User> findByUsername(@Param("username") String username);

    @RestResource(path = "by-first-name")
    Iterable<User> findByFirstName(@Param("firstName") String firstName);

    @RestResource(path = "by-last-name")
    Iterable<User> findByLastName(@Param("lastName") String lastName);

    @RestResource(path = "by-street-name")
    Iterable<User> findByStreetName(@Param("streetName") String streetName);

    @RestResource(path = "by-zip-code")
    Iterable<User> findByZipCode(@Param("zipCode") String zipCode);

    @RestResource(path = "by-city")
    Iterable<User> findByCity(@Param("city") String city);

    @RestResource(path = "by-country")
    Iterable<User> findByCountry(@Param("country") String country);

    @RestResource(path = "by-role-id")
    Iterable<User> findByRoleId(@Param("roleId") Integer roleId);
}
