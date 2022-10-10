//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++
class Solution {
  public:
    void dfs(vector<vector<int>>& mat,int i,int j){
        if(i<0||j<0||i>=mat.size()||j>=mat[0].size()||mat[i][j]==0) return;
        mat[i][j]=0;
        dfs(mat,i+1,j);
        dfs(mat,i-1,j);
        dfs(mat,i,j+1);
        dfs(mat,i,j-1);
    }
    vector<int> numOfIslands(int n, int m, vector<vector<int>> &operators) {
        // code here
        vector<vector<int>> mat(n,vector<int>(m,0));
        vector<int> count;
        vector<vector<int>> temp;
        for(auto op:operators){
            mat[op[0]][op[1]]=1;
            temp=mat;
            int num = 0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(temp[i][j]==1){
                        num++;
                        dfs(temp,i,j);
                    }
                }
            }
            count.push_back(num);
        }
        return count;
    }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n,m,k; cin>>n>>m>>k;
        vector<vector<int>> a;
        
        for(int i=0; i<k; i++){
            vector<int> temp;
            for(int j=0; j<2; j++){
                int x; cin>>x;
                temp.push_back(x);
            }
            a.push_back(temp);
        }
    
        Solution obj;
        vector<int> res = obj.numOfIslands(n,m,a);
        
        for(auto x : res)cout<<x<<" ";
        cout<<"\n";
    }
}

// } Driver Code Ends