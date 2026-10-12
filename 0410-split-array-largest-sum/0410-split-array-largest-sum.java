class Solution {
    public int splitArray(int[] nums, int k) {
         if(nums.length<k){   // agr array ke size se bada spilt k ka b=value rhega to return kr dena -1.
                return -1;
            }

        int s=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }

        int e=sum;  // ending element total element ka sum ke equal hi to hoga esliye sum ke equal kra h.
        int ans=-1;

        while(s<=e){
            int mid=(s+e)/2;
            if(validanswer(nums,k,mid)){   // agr validanswer hua to answer stre kro and move to left for getting the minimized largest sum.
                ans=mid;
                e=mid-1;
            }
            else{
                s=mid+1;   // invalidanswer pr move to the right side.
            }
        }
        return ans;
    }

    public boolean validanswer(int nums[] , int k, int maxsumelement){
        int kcount=1;  // k count ko bata re h kina baar split hoga subarray me.
        int element=0;  

        for(int i=0;i<nums.length;i++){
            if(element + nums[i]<=maxsumelement){  // agr sum of th e lements less than and equal to rha maxsumelement ke to valid answer hai.
                element=element+nums[i];  // jb valid answer hua h to ab element ka sum kr do.
            }
            else{
                kcount++;   // ek k split ka valid answer aagya ab agr or k ka value h to usko increment kr rhe h k=2 ke liye and sooo on.
                if(kcount>k || nums[i]> maxsumelement){   // kcount ka value k(no of split) se jada nhi hona chaiye  ooooorrrr agr koi element ka value phle hi maxsumelement se jada rhega to invalid answer de dega. to esliye return false.
                    return false;
                }
                else{  // agr valid anser hua to element ka value 0 se le lenge and phir se sum kr denge .
                    element=0;
                    element=element+nums[i];
                }
            }
        }
        return true;
    }
}