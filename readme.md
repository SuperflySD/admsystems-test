1.Install mysql and jdk8

2. create user with all privileges with name root and password root

3. script for db creation and inserting some sample data is located in src/main/resources/db/creation

4. execute script for db on an appropriate environment

5. execute in admsystems folder following command: ./gradlew bootrun

6. Open browser and go to  [http://localhost:8080/](http://localhost:8080/)

7. More convenient way is to run application via IDE, for example gradle plugin for IDEA (the same task bootRun)
or application plugin in IDEA (run Main method in Class Application in src/main/java) 