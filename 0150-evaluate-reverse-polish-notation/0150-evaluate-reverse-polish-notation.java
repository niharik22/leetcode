
class Solution {
    private String add(String a, String b){
        return String.valueOf(Integer.parseInt(a)+Integer.parseInt(b));
    }
    private String sub(String a, String b){
        return String.valueOf(Integer.parseInt(b)-Integer.parseInt(a));
    }
    private String multi(String a, String b){
        return String.valueOf(Integer.parseInt(a)*Integer.parseInt(b));
    }
    private String div(String a, String b){
        return String.valueOf((Integer.parseInt(b)/Integer.parseInt(a)));
    }
    
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for(String s : tokens){
            switch(s){
                    
                case "+":
                    stack.push(add(stack.pop(), stack.pop()));
                    break;
                case "-":
                    stack.push(sub(stack.pop(), stack.pop()));
                    break;
                case "*":
                    stack.push(multi(stack.pop(), stack.pop()));
                    break;
                case "/":
                    String a = stack.pop();
                    String b = stack.pop();
                    stack.push(div(a,b));
                    break;
                default:
                    stack.push(s);       
            }
                
        }
        return Integer.parseInt(stack.pop());
    }
}