import java.util.*;
import java.lang.*;
public class firstOne extends taking_input_of_featurevalues_and_feature19
{
    public static double foronenode(int numberoffeatures,double featurevalues[], double tworand[])
    {
        //double [] tworand = new double[numberoffeatures*2];
        double [] finalweight = new double[numberoffeatures];
        double [] initialrandforconnections  = new double[numberoffeatures];
        int [] checktheconnectionsexistence = new int[numberoffeatures];
        //double [] featurevalues = new double[numberoffeatures];
        //Arrays.fill(tworand, 0.707);
        Arrays.fill(initialrandforconnections, 0.707);
        //for taking feature values
        int i;
        /*for( i=0;i<numberoffeatures;i++)
        {
            featurevalues[i] = 0.7;
        }
        */
        //this if for finding the b
        for( i=0;i<numberoffeatures*2;i=i+1)
        {
            double random = randomInRange(0,1);
            if(random*random<tworand[i])
            {
                bintworand[i]=1;
            }
            else
            {
                bintworand[i]=0;
            }
        }
        /*for loop end*/
        //populating the finalweight array
        for( i=0;i<numberoffeatures*2;i=i+2)
        {
            finalweight[i/2] = findthefinalrandweight(converttoint(bintworand[i],bintworand[i+1]));
        }
        //finding whether the connecitns exist
        for( i=0;i<numberoffeatures;i++)
        {
            double random = randomInRange(0,1);
            if(random*random < initialrandforconnections[i])
            {
                checktheconnectionsexistence[i]=1;
            }
            else
            {
                checktheconnectionsexistence[i]=0;
            }
        }
        //multiplying the weights and connection existence
        double temp = 0.0;
        for( i=0;i <numberoffeatures; i++)
        {
            temp = temp + (checktheconnectionsexistence[i]*finalweight[i]*featurevalues[i]);
        }
        return 1/(1+Math.exp(temp));
    }
}