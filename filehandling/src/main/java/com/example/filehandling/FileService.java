package com.example.filehandling;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileService {
	private String fileName;
	
	public FileService(String fileName){
		this.fileName = fileName;
		try {
			File file = new File(fileName);
			if (file.createNewFile()) {
				System.out.println("File " + fileName  + " created");
			}else {
				System.out.println("File " + fileName  + " already exists!");
			}
		}catch(Exception e) {
			System.err.println("Error occurred while creating file!!\n" + e.getMessage());
		}
	}
	
	public String readData() {
		StringBuilder sb = new StringBuilder();
		try (Scanner reader = new Scanner(new File(this.fileName))) {
	      while (reader.hasNextLine()) {
	        String data = reader.nextLine();
	        sb.append(data).append("\n");
	      }
	    } catch (Exception e) {
	      System.out.println("Couldn't read the file!!\n" + e.getMessage());
		}
		return (sb.length() == 0) ? null : sb.toString();
	}
	
	public boolean write(String data) {
		boolean status = false;
		try(FileWriter fileWriter = new FileWriter(this.fileName)){
			fileWriter.write(data);
			status = true;
		}catch(Exception e) {
			System.err.println("Couldn't write to the file!!\n" +  e.getMessage());
		}
		if (status) {
			System.out.println("Successfully written to the file.");
		}
		return status;
	}
	
	public boolean append(String data) {
		boolean status = false;
		try(FileWriter fileWriter = new FileWriter(this.fileName, true)){
			//Appends data
			fileWriter.append(data);
			fileWriter.append("\n");
			status = true;
		}catch(Exception e) {
			System.err.println("Couldn't append to the file!!\n" +  e.getMessage());
		}
		
		if (status) {
			System.out.println("Successfully appended to the file.");
		}
		
		return status;
	}
	
}
