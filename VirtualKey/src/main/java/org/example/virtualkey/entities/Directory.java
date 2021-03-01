package org.example.virtualkey.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Directory implements Serializable{

	private String name;
    private List<Files> files;
    
    public Directory(String name) {
    	this.name = name;
    	this.files = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public List<Files> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<Files> files) {
        this.files = files;
    }

	@Override
	public String toString() {
		return "Directory [name=" + name + ", files=" + files + "]";
	}
}
