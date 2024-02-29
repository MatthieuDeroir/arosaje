package fr.madeit.arosaje.BO;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

@Entity
@Getter
@Table(name = "\"user\"", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "USERNAME")
    // Unique u
    private String username;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    // STREET_NUMBER, STREET_NAME, ZIP_CODE, CITY, COUNTRY
    @Column(name = "STREET_NUMBER")
    private String streetNumber;

    @Column(name = "STREET_NAME")
    private String streetName;

    @Column(name = "ZIP_CODE")
    private String zipCode;

    @Column(name = "CITY")
    private String city;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "BIRTH_DATE")
    private String birthDate;

    @Column(name = "LAST_GPS_LOCATION")
    private String lastGpsLocation;

    @Column(name = "LAST_GPS_LOCATION_TIMESTAMP")
    private String lastGpsLocationDate;

    @Column(name = "LAST_LOGIN_TIMESTAMP")
    private String lastLoginDate;

    @Column(name = "ROLE_ID")
    private Integer roleId;

    @Column(name = "CREATED_AT")
    private String createdAt;

    @Column(name = "UPDATED_AT")
    private String updatedAt;

    public User(String username, String firstName, String lastName) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getLastGpsLocation() {
        return lastGpsLocation;
    }

    public void setLastGpsLocation(String lastGpsLocation) {
        this.lastGpsLocation = lastGpsLocation;
    }

    public String getLastGpsLocationDate() {
        return lastGpsLocationDate;
    }

    public void setLastGpsLocationDate(String lastGpsLocationDate) {
        this.lastGpsLocationDate = lastGpsLocationDate;
    }

    public String getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(String lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
