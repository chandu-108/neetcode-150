class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int Totalmult=1;
        int zerosCnt=0;
        for(int i=0;i<n;i++){
           if(nums[i]==0) zerosCnt++;
           else{
           Totalmult*=nums[i];
           }
        }
        int result[]=new int[n];
        for(int i=0;i<n;i++){
            if(zerosCnt>1){
                result[i]=0;
            }
            else if(zerosCnt==1){
                if(nums[i]==0){
                    result[i]=Totalmult;
                }else{
                    result[i]=0;
                }
            }
            else{
             result[i]=Totalmult/nums[i];
            }
        }
        return result;
    }
}  
