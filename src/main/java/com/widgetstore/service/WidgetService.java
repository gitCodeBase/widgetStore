package com.widgetstore.service;

import java.util.List;

import com.widgetstore.dto.WidgetRequestDTO;
import com.widgetstore.model.Widget;

public interface WidgetService {

	/**
	 * Get widget by id
	 * 
	 * @param id
	 * @return widget details
	 */
	public Widget getWidgetById(Integer id);

	/**
	 * Create a new widget
	 * 
	 * @param id
	 * @return saved widget details
	 */
	public Widget createWidget(WidgetRequestDTO requestDTO);

	/**
	 * Update widget
	 * 
	 * @param requestDTO
	 * @return updated widget
	 */
	public Widget updateWidget(WidgetRequestDTO requestDTO);

	/**
	 * Get all widgets
	 * 
	 * @return
	 */
	public List<Widget> getAllWidgets();

	/**
	 * Delete widget by Id
	 * 
	 * @param id
	 */
	public void deleteWidget(Integer id);

}
