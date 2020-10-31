package com.widgetstore.dto;

public class WidgetRequestDTO {
	private Integer id;
	private Integer xCoordinate;
	private Integer yCoordinate;
	private Integer zCoordinate;
	private Integer width;
	private Integer height;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
