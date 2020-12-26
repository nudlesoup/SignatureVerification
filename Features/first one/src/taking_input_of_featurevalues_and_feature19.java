import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class taking_input_of_featurevalues_and_feature19 extends allfunctions {

	 public static void assignfeaturevalues() throws FileNotFoundException {
		 
	        //creating File instance to reference text file in Java
	        File text = new File("E:/data_1.txt");
	     
	        //Creating Scanner instnace to read File in Java
	        Scanner scnr = new Scanner(text);
	     
	        //Reading each line of file using Scanner class
	        int lineNumber = 1;
	      
	           
	            for(int t=0;t<7;t++)
	            {
	                // for the actual signature 9 samples' feature values
	                for( int i=0;i<numberoffeatures;i++)
	                {
	                	if(scnr.hasNextLine())
	                	{
	                	String line = scnr.nextLine();
	                	 
	                    featurevalues[t][i] = Double.parseDouble(line);
	                	}
	                }
	            }
	           
	       //taking values to feature19
	             text = new File("E:/alldata.txt");
	   	     
		        //Creating Scanner instnace to read File in Java
		      //  Scanner scnr = new Scanner(text);
		     
		        //Reading each line of file using Scanner class
		      
		           
		            for(int t=0;t<4;t++)
		            {
		                // for the actual signature 9 samples' feature values
		            	for(int j=0; j<7;j++)
		            	{
		                for( int i=0;i<numberoffeatures;i++)
		                {
		                	if(scnr.hasNextLine())
		                	{
		                	String line = scnr.nextLine();
		                	 
		                    feature19[t][j][i] = Double.parseDouble(line);
		                	}
		                }
		            	}
		            } 
	   
	    }   

}
