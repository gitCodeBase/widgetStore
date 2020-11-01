package com.widgetstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.widgetstore.dto.WidgetRequestDTO;
import com.widgetstore.exception.WidgetNotFoundException;
import com.widgetstore.exception.WidgetValidationException;
import com.widgetstore.model.Widget;
import com.widgetstore.service.WidgetService;

@RestController
@RequestMapping("/api")
public class WidgetController {

	@Autowired
	WidgetService service;

	/**
	 * Get all widgets
	 * 
	 * @return list of widgets
	 */
	@GetMapping("/widgets")
	public ResponseEntity<List<Widget>> getAllWidgets(@RequestParam(name = "limit", defaultValue = "10", required = false) int limit) {
		List<Widget> widget = service.getAllWidgets(limit);
		return new ResponseEntity<List<Widget>>(widget, HttpStatus.OK);
	}

	/**
	 * Get widget by id
	 * 
	 * @return requested widget
	 * @throws WidgetNotFoundException 
	 */
	@GetMapping("/widget/{id}")
	public ResponseEntity<Widget> getWidgetById(@PathVariable(value = "id") Integer id) throws WidgetNotFoundException {
		Widget widget = service.getWidgetById(id);
		return new ResponseEntity<Widget>(widget, HttpStatus.OK);
	}
	
	
	/**
	 * Delete a widget by its id
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/widget/{id}")
	public ResponseEntity<String> deleteWidgetById(@PathVariable(value = "id") Integer id) {
		return new ResponseEntity<String>(service.deleteWidget(id), HttpStatus.OK);
	}

	/**
	 * Inserts or Updates Widget
	 * 
	 * @param requestDTO
	 * @return saved widget
	 * @throws WidgetNotFoundException 
	 * @throws WidgetValidationException 
	 */
	@PostMapping("/widget")
	public ResponseEntity<Widget> saveWidget(@RequestBody WidgetRequestDTO requestDTO) throws WidgetNotFoundException, WidgetValidationException {
		validate(requestDTO);
		Widget widget = invokeService(requestDTO);
		return new ResponseEntity<Widget>(widget, HttpStatus.OK);
	}

	/**
	 * Check if the value of width and height is greater than zero
	 * 
	 * @param requestDTO
	 * @throws WidgetValidationException
	 */
	private void validate(WidgetRequestDTO requestDTO) throws WidgetValidationException {
		if(requestDTO.getWidth() < 1 || requestDTO.getHeight() < 1 ) {
			throw new WidgetValidationException("Value of Width and Height attributes should be greater than zer0");
		}
		
	}

	/**
	 * Invoke widget creation if id is null otherwise update
	 * 
	 * @param requestDTO
	 * @return
	 * @throws WidgetNotFoundException 
	 */
	private Widget invokeService(WidgetRequestDTO requestDTO) throws WidgetNotFoundException {
		if (requestDTO.getId() == null) {
			return service.createWidget(requestDTO);
		} else {
			return service.updateWidget(requestDTO);
		}
	}

}
