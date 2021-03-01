package org.example.virtualkey.services;

import org.example.virtualkey.screens.FileOptionsScreen;

public class WelcomeScreenService implements Option {

	private DirectoryService directoryService;
	private FileOptionService fileOptionService;
	private static final FileOptionsScreen fileOptionsScreen = new FileOptionsScreen();
	
    public WelcomeScreenService(DirectoryService directoryService) {
    	this.directoryService = directoryService;
    	fileOptionService = new FileOptionService(this.directoryService);
    }

	@Override
    public void navigateOption(int option){
        switch(option) {
            case 1: // Show Files
                this.showFiles();
                break;
            case 2: // Show Submenu
                fileOptionsScreen.show();
                int newOption = IOService.getOption();
                
                while (newOption != 4) {
                	this.fileOptionService.navigateOption(newOption);
                	fileOptionsScreen.show();
                	newOption = IOService.getOption();
                }
                System.out.println("Going back to Main Menu\n");
                break;
            default:
                System.out.println("Invalid Option\n");
                break;

        }
    }
	
	public void showFiles() {
		this.directoryService.showFiles();
	}

}
