package com.widgetstore.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.widgetstore.service.WidgetService;
import com.widgetstore.testdata.DataSet;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = WidgetController.class)
public class WidgetControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private WidgetService service;

	@Test
	void whenValidInputForCreation_thenReturns200() throws Exception {
		boolean needValidInput = true;
		mockMvc.perform(post("/widget")
		        .contentType("application/json")
		        .content(objectMapper.writeValueAsString(DataSet.buildRequest(needValidInput, false))))
		        .andExpect(status().isOk());
	}
	
	@Test
	void whenValidInputForUpdate_thenReturns200() throws Exception {
		boolean needValidInput = true;
		mockMvc.perform(post("/widget")
		        .contentType("application/json")
		        .content(objectMapper.writeValueAsString(DataSet.buildRequest(needValidInput, true))))
		        .andExpect(status().isOk());
	}
	
	@Test
	void whenInValidInput_thenReturns412() throws Exception {
		
		boolean needValidInput = false;
		mockMvc.perform(post("/widget")
		        .contentType("application/json")
		        .content(objectMapper.writeValueAsString(DataSet.buildRequest(needValidInput, false))))
		        .andExpect(status().isPreconditionFailed());
	}
	
	@Test
	void whenGetWidgetById_thenInvokeService() throws Exception {
		mockMvc.perform(get("/widget/{id}",1));
		verify(service, times(1)).getWidgetById(1);
	}
	
	@Test
	void whenDeleteWidgetById_thenInvokeService() throws Exception {
		mockMvc.perform(delete("/widget/{id}",1));
		verify(service, times(1)).deleteWidget(1);
	}
	
	@Test
	void whenDeleteWidgetByIds_thenInvokeService() throws Exception {
		mockMvc.perform(get("/widgets").queryParam("limit", "10"));
		verify(service, times(1)).getAllWidgets(10);
	}

}
