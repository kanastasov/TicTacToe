package Exersices;

import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToe 
{
	static int counter = 0;
	static boolean isFirst;
	static int[][] list = new int[3][3];
	public static void main(String[] args) 
	{
		
			int[][] matrix = new int[3][3];
			
					
			displayBoard(matrix) ;
		
			for(int i=0; i<3; i++)
			{
				for(int j=0; j<3; j++)
				{
					matrix = printIt(matrix, 2, 2);
//					System.out.print(matrix[i][j] + " " );
				}
			}
					System.out.println();
			
			for(int i=0; i<3; i++)
			{
				for(int j=0; j<3; j++)
				{
					System.out.print(list[i][j] + " " );
				}
			}
//			for(int k=0; k<10; k++)
//			{
//				printIt(matrix, counter, counter);	
//				for(int i=0; i<matrix.length; i++)
//				{
//					for(int j=0; j<matrix[i].length; j++)
//					{
//						System.out.print(matrix[i][j] + " ");
//					}
//				}
//			}
		
	}

	
	public static String count()
	{
		counter++;
		if(counter % 2 != 0)
		{
			isFirst  = true;
			return "First";
		}
			isFirst = false;
			return "Second";
			
	}
	
	public static int[][] printIt(int[][] matrix, int row, int col)
	{
		Scanner input = new Scanner(System.in);
		
		matrix = new int[3][3];
		
		
		System.out.println();
		String[][] msg = {{"-------------------------"}, 
				{"\n|       |       |       |"},
				{"\n-------------------------"}, 
				{"\n|       |       |       |"},
				{"\n-------------------------"}, 
				{"\n|       |       |       |"},
				{"\n-------------------------"}, 
					};  
				
//		System.out.println("-------------------------" +
//			"\n|\t|\t|\t| " +
//			"\n-------------------------" +
//			"\n|\t|\t|\t| " +
//			"\n-------------------------" +
//			"\n|\t|\t|\t|" +
//			"\n-------------------------");
//		for(int i=0; i<msg.length; i++)
//		{
//			for(int j=0; j<msg[i].length; j++)
//			{
//					System.out.print(msg[i][j] );
//			}
//		}
		
		System.out.println();
		System.out.println("Enter a row (1, 2, or 3) for player " + count());
		System.out.println("Enter a col (1, 2, or 3) for the same player ");
		 row = input.nextInt();
		 col = input.nextInt();
		 
		 
//		 add(matrix, row, col);
//		 System.out.print(matrix[row][col] + " ");
		if(!(!hasFinished(matrix)  && canInsert(matrix, row, col)))
		{
			 add(matrix, row,  col);
			 list[row][col] = matrix[row][col];
			 System.out.print("On row " + row + " and col " + col + " is: " + matrix[row][col] + " ");
		}
		
		
		
		
		return matrix;
	}
	
	
	public static boolean hasFinished(int[][]matrix)
	{
		
		// Check rows
        for (int i = 0; i < 3; i++)
        {
        	
            if (matrix[i][0] == matrix[i][1] && matrix[i][0] == matrix[i][2])
            {
//            	System.out.println("All " + matrix[i][0] + "'s on row " + i);
            	return true;
            }
        }
        
        // Check cols
        for(int i=0; i<3; i++)
        {
        	if(matrix[0][i] == matrix[1][i] && matrix[0][i] == matrix[2][i])
        	{
//        		System.out.println("All " + matrix[0][i] + "'s on row" + i);
        		return true;
        	}
        }
        
        //Chech Major Diagonal
        if(matrix[0][0] == matrix[1][1] && matrix[0][0] == matrix[2][2])
    	{
//    		System.out.println("All " + matrix[0][0] + "'s on major diagonal");
    		return true;
    	}
        

        //Check Sub Diagonal
        if(matrix[0][2] == matrix[1][1] && matrix[0][2] == matrix[2][0])
    	{
//    		System.out.println("All " + matrix[0][2] + "'s on sub diagonal");
    		return true;
    	}
        return false;

	}
	
	//check wether the possition for insertion is available
	public static boolean canInsert(int[][] matrix, int row, int col)
	{
		if(matrix[row][col] == 0)
		{
			return true;
		}
		return false;
		
	}
	
	// if canInsert is true insert the element in the matrix:
	public static void add(int[][] matrix, int row, int col)
	{
		if(canInsert(matrix, row, col))
		{
			if(isFirst)
			{
				matrix[row][col]  = 1;
//				System.out.print(matrix[row][col]);
			}
			else if(!isFirst)
			{
				matrix[row][col] = 2;
//				System.out.print(matrix[row][col]);
			}
		}
		
	}
	
	public static void draw(int[][]matrix, int row, int col)
	{
		if(hasFinished(matrix) && !canInsert(matrix, row, col))
		{
			System.out.println("It is draw!");
		}
	}
	
	
	static void displayBoard(int[][] matrix) 
	{
		System.out.println("----------------------");
	    for (int i = matrix.length - 1; i >= 0; i--) 
	    {
	      System.out.print("|");
	      for (int j = 0; j < matrix[i].length; j++)
	        System.out.print(matrix[i][j] != 0 ?  matrix[i][j] + "|": "      |");
	      System.out.println("\n----------------------");
//	      System.out.println();
	    }
//	    System.out.println("----------------------");
	  }
	
}
