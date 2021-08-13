package io.javabrains.Repository;

import io.javabrains.Model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City,String> {
//	Optional<City> findFirstByName(String name);
//	
//	@NamedQuery("select ")
//	Optional<City> whatever(String name);


}
