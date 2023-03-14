package com.vivekanandpv.jpademo.repositories;

import com.vivekanandpv.jpademo.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
}
