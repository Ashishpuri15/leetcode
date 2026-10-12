class Solution {
    public int removeElement(int[] nums, int val) {
        // in-place modification krna h to nums array me hi krna padega.
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]  != val){    // agr woh element val ke equal nhi aaya to 
                nums[k]=nums[i];  // to usko usi nums ke array me modification kr de rhe h usme hi store kr de rhe h .
                k++;   // k ko next index pe le jaa rhe h.
            }
        }
        return k;
    }
}