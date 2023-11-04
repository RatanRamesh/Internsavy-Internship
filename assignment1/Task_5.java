package assignment1;


import java.util.Scanner;

//Define an interface for the calculator operations
interface Calculator {
 double add(double num1, double num2);

 double subtract(double num1, double num2);

 double multiply(double num1, double num2);

 double divide(double num1, double num2);
}

//Create a class that implements the Calculator interface
class BasicCalculator implements Calculator {
 @Override
 public double add(double num1, double num2) {
     return num1 + num2;
 }

 @Override
 public double subtract(double num1, double num2) {
     return num1 - num2;
 }

 @Override
 public double multiply(double num1, double num2) {
     return num1 * num2;
 }

 @Override
 public double divide(double num1, double num2) {
     if (num2 == 0) {
         System.out.println("Error: Division by zero is not allowed.");
         return Double.NaN; // Return NaN (Not-a-Number) for division by zero
     }
     return num1 / num2;
 }
}

public class Task_5 {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     Calculator calculator = new BasicCalculator();

     System.out.println("\tBasic Calculator");
     System.out.println("Available operations:");
     System.out.println("1. Addition (+)");
     System.out.println("2. Subtraction (-)");
     System.out.println("3. Multiplication (*)");
     System.out.println("4. Division (/)");
     System.out.println("5. Exit");

     while (true) {
         System.out.print("\nEnter your choice (1-5): ");
         int choice = scanner.nextInt();

         if (choice == 5) {
             System.out.println("Exiting the calculator.");
             break;
         }

         System.out.print("Enter the first number: ");
         double num1 = scanner.nextDouble();
         System.out.print("Enter the second number: ");
         double num2 = scanner.nextDouble();

         switch (choice) {
             case 1:
                 System.out.println("Result: " + calculator.add(num1, num2));
                 break;
             case 2:
                 System.out.println("Result: " + calculator.subtract(num1, num2));
                 break;
             case 3:
                 System.out.println("Result: " + calculator.multiply(num1, num2));
                 break;
             case 4:
                 System.out.println("Result: " + calculator.divide(num1, num2));
                 break;
             default:
                 System.out.println("Invalid choice. Please try again.");
         }
     }

     scanner.close();
 }
}
