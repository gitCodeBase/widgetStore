package com.widgetstore.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class WidgetRepositoryTest {
	  @Autowired 
	  private WidgetRepository widgetRepository;

	  @Test
	  void injectedComponentsAreNotNull(){
	    assertThat(widgetRepository).isNotNull();
	  }
	}
