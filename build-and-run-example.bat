@echo off
pushd "%~dp0"

echo Cleaning generated code ...
if exist src\generated\java rmdir /S /Q src\generated\java
if exist target rmdir /S /Q target
if exist tools\temp rmdir /S /Q tools\temp

mkdir target
mkdir tools\temp

echo Compiling the DSL model and generating classes ...
java -jar tools\dsl-clc.jar ^
  -compiler=tools\dsl-compiler.exe ^
  -dsl=dsl ^
  -settings=manual-json,no-jackson ^
  -dependencies:java_client=tools\dependencies\java_client ^
  -java_client=target\model.jar ^
  -namespace=com.dslplatform.example ^
  -temp=tools\temp

echo Moving generated sources ...
rmdir /S /Q tools\temp\java_client\compile-java_client
move tools\temp\java_client src\generated\java > NUL

echo Formatting sources ...
java -jar tools\dcf.jar src\generated\java

echo Compiling the main program ...
javac src\main\java\com\dslplatform\example\Main.java ^
  -classpath lib\*;target\model.jar ^
  -d target

echo Generating manifest ...
mkdir target\META-INF
echo Main-Class: com.dslplatform.example.Main > target\META-INF\MANIFEST.MF

echo Packaging the main program jar ...
jar -cfm target\dsl-platform-json-example.jar ^
  target\META-INF\MANIFEST.MF ^
  -C target com

echo.
echo ###################################
echo ### Running the example program ###
echo ###################################
java -cp lib\*;target\* com.dslplatform.example.Main

goto :EOF
