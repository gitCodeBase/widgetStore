# widgetStore


END POINTS: Swagger UI: http://localhost:8080/swagger-ui/


CREATE AND UPDATE   - POST : http://localhost:8080/api/widget

CREATE Request Body:
{
	"xCoordinate":1,
	"yCoordinate":1,
	"zCoordinate":5,
	"width":205,
	"height":100
}

UPDATE Request Body:
{
	"id":1
	"xCoordinate":1,
	"yCoordinate":1,
	"zCoordinate":5,
	"width":205,
	"height":100
}

GetWidget By Id       - GET: http://localhost:8080/api/widget/{id}

Get All widgets       - GET: http://localhost:8080/api/widgets?limit={anyNumber}

Delete Widget by id   - DELETE: http://localhost:8080/api/widget/{id}
