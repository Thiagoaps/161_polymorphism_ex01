package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List <Employee> employees = new ArrayList<>();
		
		System.out.print("Enter the number of employees: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Employee #" + i + " data:");
			System.out.print("Outsourced (y/n)? ");
			char answer = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Hours: ");
			int hours = sc.nextInt();
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();		
			if (answer == 'n') {				
				Employee employee = new Employee(name, hours, valuePerHour);
				employees.add(employee);
			}
			else {
				System.out.print("Additional charge: ");
				double additionalCharge = sc.nextDouble();
				Employee employee = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
				employees.add(employee);				
			}
		}
		
		System.out.println();
		System.out.println("PAYMENTS");
		
		for (Employee emp : employees) {
			System.out.printf("%s - $ %.2f%n", emp.getName(), emp.payment());
		}
				
		sc.close();
	}
}
