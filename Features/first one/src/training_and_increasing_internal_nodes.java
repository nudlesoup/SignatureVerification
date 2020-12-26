import java.io.FileNotFoundException;
import java.util.*;
public class training_and_increasing_internal_nodes extends hundrediterations {
	public static void runlater () throws FileNotFoundException{
		currentclass=0;
		currentintinclass=0;
	int class_of_sign=0;
	assignfeaturevalues();
	//double signature_to_be_tested[] = new double[numberoffeatures];
	double test_signatures[][] = new double [20][numberoffeatures];
	double optalphafornow = onesign100iters(featurevalues, feature19,  currentclass, currentintinclass);
	System.out.println("this from training"+optalphafornow);
	//double optalphafornow = onesign100iters(signature_to_be_tested, all_side_signatures,  currentclass, currentintinclass);
	for(int i=0;i<5;i++){
	if(i==0){
	if(findvalue(numberoffeatures,test_signatures[0],optweights[currentclass][currentintinclass])/100<optalphafornow)
	{
		System.out.println("This is signature of class"+ currentclass);
		optimumalphas[0][0]=optalphafornow;
		System.out.println("check   "+optalphafornow);
		
	}
	else
	{
		swap_2(test_signatures[0]);
		currentintinclass	=	currentintinclass+1;
		optalphafornow = onesign100iters(featurevalues, feature19,  currentclass, currentintinclass);
		optimumalphas[0][currentintinclass]=optalphafornow;
	}
	}
	else if(i!=0)
	{
		currentintinclass=0;
		currentclass = i;
		swap(i);
		optalphafornow = onesign100iters(featurevalues, feature19,  currentclass, currentintinclass);
		if(findvalue(numberoffeatures,test_signatures[i],optweights[currentclass][currentintinclass])/100<optalphafornow)
		{
			System.out.println("This is signature of class"+ currentclass);
			optimumalphas[currentclass][currentintinclass]=optalphafornow;
			continue;
		}
		else
		{
			swap_2(test_signatures[i]);
			currentclass=i;
			currentintinclass	=	currentintinclass+1;
			optalphafornow = onesign100iters(featurevalues, feature19,  currentclass, currentintinclass);
			optimumalphas[currentclass][currentintinclass]=optalphafornow;
		}
	}
	}
	}
}
