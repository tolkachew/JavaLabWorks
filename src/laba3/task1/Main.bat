@echo off
set JAVA_HOME=C:\Program Files\Java\jdk-17.0.5
set "BASE_DIR=%~dp0"
echo Compiling project.
javac -d . Main.java
echo Running class Main with args: dog book banana i garden go English Morningg
java -cp %BASE_DIR% laba3.task1.Main dog book banana i garden go English Morningg
pause