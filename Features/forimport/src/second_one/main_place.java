package second_one;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;




public class main_place extends taking_input {
static int allcountyes=0;
static int allcountno=0;
static double[] features_for_testing = new double [45];
	public static void taking_test_input_from_file( String a ) throws FileNotFoundException 
	{
		 
		
	    //creating File instance to reference text file in Java
	    File text = new File(a);
	 
	    //Creating Scanner instnace to read File in Java
	    Scanner scnr = new Scanner(text);
	 
	    //Reading each line of file using Scanner class
	    int lineNumber = 1;
	  
	       
	        for(int t=0;t<45;t++)
	        {
	        	if(scnr.hasNextLine())
            	{
            	String line = scnr.nextLine();
            	features_for_testing[t] = Double.parseDouble(line);
            	}
	        	
	        }
	}
	//end iof taking input for testing function
	
	
	public static int check(int [] array)
	{
		for(int i=0;i<array.length;i++)
		{
			if(array[i]!=1)
			{
				return 0;
			}
		}
		return 1;
	}
	public static void main(String[] args) throws FileNotFoundException
	{
	
			
		Vector<interior_node> vec = new Vector<interior_node>(1);	
	 //   interior_node [] my = new interior_node [10];
	    int sillycount = 0;
	   int class_under=0;
	  int in_class=0;
	  int fe = 45;
	//  taking_input t = new taking_input ();
	  int [] classifies = new int [realsign];
	  for(int i=0;i< realsign;i++)
	  {
		  classifies[i]=-1;
	  }
	  while(class_under!=persons-1)
	  {
		  interior_node a = new interior_node();
	    a.class_classifying = class_under;
		a.number_within_class=in_class;
		for(int i=0; i<fe;i++)
		{
		a.alpha1[i]=0.707;//
		a.alpha2[i]=0.707;//
		a.alpha3[i]=0.707;
		a.alpha = -10.5;
		}
		
		assignfeaturevalues();
		copy_to_person_under_consider(class_under);
		
		a=calculate_for_one(a);
		a=updation(a);
		a=calculate_for_one(a);
	
		
		
		vec.add(a);// inerting it into the vector
	//	my[sillycount++]=a;
		/*for(int i=0;i<45;i++)
		{
			System.out.println("newly added" + vec.get(vec.size()-1).incomingedges[i]);
		}*/
	
		 
		
		
		for(int i = 0; i<realsign;i++)
		{
			if(findvalue(fe,person_under_consideration[i],a)<a.alpha)
			{
				classifies[i]=1;
			}
		}
		if(check(classifies)==1)
		{
			class_under++;
			in_class = 0;
			
		}
		else
		{
			in_class++;
		}
	}
	  //remove
	  for(int i=0;i<vec.size();i++)
	  {
		  System.out.println("This is removed "+"    "+vec.get(i).alpha+"       "+vec.get(i).class_classifying);
	  }
	 
	//testing the signatures
	  int [] testpositive = new int[36];
	  for(int pj=10;pj<30;pj++)
		{
			for(int pk=0;pk<2;pk++)
			{
				String ai = "E:/samples/";
				String b = Integer.toString(pj);
				String c = Integer.toString(pk);
				String d = ai.concat(b);
				d = d.concat(c);
				d= d.concat(".txt");
			taking_test_input_from_file(d);
	 int flag=0;
	  
	/*  int class_to_be_checked;
	  Scanner in = new Scanner(System.in);
	  
    System.out.println("Enter a string");
    class_to_be_checked = in.nextInt();*/
	  for(int i=0;i<vec.size();i++)
	  {
		  
		  if(vec.get(i).class_classifying==pj )
		  {
			  System.out.println("This is class "+findvalue(feature,features_for_testing,vec.get(i))+"    "+vec.get(i).alpha+"       "+pj);
			  
				  if(findvalue(feature,features_for_testing,vec.get(i))>vec.get(i).alpha)
				  {
					 /* System.out.println("Congrats. This belongs to the same class");
					  System.exit(0);*/
					  allcountyes++;
					  testpositive[pj]++;
					  System.out.println("This is good class "+pj+"       "+ allcountyes);
					  flag = 1;
					  break;
				  }
				  
			  
		  }
		  
	  }
	 
	/*  for(int i=0;i<vec.size();i++)
	  {
		  
		  System.out.println("in the main function printing size class and within_class"+vec.size()+"       "+vec.get(i).class_classifying+"     "+vec.get(i).number_within_class+"      "+vec.get(i).alpha+"\n");
		   
	  }
	  for(int i=0;i<sillycount;i++)
	  {
		  System.out.println("second and within_class"+my[i].alpha+"\n");
	  }*/
	 // System.out.println("Sorry. This is not from the same class");
	  //end of thesting
	}
	}
	  for(int i=0;i<36;i++)
	  {
		  System.out.println("This is the final matrix "+testpositive[i]+" for class "+i);
	  }
	System.out.println("This is  out of 72      "+ allcountyes);

	}
}
