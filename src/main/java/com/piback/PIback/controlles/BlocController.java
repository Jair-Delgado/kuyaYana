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

import com.piback.PIback.models.Bloc;
import com.piback.PIback.services.BlocService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/bloc")
@CrossOrigin({"*"})
public class BlocController {
    @Autowired
    private BlocService blocService;
    @Operation(summary = "Post Bloc", description = "Guarda bloc de notas")
    @PostMapping("/save")
    public Bloc saveBloc(@RequestBody Bloc entity) {
        
        
        return blocService.saveBloc(entity);
    }
    @Operation(summary = "Get one Bloc", description = "Consigue bloc de notas por id")
     @GetMapping("/{id}")
    public Bloc findBloc(@PathVariable long id)
    {
        return blocService.findById(id);
    }
    @Operation(summary = "Update one Bloc", description = "Actualiza bloc de notas por id")
    @PutMapping("/{id}")
    public Bloc update(@RequestBody Bloc entity)
    {
        return blocService.saveBloc(entity);
    }
    @Operation(summary = "Delete one Bloc", description = "Elimina bloc de notas por id")
    @DeleteMapping("/{id}")
    public void deleteByID(@PathVariable long id)
    {
        blocService.deleteByID(id);
    }
    @Operation(summary = "Get all Blocs", description = "Consigue todas las bloc de notas")
    @GetMapping("/")
    public List<Bloc> findAll()
    {
        return blocService.findAll();
    }
}
