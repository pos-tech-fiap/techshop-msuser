package com.techshopmsuser.controller;

import com.techshopmsuser.dto.UserDTO;
import com.techshopmsuser.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Page<UserDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok().body((Page<UserDTO>) userService.findAll(pageRequest));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<UserDTO> save(@RequestBody @Valid UserDTO userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody @Valid UserDTO usuarioDTO) {
        return ResponseEntity.ok().body(userService.update(id, usuarioDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok().body("Usuario removido com sucesso!");
    }

}
