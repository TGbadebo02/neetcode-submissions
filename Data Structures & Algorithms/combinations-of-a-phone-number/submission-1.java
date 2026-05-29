class Solution {
    List<String> result = new ArrayList<>();
    Map<Character,String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        //set the base case.
        if(digits.length() == 0) return new ArrayList<>();

        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        backTrack(0,"",digits);

        return result;
    }

    public void backTrack(int index, String cmbtn, String digits){
        //set the base case(s).
        //if(digits.length == index) return;

        if(digits.length() == cmbtn.length()){
            result.add(cmbtn);
            return;
        }

        String numDgts = map.get(digits.charAt(index));

        for(int i = 0; i < numDgts.length(); i++){
            char c = numDgts.charAt(i);
            backTrack(index + 1, cmbtn + c, digits);
        }
    }
}
