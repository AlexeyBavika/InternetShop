
# InternetShop
***
## Description
  Simple site with internet shop simulation. There are two roles : Admin and User. User can see all his products, add it to his own shopping cart and complete order. Also user is able to see his order history. Admin can manage products (add, update, delete), see all users, delete them.
  
***
## Technologies
* Tomcat
* JDBC
* Log4j
* Maven
* MySQL
* Servlet JSP/JSTL
***
## Requirements
Please make sure that you have already installed : 

    1. JDK 11 or higher
    2. MySQL 8.0.20 or higher
***
## Installiation

    1. Clone this project from GitHub
    2. Go to /src/main/java/com/internet/shop/util/ConnectionUtil.java and fill in connection parameters to your database (url/login/password).
    3. Execute script /src/main/resources/init_database.sql
    4. Configure Tomcat: add the artifact internet-shop:war exploded; add as URL http://localhost:8080/
***
## Running
    1. Run the project
    2. After server starts you will be redirected to login page
    3. You can use injected data after script executing or you can redirect to /register page to register your own user   
    
