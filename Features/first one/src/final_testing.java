
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class final_testing extends training_and_increasing_internal_nodes
{
    public static void main(String[] args) throws FileNotFoundException
    {
        // TODO Auto-generated method stub
    	runlater();
    	//onesign100iters(feature)
        double features [] = new double [numberoffeatures];
        File text = new File("E:/data_false.txt");
	     
        //Creating Scanner instnace to read File in Java
        Scanner scnr = new Scanner(text);
     
           
            for(int t=0;t<7;t++)
            {
                // for the actual signature 9 samples' feature values
                for( int i=0;i<numberoffeatures;i++)
                {
                	if(scnr.hasNextLine())
                	{
                	String line = scnr.nextLine();
                	 
                    features[i] = Double.parseDouble(line);
                	}
                }
            }
            for(int i=0;i<5;i++){
            	for(int j=0;j<3;j++){
            		System.out.println("THis is opt"+optimumalphas[i][j]);
            	}
            }
        for(int i=0;i<5;i++)
        {
        //	System.out.println(onesign100iters(featurevalues,feature19,i,0));
            if(findvalue(numberoffeatures,features,optweights[i][0])/((3-i)+1)/100 > optimumalphas[i][0])
            {
                System.out.println(" YOu are from "+ i+"class");
                System.exit(0);
            }
            else if(findvalue(numberoffeatures,features,optweights[i][1])/1000<optimumalphas[i][1]/3)
            {
                System.out.println("COngrats. YOu are from "+i +"class");
            }
        }
        System.out.println("This is nothing");
    }
}