package fr.madeit.arosaje.BO;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;

@Entity
@Getter
@Table(name = "species")
public class Species implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "name")
    private String name;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}