class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();    // list me store krna h elsiye creat ek rhe h 

        int n=nums.length;

        for(int i=0;i<n;i++){
            int value = Math.abs(nums[i]);   // value ko positive k rde rhe h 
            int indexpos = value-1;         // index position nikl rhe h jo ki number-1 hoga.
            if(nums[indexpos] > 0){     
                nums[indexpos] = -nums[indexpos];
            }
        }

        for(int i=0;i<n;i++){
            if(nums[i]>0){
                int valueatthisindex = i+1;
                result.add(valueatthisindex);
            }
        }
        return result;
    }
}