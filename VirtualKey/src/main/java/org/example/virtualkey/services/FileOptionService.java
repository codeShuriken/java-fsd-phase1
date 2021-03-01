package org.example.virtualkey.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FileOptionService implements Option {
	
	private DirectoryService directoryService;
	
    public FileOptionService(DirectoryService directoryService) {
    	this.directoryService = directoryService;
    }

	@Override
    public void navigateOption(int option){
        switch(option) {
            case 1: // Add File
                this.addFile();
                break;
            case 2:
            	this.deleteFile();
            	break;
            case 3:
            	this.searchFile();
            	break;
            default:
                System.out.println("Invalid Option");
                break;
        }
    }
	
    public void addFile() {
        System.out.println("Please Enter the file name to add:");
        String fileName = IOService.getInputString();
        if (fileName != null && validateFileName(fileName)) {
        	
        	fileName = fileName.toLowerCase();
        	if (fileName.chars().filter(c -> c=='/').count() > 0) {
        		String[] splitFileName = split(fileName);
        		this.directoryService.addFile(splitFileName[0], splitFileName[1]);
        	}else {
        		this.directoryService.addFile("/", fileName);
        	}
        	
        }else {
        	errorInput();
        }
    }
    
    public void deleteFile() {
        System.out.println("Please Enter the file name to delete:");

        String fileName = IOService.getInputString();
        if (fileName != null && validateFileName(fileName)) {
        	System.out.println("Deleting a file named: " + fileName);
        	boolean deleted = false;
        	
        	if (fileName.chars().filter(c -> c=='/').count() > 0) {
        		String[] splitFileName = split(fileName);
        		deleted = this.directoryService.deleteFile(splitFileName[0], splitFileName[1]);
        	}else {
        		deleted = this.directoryService.deleteFile(fileName);
        	}
        	
        	if (!deleted) {
        		System.out.println("File Not Found!!!!\n");
        	}
        	
        }
        else {
        	errorInput();
        }
    }

	public void searchFile() {
        System.out.println("Please Enter the file name to search:");

        String fileName = IOService.getInputString();
        
        if (fileName != null && validateFileName(fileName)) {
        	System.out.println("Searching for file named: " + fileName);
        	
        	boolean isFound = false;
        	
        	if (fileName.chars().filter(c -> c=='/').count() > 0) {
        		 String[] splitFileName = split(fileName);
        		isFound = this.directoryService.searchFile(splitFileName[0], splitFileName[1]);
        	}else {
        		isFound = this.directoryService.searchFile(fileName);
        	}
        	
        	if (!isFound) {
        		System.out.println("File Not Found!!!!\n");
        	}
        	
        }else {
        	errorInput();
        }
    }
	
	 private boolean validateFileName(String fileName) {
		 final Set<Character> invalidChars = new HashSet<>(Arrays.asList('\n', '\r', '\t', '\0', '\f', '`', '?', '*', '<', '>', '|', '\"', '!', '@', '%',
				 '&', '*', '(', ')', '{', '}', '[', ']', ';', ',', '?', '+', '=', '^', '$', '`'));
		 for (char c : fileName.toCharArray()) {
			 if (invalidChars.contains(c))
				 return false;
		 }
		 return true;
	}

	private void errorInput() {
	    System.out.println("You didn't enter a valid file name!\n");
	 }

	private String[] split(String fileName) {
    	int index = 0;
    	for (int i = 0; i < fileName.length(); ++i) {
    		if (fileName.charAt(i) == '/') {
    			index = i;
    		}
    	}
    	return new String[] {fileName.substring(0, index+1), fileName.substring(index+1)};
	}

    
}
