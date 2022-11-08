//

/*class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }

        HashMap<String, List<String>> map = new HashMap<>();
        for(int i=0; i< strs.length; i++){
            String s = strs[i];
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            String sorted = String.valueOf(charArr);
            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(s);
        }
        return new ArrayList<>(map.values());
    }
}*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }

        HashMap<Double, List<String>> map = new HashMap<>();
        for(int i=0; i< strs.length; i++){
            String s = strs[i];
            Double primeprod = primeprod(s);
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            String sorted = String.valueOf(charArr);
            if(!map.containsKey(primeprod)){
                map.put(primeprod, new ArrayList<>());
            }
            map.get(primeprod).add(s);
        }
        return new ArrayList<>(map.values());
    }

    private double primeprod(String s){
        double result = 1;
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            result = result * primes[c - 'a'];
        }
        return result;
    }
}
