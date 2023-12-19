package fr.madeit.arosaje.BO;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "role")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "description")
    private String description;
}
