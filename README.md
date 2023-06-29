
![horizontal line](Aspose.Words.fcb84065-4344-4d49-9547-5f532e2dc8bc.001.png)

<a name="_2mcsahkpepwj"></a>**Hotel Database Management System**


**Introduction**

The project aims to develop an application for five major hotel chains operating in North America. The application will allow customers to view real-time availability and book rooms in hotels of these chains. The application provides information about hotel chains, hotels, rooms, customers, and employees. The hotels are categorized into 1-star to 5-star, and the rooms have information about their amenities, capacity, price, view, extension, and any problems/damages. Customers can search and book rooms online, and their room booking is transformed into renting upon check-in. The employees who check-in the customers are responsible for this transformation. 

The project has an ER diagram, a relational database schema, defining necessary constraints such as primary keys, referential integrity constraints, domain constraints, and user-defined constraints. The web application is also capable of inserting data into the database, creating necessary SQL modifications and triggers, designing, and implementing a user interface for searching and booking rooms, and updating customer, employee, hotel, and room information.
# <a name="_14mpx6a8znb7"></a>**Languages and DBMS Used**  
We have used several programming languages in this project to achieve our goal. We used SQL queries to populate our database and meet the specific data constraints we were provided. A combination of Java and HTML was used to develop and link the application to our database.  We then used CSS to design it and give it a more professional look. We used PostgreSQL as a DBMS to make our application and Apache Tomcat for server communications. We had to change a lot of the versions of these technologies to make everything work, here is the final list of everything with their version:

- Maven Compiler 17
- Jakarta Servlet API 6.0
- Postgre SQL 15
- Apache Tomcat 10.1.7
- HTML 5,CSS3, Java
- Bootstrap 5
- Github
- pgAdmin4
# <a name="_oymnw3nlvwib"></a>**Steps to Install Application**  
Anybody can install and use our application with two ways, either by downloading the files from the provided zip folder or cloning our GitHub repository from the main branch <https://github.com/mehtameet12/HotelDatabase.git> and then following these steps . 

1. You will need Apache Tomcat 10.1.7 , IntelliJ IDEA with Maven & Tomcat plugin, pgAdmin4 installed to configure the webapp. 
1. Open the project in the IDEA and Maven will download all the required dependencies for the project.
1. Create a Database in pgAdmin called DataBF.
1. From the downloaded folder or the repository, restore the database from Hotel.tar.
1. Connect the database to the IntelliJ project by configuring the Tomcat server in the IDE to your Tomcat location on your drive. 
1. In the Project file ConnectionDB.java change the user name and password to your pgAdmin profile.
1. Run the application and you should be able to access the web application at the address <http://localhost:8080/HotelDatabase/> , from here on you can access all the functionalities of the app. 
# <a name="_c5rpsdy8g2ak"></a>**DDL’s**
- CREATE SCHEMA HotelChain;
- CREATE TABLE rooms (

`   `room\_id SERIAL PRIMARY KEY,

`   `status VARCHAR(20),

`   `price INT,

`   `room\_view VARCHAR(50),

`   `extension INT,

`   `damages VARCHAR(50),

`   `amenities VARCHAR(200),

`   `hotel\_id INT,

`   `date\_from DATE,

`   `date\_to DATE   );

- CREATE TABLE hotelchain (

`    `name CHAR(20) PRIMARY KEY,

`    `totalhotels INT,

`    `address CHAR(45),

`    `emailaddress TEXT[],

`    `phoneno INT[] );

- CREATE TABLE hotels (

`  `hotelid INTEGER PRIMARY KEY,

`  `category INTEGER,

`  `address CHAR(20),

`  `totalrooms INTEGER,

`  `name CHAR(20) );

- CREATE TABLE Employee (

`    `empid INT PRIMARY KEY,

`    `name CHAR(20),

`    `address CHAR(20),

`    `emprole CHAR(20),

`    `hotelid INT );

- CREATE TABLE customer (

`    `custid INT PRIMARY KEY,

`    `name CHAR(20),

`    `address CHAR(20),

`    `regdate DATE,

`    `roomid INT );

- CREATE TABLE manager (

`  `empid INT PRIMARY KEY,

`  `name CHAR(20),

`  `address CHAR(20),

`  `hotelid INT );

- CREATE TABLE Archive (

`    `hotelid INT,

`    `roomid INT,

`    `roomstatus BOOLEAN,

`    `dates DATE,

`    `PRIMARY KEY (hotelid, roomid, dates) );
<a name="_5gqt6a5yy27g"></a>**

==============================
# <a name="_9kt83lx9l7l1"></a>**UPDATED DATABASE SCHEMA**
![](Aspose.Words.fcb84065-4344-4d49-9547-5f532e2dc8bc.002.png)





# <a name="_7q1ipxfj4hov"></a>**INDEXES**
select count(\*) from rooms where status='Available' ;

Before index:80msec

create **index room\_status\_index** on rooms(status); 

After index:41msec

We thought of indexing the Status column of the Rooms table because it is necessary for any operation in our application. Booking and renting a room is the primary job of our application and so indexing it first makes sense. This is reflected in the 2x execution time of the query, which was 80 milliseconds before the index was created and only 41 milliseconds after the index was created. This column will go through a lot of changes so indexing it will be an intense operation in an actual database, so they will have to consider more complex indexes when implementing it in a real database.

select  from hotels where address='Toronto' ;

Before index:85msec

create **index hotel\_address\_index** on hotels(address);

After index: 42msec

The second most searched query would be of the address of the hotel, since during checking of the rooms we need to see the hotel’s address first based on the search criteria of the person. People always have a city in mind when booking a hotel, they will book any Hotel Chain as long as it is in the area where they want to travel in. So indexing the Hotel’s address which gave a 2x improvement in a small database will be helpful for a larger database. Another benefit is that there aren’t many insertions and deletions so there is no downside in indexing this column.

select count(\*) from customer where name='Customer 96' ;

Before index:112msec

create **index customer\_name\_index** on customer(name); 

After indexing:42msec

The third most searched query would be at the end of the booking session or at the time of check-in which is to look up the name of the Customer. Also, there will be a lot of customers with similar names so querying them is an intensive operation. It can be seen from the 3-fold search improvement that a large database would need indexing Customer names to improve speed. It has to be noted that the Customer table will go through a lot of insertions and deletions as customers come and go, so we have to compare the cost and size when indexing this column.

**Conclusion**

In conclusion, the development of a hotel booking and renting system for five major hotel chains with multiple locations in North America was a complex project that required careful planning, design, and implementation. 

We have designed an ER diagram that represents the relationships between the entities and their attributes which was submitted in Deliverable 1 and since then has been modified to reflect the changes made in the database, and based on it, we created a relational database schema with necessary constraints to ensure data integrity. 

We also implemented the database, inserted sample data, and created SQL queries and triggers to allow for easy manipulation of data while enforcing data integrity. Additionally, we designed and implemented a user-friendly interface that allows users to search for and book rooms based on various criteria, and it also allows employees to manage bookings, rentings, and customer information. 

Overall, this system provides an efficient and easy-to-use solution for customers and hotel employees to manage hotel bookings and rentals, and it can be further improved and customized to meet specific needs and requirements.
