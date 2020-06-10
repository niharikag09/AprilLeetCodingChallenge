/*
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
*/

class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int row=matrix.length;
        if(row==0) return 0;
        int col=matrix[0].length;
        
        int[][] area=new int[row][col];
        int result=0;
        
        //copy 0th col
        for(int i=0;i<row;i++){
            area[i][0]=matrix[i][0]=='1'?1:0;
            result=Math.max(area[i][0],result);
        } 
        
        //copy 0th row
        for(int j=0;j<col;j++){
            area[0][j]=matrix[0][j]=='1'?1:0;
            result=Math.max(area[0][j],result);
        } 
        
       //set other rows and cols and compute result
        for(int i=1;i<row;i++){
            
            for(int j=1;j<col;j++){
                
                if(matrix[i][j]=='1'){
                    area[i][j]=Math.min(area[i-1][j],Math.min(area[i][j-1],area[i-1][j-1]))+1;
                    result=Math.max(result,area[i][j]);
                }
               
            }
        }
        
        return result*result;
        
    }
}
