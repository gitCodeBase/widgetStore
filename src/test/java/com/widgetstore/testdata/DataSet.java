package com.widgetstore.testdata;

import com.widgetstore.dto.WidgetRequestDTO;

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

}
