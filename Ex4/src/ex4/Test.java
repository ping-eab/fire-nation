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
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Create all subjects
        ConcreteSubject subject = new ConcreteSubject();
        IObserver o1 = new ConcreteObserver (subject, "John");
        IObserver o2 = new ConcreteObserver (subject, "Paul");
        IObserver o3 = new ConcreteObserver (subject, "Georgette");
        IObserver o4 = new ConcreteObserver (subject, "Ringina");
        
        //send a message
        subject.newMessage = "Hello";
        subject.notifySubscribers();
        
        //No output becuase bobody has subscribed yet
        
        // John, Paul, Georgette and Ringina will now subscribe
        
        subject.subscribe(o1);
        subject.subscribe(o2);
        subject.subscribe(o3);
        subject.subscribe(o4);
        
        //send a mesage again
        subject.newMessage = "Hello guys";
        subject.notifySubscribers();
        
       //John, Paul, Georgette and Ringina should now receive "Hello guys"
       //send a message again
        subject.newMessage = "Good day";
        subject.notifySubscribers();
       
        //John, Paul and Georgette will unsubscribe
        subject.unSubscribe(o1);
        subject.unSubscribe(o2);
        subject.unSubscribe(o3);
        
        //send a message again
        subject.newMessage = "How do you do?";
        subject.notifySubscribers();
        //Only Ringina should receive "Good day"
    }
}
