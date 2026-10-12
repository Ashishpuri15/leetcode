class Solution {
    public int maxDistance(int[] position, int m) {
        // Corrected: Java array sorting syntax
        Arrays.sort(position);
        
        int n = position.length;
        int s = 1; // Start ko 1 se shuru krnge
        int e = position[n - 1] - position[0];  //  sort kr diye h to last posititon pr max value h and 0th index pr minimum value h to max-min kr diye jo ki dono ke bich ka max distance h esliye ye ending point h.
        int ans = -1;
        
        while (s <= e) {
            int mid = (s+e) / 2; // Integer overflow se bachne ke liye safe tarika
            if (validanswer(position, m, mid)) {
                ans = mid;  // ans stored
                s = mid + 1; // move to the right
            } else {
                e = mid - 1; // move to left
            }
        }
        return ans;
    }

    static boolean validanswer(int position[], int m, int mindistance) {
        int ballcount = 1;         // Pehli ball pehli basket par rakh di hai, isliye count 1 se start hoga
        int lastposition = 0;      // Pehli basket ka index 0 hai
        
        for (int i = 1; i < position.length; i++) { // i = 1 se loop chalega
            // Agar current basket or last rakhi gayi ball ki position ka difference >= mindistance hai
            if (position[i] - position[lastposition] >= mindistance) {  // aagr ye condtion sahi hua to 
                ballcount++;   // to ball place kr do and move to next ball.
                lastposition = i;   // basket ka position change kro
                if (ballcount == m) {
                    return true; // Agar saari m balls rakh di, toh true return karo
                }
            }
        }
        return false;
    }
}