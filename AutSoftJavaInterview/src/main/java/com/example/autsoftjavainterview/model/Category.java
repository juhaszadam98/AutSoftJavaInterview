package com.example.autsoftjavainterview.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "hashtags")
    private String hashtags;

    @ManyToMany
    @JoinTable(
            name = "categoryOfEntry",
            joinColumns = @JoinColumn(name = "categoryId"),
            inverseJoinColumns = @JoinColumn(name = "entryId")
    )
    private Set<Entry> entries;

    public Category() {}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHashtags() {
        return hashtags;
    }

    public void setHashtags(String hashtags) {
        this.hashtags = hashtags;
    }
}
