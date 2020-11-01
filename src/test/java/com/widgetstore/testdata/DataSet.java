package com.widgetstore.testdata;

import java.util.ArrayList;
import java.util.List;

import com.widgetstore.dto.WidgetRequestDTO;
import com.widgetstore.model.Widget;

public class DataSet {
	
	public static WidgetRequestDTO buildRequest(boolean needValidInput, boolean isUpdate) {
		WidgetRequestDTO request = new WidgetRequestDTO();
		if(isUpdate) {
			request.setId(1);
		}
		if(needValidInput) {
			request.setHeight(1);
			request.setWidth(2);
		}
		else {
			request.setHeight(0);
			request.setWidth(0);
		}
		request.setxCoordinate(1);
		request.setyCoordinate(2);
		request.setzCoordinate(1);

		return request;
	}
	
	public static Widget getWidget() {
		Widget widget = new Widget();
		widget.setHeight(1);
		widget.setWidth(2);
		widget.setHeight(1);
		widget.setWidth(1);
		widget.setxCoordinate(1);
		widget.setyCoordinate(2);
		widget.setzCoordinate(1);
		
		return widget;
	}
	
	public static List<Widget> getWidgets() {
		
		List<Widget> widgets = new ArrayList<>();
		Widget widget = new Widget();
		widget.setId(1);
		widget.setHeight(1);
		widget.setWidth(2);
		widget.setHeight(1);
		widget.setWidth(1);
		widget.setxCoordinate(1);
		widget.setyCoordinate(2);
		widget.setzCoordinate(1);
		
		widgets.add(widget);
		
		return widgets;
	}

}
