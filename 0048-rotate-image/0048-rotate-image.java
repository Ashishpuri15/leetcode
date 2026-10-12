class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;

        // square matrix h to ye transpose krne ka tarika use krnge apne place m eye transpose kr det ah new array craete krne ka jarurt nhi h.
        // swapping kr rhe h 
        for(int i =0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]= temp;
            }
        }

        /// every row ko reverse krne ke liye 
        for(int row=0;row<n;row++){
            int startcol=0;
            int endcol=n-1;
            while(startcol<=endcol){
                // swapping kr rhe h 
                int temp=matrix[row][startcol];
                matrix[row][startcol]=matrix[row][endcol];
                matrix[row][endcol]=temp;
                startcol++;  // swapping hone ke baad starting wla column badhaao;
                endcol--;   // swapping hone ke baad ending column ko ghatao
            }
        }
        
    }
}