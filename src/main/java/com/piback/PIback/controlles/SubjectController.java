package com.piback.PIback.controlles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piback.PIback.models.Subject;
import com.piback.PIback.services.SubjectService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/subject")
@CrossOrigin({"*"})
public class SubjectController {
     @Autowired
    private SubjectService subjectService;
    @Operation(summary = "post subject", description = "Guarda una materia")
    @PostMapping("/save")
    public Subject saveProveedores(@RequestBody Subject entity) {
        
        System.out.println(entity);
        return subjectService.saveSubjectRepository(entity);
    }
    @Operation(summary = "get one subject", description = "Consulta una materia por id")
     @GetMapping("/{id}")
    public Subject findProveedores(@PathVariable long id)
    {
        return subjectService.findById(id);
    }
    @Operation(summary = "get one subject", description = "Consulta una materia por id")
     @GetMapping("user/{id}")
    public List<Subject> findByUser(@PathVariable long id)
    {
        return subjectService.findByUserId(id);
    }
    @Operation(summary = "put subject", description = "Actualiza una materia")
    @PutMapping("/{id}")
    public Subject update(@RequestBody Subject entity)
    {
        return subjectService.saveSubjectRepository(entity);
    }
    @Operation(summary = "delete subject", description = "Elimina una materia")
    @DeleteMapping("/{id}")
    public void deleteByID(@PathVariable long id)
    {
        subjectService.deleteByID(id);
    }
    @Operation(summary = "get all subject", description = "Consulta todas las materias")
    @GetMapping("/")
    public List<Subject> findAll()
    {
        return subjectService.findAll();
    }
}
