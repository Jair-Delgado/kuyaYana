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

import com.piback.PIback.models.Profile;
import com.piback.PIback.services.ProfileService;

import io.swagger.v3.oas.annotations.Operation;
@RestController
@RequestMapping("api/profile")
@CrossOrigin({"*"})
public class ProfileController {
    @Autowired
    private ProfileService profileService;
    @Operation(summary = "post profile", description = "Guarda el perfil")
    @PostMapping("/save")
    public Profile saveProfile(@RequestBody Profile entity) {
        
        
        return profileService.saveProfile(entity);
    }
    @Operation(summary = "get profile", description = "Consulta el perfil por id")
    @GetMapping("/{id}")
    public Profile findProfile(@PathVariable long id)
    {
        return profileService.findById(id);
    }
    @Operation(summary = "put profile", description = "Actualiza el perfil")
    @PutMapping("/{id}")
    public Profile update(@RequestBody Profile entity)
    {
        return profileService.saveProfile(entity);
    }
    @Operation(summary = "delete profile", description = "Elimina el perfil")
    @DeleteMapping("/{id}")
    public void deleteByID(@PathVariable long id)
    {
        profileService.deleteByID(id);
    }
    @Operation(summary = "get all profile", description = "consulta todos los perfiles")
    @GetMapping("/")
    public List<Profile> findAll()
    {
        return profileService.findAll();
    }
}
