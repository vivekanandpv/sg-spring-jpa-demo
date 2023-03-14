package com.vivekanandpv.jpademo.services;

import com.vivekanandpv.jpademo.repositories.CarRepository;
import com.vivekanandpv.jpademo.viewmodels.CarCreateViewModel;
import com.vivekanandpv.jpademo.viewmodels.CarUpdateViewModel;
import com.vivekanandpv.jpademo.viewmodels.CarViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImplementation implements CarService {
    private final CarRepository repository;

    public CarServiceImplementation(CarRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CarViewModel> getAll() {
        return null;
    }

    @Override
    public CarViewModel getById(int id) {
        return null;
    }

    @Override
    public CarViewModel create(CarCreateViewModel viewModel) {
        return null;
    }

    @Override
    public CarViewModel update(int id, CarUpdateViewModel viewModel) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
