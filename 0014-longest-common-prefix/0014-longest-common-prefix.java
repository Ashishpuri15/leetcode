class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0){  // agr strs array null ya phir empty rha to
            return "";
        }
        String first=strs[0];  // first string element ko refrence maan le rhe h.(word)
        for(int i=0;i<first.length();i++){  // us string ke har ek character ko traverse kr rhe h.
            char ch=first.charAt(i);
            for(int j=1;j<strs.length;j++){ // jitna no. of elements hai array me ura ko le iye ab 
                if(i>=strs[j].length() || strs[j].charAt(i) != ch){  // agr first string ka length chhota hi pad jaye firt element of strs array or || us strs element ka charchetr match nhi kre humlog first char se to ruk jana.
                    return first.substring(0,i); // to agr match hua to 0 se i tk ka substring return kr do.
                }
            }
        }
        return first;
    }
}