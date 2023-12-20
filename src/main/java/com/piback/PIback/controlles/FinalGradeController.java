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

import com.piback.PIback.models.FinalGrade;
import com.piback.PIback.services.FinalGradeService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/finalgrade")
@CrossOrigin({"*"})
public class FinalGradeController {
     @Autowired
    private FinalGradeService FinalGradeService;
    @Operation(summary = "Post finalGrade", description = "Guarda nota final")
    @PostMapping("/save")
    public FinalGrade saveProveedores(@RequestBody FinalGrade entity) {
        
        
        return FinalGradeService.saveFinalGrade(entity);
    }
    @Operation(summary = "Get one finalGrade", description = "Consigue nota final por id")
     @GetMapping("/{id}")
    public FinalGrade findProveedores(@PathVariable long id)
    {
        return FinalGradeService.findById(id);
    }
    @Operation(summary = "Update one finalGrade", description = "Actualiza nota final por id")
    @PutMapping("/{id}")
    public FinalGrade update(@RequestBody FinalGrade entity)
    {
        return FinalGradeService.saveFinalGrade(entity);
    }
    @Operation(summary = "Delete one finalGrade", description = "Elimina nota final por id")
    @DeleteMapping("/{id}")
    public void deleteByID(@PathVariable long id)
    {
        FinalGradeService.deleteByID(id);
    }
    @Operation(summary = "Get all finalGrades", description = "Consigue todas las notas finales")
    @GetMapping("/")
    public List<FinalGrade> findAll()
    {
        return FinalGradeService.findAll();
    }
}
