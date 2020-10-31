package com.widgetstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.widgetstore.dto.WidgetRequestDTO;
import com.widgetstore.model.Widget;
import com.widgetstore.repository.WidgetRepository;

@Service
public class WidgetServiceImpl implements WidgetService {
	
	@Autowired
	WidgetRepository repository;

	@Override
	public Widget getWidgetById(Integer id) {
		//TODO: insert dummy widget
		Widget widget = new Widget();
		widget.setHeight(1);
		widget.setWidth(2);
		widget.setxCoordinate(1);
		widget.setyCoordinate(2);
		widget.setzCoordinate(1);
		repository.save(widget);
		return repository.findById(id).orElse(null);
	}
	
	@Override
	public List<Widget> getAllWidgets() {
		int offset = 0;
		int limit = 10;
		return repository.getWidgets(offset, limit);
	}

	@Override
	public void deleteWidget(Integer id) {
		// TODO Auto-generated method stub
	}

	@Override
	public Widget saveWidget(WidgetRequestDTO requestDTO) {
		if(requestDTO.getId() == null)
		{
			createWidget(requestDTO);
		}
		else {
			updateWidget(requestDTO);
		}
		return null;
	}
	
	public Widget createWidget(WidgetRequestDTO requestDTO) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Widget updateWidget(WidgetRequestDTO requestDTO) {
		// TODO Auto-generated method stub
		return null;
	}


}
