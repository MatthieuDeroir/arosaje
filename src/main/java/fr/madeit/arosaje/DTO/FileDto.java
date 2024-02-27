package fr.madeit.arosaje.DTO;

import fr.madeit.arosaje.Enum.EntityType;
import lombok.Getter;

public class FileDto {
    private int userId;
    private int entityId;
    @Getter
    private EntityType entityType;

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
