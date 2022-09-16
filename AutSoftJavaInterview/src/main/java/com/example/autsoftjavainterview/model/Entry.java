package com.example.autsoftjavainterview.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
public class Entry {

    @Id
    @GeneratedValue
    Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "postBody")
    private String postBody;

    @Column(name = "added", updatable = false)
    @CreationTimestamp
    private Date added;

    @Column(name = "modified")
    @UpdateTimestamp
    private Date modified;

    @ManyToMany(mappedBy = "entries")
    private Set<Category> categories;

    public Entry() {}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
