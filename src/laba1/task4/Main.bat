@echo off
set JAVA_HOME=C:\Program Files (x86)\Java\jdk1.7.0_45
set "BASE_DIR=%~dp0"
set CLASSPATH=%BASE_DIR%painting.jar
echo Compiling project.
javac -cp .;"%CLASSPATH%" -d . Main.java
echo Running class Painting with args dPhi = 0.1
java -cp "%CLASSPATH%;" laba1.task4.Main 0.1
pause