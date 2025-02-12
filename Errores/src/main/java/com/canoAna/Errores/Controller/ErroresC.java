package com.canoAna.Errores.Controller;

import com.canoAna.Errores.Exceptions.UnauthorizedException;
import jakarta.validation.ValidationException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ErroresC {

    @GetMapping("/recurso/{id}")
    public String obtenerRecurso(@PathVariable int id) throws ChangeSetPersister.NotFoundException {
        if (id <= 0) {
            throw new ValidationException("El ID debe ser mayor a 0");
        }
        if (id > 100) {
            throw new ChangeSetPersister.NotFoundException();  //
        }
        return "Recurso encontrado con ID: " + id;
    }

    @PostMapping("/login")
    public String login(@RequestParam String user, @RequestParam String password) {
        if (!user.equals("admin") || !password.equals("1234")) {
            throw new UnauthorizedException("Usuario o contraseña incorrectos");
        }
        return "Bienvenido, " + user;
    }
}
