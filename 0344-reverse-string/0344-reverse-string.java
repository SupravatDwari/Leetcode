class Solution {
    public void reverseString(char[] s) {
        Stack<Character> st=new Stack<>();
        int i=0;
        while(i< s.length)
        {
            st.push(s[i]);
            i++;
        }
        int j=0;
        while(!st.empty())
        {
           char ch=st.pop();
           s[j]=ch;
           j++;
        }
        return;
    }
}