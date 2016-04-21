
import java.util.*;
import java.io.*;

public class HelloWorldConsole{
	
	public static void main (String[] args){

		Scanner keyboard = new Scanner(System.in);
		Boolean valid = true;
        String str="";
        String input="";

		while (valid) {
			System.out.println("Select one of the following: \n[D]eutsch \n[E]nglish \n[F]rancais \n [Q]uit");
            str = keyboard.nextLine();
            input = str.toUpperCase();

            switch (input) {
                case "D":
                 System.out.println("Guten Tag!\n");       
                    break;
                case "E":
				System.out.println("Good Day!\n");
					break;
                case "F":
				System.out.println("Bon Jour!\n");
                    break;
                case "Q":
				    valid = false;
                    break;
                default :
                System.out.println("Error: Wrong Character\n");
                    break;
                }
        }

		System.out.println("Quitting . . .");


	}
}