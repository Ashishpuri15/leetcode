class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstindex = lowerbound(nums, target);

        // Target not found
        if (firstindex == -1 || nums[firstindex] != target) {  //Check target actually exists or not
            return new int[]{-1, -1}; 
        }

        int upper = upperbound(nums, target);
        int lastindex;

        if (upper == -1) {   // ye humlog ko usse greater than wa value ka index dega 
            lastindex = nums.length - 1;
        }
        else {
            lastindex = upper - 1;   // greater than wla value me se -1 krnge to usse chhota jo ki target ki value uska index position  de dega to aa gya n last index \.
        }

        return new int[]{firstindex, lastindex};
    }
    public int lowerbound(int[] nums, int target){
            int n = nums.length;
            int s=0;
            int e=n-1;
            int ans=-1;
            while(s<=e){
                int mid=(s+e)/2;
                if(nums[mid] >=target){
                    ans=mid;
                    e=mid-1;
                }
                else{
                    s=mid+1;
                }
            }
            return ans;
        }

        public int upperbound(int[] nums, int target){
            int n = nums.length;
            int s=0;
            int e=n-1;
            int ans=-1;
            while(s<=e){
                int mid=(s+e)/2;
                if(nums[mid] <=target){
                    s=mid+1;
                }
                else{
                    ans=mid;
                    e=mid-1;
                }
            }
            return ans;
        }
}