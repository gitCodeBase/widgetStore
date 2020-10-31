package com.widgetstore.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.widgetstore.model.Widget;

@Repository
public interface WidgetRepository extends CrudRepository<Widget, Integer> {
	@Query(value="SELECT * FROM WIDGET ORDER BY Z_COORD ASC", nativeQuery=true)
	List<Widget> getWidgets(PageRequest pageRequest);
	
	default List<Widget> getWidgets(int offset, int limit) {
		return getWidgets(PageRequest.of(offset, limit));
	}
}
