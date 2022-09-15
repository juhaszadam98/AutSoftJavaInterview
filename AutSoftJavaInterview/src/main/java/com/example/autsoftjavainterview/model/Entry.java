package com.example.autsoftjavainterview.model;

import javax.persistence.*;
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

    @Column(name = "added")
    private String added;       //"yyyy-mm-dd"

    @Column(name = "modified")
    private String modified;       //"yyyy-mm-dd"

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

    public String getAdded() {
        return added;
    }

    public void setAdded(String added) {
        this.added = added;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }
}
