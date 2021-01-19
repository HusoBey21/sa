/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diningphilosophers;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author acar
 */
public class PhilosophMonitor {
    
    enum State {THINKING, HUNGRY, EATING};
    State[] states = new State[5];
    Condition[] self =new Condition[5];
    private ReentrantLock lock =new ReentrantLock();
    
    public PhilosophMonitor(){
        for(int i=0; i<5; i++){
            
            states[i]=State.HUNGRY;
            self[i] = lock.newCondition();
            
        }
    }
    
    public void takeForks(int id){
        
        lock.lock();
        try{
            states[id]= State.HUNGRY;
            test(id);
            if(states[id] != State.EATING){
                try{
                    System.out.println("Philosoph "+ id+" bekliyor");
                    self[id].await();
                    
                }
                catch(Exception e)
                {
                
                
                }
                
                
            }
   
        }
        catch(Exception e){ }
        finally{
           lock.unlock();
        }  
    }
    
    
    public void returnForks(int id){
        lock.lock();
        try{
        
            states[id]= State.THINKING;
            System.out.println("Philosoph "+id +" düşünüyor");
            test((id+4)%5);
            test((id+1)%5);
        }
        catch(Exception e){ }
        finally
        {
          
           lock.unlock();
        
        }
        
        
        
        
    }
    
    private void test (int id){
        lock.lock();
        try{
        
            if ((states[(id+4)%5]!=State.EATING) && (states[id] == State.HUNGRY) && (states[(id+1)%5])!=State.EATING)
            {  
                states[id]= State.EATING;
                try{
                    self[id].signal();
                    
                }
                catch(Exception e){
                }
            
            
            }
        
        
        }
        catch(Exception e){}
        finally{
            
            lock.unlock();
        
        
        }
        
        
        
        
    }
    
    
    
    
    
    
}
