package com.temalabor.temalab.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Document
public class Contest {
    @Id
    private String _id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate deadline;
    private String category_id;
    private List<String> submittedPosts;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category) {
        this.category_id = category;
    }

    public List<String> getSubmittedPosts() {
        return submittedPosts;
    }

    public void setSubmittedPosts(List<String> submittedPosts) {
        this.submittedPosts = submittedPosts;
    }
}
