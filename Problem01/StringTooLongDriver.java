
import java.util.Scanner;
public class StringTooLongDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		String input;
		boolean done = false;
		Scanner scanner = new Scanner(System.in);
		
		while(!done){
			System.out.println("Please enter a string. Type DONE to quit");	
			
			try{
				input = scanner.nextLine();
				if(input.equals("DONE"))
					done = true;
				else
					if(input.length() >= 20){
						throw new StringTooLongException("The entered string must be under 20 characters.");
					}
			}
			catch(StringTooLongException e){
				System.out.println(e.getMessage());
			}
		}
	}

}
