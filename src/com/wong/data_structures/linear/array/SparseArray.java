package com.wong.data_structures.linear.array;

public class SparseArray {

    // we can change to use sparse array when 2d array most elements is 0, or same elements
    // 1. stored how many rows and columns, and how many 不同值的 elements
    // 2. stored different value elements row and column position into one smaller 2d array, to compress the size instead of storing all the elements in 2d array
    public static void main(String[] args)
    {
        // original 2d array
        int cheeseArr1[][] = new int[11][11];
        cheeseArr1[1][2] = 1;
        cheeseArr1[2][3] = 2;

        int sum =0;
        for(int[] row :cheeseArr1)
        {
            for(int column : row)
            {
                if(column != 0)
                    sum++;

                System.out.printf("%d\t" ,column);
            }
            System.out.println();
        }
        System.out.println(sum);

        // create sparse array
        int sparseArr[][] = new int[sum+1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        // store non 0 element to sparse array
        int count = 0;
        for(int i=0; i<11; i++)
        {
            for(int j=0; j<11; j++)
            {
                if(cheeseArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = cheeseArr1[i][j];
                }
            }

        }

        System.out.println("-----------------------------------------");
        // print spare array result
        for(int i=0; i< sparseArr.length; i++){
            System.out.printf("%d\t%d\t%d\t", sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
            System.out.println();
        }


        //restore sparse array back to 2d array
        int cheeseArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        for(int i=1; i<sparseArr.length;i++)
        {
            cheeseArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println("------------------------------------------");
        for(int[] row :cheeseArr2)
        {
            for(int column : row)
            {

                System.out.printf("%d\t" ,column);
            }
            System.out.println();
        }

    }
}
