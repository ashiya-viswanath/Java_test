package assignment4;

//https://javabypatel.blogspot.com/2016/10/search-in-sorted-row-and-column-matrix.html [1]

public class Task2 {

    public static int []search(int[][]inputArray,int size,int number)
    {
        //applying binary search to minimise the search space [1]
        int i=0;//first row
        int j=size-1;//last column, top rightmost cell
        int  [] result= new int[]{}; //result array to return

        while(i<size && j>=0) //limit for row and column
        {
        if(inputArray[i][j]==number)
        {

            result= new int[]{i, j};
    }
        if(number>inputArray[i][j])
        {
          i++;//go down the column and discard the current row
    }
        else{
            j--;//go to next row and discard current column
        }
    }

        return result;
    }

  //main method
}