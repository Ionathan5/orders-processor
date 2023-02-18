About:
    This is a middleware application for ordering systems with the multiple suppliers of electronic products.
    Company customers can place product orders from various locations and systems and these orders need to be processed and sent to the corresponding suppliers.
    The orders are sent as XML files on a central server, where the application needs to process them and create the XML files that will be sent to the suppliers.

How to run this application:
    Import this project to your IDE like a Maven project
    Build the project with: mvn clean install 
    Create directory C:\temp\input and place your input files here (for example orders12.xml)
    Run App.java from \src\main\java\com\ardelean\App.java
    You can find the processed files in C:\temp\output directory
    
    
How it works:
    The application loads the properties file which contains input and output folders.
    Every three seconds the application looks for files in the input folder and tries to process them.
    First, the name of the file is validated, then the xml is unmarshalled to POJO classes which model its data.
    The input products are linked to suppliers and order ids.
    For each supplier, an xml is created with its corresponding products in the output directory.
    If successful the processed file is then moved to an archive directory, otherwise it is moved to error directory.
    The paths to input, output, archive and error directories can be configured in the xmlorders\src\main\resources\application.properties file;
    The marshaling and unmarshalling is done with classes and annotations from javax.xml.bind package present in java 8
    
Further enhancements:
    This application can be improved by adding tests to prove that it is working properly.
    A useful feature especially for debugging would be to add logging functionality.