OracleJET for Java Demo
=======================

This is a trivial modification of the skeletal OracleJET project
to demonstrate coding the application logic in Java.

To try the demo invoke following three commands:

```bash
$ git clone https://github.com/jaroslavtulach/oraclejet4j.git
$ cd oraclejet4j
oraclejet4j$ JAVA_HOME=/jdk-11/ ./gradlew run
```

a window with WebKit is going to be shown. Click the top or bottom navigations 
elements and observe that the user name in top right corner is changing
its case with each click. That's thanks to the code in 
[RootViewModel](https://github.com/JaroslavTulach/oraclejet4j/blob/master/src/main/java/OpenJFXLiteDemo/RootViewModel.java).

### Debug the Java Code ###

Open the project in your IDE, open 
`src/main/java/OpenJFXLiteDemo/RootViewModel.java`
in the editor. Place breakpoints for example to `changeUserLoginCase` method.
Then launch the application as:

```bash
oraclejet4j$ JAVA_HOME=/jdk-11 ./gradlew run --debug-jvm
```

connect your IDE to port `5005` and debug. Once you click a hyperlink, your break
point shall be hit.

Modify the source code, kill the `gradlew` process, launch again. Observe your
changes.
