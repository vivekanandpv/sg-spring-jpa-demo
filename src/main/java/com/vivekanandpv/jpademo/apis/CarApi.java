package com.vivekanandpv.jpademo.apis;

import com.vivekanandpv.jpademo.viewmodels.CarCreateViewModel;
import com.vivekanandpv.jpademo.viewmodels.CarUpdateViewModel;
import com.vivekanandpv.jpademo.viewmodels.CarViewModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cars")
public class CarApi {
    @GetMapping
    public ResponseEntity<List<CarViewModel>> getAll() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<CarViewModel> getById(@PathVariable int id) {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<CarViewModel> create(@RequestBody CarCreateViewModel viewModel) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<CarViewModel> update(@PathVariable int id, @RequestBody CarUpdateViewModel viewModel) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        return ResponseEntity.ok().build();
    }
}
