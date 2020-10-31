package com.widgetstore.service;

import java.util.List;

import com.widgetstore.dto.WidgetRequestDTO;
import com.widgetstore.exception.WidgetNotFoundException;
import com.widgetstore.model.Widget;

public interface WidgetService {

	/**
	 * Get widget by id
	 * 
	 * @param id
	 * @return widget details
	 * @throws WidgetNotFoundException 
	 */
	public Widget getWidgetById(Integer id) throws WidgetNotFoundException;

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
	 * @throws WidgetNotFoundException 
	 */
	public Widget updateWidget(WidgetRequestDTO requestDTO) throws WidgetNotFoundException;

	/**
	 * Get all widgets
	 * 
	 * @param limit - default 10 if no limit is specified
	 * @return
	 */
	public List<Widget> getAllWidgets(int limit);

	/**
	 * Delete widget by Id
	 * 
	 * @param id
	 */
	public String deleteWidget(Integer id);

}
