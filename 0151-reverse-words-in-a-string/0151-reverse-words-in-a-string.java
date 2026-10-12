class Solution {
    public String reverseWords(String s) {

        StringBuilder ans=new StringBuilder();

        int i=s.length()-1;
        while(i>=0){  
            while(i>=0 && s.charAt(i)==' '){  // agr i index bada ho and i ke place pe space ho to i ko or piche le jao i--
                i--;
            }
            if(i<0){  // agr i index chhota ho jaye decrement krte krte to break kr dena
                break;
            }

            int j=i;  // i pe hi j ko initialize kre h.
            while(j>=0 && s.charAt(j)!=' '){  // agr j index greater ho and j ke index pe koi char ho space aayega to ye condititon false or loop ruk jayega
                j--;  // agr j pe koi char rha to j ko piche le jao taki agla space aaye to ruk andwaha tk ka substring le le.
            }

            ans.append(s.substring(j+1,i+1));  // currentlly to j space pe hoga esliey j+1 tk and kiye and i+1 kyuki last wla substring me count nhi hota h i+1 i tk hi lega.

            while(j>=0 && s.charAt(j)==' '){ // agr two word ke bich me multiple space rha to remvoe kr do.
                j--;  // jb tk space aayega tb tk piche jayega
            }

            if(j>=0){  // string concatenate krne ke baad tw word ke bich me single space v dena h excep 1st word.
                ans.append(" ");
            }

            i=j;  // sbh complete ho jane ke baad phir se j ke index pe i utha kr laa diye and phir se sara process repeate krega 
        }
        return ans.toString();
    }
}