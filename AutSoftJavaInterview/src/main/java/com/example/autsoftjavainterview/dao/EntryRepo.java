package com.example.autsoftjavainterview.dao;

import com.example.autsoftjavainterview.model.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource
public interface EntryRepo extends JpaRepository<Entry, Long> {
}
