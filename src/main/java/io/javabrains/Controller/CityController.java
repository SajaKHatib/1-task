package io.javabrains.Controller;
import java.util.List;

import io.javabrains.Controller.error.NullIdException;
import io.javabrains.Model.City;
import io.javabrains.Model.Entity;
import io.javabrains.Repository.CityRepository;
import io.javabrains.Service.CityService;
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
import org.springframework.web.bind.annotation.RestController;
import io.javabrains.Repository.AreaRepository;
import io.javabrains.Controller.error.NullNameException;
import java.util.Optional;
@RestController
@RequestMapping("/cities")
public class CityController {
	
	@Autowired
	private CityService cityService ;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private AreaRepository areaRepository;

	/**
	 * {@code Get/cities/} Get a list of all cities
	 * @return list of all cities
	 */
	@GetMapping("")
	public List<City> getAllCities() {

		return cityService.getAllCities();
	}

	/**
	 *{@code Get/cities/:id } get city based with given id
	 * @param id
	 * @return {@link ResponseEntity}  with {@code 200 (ok)} with body contains all the cities, or  {@code 400 (bad request} if city name is missing
	 *  @throws NullIdException when the requested id is not found
	 */
	@GetMapping("/{id}")
	public ResponseEntity<City> getCity(@PathVariable String id) {
		if(id == null) {
			throw new NullIdException(Entity.CITY);
		}

		return ResponseEntity.ok().body(cityService.getCity(id).get());
	}
	/**
	 *{@code Post/cities} add a new city
	 * @param city
	 * @return returned a created city to the list
	 *  @throws NullNameException when the requested city name  is not found
	 */
	@PostMapping("")
	public ResponseEntity<City> createCity(@RequestBody City city) {
		//if(city == null) {
		//	throw new NullNameException(Entity.CITY);
	//	}
		 return ResponseEntity.status(HttpStatus.CREATED).body(cityService.createCity(city));
	}

	/**
	 *{@code PUT /cities/:id} update city passed by the given id
	 * @param city
	 * @return returned the city object that has been updated
	 */
	@PutMapping("/{id}")
	public void UpdateCity(@PathVariable Long id,@RequestBody City city ) {

		cityService.updateCity(city);
	}

	/**
	 *{@code Delete /cities/:id} Delete a city passed by its id
	 * @param id
	 *  @throws NullIdException when the requested id is not found
	 */
	@DeleteMapping("/{id}")
	public void deleteCity(@PathVariable String id ) {

		if(id == null) {
			throw new NullIdException(Entity.CITY);
		}

		cityService.deleteCity(id);
	}
	
	
}

