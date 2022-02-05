package app.controllers;

import app.entity.Car;
import app.exception.ItemNotFoundException;
import app.repos.rep.CarRepoitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:6227"},
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}, maxAge = 3600)
public class CarController {
    @Autowired
    CarRepoitory carRepoitory;

    //получить все записи
    @GetMapping("/cars")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Car>> getAllNotes() {
        return ResponseEntity.ok(carRepoitory.findAll());
    }

    // Получить запись по id
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @GetMapping("/cars/{id}")
    public Car getNoteById(@PathVariable(value = "id") Long carId) throws Throwable {
        return (Car) carRepoitory.findById(carId)
                .orElseThrow(() -> new ItemNotFoundException(carId));
    }

    // Обновить запись
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PutMapping("/cars/upd/{id}")
    public Car updateNote(@PathVariable(value = "id") Long carId,
                          @Valid
                          @RequestBody Car carDetails) throws Throwable {

        Car car = (Car) carRepoitory.findById(carId)
                .orElseThrow(() -> new ItemNotFoundException(carId));

        car.setCar_id(carDetails.getCar_id());
        car.setCar_color(carDetails.getCar_color());
        car.setCar_model(carDetails.getCar_model());
        car.setCar_number(carDetails.getCar_number());
        car.setCar_type(carDetails.getCar_type());


        Car updateCar = (Car) carRepoitory.save(car);
        return updateCar;
    }

    // Создать запись
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PostMapping("/cars")
    public Car createNote(@Valid @RequestBody Car car) {
        return carRepoitory.save(car);
    }

    //удалить запись
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @DeleteMapping("/cars/{id}")
    public ResponseEntity deleteBook(@PathVariable(value = "id") Long carId) throws Throwable {

        Car car = (Car) carRepoitory.findById(carId)
                .orElseThrow(() -> new ItemNotFoundException(carId));

        carRepoitory.delete(car);
        return ResponseEntity.ok().build();
    }
}
