class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) {  
            return -1;
        }
    // ye batat h ki hume jitna flower chahiye utna garden me h v ki nhi if not then return -1.
    // m --> Total bouquets jo hume banane hai.
    // k --> Ek bouquet banane ke liye kitne adjacent flower chahiye.
    // m*k -> total no. of flower needed
    //(long) (Type Casting): Agar m or k ki values boht badi hogi,toh m*k karne par Integer Overflow ho sakta hai(yaani value integer ki limit se bahar nikal sakti hai).esliye long data type use kr liye type casting kr ke.
        int s=bloomDay[0]; // Agar aap s = 0 maan lete, toh binary search 0 se shuru hota, jabki sabse pehla flower toh jo index no. 0 pe rhega us din ko khil rha hai. Yeh sabse chota din hoga jab garden ka pehla flower khilega (array ka minimum value).
        int e=bloomDay[0]; // Yeh sabse bada din hoga jab garden ka sabse aakhri phool khilega (array ka maximum value). jo ki assume kr liye ki bloomday[0] pr hi h.
        for (int i = 0; i < bloomDay.length; i++) {
            s = Math.min(s, bloomDay[i]);
            e = Math.max(e, bloomDay[i]);
        }
        int ans=-1;
        while(s<=e){
            int mid=(s+e)/2;
            if(validanswer(bloomDay , m , k , mid)){
                ans=mid;
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return ans;
    }

    public boolean validanswer(int[] bloomDay, int m, int k, int days) {
        int bouquets = 0; //Yeh count karega ki abhi tak total kitne bouquets ban chuke hain
        int flowers = 0; //Yeh count karega ki current line (adjacent) mein kitne phool khil chuke hain.

        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= days) {
                flowers++;
                if (flowers == k) {   // agr adjacent flower full hogye bouquet me to move to next bouquet.
                    bouquets++;   // next bouquet me jane ke liye
                    flowers = 0;  // reset kar dete hain agla bouquet banane ke liye.
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets >= m;
    }
}