class Solution {
    public int mySqrt(int x) {
        int s=1;   // yaha start 0 se nhi krnge 1 se krnge or 0 ko separatly handle kr lenge.
        int e=x;
        int ans=-1;
        if (x==0){   // 0 ka special case handle kr diye 
            return 0;
        }
        while(s<=e){
            int mid=(s+e)/2;
            if(mid==x/mid){   // mid*mid nhi krnge nhi to interger ka overflow hoga to error de dega.
                return mid;
            }
            else if(mid>x/mid){
                e=mid-1;
            }
            else{
                ans=mid;
                s=mid+1;
            }
        }
        return ans;
    }
}