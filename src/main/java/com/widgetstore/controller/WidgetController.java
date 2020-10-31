package com.widgetstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.widgetstore.dto.WidgetRequestDTO;
import com.widgetstore.model.Widget;
import com.widgetstore.service.WidgetService;

@RestController
public class WidgetController {

	@Autowired
	WidgetService service;

	/**
	 * Get all widgets
	 * 
	 * @return list of widgets
	 */
	@GetMapping("/widgets")
	public ResponseEntity<List<Widget>> getAllWidgets() {
		List<Widget> widget = service.getAllWidgets();
		return new ResponseEntity<List<Widget>>(widget, HttpStatus.OK);
	}

	/**
	 * Get widget by id
	 * 
	 * @return requested widget
	 */
	@GetMapping("/widget/{id}")
	public ResponseEntity<Widget> getWidgetById(@PathVariable(value = "id") Integer id) {
		Widget widget = service.getWidgetById(id);
		return new ResponseEntity<Widget>(widget, HttpStatus.OK);
	}

	/**
	 * Inserts or Updates Widget
	 * 
	 * @param requestDTO
	 * @return saved widget
	 */
	@PostMapping("/widget")
	public ResponseEntity<Widget> saveWidget(@RequestBody WidgetRequestDTO requestDTO) {
		Widget widget = invokeService(requestDTO);
		return new ResponseEntity<Widget>(widget, HttpStatus.OK);
	}

	/**
	 * Invoke widget creation if id is null otherwise update
	 * 
	 * @param requestDTO
	 * @return
	 */
	private Widget invokeService(WidgetRequestDTO requestDTO) {
		if (requestDTO.getId() == null) {
			return service.createWidget(requestDTO);
		} else {
			return service.updateWidget(requestDTO);
		}
	}

}
