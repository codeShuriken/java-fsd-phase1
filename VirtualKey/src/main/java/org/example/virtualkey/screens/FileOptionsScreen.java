package org.example.virtualkey.screens;

import java.util.List;
import java.util.Arrays;

public class FileOptionsScreen implements Screen {
    private static final List<String> options = Arrays.asList("1. Add a File", "2. Delete A File", "3. Search A File", "4. Back to the Main Menu!");

    @Override
    public void show(){
    	System.out.println("-----------------------------" + "File Options" + "----------------------------");
        for (String option : options)  {
            System.out.println(option);
        }

    }
}
