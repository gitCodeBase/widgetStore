package com.widgetstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.widgetstore.model.Widget;
import com.widgetstore.repository.WidgetRepository;

@Service
public class WidgetServiceImpl implements WidgetService {
	
	@Autowired
	WidgetRepository repository;

	@Override
	public Optional<Widget> getWidgetById(Integer id) {
		//TODO: insert dummy widget
		Widget widget = new Widget(1, 2, 3, 4, 5);
		repository.save(widget);
		return repository.findById(id);
	}
}
