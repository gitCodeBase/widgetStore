package com.widgetstore.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.CollectionUtils;

import com.widgetstore.dto.WidgetRequestDTO;
import com.widgetstore.model.Widget;
import com.widgetstore.repository.WidgetRepository;
import com.widgetstore.testdata.DataSet;

@SpringBootTest
public class WidgetServiceTest {
	
	WidgetServiceImpl service;
	
	@MockBean
	WidgetRepository repository;
	
	@BeforeEach
	public void setUp() {
		service = new WidgetServiceImpl(repository);
	}
	
	@Test
	void whenValidInputForCreation_thenReturnCreatedWidget() throws Exception {
		WidgetRequestDTO request = DataSet.buildRequest(true, false);
		
		Mockito.when(repository.findByXYZCoord(request.getzCoordinate(),request.getxCoordinate(),request.getyCoordinate()))
	      .thenReturn(null);
		Mockito.when(repository.save(Mockito.any()))
	      .thenReturn(DataSet.getWidget());
		
		Widget result = service.createWidget(request);
		
		assertEquals(request.getHeight(), result.getHeight());
		
	}
	
	@Test
	void whenValidInput_thenReturnUpdatedObject() throws Exception {
		WidgetRequestDTO request = DataSet.buildRequest(true, false);
		request.setId(1);
		Widget existingObject = DataSet.getWidget();
		existingObject.setId(1);
		existingObject.setHeight(4);
		existingObject.setxCoordinate(110);
		existingObject.setyCoordinate(11);
		existingObject.setzCoordinate(16);
		
		Mockito.when(repository.findById(request.getId()))
	      .thenReturn(Optional.of(existingObject));
		Mockito.when(repository.findByXYZCoord(request.getzCoordinate(), request.getxCoordinate(), request.getyCoordinate()))
	      .thenReturn(null);
		Mockito.when(repository.save(Mockito.any()))
	      .thenReturn(DataSet.getWidget());
		
		Widget result = service.updateWidget(request);
		assertEquals(request.getzCoordinate(), result.getzCoordinate());
		
	}
	
	@Test
	void whenInvokedAndIfWidgetsExistsInDatabase_thenReturnListOfWidgets() throws Exception {
		Mockito.when(repository.getWidgets(1))
	      .thenReturn(DataSet.getWidgets());
		
		List<Widget> result = service.getAllWidgets(1);
		assertFalse(CollectionUtils.isEmpty(result));
		
	}
	
	@Test
	void whenInvokedAndIfNoWidgetsInDatabase_thenReturnEmptyList() throws Exception {
		Mockito.when(repository.getWidgets(1))
	      .thenReturn(null);
		
		List<Widget> result = service.getAllWidgets(1);
		assertTrue(CollectionUtils.isEmpty(result));
		
	}

}
