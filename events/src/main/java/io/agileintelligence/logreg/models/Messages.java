package io.agileintelligence.logreg.models;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Messages {
    @Id
    @GeneratedValue
    private Long id;
    private String messageBody;
    private String username;

    @ManyToMany(fetch = FetchType.LAZY)

    private List<Event> events = new ArrayList<>();

    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;

    public Messages() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        return "Messages{" +
                "id=" + id +
                ", message='" + messageBody + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
