#This program greets the user by name
To run the program, you need the following:

In order to run a java application using the command line, the JDK (Java Development Kit) 
must be installed on the computer, and the CLASSPATH environment variables and PATH must 
also be correctly set. 

The value field must contain the path to the bin folder located in the JDK folder.
<p> 1) Compilation "java -classpath ./classes mypackage.Hello";
<p> 2) Building the archive "jar cvmf manifest.mf hello.jar -C ./classes mypackage"</p>
<p> In what order are m and f - the names of manifest and jar files must appear in the same 
order, respectively. manifest.mf is the name of the file where we specified the executable class.; </p>
<p> 3) Run the "java -jar hello.jar" program.</p>
Hello.jar is the name of the archive to be created. The construction "-C ./classes mypackage"
means "change the directory to classes and take the mypackage directory there"
(from the root directory of the project).