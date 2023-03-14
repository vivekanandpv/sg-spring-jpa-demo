package com.vivekanandpv.jpademo.services;

import com.vivekanandpv.jpademo.exceptions.RecordNotFoundException;
import com.vivekanandpv.jpademo.models.Car;
import com.vivekanandpv.jpademo.repositories.CarRepository;
import com.vivekanandpv.jpademo.viewmodels.CarCreateViewModel;
import com.vivekanandpv.jpademo.viewmodels.CarUpdateViewModel;
import com.vivekanandpv.jpademo.viewmodels.CarViewModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImplementation implements CarService {
    private final CarRepository repository;

    public CarServiceImplementation(CarRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CarViewModel> getAll() {
        return repository
                .findAll()
                .stream()
                .map(c -> {
                    CarViewModel vm = new CarViewModel();
                    BeanUtils.copyProperties(c, vm);
                    return vm;
                })
                .collect(Collectors.toList());
    }

    @Override
    public CarViewModel getById(int id) {
        Car car = repository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(String.format("Could not find the car with id: %d", id)));

        CarViewModel viewModel = new CarViewModel();
        BeanUtils.copyProperties(car, viewModel);

        return viewModel;
    }

    @Override
    public CarViewModel create(CarCreateViewModel viewModel) {
        Car car = new Car();
        BeanUtils.copyProperties(viewModel, car);
        repository.saveAndFlush(car);

        CarViewModel carViewModel = new CarViewModel();
        BeanUtils.copyProperties(car, carViewModel);

        return carViewModel;
    }

    @Override
    public CarViewModel update(int id, CarUpdateViewModel viewModel) {
        Car car = repository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(String.format("Could not find the car with id: %d", id)));

        BeanUtils.copyProperties(viewModel, car);

        repository.saveAndFlush(car);

        CarViewModel carViewModel = new CarViewModel();
        BeanUtils.copyProperties(car, carViewModel);

        return carViewModel;
    }

    @Override
    public void deleteById(int id) {
        Car car = repository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(String.format("Could not find the car with id: %d", id)));

        repository.delete(car);
    }
}
