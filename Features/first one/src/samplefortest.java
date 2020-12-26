import java.util.*;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
public class samplefortest {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		  //creating File instance to reference text file in Java
        File text = new File("E:/as.txt");
     
        //Creating Scanner instnace to read File in Java
        Scanner scnr = new Scanner(text);
     
        //Reading each line of file using Scanner class
        int lineNumber = 1;
        while(scnr.hasNextLine()){
            String line = scnr.nextLine();
            System.out.println("line " + lineNumber + " :" + line);
            lineNumber++;
        }
		
		

	}

}
