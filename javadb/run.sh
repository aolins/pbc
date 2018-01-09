echo Hello world
echo Now the JAVA is about to run
#!/bin/bash
javac src/main/java/bootcamp/*.java
java -cp "./src/main/java;./lib/*"  bootcamp.JDBCExample
read
