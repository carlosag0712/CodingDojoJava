package io.agileintelligence.waterbnb.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Listing {
    @Id
    @GeneratedValue
    private Long id;

    @Size(min = 3, message = "venue name cannot be less than 3 characters")
    private String venueName;

    @Size(min = 3, message = "Address cannot be empty")
    private String address;

    @Size(min = 3, message = "Address cannot be empty")
    private String description;

    private BigDecimal costPerNight;

    private String poolSize;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "listings")
    private List<Rating> ratings = new ArrayList<>();

    private double rating_average;

    public Listing() {
    }

    @Column(updatable=false)
    private Date createdAt;
    @Column
    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getCostPerNight() {
        return costPerNight;
    }

    public void setCostPerNight(BigDecimal costPerNight) {
        this.costPerNight = costPerNight;
    }

    public String getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(String poolSize) {
        this.poolSize = poolSize;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public double getRating_average() {
        return rating_average;
    }

    public void setRating_average(double rating_average) {
        this.rating_average = rating_average;
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    @Override
    public String toString() {
        return "Listing{" +
                "id=" + id +
                ", venueName='" + venueName + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", costPerNight=" + costPerNight +
                ", poolSize='" + poolSize + '\'' +
                '}';
    }
}
