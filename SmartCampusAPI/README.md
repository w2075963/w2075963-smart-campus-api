Create a room:
Curl POST http://localhost:8080/SmartCampusAPI/api/v1/rooms -H "Content-Type: application/json" -d '{"id":"LIB-301","name":"Library Room","capacity":50}'

Get rooms:
Curl http://localhost:8080/SmartCampusAPI/api/v1/rooms

Add sensor:
Curl POST http://localhost:8080/SmartCampusAPI/api/v1/sensors -H "Content-Type: application/json" -d '{"id":"TEMP-001","type":"Temperature","status":"ACTIVE","currentValue":0,"roomId":"LIB-301"}'

Part 1: Architecture
JAX-RS typically creates a new instance of a resource class for each request. This helps avoid shared state issues between requests. However, since this project uses in-memory static collections, there is still a risk of race conditions if multiple requests modify the same data at the same time. In a real system, thread-safe structures or synchronization would be required.
HATEOAS improves REST design by allowing the server to include links in responses, helping clients navigate the API dynamically instead of relying on fixed endpoints.



Part 2: Room Management
Returning only IDs would reduce bandwidth usage but require additional requests from the client. Returning full objects increases payload size but is more convenient and efficient for client applications.
The DELETE operation is idempotent because repeating the same request results in the same state — the room remains deleted.


Part 3: Sensor Operations
The @Consumes(MediaType.APPLICATION_JSON) annotation ensures that the API only accepts JSON input. If a client sends data in another format (e.g., text/plain), JAX-RS returns a 415 Unsupported Media Type error.
Query parameters (e.g., ?type=Temperature) are more suitable for filtering because they do not change the identity of the resource, unlike path parameters.


Part 4: Sub-Resources
The sub-resource locator pattern allows nested resources (such as sensor readings) to be handled by separate classes. This improves maintainability and keeps the API modular, especially as the system grows.


Part 5: Error Handling
HTTP 422 is more appropriate than 404 when the request structure is valid but contains incorrect data (such as a non-existent roomId). A 404 would imply the endpoint itself does not exist.
Exposing stack traces can reveal internal system details such as class names and file structure. This information could be used by attackers to exploit vulnerabilities, so a generic 500 response is safer.


