class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int s=1;
        int sum=0;
        for(int i=0;i<weights.length;i++){
            sum+=weights[i];
        }
        int e=sum;
        int ans=-1;
        while(s<=e){
            int mid=(s+e)/2;
            if(validanswer(weights, days , mid)){
                ans=mid;
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return ans;
    }

    public boolean validanswer(int weights[], int days ,int maxsumweight){
        int dayscount=1;
        int weight=0;
        for(int i=0;i<weights.length;i++){
            if(weight + weights[i] <=maxsumweight){
                weight=weight+weights[i];
            }
            else{
                dayscount++;
                if(dayscount>days || weights[i]>maxsumweight){
                    return false;
                }
                else{
                    weight=0;
                    weight=weight+weights[i];
                }
            }
        }
        return true;
    }
}