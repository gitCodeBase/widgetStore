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

	/* (non-Javadoc)
	 * @see com.widgetstore.service.WidgetService#getWidgetById(java.lang.Integer)
	 */
	@Override
	public Widget getWidgetById(Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	/* (non-Javadoc)
	 * @see com.widgetstore.service.WidgetService#getAllWidgets()
	 */
	@Override
	public List<Widget> getAllWidgets() {
		int offset = 0;
		int limit = 10;
		//TODO: Accept Pagination parameters from url
		return repository.getWidgets(offset, limit);
	}

	
	/* (non-Javadoc)
	 * @see com.widgetstore.service.WidgetService#deleteWidget(java.lang.Integer)
	 */
	@Override
	public void deleteWidget(Integer id) {
		repository.deleteById(id);
	}

	/* (non-Javadoc)
	 * @see com.widgetstore.service.WidgetService#createWidget(com.widgetstore.dto.WidgetRequestDTO)
	 */
	@Override
	public Widget createWidget(WidgetRequestDTO requestDTO) {
		
		Widget widget = new Widget();
		widget.setHeight(requestDTO.getHeight());
		widget.setWidth(requestDTO.getWidth());
		widget.setxCoordinate(requestDTO.getxCoordinate());
		widget.setyCoordinate(requestDTO.getyCoordinate());
		widget.setzCoordinate(requestDTO.getzCoordinate()); 
		
		//TODO: implement logic related to z coordinate
		
		return repository.save(widget);
	}
	
	/* (non-Javadoc)
	 * @see com.widgetstore.service.WidgetService#updateWidget(com.widgetstore.dto.WidgetRequestDTO)
	 */
	@Override
	public Widget updateWidget(WidgetRequestDTO requestDTO) {
		Widget widget = repository.findById(requestDTO.getId()).orElse(null);
		
		if(widget == null) {
			//Widget not found exception;
		}
		else {
			//TODO:Update logic related to z coordinate, optimistic locking
		}
		return widget;
	}


}
