package fr.madeit.arosaje.BO;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "conversation")
public class Conversation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "user1_id")
    private Integer user1Id;

    @Column(name = "user2_id")
    private Integer user2Id;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

}
