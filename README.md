# BuildingController
backend part of Building Controller application

[angular part of project](https://github.com/patrykidkowiak/building-controller-angular)

the target of the project is to create a Web Application to control the electrical installation in a smart-building

the application will control lighting in the building, electrical sockets, heating, logging measurements (eg wetness, temperature, etc.)
data about electrical elements will be stored in the MySQL database

PLC (Programmable Logic Controller) will read this data and control the electrical components (eg turn on at an hour, turn off when it is bright outside, etc.)


## built with:
* java 8
* spring boot
* hibernate
* maven
* MySQL
* lombok

### also:
* JUnit tests
* MailSender with user activation link
