# README #

This is the repository used as a template for student repositories in LAPR2, 2017-2018 Edition.

## What is this repository for? ##

This repository contains LAPR2 project work.

## How do I get set up? ##

* Writing tests & other guidelines: [Moodle LAPR2](https://moodle.isep.ipp.pt/course/view.php?id=6037)

## Who do I talk to? ##
In case you have any problem, please talk to:
* Nuno Bettencourt (nmb@isep.ipp.pt)

## How was the .gitignore file generated? ##
.gitignore file was generated based on https://www.gitignore.io/ with the following keywords:
  - Java
  - Maven
  - Eclipse
  - NetBeans
  - Intellij

## How do I use Maven? ##

### How to run unit tests? ###
Execute the "test" goals.
`$ mvn test`

### How to generate the javadoc for source code? ###
Execute the "javadoc:javadoc" goal.

`$ mvn javadoc:javadoc`

This generates the source code javadoc in folder "target/site/apidocs/index.html".

### How to generate the javadoc for test cases code? ###
Execute the "javadoc:test-javadoc" goal.

`$ mvn javadoc:test-javadoc`

This generates the test cases javadoc in folder "target/site/testapidocs/index.html".

### How to generate Jacoco's Code Coverage Report? ###
Execute the "jacoco:report" goal.

`$ mvn test jacoco:report`

This generates a jacoco code coverage report in folder "target/site/jacoco/index.html".

### How to generate PIT Mutation Code Coverage? ###
Execute the "org.pitest:pitest-maven:mutationCoverage" goal.

`$ mvn test org.pitest:pitest-maven:mutationCoverage`

This generates a PIT Mutation coverage report in folder "target/pit-reports/YYYYMMDDHHMI".

### How to combine different maven goals in one step? ###
You can combine different maven goals in the same command. For example, to locally run your project just like on jenkins, use:

`$ mvn clean test install jacoco:report org.pitest:pitest-maven:mutationCoverage`

### How to run the Application? ###
Using maven to compile and execute the application.

`$ mvn compile exec:java -Dexec.mainClass="lapr.project.ui.Main" `

or:

generating a jar file:
`$ mvn package" `

and execute the main class:
`$ java -cp target/expo-1.0-SNAPSHOT.jar lapr.project.ui.Main`
