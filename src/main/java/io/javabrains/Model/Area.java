
package io.javabrains.Model;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "area")
public class Area {
	@Id
	private String id ; 
	@Column(name="name")
	private String name ;
	@Column(name="site")
	private String site ;
	
	@ManyToOne
	private City city_id ;
	
	


	public Area() {
		
	}
	
	
	public String getId() {

		return id;
	}

	public void setId(String id) {

		this.id = id;
	}
	public String getName() {

		return name;
	}
	public void setName(String name) {

		this.name = name;
	}
	
	public String getSite() {
		return site;
	}

	public void setSite(String site) {

		this.site = site;
	}

	public City getCity_id() {

		return city_id;
	}

	public void setCity_id(City city_id) {
		this.city_id = city_id;
	}

	//public City getCity() {
	//	return city;
	//}

	//public void setCity(City city) {
	//	this.city = city;
	//}

}
