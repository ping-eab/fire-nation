/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyLibs;

/**
 *
 * @author Maglasang
 */
public class Team {
    String name;
    int memberCnt;
    int maxMember;
    int minAge;
    int maxAge;
    Member [] members = new Member [5];

    public Team(String name, int maxMember, int minAge, int maxAge) {
        this.name = name;
        this.maxMember = maxMember;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.members= new Member[maxMember];
    }
    
    public boolean checkQualification(int age) {
        return (age >= 18 && age <= 21); 
    }
    public void addMember(Member member) {
        if (checkQualification(member.age)) {
            if (memberCnt < maxMember) {
                members[memberCnt] = member;
                memberCnt++;
                System.out.println("Welcome to the Basketball Team!");
            } else {
                System.out.println("Basketball team is no longer accepting applicants");
            }
        } else {
            System.out.println("Sorry, you are not qualified!");
        }
    }
    
    public void displayApplicants() {
        System.out.println("Qualified Applicants for " + name + " team:");
        for (Member member : members) {
            if (member != null) {
                System.out.println("Name: " + member.name + ", Age: " + member.age);
            }
        }
    }
}