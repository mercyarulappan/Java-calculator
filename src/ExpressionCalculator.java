import java.util.*;

public class ExpressionCalculator {

    public int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    public int applyOp(int a, int b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0;
    }

    public int evaluate(String expression) {
        Stack<Integer> values = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == ' ') continue;

            if (Character.isDigit(ch)) {
                int val = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    val = val * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                values.push(val);
                i--; 
            }
            else if (ch == '(') {
                ops.push(ch);
            }
            else if (ch == ')') {
                while (!ops.isEmpty() && ops.peek() != '(') {
                    int b = values.pop();
                    int a = values.pop();
                    char op = ops.pop();
                    values.push(applyOp(a, b, op));
                }
                ops.pop(); 
            }
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(ch)) {
                    int b = values.pop();
                    int a = values.pop();
                    char op = ops.pop();
                    values.push(applyOp(a, b, op));
                }
                ops.push(ch);
            }
        }

        while (!ops.isEmpty()) {
            int b = values.pop();
            int a = values.pop();
            char op = ops.pop();
            values.push(applyOp(a, b, op));
        }

        return values.pop();
    }

    public void calculateExpression() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter expression (only +, -, *, /, brackets allowed):");
            String expr = sc.nextLine().trim();
            if (expr.equalsIgnoreCase("exit")) {
            System.out.println("Calculator exited. Goodbye!");
            break;
        }
         expr = expr.replaceAll("\\s+", ""); 
            try {
                int result = evaluate(expr);
                
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.out.println("Invalid expression!");
            }
        }
    }
}
 