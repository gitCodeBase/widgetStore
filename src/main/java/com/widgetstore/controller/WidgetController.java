package com.widgetstore.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.widgetstore.model.Widget;
import com.widgetstore.service.WidgetService;

@RestController
public class WidgetController {
	
	@Autowired
	WidgetService service;
	
	@GetMapping("/widget/{id}")
	public ResponseEntity<Optional<Widget>> getWidgetById(@PathVariable(value="id") Integer id) {
		Optional<Widget> widget = service.getWidgetById(id);
		return new ResponseEntity<Optional<Widget>>(widget,HttpStatus.OK);
	}

}
