class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backTrack(0,s,new ArrayList<>(), new StringBuilder());
        return result;
    }

    public void backTrack(int i, String s, List<String> list, StringBuilder sb){
        if(i >= s.length()){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int j = i; j < s.length(); j++){
              if(isPalindrome(s,i,j)){
                list.add(s.substring(i, j + 1));
                backTrack(j + 1, s, list, sb);
                list.remove(list.size() - 1);
           }
        }
    }

    public boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            right--;
            left++;
        }
        return true;
    }
}