class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){   // outer loop bs koi pair ka 1st index lega (2,7) to i wla loop 2 rkhega and then inner loop me jaa kr 2 ke th ka jitna v pair rhega niklega jb 2 ke sth ka pura combinantion khtm ho jayega to next i pr jayega like ke baad 7 ke sth ka pura combination banega
            for(int j =i+1 ;j<nums.length;j++){  // i+1 krne ka ek reason or h ki same element ko sum kr ke v to arget mil skta h pr yaha humlog ko alag aalag elements lena h to y enhi kr skte h 
                if(nums[i] + nums[j] == target){   
                    int ans[] = {i,j};     // if condition true then return the index positions
                    return ans;    /// return statment to code yahi se return ho jayega or niche wla empty array to run v nhi krega bs output ke liye rkhe h usko
                }
            }
        }
        int empty[] = {};    /// ye array bs aise hi create kr diye h eska kuch use nhi h upar output me array (int []) kr diya h to output me v array aana chaiye n esliye kre h bs 
        return empty;
    }
}