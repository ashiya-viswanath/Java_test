package assignment4;
//https://www.geeksforgeeks.org/program-to-print-the-diagonals-of-a-matrix/[1]
public class Task1 {

    public static int productDiagonals(int [][]inputArray, int size)
    {
        int result =1;

        for(int i=0;i<size;i++)
        {
            //main diagonal product ,here row and column are identical[1]
            result *=inputArray[i][i];
            //secondary diagonal product ,here row and column sum will be size-1
            result *=inputArray[i][size -1-i];

    }
     if(size % 2 != 0)
        {
             int middleElement =inputArray[size/2][size/2];
             result = result/middleElement;
        }

     return result;

    }
    //main method
}