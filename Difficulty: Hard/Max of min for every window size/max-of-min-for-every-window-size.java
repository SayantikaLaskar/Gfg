class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        // code here
         int n = arr.length ; 
        int rightMin[] = new int[n] ; 
        int leftMin[] = new int[n] ; 
        Stack<Integer>st = new Stack<>() ; 
        
        for(int  i =0 ; i<n ; i++)
        {
             while(!st.isEmpty() && arr[st.peek()] > arr[i])
             {
                  rightMin[st.peek()] = i ; 
                  st.pop() ; 
             }
             st.push(i) ; 
        }
        while(!st.isEmpty())
        {
             rightMin[st.peek()] = n ; 
             st.pop() ; 
        }
        
        for(int i = n-1; i>=0 ; i--)
        {
             while(!st.isEmpty() && arr[st.peek()] > arr[i])
             {
                 leftMin[st.peek()] = i ; 
                 st.pop() ; 
             }
             st.push(i) ; 
        }
        while(!st.isEmpty())
        {
             leftMin[st.peek()] = -1 ; 
             st.pop() ; 
        }
        
        int result[] = new int[n] ; 
        for(int  i =0 ; i<n ; i++)
        {
             int range = (rightMin[i] - leftMin[i] )- 1 ; //width
             result[range-1] = Math.max(result[range-1] ,arr[i]) ; // index 
        }
        
        for(int i=n-2 ; i>=0 ; i--)
        {
             result[i] = Math.max(result[i] , result[i+1]) ; 
        }
        
        ArrayList<Integer>returnValue = new ArrayList<>() ;
        
        for(int val : result)
        {
            returnValue.add(val) ; 
        }
        
        return returnValue ; 
    }
}