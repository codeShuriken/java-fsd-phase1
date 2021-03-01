package org.example.virtualkey;

import org.example.virtualkey.entities.*;
import org.example.virtualkey.screens.WelcomeScreen;
import org.example.virtualkey.services.DirectoryService;
import org.example.virtualkey.services.IOService;
import org.example.virtualkey.services.WelcomeScreenService;

public class VirtualKeyApplication {
    public static void main(String[] args) {
    	User developer = new User("Gowtham", "Vuppala", 51915996, "gowtham.vuppala@hcl.com");
        WelcomeScreen welcomeScreen = new WelcomeScreen(developer);
        
        DirectoryService directoryService = DirectoryService.loadData();
        WelcomeScreenService welcomeScreenService = new WelcomeScreenService(directoryService);
        
        welcomeScreen.developerDetails();
        welcomeScreen.show();        
        int option = IOService.getOption();
        while (option != 3) {	
        	welcomeScreenService.navigateOption(option);
	    	welcomeScreen.show();        
	        option = IOService.getOption();
        }
        directoryService.saveData();
        closeApp();
        
    }
    
    public static void closeApp() {
    	System.out.println("Closing the Virtual Key Application!!!!\n");
    	System.out.println("--------------------------- Good Bye ----------------------------");
    	System.exit(0);
    }
}
