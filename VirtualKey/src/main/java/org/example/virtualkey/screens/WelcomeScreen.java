package org.example.virtualkey.screens;

import java.util.List;
import java.util.Arrays;
import org.example.virtualkey.entities.User;

public class WelcomeScreen implements Screen {

    private static final String welcomeText = "Welcome to VirtualKey!";
    private User developer;
    private static final List<String> options = Arrays.asList("1. Show Files", "2. Show File Options Menu", "3. Quit Application");

    public WelcomeScreen(User developer) {
    	this.developer = developer;
    }
    
    @Override
    public void show(){
    	System.out.println("----------------------" + "Main Screen Options" + "------------------------");
        for (String option : options)  {
            System.out.println(option);
        }
    }
    
    public void developerDetails() {
    	System.out.println("---------------------" + welcomeText + "---------------------");
        System.out.println(developer);
        System.out.println("-----------------------------------------------------------------");
        
    }

}
