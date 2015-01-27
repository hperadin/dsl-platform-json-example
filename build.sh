#!/bin/bash
echo 'Cleaning generated code...'
bash clean.sh

echo 'Creating the directory structure...'
mkdir -p client.tmp/
mkdir -p target/
mkdir -p src/generated/

echo 'Compiling the DSL model and generating classes..'
java -jar dsl-clc.jar \
    -temp=client.tmp \
    -dsl=./dsl/ \
    -settings=manual-json,no-jackson \
    -target=java_client \
    -namespace=hr.dslplatform.example \
    -no-prompt \
    -download \
    -parse \
    -compiler=dsl-compiler.exe

echo 'Moving the generated model...'
mv generated-model-java.jar target/

echo 'Moving generated sources...'
mv -f client.tmp/java_client/compile-java_client/hr/ target/
mv -f client.tmp/java_client/hr/ src/generated/

echo 'Cleaning temporary dir...'
rm -rf client.tmp

echo 'Compiling the main program...'
javac src/main/hr/dslplatform/example/Main.java \
    -classpath ./target/generated-model-java.jar:./java_client/* \
    -d target/

echo 'Generating Manifest...'
mkdir -p target/META-INF/
echo 'Main-Class: hr.dslplatform.example.Main' > target/META-INF/MANIFEST.MF

echo 'Packagin the Main program jar...'
jar -cfm target/dsl-platform-json-example.jar target/META-INF/MANIFEST.MF \
    -C target/ hr

echo 'Generating the example script'
echo 'java -cp java_client/*:target/dsl-platform-json-example.jar hr.dslplatform.example.Main' > runExample.sh

echo
echo 'To run the example do a:'
echo '    bash runExample.sh'
echo