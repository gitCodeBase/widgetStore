package com.widgetstore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.widgetstore.model.Widget;

@Repository
public interface WidgetRepository extends CrudRepository<Widget, Integer> {

}
