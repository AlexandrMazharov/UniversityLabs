package app.controllers;

import app.entity.Trip;
import app.exception.ItemNotFoundException;
import app.repos.rep.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:6227"},
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}, maxAge = 3600)
public class TripController {
    @Autowired
    TripRepository tripRepository;

    //получить все записи
    @GetMapping("trip")
    public ResponseEntity<List<Trip>> getAllNotes() {
        return ResponseEntity.ok(tripRepository.findAll());
    }

    // Получить запись по id
    @GetMapping("/trip/{id}")
    public Trip getNoteById(@PathVariable(value = "id") Long id) throws Throwable {
        return (Trip) tripRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
    }

    // Обновить запись
    @PutMapping("/trip/upd/{id}")
    public Trip updateNote(@PathVariable(value = "id") Long id,
                           @Valid
                           @RequestBody Trip tripDetails) throws Throwable {

        Trip trip = (Trip) tripRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));

        trip.setTrip_id(tripDetails.getTrip_id());
        trip.setTrip_dirver(tripDetails.getTrip_dirver());
        trip.setTrip_user(tripDetails.getTrip_user());
        trip.setTrip_price(tripDetails.getTrip_price());
        trip.setTrip_adress_a(tripDetails.getTrip_adress_a());
        trip.setTrip_adress_b(tripDetails.getTrip_adress_b());
        trip.setTrip_feedback(tripDetails.getTrip_feedback());


        Trip updateTrip = (Trip) tripRepository.save(trip);
        return updateTrip;
    }

    // Создать запись
    @PostMapping("/trip")
    public Trip createNote(@Valid @RequestBody Trip trip) {
        return tripRepository.save(trip);
    }

    //удалить запись
    @DeleteMapping("/trip/{id}")
    public ResponseEntity deleteBook(@PathVariable(value = "id") Long id) throws Throwable {

        Trip trip = (Trip) tripRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));

        tripRepository.delete(trip);
        return ResponseEntity.ok().build();
    }
}
