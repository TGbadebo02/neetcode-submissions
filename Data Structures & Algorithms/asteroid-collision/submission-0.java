class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        /**
         notes:
           value is the size.
          '+' -> moving right.
          '-' -> moving left.
          asteroids move at same speed.

          'collsion rules'
            - same size, both explode.
            - smaller of the two explode.
            - if move same way never explode.
        */

        //base case - invalid size.
        if(asteroids.length == 0 || asteroids.length > 10000) return new int[0];
        
        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);

        for(int i = 1; i < asteroids.length; i++){
            int asteroid = asteroids[i];

            if(asteroid >= stack.peek()){
                stack.push(asteroid);
            }
            
            else if(asteroid < 0 && stack.peek() == Math.abs(asteroid)){
                stack.pop();
            }

            else if(asteroid < 0 && stack.peek() > Math.abs(asteroid)){
                continue;
            }
        }

        int [] resArray = new int[stack.size()];

        for(int i = 0; i < resArray.length; i++){
            resArray[i] = stack.pop();
        }

        Arrays.sort(resArray);

        return resArray;

    }
}