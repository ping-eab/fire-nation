/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex4;

/**
 *
 * @author Maglasang
 */
public class ConcreteObserver implements IObserver {
    ConcreteSubject subject;
    String name;
    
    public ConcreteObserver (ConcreteSubject subject, String name)
    {
        this.subject = subject;
        this.name = name;
    }
    
    public void update(){
        System.out.println("Message for " + name + "-->" + subject.newMessage);
    }   
}
