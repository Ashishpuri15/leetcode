class Solution {
    public int[][] transpose(int[][] matrix) {
        if(matrix == null || matrix.length == 0 ){  /// agr koi matri null or jiska row length =0 rha to usko return kr dena 0 0 matrix
            return new int[0][0];
        }
        // for original array
        int totalrow=matrix.length;  // original array ke row ka length
        int totalcol = matrix[0].length;    // original array ke column ka length
        //for new array
        int newtotalrow = totalcol;     // new array ke row ka length  original array ke colummn ban jayega
        int newtotalcol = totalrow; // new array ke column ka length  original array ke row ban jayega

        int ans[][] = new int[newtotalrow][newtotalcol];  // ek arrray bana rhe h jiska row column ka size de rhe h 
        for(int i=0;i<totalrow;i++){   // row ke element ko traverse krne ke liye 
            for(int j=0;j<totalcol;j++){   // column ke elsment ko traverse krne ke liye
                ans[j][i] = matrix[i][j];   // ans me strore kr  de rhe h i ko j me or j ko i me.
            }
        }
        return ans;
    }
}