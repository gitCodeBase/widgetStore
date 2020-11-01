package com.widgetstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.widgetstore.controller.WidgetController;

@SpringBootTest
class WidgetServiceApplicationTests {
	@Autowired
	private WidgetController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
