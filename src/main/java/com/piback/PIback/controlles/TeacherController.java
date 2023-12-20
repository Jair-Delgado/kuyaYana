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

import com.piback.PIback.models.Teacher;
import com.piback.PIback.services.TeacherService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/teacher")
@CrossOrigin({"*"})
public class TeacherController {
     @Autowired
    private TeacherService teacherService;
    @Operation(summary = "post teacher", description = "Guarda el profesor")
    @PostMapping("/save")
    public Teacher saveProveedores(@RequestBody Teacher entity) {
        
        
        return teacherService.saveTeacher(entity);
    }
    @Operation(summary = "get one teacher", description = "Consulta un profesor por id")
     @GetMapping("/{id}")
    public Teacher findProveedores(@PathVariable long id)
    {
        return teacherService.findById(id);
    }
    @Operation(summary = "get one teacher", description = "Consulta un profesor por id de usuario")
     @GetMapping("user/{id}")
    public List<Teacher> findByUser(@PathVariable long id)
    {
        return teacherService.findByUser(id);
    }
    @Operation(summary = "put teacher", description = "Actualiza el profesor")
    @PutMapping("/{id}")
    public Teacher update(@RequestBody Teacher entity)
    {
        return teacherService.saveTeacher(entity);
    }
    @Operation(summary = "delete teacher", description = "Elimina el profesor")
    @DeleteMapping("/{id}")
    public void deleteByID(@PathVariable long id)
    {
        teacherService.deleteByID(id);
    }
    @Operation(summary = "get all teacher", description = "consulta todos los profesores")
    @GetMapping("/")
    public List<Teacher> findAll()
    {
        return teacherService.findAll();
    }
}
