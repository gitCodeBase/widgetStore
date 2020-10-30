package com.widgetstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Widget {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private Integer xCoordinate;
	
	private Integer yCoordinate;
	
	@Column(unique = true, nullable = false)
	private Integer zCoordinate;
	
	private Integer width;
	
	private Integer height;
	
	protected Widget() {
		//default constructor exists only for the sake of JPA
	}
	
	public Widget(Integer xCoordinate, Integer yCoordinate, Integer zCoordinate, Integer width, Integer height) {
		super();
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.zCoordinate = zCoordinate;
		this.width = width;
		this.height = height;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(Integer xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public Integer getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(Integer yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public Integer getzCoordinate() {
		return zCoordinate;
	}

	public void setzCoordinate(Integer zCoordinate) {
		this.zCoordinate = zCoordinate;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

}
