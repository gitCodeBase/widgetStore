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
	
	default List<Widget> getWidgets(int limit) {
		return getWidgets(PageRequest.of(0, limit));
	}
	
	@Query(value="SELECT * FROM WIDGET where Z_COORD =? AND X_COORD=? AND Y_COORD=? ORDER BY Z_COORD ASC", nativeQuery=true)
	Widget findByXYZCoord(Integer zCoord, Integer xCoord, Integer yCoord);
	
	@Query(value="SELECT * FROM WIDGET where Z_COORD >=? AND X_COORD=? AND Y_COORD=? ORDER BY Z_COORD ASC", nativeQuery=true)
	List<Widget> findAllZCoord(Integer zCoord,Integer xCoord, Integer yCoord);
	
	@Query(value="SELECT max(Z_COORD) FROM WIDGET WHERE X_COORD=? AND Y_COORD=?", nativeQuery=true)
	int findMax(Integer xCoord, Integer yCoord);
}
