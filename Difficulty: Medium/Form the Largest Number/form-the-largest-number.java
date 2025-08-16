class Solution {
    public String findLargest(int[] arr) {
        // code here
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
       Arrays.sort(nums, (a,b) -> {
           String c = a+""+b, d = b+""+a;
           return d.compareTo(c);
       });
       //If all the values in the array are 0 like [0,0,0,0] then largest number is 0
       if(nums[0] == 0){
           return "0";
       }
       StringBuilder sb = new StringBuilder();
       for(int num : nums){
           sb.append(""+num);
       }
       return sb.toString();
    }
}