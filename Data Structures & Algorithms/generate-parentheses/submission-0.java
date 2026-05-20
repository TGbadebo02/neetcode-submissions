class Solution {
    List<String> stack = new ArrayList<>();
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backTrack(0, 0, n);
        return result;
    }

    public void backTrack(int opencount, int closecount, int n){
        //set the base case(s).
        if(opencount == n && closecount == n){
            result.add(String.join("",stack));
            return;
        }

        if(opencount < n){
            stack.add("(");
            backTrack(opencount + 1, closecount, n);
            stack.remove(stack.size()-1);
        }

        if(closecount < opencount){
            stack.add(")");
            backTrack(opencount, closecount + 1, n);
            stack.remove(stack.size()-1);
        }
    }
}
