package com.widgetstore.service;

import java.util.List;

import com.widgetstore.dto.WidgetRequestDTO;
import com.widgetstore.model.Widget;

public interface WidgetService {
	
	public Widget getWidgetById(Integer id);
	
	public Widget saveWidget(WidgetRequestDTO requestDTO);
	
	public List<Widget> getAllWidgets();
	
	public void deleteWidget(Integer id);

}
