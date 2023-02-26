<h1 align="center">TALES OF TIME TRAVEL</h1>

# Description
This is a REST API for a Bus reservation system portal. This API performs all the fundamental CRUD operations of any Bus reservation platform with user and admin validation at every step.
This is a collaborative project built by a team of 5 members executed in 5 days.


## Techstacks

- Java
- Spring Framework
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL


## Modules

- Admin Module
- User Module
- Login Module
- Route Module
- Bus Module
- Reservation Module
- Feedback Module

## ER Diagram
Following ER diagram indicates the database tables and thier interaction which we are using.
![table-relationship](https://user-images.githubusercontent.com/105231493/221410769-4d3d2e3d-ed0c-4191-ae7b-06698320f15a.png)


## Features

* User and Admin authentication & validation with session uuid having.
* Admin Features:
    * Administrator Role of the entire application
    * Only registered admins with valid session token can add/update/delete route or customer from main database
    * Admin can access the details of different users, buses and routes.
* User Features:
    * Registering themselves with application, and logging in to get the valid session token.
    * Viewing list of available bus and booking a reservatioon.
    * Only logged in users can update his/her reservation, profile updation and other features.
