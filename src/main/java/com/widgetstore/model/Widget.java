package com.widgetstore.model;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Widget")
public class Widget {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "id", nullable = false, updatable = false)
	private Integer id;
	
	@Version
	@Column(name= "versionId", nullable = false, columnDefinition="int default 0", insertable=false)
	private Integer versionId;

	@Column(name= "xCoord", nullable = false)
	private Integer xCoordinate;
	
	@Column(name= "yCoord", nullable = false)
	private Integer yCoordinate;
	
	@Column(name= "zCoord", unique = true, nullable = false)
	private Integer zCoordinate;
	
	@Column(name= "width", nullable = false)
	private Integer width;
	
	@Column(name= "height", nullable = false)
	private Integer height;
	
	@Column(name = "lastUpdateDate", columnDefinition = "datetime default current_timestamp",  nullable=false, updatable = false, insertable=false)
	private LocalDateTime lastUpdateTimestamp;
	
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
