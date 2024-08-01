package com.ista.api_full.controller;




import com.ista.api_full.entity.Usuario;
import com.ista.api_full.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("usuario")
    public Usuario postUsuario(@RequestBody Usuario usuario) {
        return usuarioService.postUsuario(usuario);
    }

    @GetMapping("/usuarios")
    private List<Usuario>getAllUsuario() {
        return usuarioService.getAllUsuario();
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario>getUsuarioById(@PathVariable Long id) {
        Usuario  personau =  usuarioService.getUsuarioById(id);
        if(personau == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(personau);
    }


    @PutMapping("/usuario-up/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario persona) {
        Usuario  existingCustomer = usuarioService.getUsuarioById(id);
        if(existingCustomer == null)
            return ResponseEntity.notFound().build();
        existingCustomer.setUsername(persona.getUsername());
        existingCustomer.setPassword(persona.getPassword());
        Usuario updateCustomer = usuarioService.updateUsuario(existingCustomer);
        return ResponseEntity.ok(updateCustomer);
    }



    @DeleteMapping("/usuario-dl/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable Long id) {
        Usuario existingCostomer = usuarioService.getUsuarioById(id);
        if(existingCostomer == null)
            return ResponseEntity.notFound().build();
        usuarioService.deleteUsuario(id);
        return ResponseEntity.ok().build();
    }
}
