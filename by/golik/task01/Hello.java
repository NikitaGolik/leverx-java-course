/* Создать класс Hello, который будет приветствовать любого пользователя 
*при вводе его имени через командную строку.
*/

import java.util.Scanner;

public class Hello {

    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
	System.out.println("Enter your name");
        String name = sc.next();
        System.out.println("Hello, " + name);
	sc.close();
    }
}
