class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        int s=0;
        int e=n-1;
        while(s<=e){

            if(s==e){    // agr koi array single element rha to wahi unique hua to wahi answer ho jayega yaha s ke jagah e v de skte h kyu ki dono to same hi h.
                return nums[s];
            }

            int mid=(s+e)/2;

            int currentvalue=nums[mid];   

            int prevvalue=-1;
            if(mid-1>=0){
                prevvalue=nums[mid-1];
            }

            int nextvalue=-1;
            if(mid+1<n){
                nextvalue=nums[mid+1];
            }

            if(currentvalue != prevvalue && currentvalue != nextvalue){
                return currentvalue;  // to yahi unique ua jo match nhi kr rha h.
            }

            if(currentvalue != prevvalue && currentvalue == nextvalue){
                int startingindexofpair=mid;  // current value or next value ka pair ban rha h to current value ka jo index hoga (mid) wahi startingindexofpair ka hoag.
                if((startingindexofpair & 1)==1){
                    e=mid-1;  // agr odd rha to move to left
                }
                else{
                    s=mid+1;  //// agr even rha to move to left
                }
            }

            if(currentvalue == prevvalue && currentvalue != nextvalue){
                int endingindexofpair=mid;
                if((endingindexofpair & 1)==1){
                    s=mid+1;  // // agr odd rha to move to left
                }
                else{
                    e=mid-1;  // // agr even rha to move to left
                }
            }
        }
        return -1;
    }
}