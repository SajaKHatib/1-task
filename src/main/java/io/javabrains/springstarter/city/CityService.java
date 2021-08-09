package io.javabrains.springstarter.city;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
	
	@Autowired
	private CityRepository cityRepository;
	

public List<City> getAllCities(){
	List<City> cities = new ArrayList<>();
	cityRepository.findAll().forEach(cities::add);
	return cities ;
	
}
public Optional<City> getCity(String id) {
	return cityRepository.findById(id);
}
public City addCity(City city) {
	
	City city2 = new City();
	city2.setId(city.getId());
	city2.setName(city.getName());
	city2.setSite(city.getSite());
	 return cityRepository.save(city2);		
}

public void updateCity( City city) {
	cityRepository.save(city);
		
	}
	

public void deleteTopic(String id) {
	cityRepository.deleteById(id);	
}
	



}
