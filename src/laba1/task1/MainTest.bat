@echo off
set JAVA_HOME=C:\Program Files\Java\jdk-17.0.5
set "BASE_DIR=%~dp0"
echo Compiling project.
javac -d . Main.java
echo Compiling tests.
javac -cp .;%BASE_DIR%lib\junit.jar;%BASE_DIR%lib\hamcrest-core.jar -d . MainTest.java
echo Running tests.
java -cp .;%BASE_DIR%lib\junit.jar;%BASE_DIR%lib\hamcrest-core.jar org.junit.runner.JUnitCore laba1.task1.MainTest
echo Running program with args 1 2 3.
java -cp %BASE_DIR% laba1.task1.Main 1 2 3
pause