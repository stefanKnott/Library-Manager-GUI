The Public Domain Library Manager repository is structured such that all necessary files to run the program are contained within the repo.  Program files are available at:  https://github.com/stefanKnott/LibManGUI

The most up-to-date instance of the application is included in the repository as LibManager.jar
If you simply wish to use the program, this is the only necessary file and is executable on any standard operating system with JRE 1.7 installed. 

For information about downloading and installing JRE 1.7: http://www.oracle.com/technetwork/java/javase/downloads/java-se-jre-7-download-432155.html

To build the program, simply clone the repository locally or download and extract the zip file available on GitHub.  Navigate to the root directory of the program and run, in a terminal:

$ javac LibManGUI.java
$ java LibManGUI

Unnecessary files for normal program building would be the test suite CompleteUnitTest.java, and this file may be deleted.  All other *.java files are necessary for building the application.  If developing and testing the source code, however, this file should be ran as a JUnit test case and updated accordingly.  More information about JUnit is available at: http://junit.org/
