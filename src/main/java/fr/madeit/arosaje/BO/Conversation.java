package fr.madeit.arosaje.BO;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;

@Getter
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

    public void setId(Integer id) {
        Id = id;
    }

    public void setUser1Id(Integer user1Id) {
        this.user1Id = user1Id;
    }

    public void setUser2Id(Integer user2Id) {
        this.user2Id = user2Id;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
