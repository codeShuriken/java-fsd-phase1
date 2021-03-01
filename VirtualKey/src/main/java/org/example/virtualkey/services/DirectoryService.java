package org.example.virtualkey.services;

import org.example.virtualkey.entities.Directory;
import org.example.virtualkey.entities.Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Comparator;

public class DirectoryService implements Serializable{

	//Stores the directories in increasing hierarchical order.
    @SuppressWarnings("unchecked")
	private final Map<String, Directory> directories = new TreeMap<>(
    		(Comparator<String> & Serializable)(a, b) -> {
    			int countA = (int)a.chars().filter(i -> i == '/').count();
    			int countB = (int)b.chars().filter(i -> i == '/').count();
    			if (countA == countB) {
    				return a.compareTo(b);
    			}
    			return Integer.compare(countA, countB);
    		});
    
    private int numFiles;
    
    public DirectoryService() {
    	this.numFiles = 0;
    }
	
    public boolean deleteFile(String path, String fileName) {
    	if (!this.directories.containsKey(path))return false;
    	
        List<Files> files = this.directories.get(path).getFiles();
    	for (Files f : files) {
    		if (f.getName().equals(fileName)) {
    			files.remove(f);
    			this.numFiles--;
    			
    			if (path.equals("/"))
    				System.out.println("File " + f.getName() + " deleted from the root directory!!\n");
    			else
    				System.out.println("Deleted " + f.getName() + " from the " + path + " directory!!\n");
    			
    			return true;
    		}
    	}	
    	return false;
    }
    
    public boolean deleteFile(String fileName) {
    	for (String path : this.directories.keySet()) {
    		if (deleteFile(path, fileName)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public void addFile(String path, String fileName) {
    	if (this.directories.get(path) == null) {
    		Directory d = new Directory(path);
    		this.directories.put(path, d);
    	}
    	
    	if (!searchFile(path, fileName)) {
    		Files file = new Files(path, fileName);
        	this.directories.get(path).getFiles().add(file);
        	this.numFiles++;
        	System.out.println("Successfully added the file!!\n");
    	}else {
    		System.out.println("File already exits in this directory!!\n");
    	}
    	//System.out.println(this.directories);
    }
    
    public boolean searchFile(String path, String fileName) {
    	if (!this.directories.containsKey(path))return false;
    	
    	List<Files> files = this.directories.get(path).getFiles();
    	for (Files f : files) {
    		if (f.getName().equals(fileName)) {
    			if (path.equals("/")) {
    				System.out.println("File " + f.getName() + " found in the root directory!!\n");
    			}else {
    				System.out.println("File " + fileName + " found in the " + path + " directory!!\n");
    			}
    			return true;
    		}
    	}
    	return false;
    }
    
    public boolean searchFile(String filename) {
    	for (String path : this.directories.keySet()) {
    		if (searchFile(path, filename)) {
    			return true;
    		}
    	}
        return false;
    }


	public void showFiles() {
		if (this.numFiles == 0) {
			System.out.println("Currently there are no files in the directory!!\n");
		}else {
			System.out.println("Files:");
			int i = 0;
			for (Directory dir : this.directories.values()) {
				if (dir != null && dir.getFiles() != null) {
					
					List<Files> temp = dir.getFiles();
					Collections.sort(temp, (a,b)->a.getName().compareTo(b.getName()));
					
					for (Files f : temp) {
						String name = (dir.getName().equals("/")) ? f.getName() :  dir.getName() + f.getName();
						System.out.println(i++ + ") " + name);
					}
					
				}
			}
		}		
	}
	
	public void saveData(){
		try {
		    String fileName= "data.txt";
		    File file = new File(fileName);
		    file.createNewFile(); 
		    
		    FileOutputStream fileOutputStream = new FileOutputStream(file, false);
		    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		    objectOutputStream.writeObject(this);
		    objectOutputStream.close();
		    
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Couldn't save data!");
		}
	}

	public static DirectoryService loadData(){
		DirectoryService directoryService = null;
		try {
		   String fileName= "data.txt";
		   FileInputStream fileInputStream = new FileInputStream(fileName);
		   ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		   
		   directoryService= (DirectoryService) objectInputStream.readObject();
		   objectInputStream.close();
		   return directoryService;
		   
		}catch(Exception e) {
			directoryService = new DirectoryService();
		}
		return directoryService;
	}
}
