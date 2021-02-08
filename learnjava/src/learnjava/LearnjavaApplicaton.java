package learnjava;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.io.File;
import java.util.ArrayList;

public class LearnjavaApplicaton {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");
		
		List<Map<String, String>> students = new ArrayList<Map<String,String>>();
		Map<String, String> gowt = new HashMap<String, String>();
		
		gowt.put("name", "gowtham");
		gowt.put("address", "123 Main Street");
		
		students.add(gowt);
		
		System.out.println(gowt.get("name"));
		System.out.println(students);
		
		//Inner class example
		System.out.println("-------------------------------------");

		System.out.println("Inner Classess");
		InnerClassExample i = new InnerClassExample("test1");
		System.out.println(i.getMyMember1());
		System.out.println(i.useMyInnerClass());
		
		//Strings
		System.out.println("-------------------------------------");

		System.out.println("Strings");
		StringExample s = new StringExample();
		s.TestString();
		System.out.println("-------------------------------------");
		
		//Arrays
		System.out.println("Arrays");
		ArrayExample arrayExample = new ArrayExample();
		try {
			arrayExample.testArrays();
		}catch(IndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println("-------------------------------------");
		
		//Thread
		System.out.println("Threads");
		ThreadExample threadExample = new ThreadExample();
		threadExample.start();
		
		 System.out.println("MAIN: Starting Main Thread...");
	        MyRunnableThread mrt = new MyRunnableThread();
	        Thread t = new Thread(mrt);
	        t.start();
	        while(MyRunnableThread.myCount <= 10){
	            try{
	                System.out.println("MAIN: Main Thread: "+(++MyRunnableThread.myCount));
	                Thread.sleep(100);
	            } catch (InterruptedException iex){
	                System.out.println("Exception in main thread: "+iex.getMessage());
	            }
	        } 
	        System.out.println("MAIN: End of Main Thread...");

			System.out.println("MAIN: Running Sleep Wait Example...");

			try {
				Thread.sleep(1000);
				ThreadSleepWaitExample.RunSleepWait();
			} catch (InterruptedException iex) {
				System.out.println("MAIN:Exception in main thread: "+iex.getMessage());
			}
			
			System.out.println("-----------------");
			System.out.println("ThreadSender:");

			ThreadSender snd = new ThreadSender();
			ThreadedSend S1 = new ThreadedSend( " Hi " , snd );
			ThreadedSend S2 = new ThreadedSend( " Bye " , snd );
			
			S1.start();
			S2.start();
			try{
				S1.join();
				S2.join();
			}catch(Exception e)
			{
				System.out.println("Interrupted");
			}
			
			Thread.sleep(1000);

			System.out.println("-----------------");
			System.out.println("ExecptionExamples:");
			
			ExceptionExample exceptionExample = new ExceptionExample();
			exceptionExample.HandleException();
			try {
				System.out.println(exceptionExample.UnknownWord());
			}catch(UnknownWordException e) {
				System.err.println(e.getMessage());
			}
			
			
			System.out.println("-----------------");
			System.out.println("FileExample:");

			FileExample fileExample = new FileExample();
			fileExample.DeleteFileIfExists("text.txt");
			File myFile = fileExample.CreateFile("text.txt");
			fileExample.WriteFile("Hello world! LOL");
	}

}
