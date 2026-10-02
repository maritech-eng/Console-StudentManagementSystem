package Package1;

import java.util.*;
import java.io.*;

public class Student {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Function obj1 = new Function();
		while (true) {
			System.out.println("======= Student Management ========");
			System.out.println("1. Add Student");
			System.out.println("2. Display Students");
			System.out.println("3. Highest Mark");
			System.out.println("4. Search Student ");
			System.out.println("5. Passed Students");
			System.out.println("6. Average Students");
			System.out.println("7. Exit");
			System.out.println("Enter your choice:");
			int a = scan.nextInt();
			switch (a) {
			case 1:
				obj1.addstudent();
				break;
			case 2:
				obj1.displaystudent();
				break;
			case 3:
				obj1.highestmark();
				break;
			case 4:
				obj1.searchstudent();
				break;
			case 5:
				obj1.passedstudent();
				break;
			case 6:
				obj1.averagemark();
				break;
			case 7:
				obj1.exit();
				System.exit(0);
			default:
				System.out.println("Invalid choice!");
			}
		}
	}
}

class Studentt {
	String name;
	int age;
	int mark;
}

class Function {
	ArrayList<Studentt> list = new ArrayList<>();
	Scanner s = new Scanner(System.in);

	public void addstudent() {
		Studentt std = new Studentt();

		System.out.println("Enter student name:");
		std.name = s.nextLine();
		System.out.println("Enter student age:");
		std.age = s.nextInt();
		System.out.println("Enter student mark:");
		std.mark = s.nextInt();
		s.nextLine();
		list.add(std);

		try {
			FileWriter fw = new FileWriter("students.txt", true);
			fw.write("Name: " + std.name + ", Age: " + std.age + ", Mark: " + std.mark + "\n");
			fw.close();
			System.out.println("Student added successfully");
		} catch (IOException e) {
			System.out.println("An error occur saving to file");
			e.printStackTrace();

		}
	}

	public void displaystudent() {
		if (list.isEmpty()) {
			System.out.println("list is nill");
		}
		for (Studentt a : list) {
			System.out.println("Name:" + a.name);
			System.out.println("Age:" + a.age);
			System.out.println("Mark:" + a.mark);
		}
	}

	public void highestmark() {
		if (list.isEmpty()) {
			System.out.println("nill");
		}
		int max = list.get(0).mark;
		String topstudent = list.get(0).name;
		for (Studentt a : list) {
			if (max < a.mark) {
				max = a.mark;
				topstudent = a.name;

			}
		}
		System.out.println("Highest mark is:  " + max);
		System.out.println("Top Student Name is:  " + topstudent);
	}

	public void searchstudent() {
		if (list.isEmpty()) {
			System.out.println("list is nill");
		}
		System.out.println("Enter the Search Name:");
		String search_name = s.next();
		for (Studentt a : list) {
			if (search_name.equals(a.name)) {
				System.out.println("Name:  " + a.name);
				System.out.println("Age:  " + a.age);
				System.out.println("Mark:  " + a.mark);
			} else {
				System.out.println("Student is not found");
			}
		}
	}

	public void passedstudent() {
		if (list.isEmpty()) {
			System.out.println("list is nill");
		}
		for (Studentt a : list) {
			if (a.mark >= 35) {
				System.out.println(a.name + "is PASS");
			} else {
				System.out.println(a.name + "FAIL");
			}
		}
	}

	public void averagemark() {
		if (list.isEmpty()) {
			System.out.println("list is nill");
		}
		int sum = 0;
		int count = 0;
		for (Studentt a : list) {
			sum = sum + a.mark;
			count = count + 1;
		}
		try {
			double avg = sum / count;
			System.out.println("Average Mark is:" + avg);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void exit() {

	}
}
