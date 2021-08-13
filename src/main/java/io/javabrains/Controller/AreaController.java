
package io.javabrains.Controller;

//import io.javabrains.Controller.error.AreaNameInUseException;
import io.javabrains.Repository.AreaRepository;
import io.javabrains.Service.AreaService;
//import io.javabrains.springstarter.error.AreaNameInUseException;
//import io.javabrains.springstarter.error.CityIdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.javabrains.Repository.CityRepository;
import io.javabrains.AreaDto;
import io.javabrains.Model.Area;
import io.javabrains.Model.City;
import java.util.List;
import java.util.Optional;
import io.javabrains.Model.Entity;
import io.javabrains.Controller.error.NullIdException;
@RestController
@RequestMapping("/areas")
public class AreaController {
    @Autowired
    private AreaRepository areaRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private AreaService areaService;


    //@RequestMapping(method=RequestMethod.GET,value="/areas")
    //public List<Area> getAllarea(){
    //return areaService.getAllarea();
//	}

//        @RequestMapping(method=RequestMethod.GET,value="cities/{id}/areas")
//	    public List<Area> getAllAreas(@PathVariable String id ) {
//
//	return areaService.getAllAreas(id);
//
//	}

    /**
     * {@code GET /areas/} Get all areas information with their cities
     *
     * @return list of cities containing all areas
     */
    @GetMapping()
    public List<City> getAll() {

        return areaService.getAll();
    }
	/**
	 * {@code Get /area:id} get area based on id
	 *
	 * @param id
	 * @return {@link ResponseEntity} with {@code 200 (ok)} with body contains all the areas, or  {@code 400 (bad request} if area name is missing
	 * @throws NullIdException when
	 */
    @GetMapping("/{id}")
    public ResponseEntity<Area> getArea(@PathVariable String id) {
        if(id == null) {
            throw new NullIdException(Entity.AREA);
        }
        return ResponseEntity.ok().body(areaService.getArea(id).get());
    }

    /**
     *{@code post /areas } create area
     * @param areaDto
     * @return the created area
     * //@throws AreaNameInUseException
     */
    @PostMapping("")
    public Area AddArea(@RequestBody AreaDto areaDto) {

        return areaService.AddArea(areaDto);
    }


    /**
     *{@code put/areas:id} updated area
     * @param areaDto
     * @param id
     * @return the updated area
     */
    @PutMapping("/{id}")
    public void UpdateArea(@RequestBody AreaDto areaDto,  @PathVariable String id) {
        Optional<Area> optionalArea = areaRepository.findById(id);
        Area area = optionalArea.get();

        areaService.updateArea(area,areaDto);
    }

    /**
     *{@code Delete /areas:id} removing area passed by thr given id
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteArea(@PathVariable String id) {
        if(id == null) {
            throw new NullIdException(Entity.CITY);
        }

        areaService.deleteArea(id);
    }
}

