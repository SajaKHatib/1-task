
package io.javabrains.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import io.javabrains.Repository.AreaRepository;
import io.javabrains.Repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.Model.City;
import io.javabrains.Model.Area;
import io.javabrains.AreaDto;
@Service
@Transactional
public class AreaService {
	
	@Autowired
	private AreaRepository areaRepository;

	@Autowired
	private CityRepository CityRepository;





//public List<Area> getAllAreas(String cityId ){
//	List<Area> areas = new ArrayList<>();
//	areaRepository.findByCity_id(cityId)
//	.forEach(areas::add);
//	return areas ;
//}
public List<City> getAll() {
	return CityRepository.findAll();
}
public Optional<Area> getArea(String id) {

	return areaRepository.findById(id);
}
public Area AddArea(AreaDto areaDto) {
	City city = new City();
	city.setId(areaDto.getCityId());
	Area area2 = new Area();
	area2.setId(areaDto.getId());
	area2.setName(areaDto.getName());
	area2.setSite(areaDto.getSite());
	area2.setCity_id(city);
	city.addArea(area2);
	 return areaRepository.save(area2);		
}
	//areaRepository.save(area);
		

public void updateArea(Area area ,AreaDto areaDto) {

	areaRepository.save(area);
}

public void deleteArea(String id) {

	areaRepository.deleteById(id);
}



	
}




	




