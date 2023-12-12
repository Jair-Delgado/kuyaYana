package com.piback.PIback.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.piback.PIback.models.Subject;

public interface SubjectRepository extends CrudRepository<Subject,Long> {
    List<Subject> findAll();

    Optional<List<Subject>> findByUserId(Long id);

   
}
