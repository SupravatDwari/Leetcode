//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        // add your code here
        Stack<Character> s=new Stack<>();
        int n=x.length();
        for(int i=0;i<n;i++){
            char c=x.charAt(i);
            if(isOpening(c))
                s.push(c);
            else {
                if (s.isEmpty())
                    return false;
                else if (!isValid(s.peek(), c))
                    return false;
                else
                    s.pop();
            }
        }
        return s.isEmpty();
    }

    static boolean isOpening(char a) {
        return (a == '(' || a == '{' || a == '[');
    }

    static boolean isValid(char a, char b) {
        return ((a == '(' && b == ')') || (a == '{' && b == '}') || (a == '[' && b == ']'));
    }
}
