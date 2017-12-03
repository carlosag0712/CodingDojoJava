package io.carlosarosemena.dojooverflow.Models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class Questions {
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty()
    private String question;
    @Column(nullable = false)
    private Date createdAt;
    private Date updatedAt;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Answers> answers;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tags_questions",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    @Size(max = 3, message = "cannot have more than 3 tags")
    private List<Tags>tags;

    public Questions(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
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

    public List<Answers> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answers> answers) {
        this.answers = answers;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
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
