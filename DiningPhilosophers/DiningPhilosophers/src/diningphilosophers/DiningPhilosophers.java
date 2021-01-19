/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diningphilosophers;

/**
 *
 * @author acar
 */
public class DiningPhilosophers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PhilosophMonitor pm = new PhilosophMonitor();
        Thread [] philosophers = new Thread[5];
        for(int i=0; i<5; i++){
           philosophers[i] = new Thread( new Philosoph(pm,i));
        }
        for(int i=0; i<5; i++)
        {
             philosophers[i].start();
        
        }
        
        
    }
    
}
