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
public class Philosoph implements Runnable{
    
    PhilosophMonitor monitorObj;
    int id;
    
    public Philosoph(PhilosophMonitor monitorObj,int id)
    {
      this.monitorObj= monitorObj;
      this.id = id;
    
    }
    
    @Override
    public void run()
    {
    
        while(true){
            
            System.out.println("Philosoph "+id+" acıktı");
            try{
            
                Thread.sleep(1000);
            }
            catch(Exception e){}
            monitorObj.takeForks(id);
            System.out.println("Philosop "+id + "yemek yiyor");
            try{
            
                Thread.sleep(1000);
            }
            catch(Exception e){ }
            finally{
                
            }
            monitorObj.returnForks(id);
            
            try{
                Thread.sleep(1000);
            }
            catch(Exception e){}
            
            
            
        }
    
    
    
    }
    
}
