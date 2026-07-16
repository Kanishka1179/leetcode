class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int i=0, j=0;
        int ans=0;
        int one=0;
        while(j<nums.length){
            if(nums[j]==1) one++;
            if(j-i+1-one <=k){
                ans=Math.max(ans,j-i+1);
                j++;
            } else{
                if(nums[i]==1) one--;
                i++; j++;
            }
        }
        return ans;
    }
}