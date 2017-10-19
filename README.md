# sample_applications

## Description: 
Shop is a simple online store application mostly using Spring MVC and database (MySQL Workbench). 
It is in development. After open, you must log in.
It has separate views for admin and shopper. 
Admin has the ability to add, delete and edit a product.
Shopper has the option to purchase the selected product and / or search for it.

### Installation:
1. Import the database included with the application (eg in MySQL Workbench).
2. In IntelliJ IDEA, load the application.
3. In the folder: Shop / src / resources / open config.properties and set your jdbc.username and jdbc.password.
4. In the Shop / src / webapp / WEB-INF folder, open applicationContext 
  and go to bean id = "dataSource" and set your: p: username and p: password.
5. Go to the Maven Projects tab and execute the command: clean install.
6. On the taskbar of the "Select Run / Debug Configuration" list, select "Edit Configurations".
7. In the "Server" tab, point to the Application server (for example, a folder for Tomcat).
8. Run apllication...

#### Usage:
You can log in as admin and use: login: admin, password: admin. Admin has the ability to add, 
delete and edit a product. You can also login as a shopper by registering or using eg: login: stas, password stas. 
Shopper has the option to purchase the selected product and / or search for it.
