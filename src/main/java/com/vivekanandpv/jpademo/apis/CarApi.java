package com.vivekanandpv.jpademo.apis;

import com.vivekanandpv.jpademo.services.CarService;
import com.vivekanandpv.jpademo.viewmodels.CarCreateViewModel;
import com.vivekanandpv.jpademo.viewmodels.CarUpdateViewModel;
import com.vivekanandpv.jpademo.viewmodels.CarViewModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cars")
public class CarApi {
    private final CarService service;

    public CarApi(CarService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CarViewModel>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<CarViewModel> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<CarViewModel> create(@RequestBody CarCreateViewModel viewModel) {
        return ResponseEntity.ok(service.create(viewModel));
    }

    @PutMapping("{id}")
    public ResponseEntity<CarViewModel> update(@PathVariable int id, @RequestBody CarUpdateViewModel viewModel) {
        return ResponseEntity.ok(service.update(id, viewModel));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
