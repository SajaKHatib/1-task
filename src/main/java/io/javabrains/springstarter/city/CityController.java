package io.javabrains.springstarter.city;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.javabrains.springstarter.Area.Area;
@RestController
@RequestMapping("/cities")
public class CityController {
	
	@Autowired
	private CityService cityService ;
	
	@GetMapping("")
	public List<City> getAllCities() {
		return cityService.getAllCities();
				
	}	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<City> getCity(@PathVariable String id) {
		
		return ResponseEntity.ok().body(cityService.getCity(id).get());
	}
	
	@PostMapping("")
	public ResponseEntity<City> addCity(@RequestBody City city) {
		 return ResponseEntity.status(HttpStatus.CREATED).body(cityService.addCity(city));
	}
	
	
	@PutMapping("")
	public void UpdateCity(@RequestBody City city ) {
		cityService.updateCity(city);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTopic(@PathVariable String id ) {
		cityService.deleteTopic(id);
	}
	
	
}

