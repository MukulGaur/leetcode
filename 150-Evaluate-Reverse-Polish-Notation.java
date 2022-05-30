// Solution 1 - runtime 10ms | TCclass Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack();
        
        for(String s : tokens){
            if(s.equals("+")){
                stack.push(stack.pop()+stack.pop());
            }
            else if(s.equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b-a);
            }
            else if(s.equals("*")){
                stack.push(stack.pop()*stack.pop());
            }
            else if(s.equals("/")){
                int c = stack.pop();
                int d = stack.pop();
                stack.push(d/c);
            }
            else{
                stack.push(Integer.parseInt(s));
            }
        }
        
        return stack.pop();
    }
} - O(n)

