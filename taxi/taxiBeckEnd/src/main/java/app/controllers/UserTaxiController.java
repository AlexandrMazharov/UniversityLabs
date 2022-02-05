package app.controllers;

import app.entity.UserTaxi;
import app.exception.ItemNotFoundException;
import app.repos.rep.UserTaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:6227"},
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}, maxAge = 3600)
public class UserTaxiController {

    @Autowired
    UserTaxiRepository userTaxiRepository;

    //получить все записи
    @GetMapping("usertaxi")
    public ResponseEntity<List<UserTaxi>> getAllNotes() {

        return ResponseEntity.ok(userTaxiRepository.findAll());
    }

    // Получить запись по id
    @GetMapping("/usertaxi/{id}")
    public UserTaxi getNoteById(@PathVariable(value = "id") Long usertaxiId) throws Throwable {
        return (UserTaxi) userTaxiRepository.findById(usertaxiId)
                .orElseThrow(() -> new ItemNotFoundException(usertaxiId));
    }

    // Обновить запись
    @PutMapping("/usertaxi/upd/{id}")
    public UserTaxi updateNote(@PathVariable(value = "id") Long userTaxiId,
                               @Valid
                               @RequestBody UserTaxi userTaxiDetails) throws Throwable {


        UserTaxi userTaxi = (UserTaxi) userTaxiRepository.findById(userTaxiId)
                .orElseThrow(() -> new ItemNotFoundException(userTaxiId));

        userTaxi.setUserId(userTaxiDetails.getUserId());
        userTaxi.setUserEmail(userTaxiDetails.getUserEmail());
        userTaxi.setUserPassword(userTaxiDetails.getUserPassword());
        userTaxi.setUserFirstName(userTaxiDetails.getUserFirstName());
        userTaxi.setUserLastName(userTaxiDetails.getUserLastName());
        userTaxi.setUserSecondName(userTaxiDetails.getUserSecondName());
        userTaxi.setUserRating(userTaxiDetails.getUserRating());

        userTaxi.setUserRoles((userTaxiDetails.getUserRoles()));

        UserTaxi updateUserTaxi = (UserTaxi) userTaxiRepository.save(userTaxi);
        return updateUserTaxi;
    }

    // Создать запись
    @PostMapping("/usertaxi")
    public UserTaxi createNote(@Valid @RequestBody UserTaxi userTaxi) {
        return userTaxiRepository.save(userTaxi);
    }

    //удалить запись
    @DeleteMapping("/usertaxi/{id}")
    public ResponseEntity deleteBook(@PathVariable(value = "id") Long Id) throws Throwable {

        UserTaxi userTaxi = (UserTaxi) userTaxiRepository.findById(Id)
                .orElseThrow(() -> new ItemNotFoundException(Id));

        userTaxiRepository.delete(userTaxi);
        return ResponseEntity.ok().build();
    }
}
