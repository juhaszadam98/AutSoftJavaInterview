package com.example.autsoftjavainterview.dao;

import com.example.autsoftjavainterview.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource
public interface CategoryRepo extends JpaRepository<Category, Long> {
}
