package com.vivekanandpv.jpademo.repositories;

import com.vivekanandpv.jpademo.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    //  automatic query method
    Optional<Car> findFirstByBhpEqualsAndTorqueGreaterThan(int bhp, int torque);

    //  jpql
    @Query("select c from Car c order by c.model asc")
    List<Car> jpql();

    //  native
    @Query(value = "SELECT * FROM car ORDER BY model", nativeQuery = true)
    List<Car> nativeQuery();
}
