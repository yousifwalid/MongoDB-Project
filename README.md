# MongoDB-Project
This MongoDB-based service with java and spring boot comes with features:
-Fetch data created by a user based on their UserId and from specific date to another.

-Track changes made to the database,then log the operations performed, and store them in a file.

Endpoints:
---------
POST/user/create : Create User 

GET/user/search/{userId} : Get User Data 

GET/user/searchByDate : Get User Data By Date (from-to)

DELETE/user/delete/{userId} : Delete User

Api Documentation:
------------------
Swagger is used to generate API documentation, describing the endpoints.

URL :  http://localhost:8080/swagger-ui.html
