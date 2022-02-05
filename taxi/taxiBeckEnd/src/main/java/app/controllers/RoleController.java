package app.controllers;

import app.entity.Role;
import app.exception.ItemNotFoundException;
import app.repos.rep.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:6227"},
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}, maxAge = 3600)


public class RoleController {
    @Autowired
    RoleRepository roleRep;

    // получить все записи
    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getAllNotes() {

        return ResponseEntity.ok(roleRep.findAll());
    }

    // Получить запись по id
    @GetMapping("/roles/{id}")
    public Role getNoteById(@PathVariable(value = "id") Long roleId) throws Throwable {
        return (Role) roleRep.findById(roleId)
                .orElseThrow(() -> new ItemNotFoundException(roleId));
    }

    // Обновить запись
    @PutMapping("/roles/upd/{id}")
    public Role updateNote(@PathVariable(value = "id") Long roleId,
                           @Valid
                           @RequestBody Role roleDetails) throws Throwable {

        Role role = (Role) roleRep.findById(roleId)
                .orElseThrow(() -> new ItemNotFoundException(roleId));

        role.setName(roleDetails.getName());
        Role updateRole = (Role) roleRep.save(role);
        return updateRole;
    }

    // Создать запись
    @PostMapping("/roles")
    public Role createNote(@Valid @RequestBody Role role) {
        return roleRep.save(role);
    }

    @DeleteMapping("/roles/{id}")
    public ResponseEntity deleteBook(@PathVariable(value = "id") Long roleId) throws Throwable {

        Role role = (Role) roleRep.findById(roleId)
                .orElseThrow(() -> new ItemNotFoundException(roleId));

        roleRep.delete(role);
        return ResponseEntity.ok().build();
    }
}
