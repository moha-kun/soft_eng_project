# Trips management mini project
This project is the result of the effort of the contributing developers, under the supervision of Mr. @elyaakoubi, to build a trip management system.

To test the functionalities implemented, you can use the provided Postman collection named **GenieLogi.postman_collection.json**. It contains all the endpoints ready for testing. For the secure endpoints, you'll need to authenticate with a manager account and obtain a token. Once you have the token, you can include it in your requests to access the secured endpoints.

Please note that the URL mentioned in the Postman collection may differ from the one you are currently using. Make sure to update the URL in the collection to match the correct endpoint URL. Feel free to explore the collection, test the endpoints, and verify the functionality.

If you have any questions or need further assistance, please let me know.
## Implemented functionalities
1. Conductor CRUD
- [x] Create conductor
- [x] Update conductor
- [x] Delete conductor
- [x] Get conductor
- [x] Get all conductors
- [x] Get available conductors during time interval
2. Trip CRUD
- [x] Create trip
- [x] Update trip
- [x] Delete trip
- [x] Get trip
- [x] Get all trip
3. Vehicle CRUD
- [x] Create vehicle
- [x] Update vehicle
- [x] Delete vehicle
- [x] Get vehicle
- [x] Get all vehicles
5. Assignement functionality
- [x] Assign conductor to trip
- [x] Assign vehicle to trip
6. correspondence functionality between vehicle and driving license type
7. Authentication with Spring security and jwt
8. Logging with Log4j
9. Exception handling
## Requirements
- Java 17
- MySQL 8.0.26