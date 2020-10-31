package com.widgetstore.service;

import java.util.ArrayList;
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
	 * @see com.widgetstore.service.WidgetService#getAllWidgets(int)
	 */
	@Override
	public List<Widget> getAllWidgets(int limit) {
		return repository.getWidgets(limit);
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
		
		Widget newWidget = new Widget();
		newWidget.setHeight(requestDTO.getHeight());
		newWidget.setWidth(requestDTO.getWidth());
		newWidget.setxCoordinate(requestDTO.getxCoordinate());
		newWidget.setyCoordinate(requestDTO.getyCoordinate());
		newWidget.setzCoordinate(requestDTO.getzCoordinate());
		
		Widget widgetByZCoord = repository.findByZCoord(requestDTO.getzCoordinate());
		if(widgetByZCoord != null) {
			shiftZCoordinate(requestDTO);
		}
		
		return repository.save(newWidget);
	}

	/**
	 * Get all widgets greater than or equal to the zCoordinate of the new widget.
	 * Traverse through each widget and check if the zCoordinate is greater than or equal
	 * to the incremented z coordinate. This check is used to ensure we are only updating the widgets that needs to be shifted.
	 * 
	 * @param requestDTO
	 */
	private void shiftZCoordinate(WidgetRequestDTO requestDTO) {
		List<Widget> allWidgets = repository.findAllZCoord(requestDTO.getzCoordinate());
		List<Widget> widgetsToBeShifted = new ArrayList<>();
		int zcoord = requestDTO.getzCoordinate();
		for(Widget widget: allWidgets) {
			zcoord = zcoord + 1;
			if(widget.getzCoordinate() >= zcoord ) {
				break;
			}
			else {
				widget.setzCoordinate(zcoord);
				widgetsToBeShifted.add(widget);
			}
		}
		
		repository.saveAll(widgetsToBeShifted);
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
			
			widget.setHeight(requestDTO.getHeight());
			widget.setWidth(requestDTO.getWidth());
			widget.setxCoordinate(requestDTO.getxCoordinate());
			widget.setyCoordinate(requestDTO.getyCoordinate());
			widget.setzCoordinate(requestDTO.getzCoordinate());
			
			Widget widgetByZCoord = repository.findByZCoord(requestDTO.getzCoordinate());
			if(widgetByZCoord != null) {
				shiftZCoordinate(requestDTO);
			}
			
		}
		return repository.save(widget);
	}


}
