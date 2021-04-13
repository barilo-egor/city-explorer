package by.resliv.cityexplorercore.service;

import by.resliv.cityexplorercore.bean.City;
import by.resliv.cityexplorercore.exception.CityAlreadyExistException;
import by.resliv.cityexplorercore.exception.CityNotFoundException;
import by.resliv.cityexplorercore.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private CityRepository cityRepository;

    public City findByName(String name){
        return cityRepository.findByName(name).orElseThrow(()
                -> new CityNotFoundException("Город \"" + name + "\" не найден."));
    }

    public void save(City city) throws CityAlreadyExistException {
        if(cityRepository.existsByName(city.getName()))
            throw new CityAlreadyExistException("Город с таким именем уже есть.");
        cityRepository.save(city);
    }

    public void delete(City city){
        cityRepository.delete(city);
    }

    public List<City> findAll(){
        return cityRepository.findAll();
    }

    @Autowired
    public void setCityRepository(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
}
