package app.controllers;

import app.entity.UsedCar;
import app.exception.ItemNotFoundException;
import app.repos.rep.UsedCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:6227"},
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}, maxAge = 3600)
public class UsedCarController {
    @Autowired
    UsedCarRepository  usedCarRepository;

    //получить все записи
    @GetMapping("usedcars")
    public ResponseEntity<List<UsedCar>> getAllNotes() {
        return ResponseEntity.ok(usedCarRepository.findAll());
    }

    // Получить запись по id
    @GetMapping("/usedcars/{id}")
    public UsedCar getNoteById(@PathVariable(value = "id") Long usedCarId) throws Throwable {
        return (UsedCar) usedCarRepository.findById(usedCarId)
                .orElseThrow(() -> new ItemNotFoundException(usedCarId));
    }

    // Обновить запись
    @PutMapping("/usedcars/upd/{id}")
    public UsedCar updateNote(@PathVariable(value = "id") Long id,
                          @Valid
                          @RequestBody UsedCar usedCarDetails) throws Throwable {

        UsedCar usedCar = (UsedCar) usedCarRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
        usedCar.setUsed_car__id(usedCarDetails.getUsed_car__id());
        usedCar.setUsed_car__car(usedCarDetails.getUsed_car__car());
        usedCar.setUsed_car__driver(usedCarDetails.getUsed_car__driver());
        usedCar.setUsed_car__with(usedCarDetails.getUsed_car__with());
        usedCar.setUsed_car__form(usedCarDetails.getUsed_car__form());

        UsedCar updateUsedCar = (UsedCar) usedCarRepository.save(usedCar);
        return updateUsedCar;
    }

    // Создать запись
    @PostMapping("/usedcars")
    public UsedCar createNote(@Valid @RequestBody UsedCar usedCar) {
        return usedCarRepository.save(usedCar);
    }

    //удалить запись
    @DeleteMapping("/usedcars/{id}")
    public ResponseEntity deleteBook(@PathVariable(value = "id") Long carId) throws Throwable {

        UsedCar car = (UsedCar) usedCarRepository.findById(carId)
                .orElseThrow(() -> new ItemNotFoundException(carId));

        usedCarRepository.delete(car);
        return ResponseEntity.ok().build();
    }
}
