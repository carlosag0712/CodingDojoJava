package io.carlosarosemena.dojooverflow.Models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Tags {
    @Id
    @GeneratedValue
    private Long id;
    private String subject;
    @Column(nullable = false)
    private Date createdAt;
    private Date updatedAt;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tags_questions",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn (name ="question_id")
    )
    private List<Questions> questions;

    public Tags() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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

    public List<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Questions> questions) {
        this.questions = questions;
    }

    @PrePersist
    void createdAt(){
        this.createdAt = new Date();
    }

    @PreUpdate
    void updatedAt(){
        this.updatedAt = new Date();
    }


}
