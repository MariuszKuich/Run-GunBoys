@echo off
mode con: cols=61 lines=47
echo loading...
cd .\src
javac logic\*.java
javac living\*.java
javac resting\*.java
java logic.ObjectThingy
timeout 3