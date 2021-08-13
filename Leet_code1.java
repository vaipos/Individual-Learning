// Leet CODE WORKS 1
public class Leet_code1 {
   public static void main(String[] args){
      int[] nums = {3, 2, 0, 4};
      int[] nums2 = {4, 1, 2, 1, 2};
      System.out.println(problem1(6, nums));
      System.out.println(problem2(-121));
      System.out.println(problem3(nums2));
   }
   public static String problem1(int target, int[] nums) {
      String finalAns = "[";
      int length = nums.length; 
      for (int i = 0; i < length; i ++ ) {
         for (int j = 0; j < length; j ++ ){
            int ans = nums[i] + nums[j];
            if ( ans == target && i!=j) {
               finalAns += "" + i + "," + j + "]";
               return finalAns;
            }
         }
      }
      return "none";
   }
   public static boolean problem2 ( int x) {
      String value = "" + x;
      int length = value.length();
      int midPoint = length/2;
      for(int i = 0; i < midPoint; i++ ) {
         char beg = value.charAt(i);
         char end = value.charAt(length-1 - i);
         if (beg!=end){
            return false;
         }
      }
      return true;
   }
   
   
   public static int problem3 ( int[] nums ){
      int val = 0;
      int length = nums.length;
      int finalAns = 0;
      for (int i = 0; i < length; i++ ) {
         for (int j = 0; j < length; j++ ) {
            if ( i!=j && nums[i]!= nums[j]){
               val++;
            }
         }
         if (val == length-1 ) {
            return nums[i];
         }
      }
      return 0;
   }
}