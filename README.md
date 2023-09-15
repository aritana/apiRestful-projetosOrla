
# Orla's projects

This challenge implements a Restful API.

A partial CRUD must be performed for the following context.
CRUD operations to be implemented:
* Create
* Read

As a user, I would like to register `projects` and each project can have N `employees` and
each `employee` can have N `projects`.
As a user, I would like to list projects with their respective employees.

As a user, I would like to list the employees of a respective project.
I as a user would like to list the projects of a respective employee.

Mandatory attributes for entities:
* Project: (name, creation_date)
* Employee: (name, social security number, email, salary)
Important technical notes
* Use Java 11+
* Spring Boot or Quarkus
* Use relational database (do not use in-memory database)
* Follow the RESTful standard
* Follow Database Normalization
* Perform unit/integrated tests
* The solution must
