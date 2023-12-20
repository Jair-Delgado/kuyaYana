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

import com.piback.PIback.models.EventCategory;
import com.piback.PIback.services.EventCategoryService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/eventscategory")
@CrossOrigin({"*"})
public class EventCategoryController {
    @Autowired
    private EventCategoryService eventCategoryService;
    @Operation(summary = "Post eventCategory", description = "Guarda categoria evento")
     @PostMapping("/save")
    public EventCategory saveeventCategory(@RequestBody EventCategory entity) {
        
        return eventCategoryService.saveEventCategory(entity);
    }
    @Operation(summary = "Get one eventCategory", description = "Consigue categoria evento por id")
     @GetMapping("/{id}")
    public EventCategory findeventCategory(@PathVariable long id)
    {
        return eventCategoryService.findById(id);
    }
    @Operation(summary = "Update one eventCategory", description = "Actualiza categoria evento por id")
    @PutMapping("/{id}")
    public EventCategory update(@RequestBody EventCategory entity)
    {
        return eventCategoryService.saveEventCategory(entity);
    }
    @Operation(summary = "Delete one eventCategory", description = "Elimina categoria evento por id")
     @DeleteMapping("/{id}")
    public void deleteByID(@PathVariable long id)
    {
        eventCategoryService.deleteByID(id);
    }
    @Operation(summary = "Get all eventCategories", description = "Consigue todas las categorias de eventos")
    @GetMapping("/")
    public List<EventCategory> findAll()
    {
        return eventCategoryService.findAll();
    }
}
