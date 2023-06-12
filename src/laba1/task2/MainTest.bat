@echo off
set JAVA_HOME=C:\Program Files (x86)\Java\jdk1.7.0_45
set "BASE_DIR=%~dp0"
echo Compiling project.
javac -d . Main.java
echo Compiling tests.
javac -cp .;%BASE_DIR%lib\junit.jar;%BASE_DIR%lib\hamcrest-core.jar -d . MainTest.java
echo Running tests.
java -cp .;%BASE_DIR%lib\junit.jar;%BASE_DIR%lib\hamcrest-core.jar org.junit.runner.JUnitCore laba1.task2.MainTest
echo Running program with class file and args x = 0.5, acc = 0.0001
java -cp %BASE_DIR% laba1.task2.Main 0.5 0.0001
pause