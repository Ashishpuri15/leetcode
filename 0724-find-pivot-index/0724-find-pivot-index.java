class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int leftsum [] = new int[n];   // ek array me store krte rhnge jiska length same hoga
        int rightsum[] = new int[n];

        // left side se jo sum krnge uske liye loop chla rhe h 
        leftsum[0] = nums[0];   // leftsum se jo array banye the uska 0th index equal kr rhe h nums se taki left side se sum start ho  
        for(int i=1;i<n;i++){     // loop 1 se start hoga kyu ki phle hi 0th index upar define kr diye h.
            leftsum[i] = leftsum[i-1] + nums[i]; /// sum kr rhe h previous wla ka next wla sse
        }

        // similarly for rightsum
        rightsum[n-1] = nums[n-1];
        for(int j=n-2;j>=0;j--){
            rightsum[j]=rightsum[j+1] + nums[j];
        }

        // check kr rhe h kaha equal h loop chla kr
        for(int k =0;k<n;k++){
            if(leftsum[k]==rightsum[k]){
                return k;
            }
        }
        return -1;    // if not then return -1.
    }
}