package org.example.virtualkey.entities;

import java.io.Serializable;

public class Files implements Serializable{

	private String path;
    private String name;

    public Files(String path, String name) {
    	this.path = path;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

	@Override
	public String toString() {
		return "File [path=" + path + ", name=" + name + "]";
	}
    
    
}
