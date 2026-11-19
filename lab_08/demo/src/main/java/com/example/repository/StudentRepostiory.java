package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepostiory extends JpaRepository<Student, Integer> {
    // Spring Data JPA automatically provides methods like existsById() and
    // deleteById() here!
}