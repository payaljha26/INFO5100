package lab7;


import java.io.BufferedReader;
import java.io.File;  // Import the File class
import java.io.FileInputStream;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner; // Import the Scanner class to read text files

public class CSVReader {
	
	// function to print 5 lines
	public String[] printfive() {
		
		int i = 0;
		String[] dataArray = new String[10];
		
	    try {
//	      File myObj = new File("/Users/payaljha/eclipse-workspace/lab7/src/annual.csv");
	      File myObj = new File("./src/annual.csv");
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine() && i < 6) {
	        String data = myReader.nextLine();
	        dataArray[i] = data;
	        System.out.println(data);
	        i++;
	      }
	      
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	    return dataArray;

	}
		
	
//  public static void main(String[] args) {
	  public void CSVRead() {
	int i = 0;
    try {
      //File myObj = new File("/Users/payaljha/eclipse-workspace/lab7/src/annual.csv");
      File myObj = new File("./src/annual.csv");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine() && i < 6) {
        String data = myReader.nextLine();
        System.out.println(data);
        i++;
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
	 
	  
    
  public void preread() {
	        BufferedReader br = null;
	        String strLine = "";
	        try {
	            LineNumberReader reader = new LineNumberReader(new InputStreamReader(new FileInputStream("/Users/payaljha/eclipse-workspace/lab7/src/annual.csv"), "UTF-8"));
	             while (((strLine = reader.readLine()) != null) && reader.getLineNumber() <= 5){
	                System.out.println(strLine);
	            }
           reader.close();
	        } catch (FileNotFoundException e) {
	            System.err.println("File not found");
	        } catch (IOException e) {
	            System.err.println("Unable to read the file.");
	        }
		    

			
	  
    try {
//    	File outStream = new File ("/Users/payaljha/eclipse-workspace/lab7/src/NewFile.txt");
    	File outStream = new File ("./src/NewFile.txt");
    	if (outStream.createNewFile()) {
    	System.out.println("File created: " + outStream.getName());
    	}
    	else {
    	System.out.println("File already exists.");
    	}
    	}
    	catch (IOException e) {
    	System.out.println("An error occurred.");
    	e.printStackTrace();
    	}
    

    try {
    	String csvSplitter = ";" ;
		String line ;
		
//		BufferedReader cd = new BufferedReader(new FileReader("/Users/payaljha/eclipse-workspace/lab7/src/annual.csv"));
		
		BufferedReader cd = new BufferedReader(new FileReader("./src/annual.csv"));
		PrintWriter output = new PrintWriter("./src/NewFile.txt", "UTF-8");
		// PrintWriter output = new PrintWriter("/Users/payaljha/eclipse-workspace/lab7/src/NewFile.txt", "UTF-8");
		
		while ((line = cd.readLine()) != null) {
		    String[] cols = line.split(csvSplitter);
		}
    }catch (IOException e) {
    	System.out.println("An error occurred.");
    	e.printStackTrace();
    	}
}
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  

    
