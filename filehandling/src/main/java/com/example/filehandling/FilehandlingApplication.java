package com.example.filehandling;


public class FilehandlingApplication {	
	private static final String[] dataToWrite = {
			"All classes need at least one constructor",
			"No return type means it never returns anything",
			"Having a main method means the class can be run"
		};
	
	private static final String[] dataToAppend = {
		"int, long, double, boolean, char, short, byte, float are PRIMITIVE data types.",
		"The actual values are stored in the variable(s).",
		"Reference types are arrays and objects."
	};
	
    public static void main( String[] args )
    {
        System.out.println( "File Handling Application!" );
        
        //Creating the file
        System.out.println("Creating file!!!");
        FileService fileService = new FileService("textFile.txt");
        
        //Read Data
        String data = fileService.readData();
        if (data == null) {
        	System.out.println("There is no data in the file!!!");
        }else{
        	System.out.println(data);
        }
        
        //Write Data
        for (String str : dataToWrite) {
        	fileService.write(str);
        }
        
        //File data after writing
        System.out.println("Data inside File after Writing: \n"  + fileService.readData());
        
        //Append Data
        for (String str : dataToAppend) {
        	fileService.append(str);
        }
        
        //File data after appending
        System.out.println("Data inside File after Appending: \n"  + fileService.readData());
    }
}
