import java.util.Scanner;

public class EmployeePay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final int theSizeOfArray = 7;
		
		int[] employeeId = {5658845, 4520125, 7895122, 8777541, 8451277, 1302850, 7580489};
		int[] hours = new int[theSizeOfArray];
		double[] payRate = new double[theSizeOfArray];
		double[] wages = new double[theSizeOfArray];
		
		double minRate = 6;
		

		Scanner keyboard = new Scanner(System.in);
		for(int index = 0 ; index <  employeeId.length ;index++) {
			
		System.out.printf("Please enter hours for employee ID: %d\n", employeeId[index] );
		int eHours =  keyboard.nextInt();
			if(eHours >0) {
				hours[index] = eHours;
			}else {
				System.out.println("Hours cannot be negative.");
			}
				while(eHours < 0) {
					System.out.printf("Please enter hours for employee ID: %d\n", employeeId[index] );
					eHours =  keyboard.nextInt();
					if(eHours >0) {
						hours[index] = eHours;
					}else {
						System.out.println("Hours cannot be negative.");
					
					}
				}
		
		
				
		System.out.printf("Please enter pay rate for employee ID: %d\n", employeeId[index] );
		double eRate = keyboard.nextDouble();
		
		if(eRate > minRate) {
			payRate[index] = eRate;
		}else {
			System.out.println("Employee pay rate cannot be less than $6.00/hour.");
		}
			while(eRate < minRate) {
				System.out.printf("Please enter pay rate for employee ID: %d\n", employeeId[index] );
				eRate = keyboard.nextDouble();
				if(eRate > minRate) {
					payRate[index] = eRate;
				}else {
					System.out.println("Employee pay rate cannot be less than $6.00/hour.");
				}
			}
		
		wages[index] += hours[index] * payRate[index];
		}
		
		keyboard.close();
		
		
		System.out.println("===========================");
		System.out.println("Employee ID	Gross Wages");
		System.out.println("===========================");
		
		for(int index = 0; index < employeeId.length; index++) {
			System.out.printf("    %d\t$    %,.2f\n", employeeId[index], wages[index]);
		}
	}
}