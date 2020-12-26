import java.util.*;
public class allfunctions
{
    static int numberoffeatures = 45;
    static int numberofinternalnodes = 0;
    static int [] bintworand = new int[numberoffeatures*2];
    //to be used in the hundred iterations file
    static int nots = 5; //nots = number of test signatures
    static double[][][] optweights = new double[nots][3][numberoffeatures];
    static int currentclass = 0;
    static int currentintinclass = 0;
    static double[][]optimumalphas = new double [5][3];
    //end of variables to be used in the hundred iterations file
    public static Random random = new Random();
    public static double randomInRange(double min, double max)
    {
        double range = max - min;
        double scaled = random.nextDouble() * range;
        double shifted = scaled + min;
        return shifted; // == (rand.nextDouble() * (max-min)) + min;
    }
    public static int  converttoint(int a, int b)
    {
        return (2*a)+b;
    }
    public static double findthefinalrandweight(int a)
    {
        if(a == 1)
        {
            return randomInRange(-2.0,-1.0);
        }
        else if(a == 2)
        {
            return randomInRange(-1.0,0.0);
        }
        else if(a == 3)
        {
            return randomInRange(0.0,1.0);
        }
        else if(a == 4)
        {
            return randomInRange(1.0,2.0);
        }
        return 0.0;
    }
    public static double findvalue(int numbofeature, double [] featurevalue,double [] weights)
    {
        double temp=0;
        for (int i=0;i<numbofeature;i++)
        {
            temp = temp + (featurevalue[i]*weights[i]);
        }
        return temp;
    }
    //imported from 100iterations. feature values asigning
    static double [][] featurevalues = new double[7][numberoffeatures];
    //declaration of variable for feature values for 19 * 9 signatures
    static    double[][][] feature19 = new double[4][7][numberoffeatures];
    // end of declaration of variable for feature values for 19 * 9 signatures
    public static void assign_features()
    {
        // feature values for 1 * 9  signatures(to be changed later)
        for(int t=0;t<7;t++)
        {
            // for the actual signature 9 samples' feature values
            for( int i=0;i<numberoffeatures;i++)
            {
                featurevalues[t][i] = 0.7;
            }
        }
        //end of feature values for 1 * 9 signatures
        //start of assigning values for feature values for 49 * 9 signatures(should be changed later)
        for(int i=0; i<4; i++)
        {
            for(int yi = 0; yi<7; yi++)
            {
                for(int k=0; k<numberoffeatures; k++)
                {
                    feature19[i][yi][k] = randomInRange(0,1);
                }
            }
        }
    }
    // end of assigning values for feature values for 19 * 9 signatures
    //end of imported from 100iterations. feature values asigning
    //start of swapping the signature features
    public static void swap (int class_of_sign_in_consideration)
    {
        for(int i =0; i<7;i++)
        {
            double temp[] = new double [numberoffeatures];
            System.arraycopy( featurevalues[i], 0, temp, 0, featurevalues[i].length );
            System.arraycopy( feature19[class_of_sign_in_consideration-1][i], 0, featurevalues[i], 0, featurevalues[i].length );
            System.arraycopy( temp, 0, feature19[class_of_sign_in_consideration-1][i], 0, featurevalues[i].length );
        }
    }
    //end of swapping
    //swapping for creting extra internal node
    public static void swap_2 (double [] features1)
    {
        double temp[] = new double [numberoffeatures];
        System.arraycopy( features1, 0, temp, 0, features1.length );
        System.arraycopy( featurevalues[0], 0, features1, 0, featurevalues[0].length );
        System.arraycopy( temp, 0, featurevalues[0], 0, temp.length );
    }
    //end of swapping for creting extra internal node
}