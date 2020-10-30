package com.widgetstore.service;

import java.util.Optional;

import com.widgetstore.model.Widget;

public interface WidgetService {
	
	Optional<Widget> getWidgetById(Integer id);

}
