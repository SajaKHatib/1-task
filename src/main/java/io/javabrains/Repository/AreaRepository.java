
package io.javabrains.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import io.javabrains.Model.Area;
@Repository
public interface AreaRepository extends JpaRepository<Area,String> {
	

//	public List<Area> findByCity_id(String cityId);
//	public List<Area> findAll();

}
