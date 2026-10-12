class Solution {
    public int findpivotindex(int nums[]){
        int n = nums.length;
        int s = 0;
        int e = n - 1;
        int ans = -1;
        
        // Agar array rotate hua hi nhi hai (so sorted hai), tab pivot nhi milega
        if(nums[s] <= nums[e]){
            return -1;
        }
        
        while(s <= e){
            int mid = (s + e) / 2;
            if(nums[mid] > nums[n-1]){
                ans = mid;
                s = mid + 1;
            }
            else{
                e = mid - 1;
            }
        }
        return ans;
    }


    public int binarysearch(int nums[] , int s, int e, int target){   // ye method binary search ke liye kr diye h jb line l1 and l2 ko do array mn liye h to dono array to sorted hi  phir to binary search easily lga skte h.
        while(s <= e){
            int mid = (s + e) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if(target > nums[mid]){
                s = mid + 1;
            }
            else{
                e = mid - 1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int pivotindex = findpivotindex(nums);
        int n = nums.length;
        
        if(pivotindex == -1){   // qestion me bola tha exactly sorted array rhega to pivotindex=-1 value aayega or simple sorted array hai to bs usme binarysearch lga do simpily.
            int ans = binarysearch(nums, 0, n-1, target);
            return ans;
        }

        else{
            // if target is in L1 
            int startarray1 = 0;   // L1 line ka starting element 
            int endarray1 = pivotindex;  // L1 line ka ending element ivot index ke equal hi to hoga.
            if(target >= nums[startarray1] && target <= nums[endarray1]){ // agr target L1 ke bich rhs to simpy binarysearch lga de rhe h.
                int ans = binarysearch(nums, startarray1, endarray1, target);
                return ans;
            }
            
            // is target is in L2 
            int startarray2 = pivotindex + 1; // L2 ka strating element to L1 line m ejo pivotindex mila tha uske baad ka hi to tha n L2 ka starting wla
            int endarray2 = n - 1;   // L2 ka ending element
            if(target >= nums[startarray2] && target <= nums[endarray2]){
                int ans = binarysearch(nums, startarray2, endarray2, target);
                return ans;
            }
        }
        return -1;
    }
}