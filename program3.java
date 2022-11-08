public boolean wordPattern(String pattern, String str) {
        Map<Character, String> patMap = 
            new HashMap<Character,String>();
        Set<String> strSet = new HashSet<String>();
        String[] bagOfWords = str.split("\\s+");
        int patSize = pattern.length();
        int strSize = bagOfWords.length;
        
        if(patSize != strSize) {
            return false;
        }
        
        for(int i = 0; i < patSize; i++) {
            Character currChar = pattern.charAt(i);
            String currStr = bagOfWords[i];
            
            if(patMap.containsKey(currChar)) {
                String retrieved = patMap.get(currChar);
                if(!retrieved.equals(currStr)) {
                    return false;
                }
            } else {
                patMap.put(currChar, currStr);
            }
        }
        
        for(String currStr : patMap.values()) {
            if(!strSet.add(currStr)) {
                return false;
            }
        }
        return true;
    }
