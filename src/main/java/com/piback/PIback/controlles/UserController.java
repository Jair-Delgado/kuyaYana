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

import com.piback.PIback.models.User;
import com.piback.PIback.services.UserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/user")
@CrossOrigin({"*"})
public class UserController {
    @Autowired
    private UserService userService;
    @Operation(summary = "post user", description = "Guarda un usuario")
    @PostMapping("/save")
    public User saveUser(@RequestBody User entity) {
        
        
        return userService.saveUser(entity);
    }
    @Operation(summary = "get one user", description = "Consulta un usuario por id")
     @GetMapping("/{id}")
    public User findUser(@PathVariable long id)
    {
        return userService.findById(id);
    }
    @Operation(summary = "put user", description = "Actualiza un usuario")
    @PutMapping("/{id}")
    public User update(@RequestBody User entity)
    {
        return userService.saveUser(entity);
    }
    @Operation(summary = "delete user", description = "Elimina un usuario")
    @DeleteMapping("/{id}")
    public void deleteByID(@PathVariable long id)
    {
        userService.deleteByID(id);
    }
    @Operation(summary = "get all user", description = "Consulta todos los usuarios")
    @GetMapping("/")
    public List<User> findAll()
    {
        return userService.findAll();
    }
}
