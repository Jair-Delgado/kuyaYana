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

import com.piback.PIback.models.Events;
import com.piback.PIback.services.EventsService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/events")
@CrossOrigin({"*"})
public class EventsController {
    @Autowired
    private EventsService eventsService;
    @Operation(summary = "Post event", description = "Guarda eventos")
     @PostMapping("/save")
    public Events saveEvents(@RequestBody Events entity) {
        
        return eventsService.saveEvents(entity);
    }
    @Operation(summary = "Get one event", description = "Consigue eventos por id")
     @GetMapping("/{id}")
    public Events findEvents(@PathVariable long id)
    {
        return eventsService.findById(id);
    }
    @Operation(summary = "Update one event", description = "Actualiza eventos por id")
    @PutMapping("/{id}")
    public Events update(@RequestBody Events entity)
    {
        return eventsService.saveEvents(entity);
    }
    @Operation(summary = "Delete one event", description = "Elimina eventos por id")
     @DeleteMapping("/{id}")
    public void deleteByID(@PathVariable long id)
    {
        eventsService.deleteByID(id);
    }
    @Operation(summary = "Get all events", description = "Consigue todos los eventos")
    @GetMapping("/")
    public List<Events> findAll()
    {
        return eventsService.findAll();
    }
}
