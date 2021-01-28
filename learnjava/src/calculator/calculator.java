package calculator;
import java.util.Scanner;

public class calculator{
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter input in the format: integer expression integer");
        String line = keyboard.nextLine();
        while (line != null){
            String[] split = line.split(" ");

            if (split.length > 3){
                System.out.println("Enter input in the format: integer expression integer");
                line =  keyboard.nextLine();
                continue;
            }

            try{
                int num1 = Integer.parseInt(split[0]);
                char expression = split[1].charAt(0);
                int num2 = Integer.parseInt(split[2]);

                switch(expression){
                    case '+':
                        System.out.println("The sum of " + num1 + " + " + num2 + " = " + (num1 + num2));
                        break;
                    case '-':
                        System.out.println("The diference of " + num1 + " - " + num2 + " = " + (num1 - num2));
                        break;
                    case '*':
                        System.out.println("The product of " + num1 + " * " + num2 + " = " + (num1 * num2));
                        break;
                    case '/':
                        System.out.println("The division of " + num1 + " / " + num2 + " = " + ((double)num1 / num2));
                        break;
                    default:
                        System.out.println("Pleasee enter valid expression(+, -, *, /)");
                        break;
                }

                line =  keyboard.nextLine();
            }catch(NumberFormatException e){
                System.out.println("Enter input in the format: integer expression integer!");
                keyboard.nextLine();
            }
        }
        keyboard.close();
    }
}