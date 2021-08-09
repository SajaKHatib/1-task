package io.javabrains.springstarter.city;

import java.util.Optional;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CityRepository extends JpaRepository<City,String> {
//	Optional<City> findFirstByName(String name);
//	
//	@NamedQuery("select ")
//	Optional<City> whatever(String name);


}
