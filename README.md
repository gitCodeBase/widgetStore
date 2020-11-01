# widgetStore

EndPoints: Swagger UI: http://localhost:8080/swagger-ui/

Create and Update     - POST : http://localhost:8080/api/widget

CREATE REQUEST BODY:
{
	"xCoordinate":1,
	"yCoordinate":1,
	"zCoordinate":5,
	"width":205,
	"height":100
}

UPDATE REQUEST BODY
{
	"id":1
	"xCoordinate":1,
	"yCoordinate":1,
	"zCoordinate":5,
	"width":205,
	"height":100
}

GetWidget By Id       - GET: http://localhost:8080/api/widget/{id}

Get All widgets       - GET: http://localhost:8080/api/widgets?limit={any number}

Delete Widget by id   - DELETE: http://localhost:8080/api/widget/{id}