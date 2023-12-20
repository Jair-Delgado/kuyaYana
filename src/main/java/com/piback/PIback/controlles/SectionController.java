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

import com.piback.PIback.models.Section;

import com.piback.PIback.services.SectionService;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("api/Section")
@CrossOrigin({"*"})

public class SectionController {
    @Autowired 
    private SectionService sectionService;
    @Operation(summary = "post section", description = "Guarda una seccion")
    @PostMapping("/save")

    public Section save(@RequestBody Section entity)
    {
        return sectionService.save(entity);
    }
    @Operation(summary = "get one section", description = "Consulta una seccion por id")
    @GetMapping("/{id}/")
    public Section findSection(@PathVariable long id)
    {
        return sectionService.findById(id);
    }
    @Operation(summary = "put section", description = "Actualiza una seccion")
    @PutMapping("/{id}/")
    public Section update(@RequestBody Section entity)
    {
        return sectionService.save(entity);
    }
    @Operation(summary = "delete section", description = "Elimina una seccion")
    @DeleteMapping("/{id}/")
    public void deleteByID(@PathVariable long id)
    {
        sectionService.deleteByID(id);
    }
    @Operation(summary = "get all profile", description = "Consulta todas las secciones")
    @GetMapping("/")
    public List<Section> findAll()
    {
        return sectionService.findAll();
    }
}
