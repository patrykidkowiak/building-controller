# BuildingController
backend part of Building Controller application

the target of the project is to create a Web Application to control the electrical installation in a smart-building

the application will control lighting in the building, electrical sockets, heating, logging measurements (eg humidity, temperature, etc.)
data about electrical elements will be stored in the MySQL database

PLC (Programmable Logic Controller) will read this data and control the electrical components (eg turn on at an hour, turn off when it is bright outside, etc.)


## built with:
* java 8
* spring
* hibernate
* maven
* MySQL

### also:
* JUnit tests
* MailSender with user activation link
