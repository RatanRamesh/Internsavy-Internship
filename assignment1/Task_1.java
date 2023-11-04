package assignment1;


import java.util.Scanner;

public class Task_1{
    public static void main(String args[]){


        //Task 1: Develop a temperature conversion tool, Fahrenheit to Celcius
        //        & Vice Versa

        Scanner sc = new Scanner(System.in);
        char choice;
        menu();
                
        do{
            

            choice = sc.next().charAt(0);
            switch(choice){
                case 'c':
                System.out.print("Enter temperature in Fahrenheit: ");
                double fahrenheit1 = sc.nextDouble();
                double celsius1 = fahrenheitToCelsius(fahrenheit1);
                System.out.println(celsius1 + " Celsius\n");
                menu();
                break;

                case 'f':
                System.out.print("Enter temperature in Celsius: ");
                double celsius2 = sc.nextDouble();
                double fahrenheit2 = celsiusToFahrenheit(celsius2);
                System.out.println(fahrenheit2 + " Fahrenheit\n");
                menu();
                break;

                case 'q':
                System.out.println("Good Bye!!!\n");
                break;


                default :
                System.out.println("Invalid Input!!!!!\n");
                menu();
                break;

            }
        
        }while(choice !='q' );
        sc.close();
    }

    public static void menu(){
        System.out.println("Enter C to covert from Fahrenheit to Celsius\nEnter F to covert from Celsius to Farenheit ");
        System.out.println("Enter Q to Quiet");
        System.out.print("Your Choice: ");
    }

    public static double fahrenheitToCelsius(double farenheit){
        return ((farenheit - 32) * 5/9) ;
    }

    public static double celsiusToFahrenheit(double celsius){
        return ((celsius * 9/5) * 32);
    }

}
