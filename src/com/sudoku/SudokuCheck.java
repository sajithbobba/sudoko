package com.sudoku;
import java.io.FileReader;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class SudokuCheck
{
  public static boolean sudokuCheck(int[][] s)
  {
	     //row checker
	  for(int row = 0; row < 9; row++)
		   for(int col = 0; col < 8; col++)
		      for(int col2 = col + 1; col2 < 9; col2++)
		         if(s[row][col]==s[row][col2])
		            return false;
       
	  
		// column checker
		for(int col = 0; col < 9; col++)
		   for(int row = 0; row < 8; row++)
		      for(int row2 = row + 1; row2 < 9; row2++)
		         if(s[row][col]==s[row2][col])
		            return false;

		
		// grid checker
		for(int row = 0; row < 9; row += 3)
		   for(int col = 0; col < 9; col += 3)
		      // row, col is start of the 3 by 3 grid
		      for(int pos = 0; pos < 8; pos++)
		         for(int pos2 = pos + 1; pos2 < 9; pos2++)
		            if(s[row + pos%3][col + pos/3]==s[row + pos2%3][col + pos2/3])
		               return false;
   

    return true;    
  }


  public static void main (String[] args)
  {
	  JSONParser parser = new JSONParser();
	  try{
Object object = parser
              .parse(new FileReader("src/boards.json"));
     
      //convert Object to JSONObject
      JSONObject jsonObject = (JSONObject)object;
 
      JSONArray num=new JSONArray();
      
      for(int k=1;k<10;k++){
    	  
       num = (JSONArray)jsonObject.get(""+k+"");
     
      String abc=num.toString();
      
      char x=abc.charAt(12); 
   
      
    int rows, columns;
    
    int[][] node = new int[9][9];
    
    
    int a[]=new int[81];
    int c=0;
    for(int i=0;i<abc.length();i++){
    	char y=abc.charAt(i);
    	String s=String.valueOf(y);
    if(StringUtils.isNumeric(s)==true){
    	a[c]=Integer.parseInt(s);
    	c++;
    }
    }
    
    int[][] int_table = new int[9][9];
    for(int j = 0; j < 9; j++)
    {  
       for(int i = 0; i < 9; i++)
       {
          int_table[j][i] = a[j * 9 + i];
       }
    }

  /*  System.out.println(Arrays.toString(a));
    System.out.println(Arrays.deepToString(int_table));*/
    
    int[][] solution =int_table;


if(sudokuCheck(solution)==true)
      System.out.println(sudokuCheck(solution));
else
  System.out.println("False");
  }
	  }
	  catch(Exception e){
  e.printStackTrace();
	  }
}
}