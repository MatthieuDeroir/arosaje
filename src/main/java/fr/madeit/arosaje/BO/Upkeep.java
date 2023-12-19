package fr.madeit.arosaje.BO;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "upkeep")
public class Upkeep implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "plant_id")
    private Integer plantId;

    @Column(name = "caretaker_id")
    private Integer caretakerId;

    @Column(name = "require_advice")
    private Boolean requireAdvice;

    @Column(name = "status")
    private String status;


    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getPlantId() {
        return plantId;
    }

    public void setPlantId(Integer plantId) {
        this.plantId = plantId;
    }

    public Integer getCaretakerId() {
        return caretakerId;
    }

    public void setCaretakerId(Integer caretakerId) {
        this.caretakerId = caretakerId;
    }

    public Boolean getRequireAdvice() {
        return requireAdvice;
    }

    public void setRequireAdvice(Boolean requireAdvice) {
        this.requireAdvice = requireAdvice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
