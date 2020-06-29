API-Filmes

Functional requirements

User should be able to add new entries about movies: title, description, actors, genre

Users should be able to list all entries
Users should be able to filter movies by title
Users should be able to edit movies
Users should be able to delete movies
Non-functional requirements
Java11
Relational database of your choice
Git repository (Github)
documentation (README) should be provided on how to:
Install the application
Run the application locally
Use API endpoint(s)
Installation
Requirements:

Java 11
MySQL 8.0+
Firstly, prepare DB

create user 'apifilmes'@'localhost' identified by 'apifilmes';
create database apifilmes;
grant all on moviedb.* to 'moviedb'@'localhost';
Then build the app (with tests) ./gradlew clean build

Notes

Why Flyway?
It's more flexible in a production environment to manage the schema via incremental migration scripts, generated using flyway dependencies and design.
