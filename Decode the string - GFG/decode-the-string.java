//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            
            Solution ob = new Solution();
            out.println(ob.decodedString(s));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int index=0;
    public String decodedString(String s){
        // code here
        
        int num = 0;
        StringBuilder str = new StringBuilder();
        for(;index<s.length();index++){
            char c = s.charAt(index);
            if(c=='['){
                index++;
                String restOfString = decodedString(s);
                for(;num>0;num--) str.append(restOfString);
            }else if(Character.isDigit(c)){
                num = num*10 + c-'0';
            }else if(c==']'){
                break;
            }else{
                str.append(c);
            }
        }
        return str.toString();
    }
}