class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        
        int maxi=-1;
        for(int i=0;i<n;i++){
            if(piles[i]> maxi){
                maxi=piles[i];
            }
        }
        int s=1;
        int e=maxi;
        int ans=-1;
        while(s<=e){
            int mid=(s+e)/2;
            if(validanswer(piles,h,mid)){
                ans=mid;
                e=mid-1; // move to left kyu ki minimum niklana h  to chhota answer chaiye or chhota left me hi milega.
            }
            else{
                s=mid+1;  // move to right kyu ki minimum niklna h 
            }
        }
        return ans;
    }


    static boolean validanswer(int[] piles, int h, int midspeed) {
    long totalhours = 0; // Total ghante track karne ke liye variable
    
    // Har ek pile par ek-ek karke jayenge
    for (int i = 0; i < piles.length; i++) {
        int currentPile = piles[i]; // Maan lo ye current pile ke bananas hain
        int hoursForThisPile = 0;   // Is akela pile ko khane me kitne ghante lagenge
        
        // Step 1: Check karo ki kya pile ki quantity speed se poori tarah divide ho rahi hai?
        if (currentPile % midspeed == 0) {
            // Agar remainder 0 hai, toh seedha divide kar do
            hoursForThisPile = currentPile / midspeed;
        } 
        else {
            // Agar remainder bachta hai (jaise 10 ko 3 se divide karne par 1 bacha),
            // toh ek extra ghanta lagega bache hue bananas ke liye.
            // Isiliye (currentPile / midspeed) karke + 1 kar dete hain.
            hoursForThisPile = (currentPile / midspeed) + 1;
        }
        
        // Step 2: Is pile ke ghante ko total hours me jod do
        totalhours = totalhours + hoursForThisPile;
    }
    
    // Step 3: Check karo kya total ghante guards ke aane ke time (h) ke andar hain?
    if (totalhours <= h) {
        return true;  // Haan ji! Ye speed ekdum valid hai.
    } else {
        return false; // Nahi ji! Is speed me time zyada lag raha hai.
    }
}

}