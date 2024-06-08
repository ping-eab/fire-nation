/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyApps;

import java.util.Scanner;
import MyLibs.Team; 
import MyLibs.Member;
/**
 *
 * @author Maglasang
 */
public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Team basketball = new Team("Cardinals", 5, 18, 21);

        int choice;
        do {
            System.out.println("Basketball Team Application");
            System.out.println("------------------");
            System.out.println("[1] Apply in the team");
            System.out.println("[2] Show Applicants");
            System.out.println("[3] Exit");
            System.out.print("Choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    Member member = new Member(name, age); // Create a new Member object with input values
                    basketball.addMember(member); // Add the member to the team
                    break;
                case 2:
                    basketball.displayApplicants();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        } while (choice != 3);

        scanner.close();
    }
}
        


       