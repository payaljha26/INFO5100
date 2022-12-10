
HOTEL MANAGEMENT SYSTEM

STEPS TO RUN APPLICATION


1. Open MySQL Workbench and create a database named 'hms' using --> create database hms; and use hms; commands
2. Use the database.txt / database.sql file to populate the 'hms' database that was created
3. Open the project in Eclipse
4. Right click on Project main folder ->  Build Path -> Configure Build path -> go to the libraries tab ->  choose the ClassPath (you need to add the JAR file here) ->click on Add external Jars -> and import the jars presents in the External Jars folder present in the repository
5. In the conn.java file make sure to edit c = DriverManager.getConnection("jdbc:mysql:///hms","root","Harsh@2003"); with your own root username and password.
6. Run the project