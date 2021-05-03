# tender-api

In order to run the app:
  1) checkout master branch
  2) make sure project sdk is set to java 1.8
  2) execute 'mvn clean install' from project root
  3) execute 'mvn exec:java -Dexec.mainClass=com.olmero.task.TaskApplication' from project root
  
Application is using h2 in-memory db. 
To access the db console, go to 'http://localhost:8080/h2-console' and use:
  1) Driver: org.h2.Driver
  2) JDBC url: jdbc:h2:mem:testdb
  2) username: sa
  3) password: password