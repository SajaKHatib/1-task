package io.javabrains.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity 
public class City {
	@Id
	private String id ;
	@Column(name="name")
	private String name;
	@Column(name="site")
	private String site ;

	@JsonInclude
	@JsonManagedReference
	@OneToMany(mappedBy = "city_id")
    private List<Area> areas = new ArrayList<>();
    public void addArea(Area area){

    	areas.add(area);
    }
	
	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public City() {
		
	}
	
	public City(String id, String name,String site) {
		super();
		this.id = id;
		this.name = name;
		this.site = site ;
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
	

}
