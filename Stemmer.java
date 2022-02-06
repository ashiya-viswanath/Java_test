package assignment5;




public class Stemmer {



    public static   String[] getNGrams(String keyword, int number)
    {

        if(keyword.length() < number)
        {
            int k = number - keyword.length();
            for(int i =0;i<k;i++)
            {
                keyword= keyword.concat("*");
            }
            // System.out.println(keyword);
        }


        //house original size -5,trousers original size -8
        int   finalSize = keyword.split("").length -number +1; // if ngram =2, then final size = 5-2+1 =4(ho,ou,us,se)
        String [] result = new String[finalSize];                                      // if ngram =3, then final size = 5-3+1 =4(hou,ous,use)
        for (int i=0;i <finalSize; i++)
        {

            result [i] =keyword.substring(i,i+number) ;



        }
        return result;
    }



    public static  String[] getShared(String [] set1, String [] set2)
    {
        int count =0;
        // String unique = "";

        int max= set2.length+ set1.length;
        String []output = new String[max];



        for(int i =0;i< set1.length;i++)
        {
            for(int j=0;j< set2.length;j++)
            {

                if(set1[i].equals(set2[j]))
                {
                    //unique =unique +set1[i]+ "!";

                    output[count] =set1[i];
                    count ++;

                }
            }

        }
        String [] newoutput =new String[count];
        for(int k =0;k<count;k++)
        {
            newoutput[k] =output[k];
        }
//output = unique.split("!");
//System.out.print(Arrays.toString(newoutput));
        return newoutput;
    }





    public static  double getDistance(String [] set1, String [] set2)
    {

        int l1=  set1.length;
        int l2=  set2.length;
        int total =l1+l2;
        int s1 =getShared(set1,set2).length;
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(s1);

        double distance =(double)s1 / total;


        return distance;
        //System.out.println(distance);

    }

    public static  boolean isRelevant(String keyword, String text)
    {
        int l1= getNGrams(keyword,3).length;
        // System.out.println(l1 +"ui");
        String [] input = text.split(" ");

        int flag =0;
        double [] output =new double[input.length];

        for (int i =0;i<input.length;i++)

        {

            System.out.println(input[i]);
            // System.out.println(input[0]);
            int l2=  getNGrams(input[i],3).length;
            System.out.println(l2 +"pi");
            int total =l1+l2;
            int s1= getShared(getNGrams(keyword,3),getNGrams(input[i],3)).length;
            System.out.println(total);
            System.out.println(s1);
            double sum = (double)s1/ total;
            output[i] =sum;
            // System.out.println(sum + "distance");
            if(output[i]>0.4)
            {
                flag++;
            }
        }
        if (flag!=0)
        {return true;
        }
        else
        {
            System.out.println("ashiya");
            return false;
        }

    }


    public static void main(String[] args) {
        // write your code here


        String []  houseNGrams =getNGrams("house", 3); // returns {"hou", "ous", "use"}
        //System.out.println(Arrays.toString(houseNGrams));

        for (int j=0;j<houseNGrams.length;j++)
        {
            System.out.print(houseNGrams[j] + " ");

        }


        System.out.println(houseNGrams.length);


        String []   trousersNGrams = getNGrams("trousers", 3); // returns {"tro", "rou", "ous", "use", "ser", "ers"}


        for (int j=0;j<trousersNGrams.length;j++)
        {
            System.out.print(trousersNGrams[j] + " ");
        }
        System.out.println(trousersNGrams.length);

        String[] shared = getShared(houseNGrams, trousersNGrams); // returns {"ous", "use"}
        for (int k=0;k<shared.length;k++)
        {
            System.out.print(shared[k] + " ");
        }

        double distance =getDistance(houseNGrams, trousersNGrams); // returns 0.222...
        System.out.println(distance);
/*
Explanation:
amount of n-grams in houseNGrams = 3
amount of n-grams in trousersNGrams = 6
total n-grams = 3 + 6 = 9
amount of shared n-grams = 2
so the distance is = 2/9 = 0.222...
*/
        //isRelevant("house", "trousers");
        //isRelevant("house", "the house is clean");
        System.out.println(isRelevant("house", "trousers")); // returns false
        System.out.println(isRelevant("house", "the house is clean")) ; // returns tru



    }
}


