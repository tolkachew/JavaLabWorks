@echo off
set JAVA_HOME=C:\Program Files\Java\jdk-17.0.5
set "BASE_DIR=%~dp0"
echo Compiling project.
javac -d . %BASE_DIR%Main.java %BASE_DIR%BubbleSort.java %BASE_DIR%HeapSort.java %BASE_DIR%Sortable.java
echo Running class Main with args: dog book banana i garden go English Morningg
java -cp %BASE_DIR% laba3.task4.Main dog book banana i garden go English Morningg
pause