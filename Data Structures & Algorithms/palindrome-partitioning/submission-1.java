class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if (s.length() == 0)
            return new ArrayList<>();

        backTrack(0, s, new ArrayList<>());
        return result;
    }

    private void backTrack(int i, String s, List<String> list) {
        // I need to ensure this goes up to the last character of the string.
        if (i >= s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            //this should only bother to add to the list 
            // if there is a valid substring, then recurse and back track.
            if (isPalindrome(s, i, j)) {
                list.add(s.substring(i, j + 1));
                backTrack(j + 1, s, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
