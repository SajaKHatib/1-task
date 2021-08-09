
package io.javabrains.springstarter.Area;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends CrudRepository<Area,String> {
	

	public List<Area> findByCityId(String cityId);
	public List<Area> findAll();

}
