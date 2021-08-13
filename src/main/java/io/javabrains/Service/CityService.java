package io.javabrains.Service;

import java.util.List;
import java.util.Optional;

import io.javabrains.Model.City;
import io.javabrains.Repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
	
	@Autowired
	private CityRepository cityRepository;
	

public List<City> getAllCities(){
	return cityRepository.findAll() ;
	
}
public Optional<City> getCity(String id) {

	return cityRepository.findById(id);
}
public City createCity(City city) {
	
	//City city2 = new City();
	//city2.setId(city.getId());
	//city2.setName(city.getName());
	//city2.setSite(city.getSite());

	 return cityRepository.save(city);
}

public void updateCity( City city) {
	cityRepository.save(city);
		
	}
	

public void deleteCity(String id) {

	cityRepository.deleteById(id);
}
	



}
