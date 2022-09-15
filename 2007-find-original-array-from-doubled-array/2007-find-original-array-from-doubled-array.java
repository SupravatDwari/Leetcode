class Solution {
    
    Map<Integer, Integer> mp = new HashMap<>();
    
    private void reduceFreq(int val)
    {
        mp.put(val, mp.getOrDefault(val, 0) - 1);
        
        if(mp.get(val) == 0)
            mp.remove(val);
        
    }
    
    public int[] findOriginalArray(int[] changed) {
        
        int n = changed.length, idx = 0;        
        
        // if len is odd, then we can't find all pairs
        if((n & 1) == 1) return new int[0];
        
        
        int[] res = new int[n/2];
        
        // sort all values
        Arrays.sort(changed);
        
        // count freq for all elements in changed
        for(int val : changed)
        {
            mp.put(val, mp.getOrDefault(val, 0) + 1);
        }
        
        for(int val : changed)
        {
            // if we processed already, skip further steps
            if(!mp.containsKey(val)) 
                continue;
            
            // reduce freq of val
            reduceFreq(val);
            
            // check if cur val doubled is present
            if(mp.containsKey(val * 2))
            {
                // reduce freq of cur val doubled
                reduceFreq(val * 2);
            }
            
            // check if cur val half is present
            else if(mp.containsKey(val / 2))
            {
                // reduce freq of cur val doubled
                reduceFreq(val / 2);
            }
            
            else{
                return new int[0];
            }
            
            
            res[idx++] = val;
        }
        
        return res;
    }
}