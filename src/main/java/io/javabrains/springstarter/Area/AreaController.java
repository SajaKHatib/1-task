
package io.javabrains.springstarter.Area;
import java.util.Arrays;
import java.util.List;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.javabrains.springstarter.Area.Area;
import io.javabrains.springstarter.city.City;

@RestController

public class AreaController {
	
	@Autowired
	private AreaService areaService ;
	
	//@RequestMapping(method=RequestMethod.GET,value="/areas")
	//public List<Area> getAllarea(){
		//return areaService.getAllarea();
//	}
	
        @RequestMapping(method=RequestMethod.GET,value="cities/{id}/areas")
	    public List<Area> getAllAreas(@PathVariable String id ) {
        	
	return areaService.getAllAreas(id);
				
	}	
        @RequestMapping(method=RequestMethod.GET,value= "cities/{cityTd}/areas/{id}")
	
		public ResponseEntity<Area> getArea(@PathVariable String id) {
		
			return ResponseEntity.ok().body(areaService.getArea(id).get());
	}
	@RequestMapping(method=RequestMethod.POST,value="cities/areas")
	public void addArea(@RequestBody AreaDto area) {
		
		areaService.addArea(area);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT,value= "cities/{cityId}/areas/{id}")
	public void UpdateArea(@RequestBody Area area ,@PathVariable String cityId ,@PathVariable String id) {
//		area.setCity_id(cityId);
		areaService.updateArea(area);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="cities/{cityId}/areas/{id}")
	public void deleteArea(@PathVariable String id ) {
	areaService.deleteArea(id);
}
}

