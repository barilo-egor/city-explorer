package by.resliv.cityexplorercore.repository;

import by.resliv.cityexplorercore.bean.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> findByName(String name);
    boolean existsByName(String name);
}
