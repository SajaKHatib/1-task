package io.javabrains.springstarter.city;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.javabrains.springstarter.Area.Area;

@Entity 
public class City {
	@Id
	private String id ;
	@Column(name="name")
	private String name;
	@Column(name="site")
	private String site ;
	
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
