package fr.madeit.arosaje.BO;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "species")
public class Species implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "name")
    private String name;
}
