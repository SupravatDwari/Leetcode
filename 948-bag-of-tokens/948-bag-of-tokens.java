class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
    
    Arrays.sort(tokens);          //sort all tokens in ascending order of power
    int score=0;
    int len = tokens.length;
    
    for(int i=0;i<len;i++){
        if(tokens[i]<=power){       //if we have sufficient power, reduce power and increase score by 1
            power-=tokens[i];
            score++;
        }
        else if(tokens[i]>=power && score>=1 && i!=len-1){      // "i!=len-1" is to check that element is not the last one
            power += tokens[len-1];     //if we don't have sufficient power,increase power 
            score--;    //reduce score to increase power              
            i--;        //to reach that token (which have higher value earlier,before increasing power)
            len--;      //decrease len by 1 (because, token played at most once only)
        }else           //if we can do nothing, break out of the loop
            break;
        
    }
    
    return score;
    
}
}