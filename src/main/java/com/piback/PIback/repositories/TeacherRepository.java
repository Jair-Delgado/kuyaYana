package com.piback.PIback.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.piback.PIback.models.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher,Long> {
    List<Teacher> findAll();

    Optional<List<Teacher>> findBySubjectUserId(Long id);
}
