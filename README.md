# JPACRUDWeather

  -- Developed for Skill Distillery Bootcamp Cohort 32 --

  View this project deployed on AWS: http://52.52.235.108:8080/Weather

### Description

  This project is the (hopefully) first rendition of a (hopefully) ongoing project. Using a web browser, a user can perform basic CRUD operations on a database containing names, elevations, and GPS coordinates for all 13er/14er summits in Colorado.  A user can view peaks in various tables, sort, search the tables, and view information for one specific location.  They can update the details for that location and the database will save their update.  They can also remove a location and have the option to add it back, though with a different ID as database auto-increments beginning with 828 (there are 827 peaks initially in the database).  A user can also create their own categories of locations.

### Cool Features

  I enjoyed getting more practice with object mapping and using the MVC structure.  After this project, I have a much greater appreciation for automation through Spring Boot and Hibernate.  It feels powerful to be able to create persistent, expandable systems, and to see great potential for developing applications for real-life scenarios.

### Technologies Used

- Java
- HTML/CSS/JS/jQuery
- MySql
- MAMP
- MYSQL Workbench
- Spring Boot
- Gradle
- Spring Tool Suite 4
- Atom
- Github
- Bootstrap
- NiceAdmin Template
- Terminal
- Google Chrome
- MacBook Pro Retina 2015

### Database Structure

  The database contains one "point" table with various pieces of information.  Two other tables exist at this time - category and range - used to connect category_id and range_id with the corresponding names.  This is all in the name of normalization.

### Thoughts For The Future

  This was all developed in hopes of turning this into a "nice weather finder" application.  Using the National Weather Service's JSON API, a user will be able to see short or detailed forecast for any GPS coordinates, and will be able to search for optimized conditions or conditions of their choosing.  This functionality is tested though not implemented into the web app at this time.  It is necessary to develop additional entities and foreign key relationships to preserve data integrity.  It may also be necessary to build in timestamps and/or to optimize an ongoing server (i.e. AWS) to update records each hour or so, rather than have users request for large amount of API requests.
