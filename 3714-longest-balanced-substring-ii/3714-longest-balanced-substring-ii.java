class Solution {
    
    private int helper(String s , char ch1 , char ch2){
        int diff = 0 ;
        int maxSub = 0;
        Map<Integer,Integer> diffMap = new HashMap<>();
        diffMap.put(0,-1);

        for (int i = 0 ; i< s.length() ; i++){
            char curr = s.charAt(i);
            if(s.charAt(i) != ch1 && s.charAt(i) != ch2){
                diffMap = new HashMap<>();
                diffMap.put(0,i);
                diff = 0;
                continue;
            }

            if(curr == ch1) diff++ ;
            else diff-- ;

            if(diffMap.containsKey(diff)){
                maxSub = Math.max(maxSub , i - diffMap.get(diff));
            }else{
                diffMap.put(diff , i);
            }
        }

        return maxSub ;
        
    }

    public int longestBalanced(String s) {
        int n = s.length();
        int maxSub = 0 ;
        // case 1 
        int count = 1 ;
        for( int i = 1 ; i < n ; i++){
            if(s.charAt(i) == s.charAt(i-1)){
                count++;
            }else{
                maxSub = Math.max(maxSub , count);
                count  = 1 ;
            }
        }
        maxSub = Math.max(maxSub , count);

        // case 2 
        maxSub = Math.max(maxSub ,helper(s ,'a' ,'b') );
        maxSub = Math.max(maxSub ,helper(s ,'b' ,'c'));
        maxSub = Math.max(maxSub ,helper(s ,'a' ,'c') );

        // case 3 
        int a = 0 ;
        int b = 0 ;
        int c = 0 ;

        Map<String,Integer> diffMap = new HashMap<>();

        for (int i = 0 ; i < n ; i++){
            char curr = s.charAt(i);
            if(curr == 'a') a++ ;
            if(curr == 'b') b++ ;
            if(curr == 'c') c++ ;

            if(a == b && a == c){
                maxSub = Math.max(maxSub , a+b+c);
            } 
            
            if( a == b && a == c) maxSub = Math.max(maxSub , a+b+c);
            int diffab = a - b ;
            int diffac = a - c ;
            String diff = diffab + "-" + diffac;

            if(diffMap.containsKey(diff)){
                maxSub = Math.max(maxSub , i - diffMap.get(diff));
            }else{
                diffMap.put(diff , i);
            }
        }
        return maxSub;
    }
}