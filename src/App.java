import java.util.*;
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hi.....This is a simple calculator");
        System.out.println("Just tell me what kind of calc I have to perform");
        System.out.println("1. Interactive Calculator\n2. Expression Based Calculator");
        System.out.println("Enter the Choice 1 or 2");
        int choice =sc.nextInt();
        if(choice==1) {
            while(true){
            System.out.println("Enter the 1st Number");
            int a = sc.nextInt();
            System.out.println("Enter the 2nd Number");
            int b = sc.nextInt();
            sc.nextLine();
            Interactive i = new Interactive(a,b);
            System.out.println("What to perform (+,-,*,/,sin,cos,tan)");
            String c = sc.nextLine().trim().toLowerCase();
            double res;
            if(c.equals("+")){
                res = i.add(a,b);

            }
            else if(c.equals("-")){
                res = i.sub(a, b);
            }
            else if(c.equals("*")){
                res = i.mul(a, b);
            }
            else if(c.equals("/")){
                res = i.div(a, b);
            }
            else if(c.equals("sin")){
                res = i.sin(a);
            }
            else if(c.equals("cos")){
                res = i.cos(a);
            }
            else if(c.equals("tan")){
                res = i.tan(a);
            }
            else{
                System.out.println("Please enter the valid input");
                return;
            }
            System.out.println("The answer is "+res);
            }
        }
        else if (choice == 2) {
    ExpressionCalculator exp = new ExpressionCalculator();
    exp.calculateExpression();
}
else{
    System.err.println("Please enter 1 or 2");
}

        
        
        
        

    }
    


}
