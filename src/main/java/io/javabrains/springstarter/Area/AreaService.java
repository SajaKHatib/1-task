
package io.javabrains.springstarter.Area;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.springstarter.city.City;

@Service
@Transactional
public class AreaService {
	
	@Autowired
	private AreaRepository areaRepository;
	
	
	

public List<Area> getAllAreas(String cityId ){
	List<Area> areas = new ArrayList<>();
	areaRepository.findByCityId(cityId)
	.forEach(areas::add);
	return areas ;	
}
public Optional<Area> getArea(String id) {
	return areaRepository.findById(id);
}
public Area addArea(AreaDto area) {
	City city = new City();
	city.setId(area.getCityId());
	Area area2 = new Area();
	area2.setId(area.getId());
	area2.setName(area.getName());
	area2.setSite(area.getSite());
	area2.setCity_id(city);
	 return areaRepository.save(area2);		
}
	//areaRepository.save(area);
		

public void updateArea(Area area) {
	areaRepository.save(area);	
}

public void deleteArea(String id) {
	areaRepository.deleteById(id);	
}


public List<Area> getAllarea() {
	List<Area> areas = new ArrayList<>();
	areaRepository.findAll()
	.forEach(areas::add);
	return areas ;	
	
	
}




	



}
