package com.desk;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<Integer> expenses = new ArrayList<>(); //Changed expenses to an static variable so that data stays consistent after every call to optionSelection() method


    public static void main(String[] args) {
        /*System.out.println("Hello World!");*/
        System.out.println("\n**************************************\n");
        System.out.println("\tWelcome to The Desk \n");
        System.out.println("**************************************");
        optionsSelection();
    }
    
    public static void addInitialExpenses() {
 	        expenses.add(1000);
 	        expenses.add(2300);
 	        expenses.add(45000);
 	        expenses.add(32000);
 	        expenses.add(110);
    }
    
    private static void optionsSelection() {       
    	displayOptions();
        addInitialExpenses();
       
        System.out.println("\nEnter your choice:\t");
        Scanner sc = new Scanner(System.in);
        int options =  sc.nextInt();
        
        while (options != 6){
            switch (options){
                case 1:
                    System.out.println("Your saved expenses are listed below: \n");
                    System.out.println(expenses+"\n");
                    break;
                case 2:
                    System.out.println("Enter the value to add your Expense: \n");
                    int value = sc.nextInt();
                    expenses.add(value);
                    System.out.println("Your value is updated\n");
                    System.out.println(expenses+"\n");
                    break;
                case 3:
                    System.out.println("You are about the delete all your expenses! \nConfirm again by selecting the same option...\n");
                    int con_choice = sc.nextInt();
                    if(con_choice==options){
                        expenses.clear();
                        System.out.println(expenses+"\n");
                        System.out.println("All your expenses are erased!\n");
                    } else {
                        System.out.println("Oops... try again!");
                    }
                    break;
                case 4:
                    sortExpenses(expenses);
                    break;
                case 5:
                    searchExpenses(expenses);
                    break;
                default:
                    System.out.println("You have made an invalid choice!\n");
                    break;
            }
            displayOptions();
            System.out.println("\nEnter your choice:\t");
            options = sc.nextInt();
            
        }
        
        closeApp();
        sc.close();
    }
    
    private static void displayOptions() {
    	 final String[] arr = {"1. I wish to review my expenditure",
    	            "2. I wish to add my expenditure",
    	            "3. I wish to delete my expenditure",
    	            "4. I wish to sort the expenditures",
    	            "5. I wish to search for a particular expenditure",
    	            "6. Close the application"
    	    };
    	 int  slen = arr.length;
         for(int i=0; i<slen;i++){
         	// display the all the Strings mentioned in the String array
             System.out.println(arr[i]);
         }
	}

	private static void closeApp() {
        System.out.println("Closing your application... \nThank you!");
    }
    
    private static void searchExpenses(ArrayList<Integer> arrayList) {
        int length = arrayList.size();
        System.out.println("Enter the expense you need to search:\t");
        
        //Complete the method
        Scanner sc = new Scanner(System.in);
        int expense = sc.nextInt();
        
        boolean found = false;
        int index = -1;
        
        //Linear Search O(N)
        for (int i = 0; i < length; ++i) {
        	if (expense == arrayList.get(i)) {
        		found  = true;
        		index = i;
        		break;
        	}
        }	
        
        if (found) {
        	System.out.println("The expense " + expense + " is present in the list at index " + index + ".\n");
        }else {
        	System.out.println("The expense is not present!!!\n");
        }    
    }
    
    
    private static void sortExpenses(ArrayList<Integer> arrayList) {
        int arrlength =  arrayList.size();
       //Complete the method. The expenses should be sorted in ascending order.
       QuickSort.sort(arrayList, 0, arrlength - 1);
       System.out.println("Expenses after Sorting: " + arrayList + "\n");
    }
    
}