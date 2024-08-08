package com.ista.api_full.controller;
import com.ista.api_full.entity.Producto;
import com.ista.api_full.entity.UsuarioRol;
import com.ista.api_full.service.ProductoService;
import com.ista.api_full.service.UsuarioRolService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UsuarioRolController {

    private final UsuarioRolService usuarioRolService;


    @PostMapping("usr")
    public UsuarioRol postUserR(@RequestBody UsuarioRol usr) {
        return usuarioRolService.postUsuarior(usr);
    }

    @GetMapping("/usrs")
    private List<UsuarioRol>getAllUserR() {
        return usuarioRolService.getAllUsuarior();
    }

    @GetMapping("/usr/{id}")
    public ResponseEntity<UsuarioRol>getUserRById(@PathVariable Long id) {
        UsuarioRol  usr =  usuarioRolService.getUsuariorById(id);
        if(usr == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(usr);
    }

    @PutMapping("/usr-up/{id}")
    public ResponseEntity<UsuarioRol> updateUserR(@PathVariable Long id, @RequestBody  UsuarioRol pr) {
        UsuarioRol  existingp = usuarioRolService.getUsuariorById(id);
        if(existingp == null)
            return ResponseEntity.notFound().build();
        UsuarioRol updateCustomer = usuarioRolService.updateUsuarior(existingp);
        return ResponseEntity.ok(updateCustomer);
    }

    @DeleteMapping("/usr-dl/{id}")
    public ResponseEntity<?> deleteUserR(@PathVariable Long id) {
        UsuarioRol existingpd = usuarioRolService.getUsuariorById(id);
        if(existingpd == null)
            return ResponseEntity.notFound().build();
        usuarioRolService.deleteUsuarior(id);
        return ResponseEntity.ok().build();
    }
}
