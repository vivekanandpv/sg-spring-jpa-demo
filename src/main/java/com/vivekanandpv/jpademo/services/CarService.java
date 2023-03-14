package com.vivekanandpv.jpademo.services;

import com.vivekanandpv.jpademo.viewmodels.CarCreateViewModel;
import com.vivekanandpv.jpademo.viewmodels.CarUpdateViewModel;
import com.vivekanandpv.jpademo.viewmodels.CarViewModel;

import java.util.List;

public interface CarService {
    List<CarViewModel> getAll();
    CarViewModel getById(int id);
    CarViewModel create(CarCreateViewModel viewModel);
    CarViewModel update(int id, CarUpdateViewModel viewModel);
    void deleteById(int id);
}
