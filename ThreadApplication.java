/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package threadapplication;

/**
 *
 * @author STUDENTE
 */
public class ThreadApplication extends Thread{

    static int n = 2;
    static int waitingTime = 200;
    private Thread padre;
    
    public ThreadApplication() {
        padre = Thread.currentThread();
    }
    
    public void printNome(){
        Thread nome = Thread.currentThread();
        if(nome == padre){
            System.out.println("Thread Padre");
        }else if(nome == this){
            System.out.println("Nuovo Thread");
        }else{
            System.out.println("Thread ignoto");
        }
    }
    
    public void run(){
        for (int i = 0; i < n; i++) {
            System.out.println("NUOVO THREAD!!!");
            printNome();
            try{
                Thread.sleep(waitingTime);
            }catch(InterruptedException e){
                System.out.println("ERRORE DI INTERRUZIONE THREAD");
                return;
            }
            System.out.println("\n"+ getName()+" finito");
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        new ThreadApplication().start();
        for (int i = 0; i < n; i++) {
            System.out.println("Main thread");
            Thread.sleep(waitingTime);
        }
    }
    
}
