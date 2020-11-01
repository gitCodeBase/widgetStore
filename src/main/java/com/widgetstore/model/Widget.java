package com.widgetstore.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "Widget")
public class Widget {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, updatable = false)
	private Integer id;

	@Version
	@Column(name = "VERSION_ID", nullable = false, columnDefinition = "int default 0")
	private Integer versionId;

	@Column(name = "X_COORD", nullable = false)
	private Integer xCoordinate;

	@Column(name = "Y_COORD", nullable = false)
	private Integer yCoordinate;

	@Column(name = "Z_COORD", nullable = false)
	private Integer zCoordinate;

	@Column(name = "WIDTH", nullable = false)
	private Integer width;

	@Column(name = "HEIGHT", nullable = false)
	private Integer height;

	@UpdateTimestamp
	@Column(name = "LAST_UPDATE_DATE", columnDefinition = "datetime default current_timestamp", nullable = false, insertable = false)
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

	public LocalDateTime getLastUpdateTimestamp() {
		return lastUpdateTimestamp;
	}

	public void setLastUpdateTimestamp(LocalDateTime lastUpdateTimestamp) {
		this.lastUpdateTimestamp = lastUpdateTimestamp;
	}

}
