import java.util.*;
public class hundrediterations extends firstOne
{
    public static double onesign100iters(double [][]featurevalues, double [][][]feature19, int classofsign, int theintnodeforthesign)
    {
    	if(classofsign!=0){
    	swap(classofsign);}
        // declaration of variables
        int tempcount1=0, tempcount2=0;
        int opttempcount=0; double optval=0.0;
        int count0=0,count1=0,temp=0;double degree = 0;
        double net1,net2;
        double[][] demarcation = new double[5][7];//first one for storing 1st sign and later for remaining 49 and the demarcation for segregating the signatures
        // end of declaration of variables
        double [] alpha = new double[numberoffeatures*2];
        Arrays.fill(alpha, 0.707);
        double [] optimumalpha = Arrays.copyOf(alpha, alpha.length);
        for(int j=0;j<7;j++)
        {
            //initially training with 9 exact samples of the 1st signature
            int[] b = Arrays.copyOf(bintworand, bintworand.length);
            //start of segregating value
            //start for the first signature samples
            for(int ui=0; ui<7;ui++)
            {
                net1 = foronenode(numberoffeatures,featurevalues[ui],alpha);
                demarcation[0][ui]=net1;
                //System.out.println("this is here"+net1);
            }
            //end for the first signature samples
            //start for the 19 signature samples
            for(int ui=0; ui<4;ui++)
            {
                for(int ij=0;ij<7;ij++)
                {
                    net1 = foronenode(numberoffeatures,feature19[ui][ij],alpha);
                    demarcation[ui+1][ij]=net1;
                    //System.out.println("net1  "+net1);
                }
            }
            //starting to find the value
            for(double uo=0.745;uo<6.5;)
            {
            	uo=uo+0.005;
                tempcount1=0;
                for(int io=0;io<7;io++)
                {
                    if(demarcation[0][io]<uo)
                    {
                        tempcount1++;
                    }
                }
                tempcount2=0;
                for(int io=1;io<5;io++)
                {
                    for(int jo=0; jo<7;jo++)
                    {
                        if(demarcation[io][jo]>uo)
                        {// System.out.println("from 100"+demarcation[io][jo]);
                            tempcount2++;
                        }
                    }
                }
                if((tempcount1+tempcount2)>=opttempcount)
                {
                    opttempcount=tempcount1+tempcount2;
                    optval=uo;
                    //System.out.println("opttempcont"+optval+"    "+opttempcount+"   "+tempcount1);
                }
                //optimumalphas[classofsign][theintnodeforthesign]=optval;
                //System.out.println("from optval"+optval);
            }
        }
        
    
        
        //end of segregating value
        // start fo my 100 iterations
        for(int vidyaranya = 0; vidyaranya<100;vidyaranya++)
        {
            net1=0; net2=0;
            //check the net for 9 signatures
            for(int ui=0; ui<7;ui++)
            {
                net1 = foronenode(numberoffeatures,featurevalues[ui],alpha);
                if(net1<optval)
                {
                    count0++;
                }
            }
            //end of 9 initial signatures
            //for 19*9 signatures
            for(int k=0;k<4;k++)
            {
                //initially training with 9 exact samples
                for(int h=0;h<7;h++)
                {
                    net2=foronenode(numberoffeatures,feature19[k][h],alpha);
                    if(net2>optval)
                    {
                        count1++;
                    }
                }
                if(count0+count1>temp)
                {
                    for(int ik=0;ik<numberoffeatures*2;ik++)
                    {
                        if(alpha[ik]==0 && optimumalpha[ik]==0)
                        {
                            degree = 0;
                        }
                        if(alpha[ik]==0 && optimumalpha[ik]==1)
                        {
                            degree = -0.03*(3.15);
                        }
                        if(alpha[ik]==1 && optimumalpha[ik]==0)
                        {
                            degree = 0.03*(3.15);
                        }
                        if(alpha[ik]==1 && optimumalpha[ik]==1)
                        {
                            degree = 0;
                        }
                        optimumalpha[ik] = alpha[ik];
                        temp=count1+count0;
                        alpha[ik] = alpha[ik]*(Math.cos(Math.toRadians(degree)))+Math.sqrt(1-alpha[ik]*alpha[ik])*(Math.sin(Math.toRadians(degree)));
                    }
                }
                else if(count0+count1<temp)
                {
                    for(int ik=0;ik<numberoffeatures*2;ik++)
                    {
                        if(alpha[ik]==0 && optimumalpha[ik]==0)
                        {
                            degree = 0;
                        }
                        if(alpha[ik]==0 && optimumalpha[ik]==1)
                        {
                            degree = 0;
                        }
                        if(alpha[ik]==1 && optimumalpha[ik]==0)
                        {
                            degree = 0;
                        }
                        if(alpha[ik]==1 && optimumalpha[ik]==1)
                        {
                            degree = 0;
                        }
                        alpha[ik] = alpha[ik]*(Math.cos(Math.toRadians(degree)))+Math.sqrt(1-alpha[ik]*alpha[ik])*(Math.sin(Math.toRadians(degree)));
                    }
                }
            }
        }
        //end of vidyaranya iteration
        optweights[classofsign][theintnodeforthesign]=optimumalpha;
        System.out.println("this is now "+ optimumalpha[0]);
        //testing on the sample
        /*    if(foronenode(numberoffeatures, features,optimumalpha)<optval)
        {
            System.out.println("COngrats this is identified as the first signature ");
        }
        else
        {
            System.out.println("Waste fellow this is the first shit's sign");
        }
        */
        //end of testing
        return optval;
    }
}